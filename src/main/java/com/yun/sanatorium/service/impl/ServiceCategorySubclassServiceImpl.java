package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.ServiceCategorySubclassMapper;
import com.yun.sanatorium.model.entity.ServiceCategorySubclass;
import com.yun.sanatorium.service.ServiceCategorySubclassService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServiceCategorySubclassServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:42
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceCategorySubclassServiceImpl extends AbstractService<ServiceCategorySubclass> implements ServiceCategorySubclassService {

    @Resource
    private ServiceCategorySubclassMapper serviceCategorySubclassMapper;

}
