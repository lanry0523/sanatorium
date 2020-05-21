package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.AttachmentMapper;
import com.yun.sanatorium.model.entity.Attachment;
import com.yun.sanatorium.model.request.AttachmentRequest;
import com.yun.sanatorium.service.AttachmentService;
import com.yun.sanatorium.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:AttachmentServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttachmentServiceImpl extends AbstractService<Attachment> implements AttachmentService {

    @Resource
    private AttachmentMapper attachmentMapper;


    @Override
    public Integer deleteByRelationId(String relationId) {
        return attachmentMapper.deleteByRelationId(relationId);
    }

    @Override
    public Attachment editAttachmentByRelationId(Attachment attachment, String relationId) {
        attachment.setId(Util.getUUID());
        attachment.setRelationId(relationId);
        attachment.setCreateTime(DateUtils.getCurrentTime());
        return attachment;
    }

    @Override
    public List<Attachment> selectByRelationIdAndType(String relationId, String type) {
        return attachmentMapper.selectByRelationIdAndType(relationId, type);
    }

    @Override
    public List<Attachment> uploadFast(AttachmentRequest attachmentRequest, MultipartFile[] files) {
        ArrayList<Attachment> attachments = new ArrayList<>();
        try{
            // 1、把FastDFS提供的jar包添加到工程中
            // 2、初始化全局配置。加载一个配置文件。
            FastDFSClientUtils fastDFSClient = new FastDFSClientUtils(FastDFSUtils.FILE_SERVICE_URL);
            Attachment attachment = new Attachment();
            BeanUtils.copyProperties(attachment,attachmentRequest);
            for(MultipartFile file : files){
                Attachment a = new Attachment();
                File file1 = MultipartFileToFile.multipartFileToFile(file);
                System.out.println(file1.getPath());
                //上传文件
                String filePath = fastDFSClient.uploadFile(file1.getPath());
                //封装文件到Attachment对象里
                if(!StringUtils.isBlank(filePath)){
                    String str = FastDFSUtils.PATH + filePath;
                    a.setId(Util.getUUID());
                    a.setName(file1.getPath());
                    a.setType(attachment.getType());
                    a.setUrl(str);
                    a.setCreateTime(DateUtils.getCurrentTime());
                    a.setUpdateTime(DateUtils.getCurrentTime());
                    System.out.println("返回路径：" +FastDFSUtils.PATH+filePath);
                    attachments.add(a);//
                }
                MultipartFileToFile.delteTempFile(file1);
            }
            if(attachments.size() > 0){
                attachmentMapper.batchSaveAttachmentList(attachments);
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return attachments;
    }

    @Override
    public Integer delete_file(List<Attachment> attachments) {
        try {
            FastDFSClientUtils fastDFSClient = new FastDFSClientUtils(FastDFSUtils.FILE_SERVICE_URL);
            if(attachments.size() > 0){
                for (Attachment at :attachments ) {
                    fastDFSClient.delete_file(at.getUrl().substring(21));//删除服务器文件
                    attachmentMapper.delete(at);//删除数据文件
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateFastDFS(AttachmentRequest attachmentRequest, MultipartFile[] files) {
        try{
            FastDFSClientUtils fastDFSClient = new FastDFSClientUtils(FastDFSUtils.FILE_SERVICE_URL);
            Attachment attachment = new Attachment();
            BeanUtils.copyProperties(attachment,attachmentRequest);
            List<Attachment> selectAt = attachmentMapper.select(attachment);
            if(selectAt.size() > 0){
                for(Attachment a : selectAt){
                    fastDFSClient.delete_file(a.getUrl().substring(21));//先删除服务器文件
                    attachmentMapper.delete(a);
                }
            }
            //添加新文件
            for(MultipartFile file : files){
                Attachment a = new Attachment();
                File file1 = MultipartFileToFile.multipartFileToFile(file);
                System.out.println(file1.getPath());
                //上传文件
                String filePath = fastDFSClient.uploadFile(file1.getPath());
                //封装文件到Attachment对象里
                if(!StringUtils.isBlank(filePath)){
                    String str = FastDFSUtils.PATH + filePath;
                    a.setId(Util.getUUID());
                    a.setName(file1.getPath());
                    a.setRelationId(attachment.getRelationId());
                    a.setType(attachment.getType());
                    a.setUrl(str);
                    a.setCreateTime(DateUtils.getCurrentTime());
                    a.setUpdateTime(DateUtils.getCurrentTime());
                    attachmentMapper.insertSelective(a);
                }
                MultipartFileToFile.delteTempFile(file1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
