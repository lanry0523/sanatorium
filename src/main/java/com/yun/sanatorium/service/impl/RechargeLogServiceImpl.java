package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.RechargeLogMapper;
import com.yun.sanatorium.model.entity.RechargeLog;
import com.yun.sanatorium.service.RechargeLogService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:RechargeLogServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:55:47
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RechargeLogServiceImpl extends AbstractService<RechargeLog> implements RechargeLogService {

    @Resource
    private RechargeLogMapper rechargeLogMapper;

}
