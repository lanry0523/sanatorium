package com.yun.sanatorium.service;

import com.yun.sanatorium.model.entity.Coupon;
import com.yun.sanatorium.core.Service;

/**
 * @title:CouponService
 * @description:**表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:57
 */
public interface CouponService extends Service<Coupon> {
    Coupon selectOne(Coupon request);
}
