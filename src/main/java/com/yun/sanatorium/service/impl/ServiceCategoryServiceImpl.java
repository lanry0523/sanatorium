package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.ServiceCategoryMapper;
import com.yun.sanatorium.model.entity.ServiceCategory;
import com.yun.sanatorium.service.ServiceCategoryService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServiceCategoryServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceCategoryServiceImpl extends AbstractService<ServiceCategory> implements ServiceCategoryService {

    @Resource
    private ServiceCategoryMapper serviceCategoryMapper;

}
