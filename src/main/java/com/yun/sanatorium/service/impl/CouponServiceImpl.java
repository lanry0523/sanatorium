package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.CouponMapper;
import com.yun.sanatorium.model.entity.Coupon;
import com.yun.sanatorium.service.CouponService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:CouponServiceImpl
 * @description:**表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:57
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CouponServiceImpl extends AbstractService<Coupon> implements CouponService {

    @Resource
    private CouponMapper couponMapper;

}
