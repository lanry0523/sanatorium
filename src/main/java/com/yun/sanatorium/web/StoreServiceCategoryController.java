package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.StoreServiceCategory;
import com.yun.sanatorium.service.StoreServiceCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:StoreServiceCategoryController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@RestController
@RequestMapping("/storeServiceCategory")
public class StoreServiceCategoryController {

    @Resource
    private StoreServiceCategoryService storeServiceCategoryService;

    @PostMapping("/add")
    public Result add(@RequestBody StoreServiceCategory storeServiceCategory) {
        storeServiceCategoryService.save(storeServiceCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        storeServiceCategoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(StoreServiceCategory storeServiceCategory) {
        storeServiceCategoryService.update(storeServiceCategory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        StoreServiceCategory storeServiceCategory = storeServiceCategoryService.findById(id);
        return ResultGenerator.genSuccessResult(storeServiceCategory);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StoreServiceCategory> list = storeServiceCategoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
