package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.CouponUserMapper;
import com.yun.sanatorium.model.entity.Coupon;
import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.model.request.CouponUserRequest;
import com.yun.sanatorium.service.CouponService;
import com.yun.sanatorium.service.CouponUserService;
import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;

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
        BeanUtils.copyProperties(couponUserRequest, couponUser);
        couponUser.setId(Util.getUUID());
        //添加优惠价截止日期
        couponUser.setCouponEndTime(coupon.getEffectiveTimeEnd());
        //添加状态为未使用
        couponUser.setCouponStatus("0");
        couponUser.setCreateTime(DateUtils.getCurrentTime());
        couponUser.setUpdateTime(DateUtils.getCurrentTime());
        return couponUserMapper.insert(couponUser);
    }

    /**
     * 新用户领取优惠券专用
     */
    @Override
    @Transactional
    public Integer drawNewUser(String userId) {
        Coupon request = new Coupon();
        //新用户领取
        request.setIsReceive(0);
        //代金券
        request.setType(0);
        Coupon coupon = couponService.selectOne(request);
        if (null != coupon && coupon.getNumber() <= 0) {
            return 0;
        } else {
            coupon.setNumber(coupon.getNumber() - 1);
            Integer update = couponService.update(coupon);
            CouponUser couponUser = new CouponUser();
            couponUser.setId(Util.getUUID());
            //添加优惠价截止日期
            couponUser.setCouponEndTime(coupon.getEffectiveTimeEnd());
            //添加状态为未使用
            couponUser.setCouponStatus("0");
            couponUser.setCreateTime(DateUtils.getCurrentTime());
            couponUser.setUpdateTime(DateUtils.getCurrentTime());
            couponUser.setUserId(userId);
            couponUser.setRelationId(coupon.getId());
            return couponUserMapper.insert(couponUser);
        }
    }

    @Override
    public List<CouponUser> selectConditions(CouponUserRequest request) {
        List<CouponUser> couponUsers = couponUserMapper.selectConditions(request);
        return couponUsers;
    }

    @Override
    public Integer UserCoupon(String id) {

        return couponUserMapper.userCoupon(id);
    }
}
