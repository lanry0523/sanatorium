package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.StoreServiceItemMapper;
import com.yun.sanatorium.model.entity.StoreServiceItem;
import com.yun.sanatorium.service.StoreServiceItemService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:StoreServiceItemServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceItemServiceImpl extends AbstractService<StoreServiceItem> implements StoreServiceItemService {

    @Resource
    private StoreServiceItemMapper storeServiceItemMapper;

}
