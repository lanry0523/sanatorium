package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.ServicePersonal;
import com.yun.sanatorium.service.ServicePersonalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:ServicePersonalController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:02
 */
@RestController
@RequestMapping("/servicePersonal")
public class ServicePersonalController {

    @Resource
    private ServicePersonalService servicePersonalService;

    @PostMapping("/add")
    public Result add(@RequestBody ServicePersonal servicePersonal) {
        servicePersonalService.save(servicePersonal);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        servicePersonalService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ServicePersonal servicePersonal) {
        servicePersonalService.update(servicePersonal);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        ServicePersonal servicePersonal = servicePersonalService.findById(id);
        return ResultGenerator.genSuccessResult(servicePersonal);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ServicePersonal> list = servicePersonalService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
