package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.PcUserMapper;
import com.yun.sanatorium.model.entity.PcUser;
import com.yun.sanatorium.service.PcUserService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:PcUserServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:55:03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PcUserServiceImpl extends AbstractService<PcUser> implements PcUserService {

    @Resource
    private PcUserMapper pcUserMapper;

}
