package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.StoreServiceCategorySubclassMapper;
import com.yun.sanatorium.model.entity.StoreServiceCategorySubclass;
import com.yun.sanatorium.service.StoreServiceCategorySubclassService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:StoreServiceCategorySubclassServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:01
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceCategorySubclassServiceImpl extends AbstractService<StoreServiceCategorySubclass> implements StoreServiceCategorySubclassService {

    @Resource
    private StoreServiceCategorySubclassMapper storeServiceCategorySubclassMapper;

}
