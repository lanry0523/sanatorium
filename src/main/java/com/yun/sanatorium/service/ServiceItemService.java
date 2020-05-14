package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.ServiceItem;
import com.yun.sanatorium.model.request.ServiceItemRequest;

/**
 * @title:ServiceItemService
 * @description:服务项目表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 18:00:33
 */
public interface ServiceItemService extends Service<ServiceItem> {

    /**
     * 添加服务项目数据
     *
     * @param request
     */
    void save(ServiceItemRequest request);
}
