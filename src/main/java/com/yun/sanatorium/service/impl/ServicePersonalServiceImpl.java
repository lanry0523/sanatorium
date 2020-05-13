package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.ServicePersonalMapper;
import com.yun.sanatorium.model.entity.ServicePersonal;
import com.yun.sanatorium.service.ServicePersonalService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServicePersonalServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:02
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ServicePersonalServiceImpl extends AbstractService<ServicePersonal> implements ServicePersonalService {

    @Resource
    private ServicePersonalMapper servicePersonalMapper;

}
