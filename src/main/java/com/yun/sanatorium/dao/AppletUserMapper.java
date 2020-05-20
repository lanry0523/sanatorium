package com.yun.sanatorium.dao;

import com.yun.sanatorium.core.Mapper;
import com.yun.sanatorium.model.entity.AppletUser;

import java.util.List;

public interface AppletUserMapper extends Mapper<AppletUser> {
    List<AppletUser> findByAppleUser(AppletUser appletUser);
}