package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Coupon;
import com.yun.sanatorium.service.CouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:CouponController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:52:57
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Resource
    private CouponService couponService;

    @PostMapping("/add")
    public Result add(@RequestBody Coupon coupon) {
        couponService.save(coupon);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        couponService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Coupon coupon) {
        couponService.update(coupon);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Coupon coupon = couponService.findById(id);
        return ResultGenerator.genSuccessResult(coupon);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Coupon> list = couponService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
