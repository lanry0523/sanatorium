package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.StoreServiceCategoryMapper;
import com.yun.sanatorium.model.entity.StoreServiceCategory;
import com.yun.sanatorium.service.StoreServiceCategoryService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:StoreServiceCategoryServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceCategoryServiceImpl extends AbstractService<StoreServiceCategory> implements StoreServiceCategoryService {

    @Resource
    private StoreServiceCategoryMapper storeServiceCategoryMapper;

}
