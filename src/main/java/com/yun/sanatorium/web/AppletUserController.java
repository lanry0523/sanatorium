package com.yun.sanatorium.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.AppletUser;
import com.yun.sanatorium.service.AppletUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:AppletUserController
 * @description:**表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:50:25
 */
@RestController
@RequestMapping("/applet/user")
public class AppletUserController {

    @Resource
    private AppletUserService appletUserService;

    @PostMapping("/add")
    public Result add(@RequestBody AppletUser appletUser) {
        appletUserService.save(appletUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        appletUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(AppletUser appletUser) {
        appletUserService.update(appletUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        AppletUser appletUser = appletUserService.findById(id);
        return ResultGenerator.genSuccessResult(appletUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<AppletUser> list = appletUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
