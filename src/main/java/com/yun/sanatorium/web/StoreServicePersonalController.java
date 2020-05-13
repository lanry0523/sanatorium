package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.StoreServicePersonal;
import com.yun.sanatorium.service.StoreServicePersonalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:StoreServicePersonalController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:33
 */
@RestController
@RequestMapping("/store/service/personal")
public class StoreServicePersonalController {

    @Resource
    private StoreServicePersonalService storeServicePersonalService;

    @PostMapping("/add")
    public Result add(@RequestBody StoreServicePersonal storeServicePersonal) {
        storeServicePersonalService.save(storeServicePersonal);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        storeServicePersonalService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(StoreServicePersonal storeServicePersonal) {
        storeServicePersonalService.update(storeServicePersonal);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        StoreServicePersonal storeServicePersonal = storeServicePersonalService.findById(id);
        return ResultGenerator.genSuccessResult(storeServicePersonal);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<StoreServicePersonal> list = storeServicePersonalService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
