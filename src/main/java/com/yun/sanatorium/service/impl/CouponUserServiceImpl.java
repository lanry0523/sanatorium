package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.CouponUserMapper;
import com.yun.sanatorium.model.entity.Coupon;
import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.model.request.CouponUserRequest;
import com.yun.sanatorium.service.CouponService;
import com.yun.sanatorium.service.CouponUserService;
import com.yun.sanatorium.core.AbstractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

public class CouponUserServiceImpl extends AbstractService<CouponUser> implements CouponUserService {

    @Resource
    private CouponUserMapper couponUserMapper;
    @Autowired
    private CouponService couponService;

    @Transactional
    @Override
    public Integer insertRelation(CouponUserRequest couponUserRequest) {
        //查询优惠券 关联用户是优惠券数量-1
        Coupon coupon = couponService.findById(couponUserRequest.getRelationId());
        coupon.setNumber(coupon.getNumber() - 1);
        Integer update = couponService.update(coupon);
        CouponUser couponUser = new CouponUser();
        BeanUtils.copyProperties(couponUser, couponUserRequest);
        return couponUserMapper.insert(couponUser);
    }
}
