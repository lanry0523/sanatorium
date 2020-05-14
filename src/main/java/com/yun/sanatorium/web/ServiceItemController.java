package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.ServiceItem;
import com.yun.sanatorium.service.ServiceItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:ServiceItemController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 18:00:33
 */
@RestController
@RequestMapping("/serviceItem")
public class ServiceItemController {

    @Resource
    private ServiceItemService serviceItemService;

    @PostMapping("/add")
    public Result add(@RequestBody ServiceItem serviceItem) {
        serviceItemService.save(serviceItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        serviceItemService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ServiceItem serviceItem) {
        serviceItemService.update(serviceItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        ServiceItem serviceItem = serviceItemService.findById(id);
        return ResultGenerator.genSuccessResult(serviceItem);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ServiceItem> list = serviceItemService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
