package com.yun.sanatorium.web;

import com.yun.sanatorium.common.OrderState;
import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Order;
import com.yun.sanatorium.model.request.WxPayRequest;
import com.yun.sanatorium.service.OrderService;
import com.yun.sanatorium.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class WxPayController {
    private static Logger logger = LoggerFactory.getLogger(WxPayController.class);
    @Autowired
    private OrderService orderService;
    /**
     * @Description: 发起微信支付
     * @param wxPayRequest
     * @param request
     * @author: wcf
     * @date: 2018年7月17日
     */
    @RequestMapping("/wxPay")
    public Result wxPay(WxPayRequest wxPayRequest, HttpServletRequest request){
        try{
            //生成的随机字符串
            String nonce_str = StringUtils.getRandomStringByLength(32);
            //商品名称
            String body = wxPayRequest.getBody();
            //获取本机的ip地址
            String spbill_create_ip = IpUtils.getIpAddr(request);

            String orderNo = wxPayRequest.getOut_trade_no();
            String money = wxPayRequest.getTotal_fee();//支付金额，单位：分，这边需要转成字符串类型，否则后面的签名会失败

            Map<String, String> packageParams = new HashMap<String, String>();
            packageParams.put("appid", WxPayConfig.appid);
            packageParams.put("mch_id", WxPayConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            packageParams.put("out_trade_no", orderNo);//商户订单号
            packageParams.put("total_fee", money);//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);
            if("充值".equals(wxPayRequest.getPayType())){
                packageParams.put("notify_url", WxPayConfig.notify_url);
            }else{
                packageParams.put("notify_url", WxPayConfig.notify_url);
            }

            packageParams.put("trade_type", WxPayConfig.TRADETYPE);
            packageParams.put("openid", wxPayRequest.getOpenid());

            // 除去数组中的空值和签名参数
            packageParams = PayUtil.paraFilter(packageParams);
            String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            String mysign = PayUtil.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();
            packageParams.put("sign",mysign);
            logger.info("=======================第一次签名：" + mysign + "=====================");

            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = PayUtil.mapToXml(packageParams);

            logger.info("request ：｛" +packageParams+"｝");

            //调用统一下单接口，并接受返回的结果
            String result = PayUtil.httpRequest(WxPayConfig.pay_url, "POST", xml);

            // 将解析结果存储在HashMap中
            Map map = PayUtil.doXMLParse(result);
            logger.info("response ：｛" +packageParams+"｝");
            String return_code = (String) map.get("return_code");//返回状态码

            //返回给移动端需要的参数
            Map<String, Object> response = new HashMap<String, Object>();
            if(return_code .equals("SUCCESS" )){
                // 业务结果
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                response.put("nonceStr", nonce_str);
                response.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误

                String stringSignTemp = "appId=" + WxPayConfig.appid + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id+ "&signType=" + WxPayConfig.SIGNTYPE + "&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtil.sign(stringSignTemp, WxPayConfig.key, "utf-8").toUpperCase();
                logger.info("=======================第二次签名：" + paySign + "=====================");

                response.put("paySign", paySign);
                //更新订单信息 预下单成功等待用户付款
                //业务逻辑代码
                Order order = new Order();
                order.setId(wxPayRequest.getOut_trade_no());
                order.setState(OrderState.IN_PAYMENT.getCode());
                Integer i = orderService.update(order);
                logger.info("预支付订单生成成功，修改订单状态：【"+i+"】");
            }else{
                return ResultGenerator.genFailResult(map.get("return_msg").toString());
            }
            response.put("appid", WxPayConfig.appid);
            return ResultGenerator.genSuccessResult(response);
        }catch(Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("发起失败");
        }
    }

    /**
     * @Description:支付回调
     * @return
     * @author dzg
     * @throws Exception
     * @throws
     * @date 2018年7月17日
     */
    @RequestMapping(value="/wxNotify")
    public void wxNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        System.out.println("接收到的报文：" + notityXml);

        Map map = PayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            if(PayUtil.verify(PayUtil.createLinkString(map), (String)map.get("sign"), WxPayConfig.key, "utf-8")){
                /**此处添加自己的业务逻辑代码start**/
//                Order order = new Order();
//                order.setId(wxPayRequest.getOut_trade_no());
//                order.setState(OrderState.IN_PAYMENT.getCode());
//                Integer i = orderService.update(order);
                logger.info("支付回调报文：{"+map+"}");
                //支付回调成功扣除
                /**此处添加自己的业务逻辑代码end**/

                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");

        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }
    /**
     * @Description:充值回调
     * @return
     * @author dzg
     * @throws Exception
     * @throws
     * @date 2018年7月17日
     */
    @RequestMapping(value="/rechargeNotify")
    public void rechargeNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        System.out.println("接收到的报文：" + notityXml);

        Map map = PayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        if("SUCCESS".equals(returnCode)){
            //验证签名是否正确
            if(PayUtil.verify(PayUtil.createLinkString(map), (String)map.get("sign"), WxPayConfig.key, "utf-8")){
                /**此处添加自己的业务逻辑代码start**/
//                Order order = new Order();
//                order.setId(wxPayRequest.getOut_trade_no());
//                order.setState(OrderState.IN_PAYMENT.getCode());
//                Integer i = orderService.update(order);
                logger.info("充值回调报文：{"+map+"}");
                //支付回调成功扣除
                /**此处添加自己的业务逻辑代码end**/

                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println(resXml);
        System.out.println("微信支付回调数据结束");

        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }
}
