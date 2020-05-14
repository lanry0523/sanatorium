package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.CouponUser;
import com.yun.sanatorium.service.CouponUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:CouponUserController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:53:20
 */
@RestController
@RequestMapping("/couponUser")
public class CouponUserController {

    @Resource
    private CouponUserService couponUserService;

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
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<CouponUser> list = couponUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
