package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.ServiceCategorySubclass;
import com.yun.sanatorium.service.ServiceCategorySubclassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:ServiceCategorySubclassController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:42
 */
@RestController
@RequestMapping("/serviceCategorySubclass")
public class ServiceCategorySubclassController {

    @Resource
    private ServiceCategorySubclassService serviceCategorySubclassService;

    @PostMapping("/add")
    public Result add(@RequestBody ServiceCategorySubclass serviceCategorySubclass) {
        serviceCategorySubclassService.save(serviceCategorySubclass);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        serviceCategorySubclassService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ServiceCategorySubclass serviceCategorySubclass) {
        serviceCategorySubclassService.update(serviceCategorySubclass);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        ServiceCategorySubclass serviceCategorySubclass = serviceCategorySubclassService.findById(id);
        return ResultGenerator.genSuccessResult(serviceCategorySubclass);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ServiceCategorySubclass> list = serviceCategorySubclassService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
