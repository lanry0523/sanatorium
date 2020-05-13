package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.StoreMapper;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.service.StoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:StoreServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:44:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceImpl extends AbstractService<Store> implements StoreService {

    @Resource
    private StoreMapper storeMapper;

}
