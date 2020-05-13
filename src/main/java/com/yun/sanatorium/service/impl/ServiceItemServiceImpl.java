package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.ServiceItemMapper;
import com.yun.sanatorium.model.entity.ServiceItem;
import com.yun.sanatorium.service.ServiceItemService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServiceItemServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 18:00:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceItemServiceImpl extends AbstractService<ServiceItem> implements ServiceItemService {

    @Resource
    private ServiceItemMapper serviceItemMapper;

}
