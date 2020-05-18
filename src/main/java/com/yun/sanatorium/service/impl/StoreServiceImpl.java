package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.StoreMapper;
import com.yun.sanatorium.model.entity.Attachment;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.request.StoreRequest;
import com.yun.sanatorium.model.vo.StoreVo;
import com.yun.sanatorium.service.AttachmentService;
import com.yun.sanatorium.service.StoreService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:StoreServiceImpl
 * @description:门店表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:44:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceImpl extends AbstractService<Store> implements StoreService {

    @Resource
    private AttachmentService attachmentService;

    @Resource
    private StoreMapper storeMapper;

    @Override
    public void save(StoreRequest request) {

        // 1.初始化操作
        Store store = new Store();
        String id = Util.getUUID();
        String createTime = DateUtils.getCurrentTime();

        // 2.编辑门店基础数据
        BeanUtils.copyProperties(request, store);
        store.setId(id);
        store.setCreateTime(createTime);

        // 3.更新数据库

        // 3.1 更新门店表
        storeMapper.insert(store);

        // 3.2 更新附件关联表
        List<Attachment> attachmentList = new ArrayList<>();

        // 3.2.1 缩略图
        Attachment attachmentLogo = request.getAttachmentLogo();
        if (null != attachmentLogo) {
            attachmentLogo.setId(Util.getUUID());
            attachmentLogo.setRelationId(id);
            attachmentLogo.setCreateTime(DateUtils.getCurrentTime());
            attachmentList.add(attachmentLogo);
        }

        // 3.2.2 简介页面相册
        List<Attachment> attachmentAlbumList = request.getAttachmentAlbumList();
        if (!CollectionUtils.isEmpty(attachmentAlbumList)) {
            for (Attachment attachmentAlbum : attachmentAlbumList) {
                attachmentAlbum = attachmentService.editAttachmentByRelationId(attachmentAlbum, id);
                attachmentList.add(attachmentAlbum);
            }
        }

        // 3.2.3 简介页面硬件设施
        List<Attachment> attachmentFacilitiesList = request.getAttachmentFacilitiesList();
        if (!CollectionUtils.isEmpty(attachmentFacilitiesList)) {
            for (Attachment attachmentFacilities : attachmentFacilitiesList) {
                attachmentFacilities = attachmentService.editAttachmentByRelationId(attachmentFacilities, id);
                attachmentList.add(attachmentFacilities);
            }
        }

        // 3.2.4 更新附件关联表
        if (!CollectionUtils.isEmpty(attachmentList)) {
            attachmentService.save(attachmentList);
        }
    }

    @Override
    public void updateByPrimaryKeySelective(StoreRequest request) {

        // 1.初始化操作
        Store store = new Store();
        String id = request.getId();
        String currentTime = DateUtils.getCurrentTime();

        // 2.编辑数据

        // 2.1 门店基础数据
        BeanUtils.copyProperties(request, store);
        store.setUpdateTime(currentTime);

        // 3.更新数据库

        // 3.1 更新门店表
        storeMapper.updateByPrimaryKeySelective(store);

        // 3.2 更新附件关联表

        // 3.2.1 删除旧的附件关联表
        attachmentService.deleteByRelationId(id);

        List<Attachment> attachmentList = new ArrayList<>();

        // 3.2.1 缩略图
        Attachment attachmentLogo = request.getAttachmentLogo();
        if (null != attachmentLogo) {
            attachmentLogo.setId(Util.getUUID());
            attachmentLogo.setRelationId(id);
            attachmentLogo.setCreateTime(DateUtils.getCurrentTime());
            attachmentList.add(attachmentLogo);
        }

        // 3.2.2 简介页面相册
        List<Attachment> attachmentAlbumList = request.getAttachmentAlbumList();
        if (!CollectionUtils.isEmpty(attachmentAlbumList)) {
            for (Attachment attachmentAlbum : attachmentAlbumList) {
                attachmentAlbum = attachmentService.editAttachmentByRelationId(attachmentAlbum, id);
                attachmentList.add(attachmentAlbum);
            }
        }

        // 3.2.3 简介页面硬件设施
        List<Attachment> attachmentFacilitiesList = request.getAttachmentFacilitiesList();
        if (!CollectionUtils.isEmpty(attachmentFacilitiesList)) {
            for (Attachment attachmentFacilities : attachmentFacilitiesList) {
                attachmentFacilities = attachmentService.editAttachmentByRelationId(attachmentFacilities, id);
                attachmentList.add(attachmentFacilities);
            }
        }

        // 3.2.4 更新附件关联表
        if (!CollectionUtils.isEmpty(attachmentList)) {
            attachmentService.save(attachmentList);
        }

    }

    @Override
    public StoreVo findVoById(String id) {

        // 初始化返回结果集
        StoreVo storeVo = new StoreVo();

        // 1.查询门店基础数据
        Store store = storeMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(store, storeVo);

        // 2.相关文件信息

        // 2.1 缩略图
        List<Attachment> attachmentLogoList = attachmentService.selectByRelationIdAndType(id, "门店缩略图");
        if (!CollectionUtils.isEmpty(attachmentLogoList)) {
            storeVo.setAttachmentLogo(attachmentLogoList.get(0));
        }

        // 2.2 简介页面相册
        List<Attachment> attachmentAlbumList = attachmentService.selectByRelationIdAndType(id, "门店简介页面相册");
        if (!CollectionUtils.isEmpty(attachmentAlbumList)) {
            storeVo.setAttachmentAlbumList(attachmentAlbumList);
        }

        // 2.3 简介页面硬件设施
        List<Attachment> attachmentFacilitiesList = attachmentService.selectByRelationIdAndType(id, "门店简介页面硬件设施");
        if (!CollectionUtils.isEmpty(attachmentFacilitiesList)) {
            storeVo.setAttachmentFacilitiesList(attachmentFacilitiesList);
        }

        // 返回结果集
        return storeVo;
    }
}
