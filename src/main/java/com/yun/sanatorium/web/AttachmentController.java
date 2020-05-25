package com.yun.sanatorium.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Attachment;
import com.yun.sanatorium.model.request.AttachmentRequest;
import com.yun.sanatorium.service.AttachmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.FastDFSClientUtils;
import com.yun.sanatorium.utils.MultipartFileToFile;
import com.yun.sanatorium.utils.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
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

    /**
     * 上传图片批量、单笔
     * @param attachmentRequest
     * @param files
     * @return
     */
    @RequestMapping(value = "/uploadFast", method = RequestMethod.POST)
    public Result uploadFast(AttachmentRequest attachmentRequest, @RequestParam MultipartFile[] files)  {

        if(attachmentRequest.getType() == null || files == null){
            return ResultGenerator.genFailResult(" type 或 files 参数不能为空");
        }
        List<Attachment> attachments = attachmentService.uploadFast(attachmentRequest, files);
        return ResultGenerator.genSuccessResult(attachments);
    }

    /**
     * 删除文件，批量，单笔
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/delete_file", method = RequestMethod.POST)
    public Result delete_file(@RequestBody JSONObject jsonObject){
        JSONArray attachmentList = jsonObject.getJSONArray("attachmentList");
        List<Attachment> attachments = attachmentList.toJavaList(Attachment.class);
        if (CollectionUtils.isEmpty(attachments)) {
            return ResultGenerator.genFailResult("请检查图片信息！");
        }
        attachmentService.delete_file(attachments);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 修改图片
     * @param attachmentRequest
     * @param files
     * @return
     */
    @RequestMapping(value = "/updateFastDFS", method = RequestMethod.POST)
    public Result updateFastDFS(AttachmentRequest attachmentRequest, @RequestParam MultipartFile[] files){
        if(StringUtils.isBlank(attachmentRequest.getRelationId()) || attachmentRequest.getType() == null || files == null){
            return ResultGenerator.genFailResult("relationId, type 或 files 参数不能为空");
        }
        attachmentService.updateFastDFS(attachmentRequest,files);
        return ResultGenerator.genSuccessResult();
    }
}
