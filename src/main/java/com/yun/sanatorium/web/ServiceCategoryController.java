package com.yun.sanatorium.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultCode;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.ServiceCategory;
import com.yun.sanatorium.model.request.ServiceCategoryRequest;
import com.yun.sanatorium.service.ServiceCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:ServiceCategoryController
 * @description:服务类别顶级分类表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:18
 */
@RestController
@RequestMapping("/serviceCategory")
public class ServiceCategoryController {

    @Resource
    private ServiceCategoryService serviceCategoryService;

    @PostMapping("/save")
    public Result save(@RequestBody ServiceCategoryRequest request) {
        if (null == request) {
            return ResultGenerator.genSuccessResult(ResultCode.FAIL);
        }
        serviceCategoryService.save(request);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/deleteById")
    public Result deleteById(@RequestParam String id) {
        serviceCategoryService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ServiceCategoryRequest request) {
        if (null == request || StringUtils.isBlank(request.getId())) {
            return ResultGenerator.genSuccessResult(ResultCode.FAIL);
        }
        serviceCategoryService.update(request);
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
