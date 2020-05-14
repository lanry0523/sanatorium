package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.StoreServiceItem;
import com.yun.sanatorium.service.StoreServiceItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:StoreServiceItemController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:19
 */
@RestController
@RequestMapping("/storeServiceItem")
public class StoreServiceItemController {

    @Resource
    private StoreServiceItemService storeServiceItemService;

    @PostMapping("/add")
    public Result add(@RequestBody StoreServiceItem storeServiceItem) {
        storeServiceItemService.save(storeServiceItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        storeServiceItemService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(StoreServiceItem storeServiceItem) {
        storeServiceItemService.update(storeServiceItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        StoreServiceItem storeServiceItem = storeServiceItemService.findById(id);
        return ResultGenerator.genSuccessResult(storeServiceItem);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StoreServiceItem> list = storeServiceItemService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
