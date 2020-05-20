package com.yun.sanatorium.service;

import com.yun.sanatorium.model.entity.AppletUser;
import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.request.AppletUserRequest;

import java.util.List;

/**
 * @title:AppletUserService
 * @description:**表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:50:25
 */
public interface AppletUserService extends Service<AppletUser> {
    /**
     * 条件查询
     * @param appletUserRequest
     * @return
     */
    List<AppletUser> findByAppleUser(AppletUserRequest appletUserRequest);
}
