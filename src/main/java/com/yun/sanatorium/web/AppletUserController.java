package com.yun.sanatorium.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.jndi.toolkit.url.UrlUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.AppletUser;
import com.yun.sanatorium.model.request.AppletUserRequest;
import com.yun.sanatorium.service.AppletUserService;
import com.yun.sanatorium.utils.Constant;
import com.yun.sanatorium.utils.Util;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;
import sun.net.www.protocol.http.Handler;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @title:AppletUserController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:50:25
 */
@Log4j
@RestController
@RequestMapping("/appletUser")
public class AppletUserController {

    @Resource
    private AppletUserService appletUserService;

    @PostMapping("/add")
    public Result add(@RequestBody AppletUser appletUser) {
        appletUserService.save(appletUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        appletUserService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(AppletUser appletUser) {
        appletUserService.update(appletUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        AppletUser appletUser = appletUserService.findById(id);
        return ResultGenerator.genSuccessResult(appletUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<AppletUser> list = appletUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    @PostMapping("/listByPage")
    public Result listByPage(@RequestBody AppletUserRequest appletUserRequest) {
        PageHelper.startPage(appletUserRequest.getPageNo(), appletUserRequest.getPageSize());
        List<AppletUser> list = appletUserService.findByAppleUser(appletUserRequest);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     *
     * @param code //临时登录凭证
     * @param rawData //用户非敏感信息
     * @param signature //签名
     * @param encrypteData //用户敏感信息
     * @param iv //解密算法的向量
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public Result doLogin(@RequestParam(value = "code",required = false) String code,
                          @RequestParam(value = "rawData",required = false) String rawData,
                          @RequestParam(value = "signature",required = false) String signature,
                          @RequestParam(value = "encrypteData",required = false) String encrypteData,
                          @RequestParam(value = "iv",required = false) String iv){

        System.out.println("用户非敏感信息"+rawData);
        JSONObject rawDataJson = JSON.parseObject( rawData );

        System.out.println("签名"+signature);
        JSONObject SessionKeyOpenId = getSessionKeyOrOpenId( code );
        System.out.println("post请求获取的SessionAndopenId="+SessionKeyOpenId);

        String openid = SessionKeyOpenId.getString("openid" );

        String sessionKey = SessionKeyOpenId.getString( "session_key" );

        System.out.println("openid="+openid+",session_key="+sessionKey);
        String get_access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+Constant.APP_ID+"&secret="+Constant.APP_SECRET;
        JSONObject access_token = httpsRequestToJsonObject(get_access_token_url, "GET", null);

        JSONObject userInfo = getUserInfo( encrypteData, sessionKey, iv );
        System.out.println("根据解密算法获取的userInfo="+userInfo);
        AppletUser user = new AppletUser();
        AppletUserRequest appletUserRequest = new AppletUserRequest();
        appletUserRequest.setOpenId(openid);
        user = appletUserService.getOne(appletUserRequest);
        //入库
        String nickName = rawDataJson.getString( "nickName" );
        String avatarUrl = rawDataJson.getString( "avatarUrl" );
        String gender  = rawDataJson.getString( "gender" );
        String city = rawDataJson.getString( "city" );
        String country = rawDataJson.getString( "country" );
        String province = rawDataJson.getString( "province" );
        String accessToken = access_token.getString("access_token");
        if(user==null){
            AppletUser appletUser = new AppletUser();
            appletUser.setId(Util.getUUID());
            appletUser.setOpenId(openid);
            appletUser.setUserName(nickName);
            appletUser.setSex(gender);
            appletUser.setBalance("0");
            appletUser.setAddress(province);
            appletUser.setPoints(0);
            appletUser.setAccessToken(accessToken);
            appletUser.setStatus(0);
            appletUser.setHeadimgurl(avatarUrl);
            appletUserService.save(appletUser);
        }else {
            System.out.println("用户已存在");
            //已存在
            user.setOpenId(openid);
            user.setUserName(nickName);
            user.setSex(gender);
            user.setAddress(province);
            user.setAccessToken(accessToken);
            user.setHeadimgurl(avatarUrl);
            appletUserService.update(user);
        }
        return ResultGenerator.genSuccessResult(userInfo);
    }

    public static JSONObject getSessionKeyOrOpenId(String code){
        //微信端登录code
        String wxCode = code;
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+Constant.APP_ID+"&secret="+Constant.APP_SECRET+"&js_code="+wxCode+"&grant_type=authorization_code";
        Map<String,String> requestUrlParam = new HashMap<String, String>(  );
        requestUrlParam.put( "appid", Constant.APP_ID );//小程序appId
        requestUrlParam.put( "secret",Constant.APP_SECRET );
        requestUrlParam.put( "js_code",wxCode );//小程序端返回的code
        requestUrlParam.put( "grant_type","authorization_code" );//默认参数

        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = httpsRequestToJsonObject(requestUrl, "GET", null);
        return jsonObject;
    }

    public static JSONObject getUserInfo(String encryptedData,String sessionKey,String iv){
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init( Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSON.parseObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchPaddingException e) {
            System.out.println(e.getMessage());
        } catch (InvalidParameterSpecException e) {
            System.out.println(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            System.out.println(e.getMessage());
        } catch (BadPaddingException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (InvalidKeyException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchProviderException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static JSONObject httpsRequestToJsonObject(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        try {
            StringBuffer buffer = httpsRequest(requestUrl, requestMethod, outputStr);
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            System.err.println("请求连接超时"+ce);
        } catch (Exception e) {
            System.err.println("https请求异常：" + e.getMessage());
        }
        return jsonObject;
    }

    private static StringBuffer httpsRequest(String requestUrl, String requestMethod, String output)
            throws NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException, MalformedURLException,
            IOException, ProtocolException, UnsupportedEncodingException {
        URL realUrl = new URL(requestUrl);
        HttpsURLConnection connection = (HttpsURLConnection) realUrl.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod(requestMethod);
        if (null != output) {
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(output.getBytes("UTF-8"));
            outputStream.close();
        }
        // 从输入流读取返回内容
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        inputStream = null;
        connection.disconnect();
        return buffer;
    }
}
