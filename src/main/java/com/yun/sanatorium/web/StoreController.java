package com.yun.sanatorium.web;

import com.yun.sanatorium.core.Result;
import com.yun.sanatorium.core.ResultCode;
import com.yun.sanatorium.core.ResultGenerator;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.request.StoreRequest;
import com.yun.sanatorium.model.vo.StoreVo;
import com.yun.sanatorium.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @title:StoreController
 * @description:门店表controller层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:44:34
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @PostMapping("/save")
    public Result save(@RequestBody StoreRequest request) {
        if (null == request) {
            return ResultGenerator.genSuccessResult(ResultCode.FAIL);
        }
        storeService.save(request);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/deleteById")
    public Result deleteById(@RequestBody StoreRequest request) {
        if (null == request || StringUtils.isBlank(request.getId())) {
            return ResultGenerator.genSuccessResult(ResultCode.FAIL);
        }
        storeService.deleteByPrimaryKey(request.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@RequestBody StoreRequest request) {
        if (null == request || StringUtils.isBlank(request.getId())) {
            return ResultGenerator.genSuccessResult(ResultCode.FAIL);
        }
        storeService.updateByPrimaryKeySelective(request);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/findVoById")
    public Result findVoById(@RequestBody StoreRequest request) {
        if (null == request || StringUtils.isBlank(request.getId())) {
            return ResultGenerator.genSuccessResult(ResultCode.FAIL);
        }
        StoreVo storeVo = storeService.findVoById(request.getId());
        return ResultGenerator.genSuccessResult(storeVo);
    }

    @PostMapping("/findAll")
    public Result findAll() {
        List<Store> list = storeService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }

}
