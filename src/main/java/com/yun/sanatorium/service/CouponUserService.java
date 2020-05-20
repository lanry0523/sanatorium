package com.yun.sanatorium.service;

import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.request.CouponUserRequest;

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
}
