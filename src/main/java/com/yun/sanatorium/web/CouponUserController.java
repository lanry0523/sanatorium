package com.yun.sanatorium.web;

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
    @Autowired
    private CouponService couponService;

    @PostMapping("/add")
    public Result add(@RequestBody CouponUser couponUser) {
        couponUserService.save(couponUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        couponUserService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(CouponUser couponUser) {
        couponUserService.update(couponUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        CouponUser couponUser = couponUserService.findById(id);
        return ResultGenerator.genSuccessResult(couponUser);
    }

    @PostMapping("/list")
    public Result list(@RequestBody CouponUserRequest request) {
        PageHelper.startPage(request.getPageNo(), request.getPageSize());
        List<CouponUser> list = couponUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 添加用户优惠券关联
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
}
