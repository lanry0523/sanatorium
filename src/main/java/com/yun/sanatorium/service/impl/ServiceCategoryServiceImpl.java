package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.ServiceCategoryMapper;
import com.yun.sanatorium.model.entity.ServiceCategory;
import com.yun.sanatorium.model.request.ServiceCategoryRequest;
import com.yun.sanatorium.service.AttachmentService;
import com.yun.sanatorium.service.ServiceCategoryService;
import com.yun.sanatorium.service.StoreServiceCategoryService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServiceCategoryServiceImpl
 * @description:服务类别顶级分类表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceCategoryServiceImpl extends AbstractService<ServiceCategory> implements ServiceCategoryService {

    @Resource
    private AttachmentService attachmentService;

    @Resource
    private StoreServiceCategoryService storeServiceCategoryService;

    @Resource
    private ServiceCategoryMapper serviceCategoryMapper;

    @Override
    public void save(ServiceCategoryRequest request) {

        // 1.初始化操作
        ServiceCategory serviceCategory = new ServiceCategory();
        String id = Util.getUUID();
        String currentTime = DateUtils.getCurrentTime();

        // 2.编辑服务类别顶级分类基础数据
        BeanUtils.copyProperties(request, serviceCategory);
        serviceCategory.setId(id);
        serviceCategory.setCreateTime(currentTime);

        // 2.2

        // 3.更新数据库

        // 3.1 更新服务类别顶级分类表
        serviceCategoryMapper.insert(serviceCategory);

        //  3.2更新附件表 TODO
        if (null != request.getAttachmentLogo()) {

        }

        // 3.3 更新门店关联服务类别顶级分类表
        storeServiceCategoryService.saveByServiceCategory(serviceCategory, request.getStoreList());
    }

    @Override
    public void update(ServiceCategoryRequest request) {

        // 1.初始化操作
        ServiceCategory serviceCategory = new ServiceCategory();
        String currentTime = DateUtils.getCurrentTime();

        // TODO
    }
}
