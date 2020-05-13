package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.AppletUserMapper;
import com.yun.sanatorium.model.entity.AppletUser;
import com.yun.sanatorium.service.AppletUserService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:AppletUserServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:50:25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AppletUserServiceImpl extends AbstractService<AppletUser> implements AppletUserService {

    @Resource
    private AppletUserMapper appletUserMapper;

}
