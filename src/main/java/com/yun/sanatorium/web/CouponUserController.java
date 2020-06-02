package com.yun.sanatorium.web;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.model.request.CouponUserRequest;
import com.yun.sanatorium.service.AppletUserService;
import com.yun.sanatorium.service.CouponService;
import com.yun.sanatorium.service.CouponUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:CouponUserController
 * @description:用户优惠券关联表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:20
 */
@RestController
@RequestMapping("/couponUser")
public class CouponUserController {

    @Resource
    private CouponUserService couponUserService;

    @PostMapping("/list")
    public Result list(@RequestBody CouponUserRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<CouponUser> list = couponUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 添加用户优惠券关联
     *
     * @param couponUserRequest
     * @return
     */
    @PostMapping("/insertRelation")
    public Result insertRelation(@RequestBody CouponUserRequest couponUserRequest) {
        if (StringUtils.isBlank(couponUserRequest.getRelationId()) || StringUtils.isBlank(couponUserRequest.getUserId())) {
            return ResultGenerator.genFailResult("用户id和优惠券id不能为空");
        }

        Integer insert = couponUserService.insertRelation(couponUserRequest);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 条件查询优惠券
     *
     * @param request
     * @return
     */
    @PostMapping("/selectConditions")
    public Result selectConditions(@RequestBody CouponUserRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<CouponUser> list = couponUserService.selectConditions(request);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
