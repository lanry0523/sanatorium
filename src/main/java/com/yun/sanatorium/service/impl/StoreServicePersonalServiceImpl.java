package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.dao.StoreServicePersonalMapper;
import com.yun.sanatorium.model.entity.StoreServicePersonal;
import com.yun.sanatorium.service.StoreServicePersonalService;
import com.yun.sanatorium.core.AbstractService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:StoreServicePersonalServiceImpl
 * @description:服务人员表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:33
 */
@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServicePersonalServiceImpl extends AbstractService<StoreServicePersonal> implements StoreServicePersonalService {

    @Resource
    private StoreServicePersonalMapper storeServicePersonalMapper;

}
