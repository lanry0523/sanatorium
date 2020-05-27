package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.AppletUserMapper;
import com.yun.sanatorium.model.entity.AppletUser;
import com.yun.sanatorium.model.request.AppletUserRequest;
import com.yun.sanatorium.service.AppletUserService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<AppletUser> findByAppleUser(AppletUserRequest appletUserRequest) {
        AppletUser appletUser = new AppletUser();
        BeanUtils.copyProperties(appletUserRequest, appletUser);
        List<AppletUser> appletUsers = appletUserMapper.findByAppleUser(appletUser);
        return appletUsers;
    }

    @Override
    public AppletUser getOne(AppletUserRequest appletUserRequest) {
        AppletUser user = new AppletUser();
        BeanUtils.copyProperties(appletUserRequest,user);
        return appletUserMapper.getOne(user);
    }
}
