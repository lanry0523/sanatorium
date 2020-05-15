package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Attachment;
import com.yun.sanatorium.service.AttachmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.FastDFSClientUtils;
import com.yun.sanatorium.utils.MultipartFileToFile;
import com.yun.sanatorium.utils.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:AttachmentController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:24
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    //读取resource下fastDfs配置文件
    final String FILE_SERVICE_URL = Thread.currentThread().getContextClassLoader().getResource("fdfs_client.properties").getPath();
    //文件保存路径前部份
    final String PATH = "http://39.100.70.223/";
    @Resource
    private AttachmentService attachmentService;

    @PostMapping("/add")
    public Result add(@RequestBody Attachment attachment) {
        attachmentService.save(attachment);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        attachmentService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Attachment attachment) {
        attachmentService.update(attachment);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Attachment attachment = attachmentService.findById(id);
        return ResultGenerator.genSuccessResult(attachment);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Attachment> list = attachmentService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value = "/uploadFast", method = RequestMethod.POST)
    public Result uploadFast(Attachment attachment,@RequestParam MultipartFile[] files) throws Exception {
        // 1、把FastDFS提供的jar包添加到工程中
        // 2、初始化全局配置。加载一个配置文件。
        FastDFSClientUtils fastDFSClient = new FastDFSClientUtils(FILE_SERVICE_URL);
        if(attachment.getType() == null || files == null){
            return ResultGenerator.genFailResult(" type 或 files 参数不能为空");
        }
        ArrayList<Attachment> attachments = new ArrayList<>();
        for(MultipartFile file : files){
            Attachment a = new Attachment();
            File file1 = MultipartFileToFile.multipartFileToFile(file);
            System.out.println(file1.getPath());
            //上传文件
            String filePath = fastDFSClient.uploadFile(file1.getPath());
            //封装文件到Attachment对象里
            if(!StringUtils.isBlank(filePath)){
                String str = PATH + filePath;
                a.setId(Util.getUUID());
                a.setName(file1.getPath());
                a.setType(attachment.getType());
                a.setUrl(str);
                a.setCreateTime(DateUtils.getCurrentTime());
                a.setUpdateTime(DateUtils.getCurrentTime());
                System.out.println("返回路径：" +PATH+filePath);
                attachments.add(a);//
            }
            MultipartFileToFile.delteTempFile(file1);
        }
        return ResultGenerator.genSuccessResult(attachments);
    }
}
