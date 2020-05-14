package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.ServiceItemMapper;
import com.yun.sanatorium.model.entity.ServiceItem;
import com.yun.sanatorium.model.request.ServiceItemRequest;
import com.yun.sanatorium.service.ServiceItemService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:ServiceItemServiceImpl
 * @description:服务项目表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 18:00:33
 */
@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class ServiceItemServiceImpl extends AbstractService<ServiceItem> implements ServiceItemService {

    @Resource
    private ServiceItemMapper serviceItemMapper;

    @Override
    public void save(ServiceItemRequest request) {

        // 1.初始化操作
        ServiceItem serviceItem = new ServiceItem();
        String id = Util.getUUID();
        String createTime = DateUtils.getCurrentTime();

        // 2.编辑服务项目基础数据
        BeanUtils.copyProperties(request, serviceItem);
        serviceItem.setId(id);
        serviceItem.setCreateTime(createTime);

        // 3.更新数据库

        // 3.1 更新服务项目表
        serviceItemMapper.insert(serviceItem);

        // TODO
        // 3.2 更新
    }
}
