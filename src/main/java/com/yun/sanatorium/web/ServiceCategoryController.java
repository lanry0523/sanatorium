package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.ServiceCategory;
import com.yun.sanatorium.service.ServiceCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:ServiceCategoryController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:18
 */
@RestController
@RequestMapping("/serviceCategory")
public class ServiceCategoryController {

    @Resource
    private ServiceCategoryService serviceCategoryService;

    @PostMapping("/add")
    public Result add(@RequestBody ServiceCategory serviceCategory) {
        serviceCategoryService.save(serviceCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        serviceCategoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ServiceCategory serviceCategory) {
        serviceCategoryService.update(serviceCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        ServiceCategory serviceCategory = serviceCategoryService.findById(id);
        return ResultGenerator.genSuccessResult(serviceCategory);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ServiceCategory> list = serviceCategoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
