package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.ServiceCategorySubclassMapper;
import com.yun.sanatorium.model.entity.ServiceCategorySubclass;
import com.yun.sanatorium.model.request.ServiceCategorySubclassRequest;
import com.yun.sanatorium.service.ServiceCategorySubclassService;
import com.yun.sanatorium.service.StoreServiceCategorySubclassService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServiceCategorySubclassServiceImpl
 * @description:服务类别子类表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:42
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceCategorySubclassServiceImpl extends AbstractService<ServiceCategorySubclass> implements ServiceCategorySubclassService {

    @Resource
    private StoreServiceCategorySubclassService storeServiceCategorySubclassService;

    @Resource
    private ServiceCategorySubclassMapper serviceCategorySubclassMapper;

    @Override
    public void save(ServiceCategorySubclassRequest request) {

        // 1.初始化操作
        ServiceCategorySubclass serviceCategorySubclass = new ServiceCategorySubclass();
        String id = Util.getUUID();
        String currentTime = DateUtils.getCurrentTime();

        // 2.编辑服务类别顶级分类基础数据
        BeanUtils.copyProperties(request, serviceCategorySubclass);
        serviceCategorySubclass.setId(id);
        serviceCategorySubclass.setCreateTime(currentTime);

        // 3.更新数据库

        // 3.1 更新服务类别子类表
        serviceCategorySubclassMapper.insert(serviceCategorySubclass);

        // 3.2 更新门店关联服务子类表
        storeServiceCategorySubclassService.saveByServiceCategorySubclass(serviceCategorySubclass, request.getStoreList());
    }
}
