package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.ServiceCategorySubclass;
import com.yun.sanatorium.model.request.ServiceCategorySubclassRequest;

/**
 * @title:ServiceCategorySubclassService
 * @description:服务类别子类表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:42
 */
public interface ServiceCategorySubclassService extends Service<ServiceCategorySubclass> {

    /**
     * 添加服务类别子类数据
     *
     * @param request
     */
    void save(ServiceCategorySubclassRequest request);
}
