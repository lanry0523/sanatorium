package com.yun.sanatorium.service;

import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.request.CouponUserRequest;

import java.util.List;

/**
 * @title:CouponUserService
 * @description:用户优惠券关联表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:20
 */
public interface CouponUserService extends Service<CouponUser> {
    /**
     * 用户关联优惠券
     *
     * @param couponUserRequest
     * @return
     */
    Integer insertRelation(CouponUserRequest couponUserRequest);

    /**
     * 新用户领取优惠券专用
     */
    Integer drawNewUser(String userId);

    /**
     * 条件查询优惠券
     *
     * @param request
     * @return
     */
    List<CouponUser> selectConditions(CouponUserRequest request);

    /**
     * 使用优惠券
     *
     * @param id
     * @return
     */
    Integer UserCoupon(String id);
}
