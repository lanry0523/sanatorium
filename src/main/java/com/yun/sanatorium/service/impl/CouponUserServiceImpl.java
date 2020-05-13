package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.CouponUserMapper;
import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.service.CouponUserService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:CouponUserServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CouponUserServiceImpl extends AbstractService<CouponUser> implements CouponUserService {

    @Resource
    private CouponUserMapper couponUserMapper;

}
