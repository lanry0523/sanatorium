package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.ServicePersonalServiceItemMapper;
import com.yun.sanatorium.model.entity.ServicePersonalServiceItem;
import com.yun.sanatorium.service.ServicePersonalServiceItemService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServicePersonalServiceItemServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServicePersonalServiceItemServiceImpl extends AbstractService<ServicePersonalServiceItem> implements ServicePersonalServiceItemService {

    @Resource
    private ServicePersonalServiceItemMapper servicePersonalServiceItemMapper;

}
