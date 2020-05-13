package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.ServicePersonalServiceItem;
import com.yun.sanatorium.service.ServicePersonalServiceItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:ServicePersonalServiceItemController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:24
 */
@RestController
@RequestMapping("/service/personal/service/item")
public class ServicePersonalServiceItemController {

    @Resource
    private ServicePersonalServiceItemService servicePersonalServiceItemService;

    @PostMapping("/add")
    public Result add(@RequestBody ServicePersonalServiceItem servicePersonalServiceItem) {
        servicePersonalServiceItemService.save(servicePersonalServiceItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        servicePersonalServiceItemService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ServicePersonalServiceItem servicePersonalServiceItem) {
        servicePersonalServiceItemService.update(servicePersonalServiceItem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        ServicePersonalServiceItem servicePersonalServiceItem = servicePersonalServiceItemService.findById(id);
        return ResultGenerator.genSuccessResult(servicePersonalServiceItem);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ServicePersonalServiceItem> list = servicePersonalServiceItemService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
