package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.StoreServiceCategorySubclass;
import com.yun.sanatorium.service.StoreServiceCategorySubclassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:StoreServiceCategorySubclassController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:01
 */
@RestController
@RequestMapping("/store/service/category/subclass")
public class StoreServiceCategorySubclassController {

    @Resource
    private StoreServiceCategorySubclassService storeServiceCategorySubclassService;

    @PostMapping("/add")
    public Result add(@RequestBody StoreServiceCategorySubclass storeServiceCategorySubclass) {
        storeServiceCategorySubclassService.save(storeServiceCategorySubclass);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        storeServiceCategorySubclassService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(StoreServiceCategorySubclass storeServiceCategorySubclass) {
        storeServiceCategorySubclassService.update(storeServiceCategorySubclass);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        StoreServiceCategorySubclass storeServiceCategorySubclass = storeServiceCategorySubclassService.findById(id);
        return ResultGenerator.genSuccessResult(storeServiceCategorySubclass);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StoreServiceCategorySubclass> list = storeServiceCategorySubclassService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
