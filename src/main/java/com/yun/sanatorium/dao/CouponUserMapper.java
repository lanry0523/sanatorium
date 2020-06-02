package com.yun.sanatorium.dao;

import com.yun.sanatorium.core.Mapper;
import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.model.request.CouponUserRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponUserMapper extends Mapper<CouponUser> {
    /**
     * 使用优惠券
     *
     * @param id
     * @return
     */
    Integer userCoupon(@Param("id") String id);

    /**
     * 查询可用优惠券
     *
     * @param request
     * @return
     */
    List<CouponUser> selectConditions(CouponUserRequest request);
}