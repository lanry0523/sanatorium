package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.ServiceCategory;
import com.yun.sanatorium.model.request.ServiceCategoryRequest;

/**
 * @title:ServiceCategoryService
 * @description:服务类别顶级分类表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:56:18
 */
public interface ServiceCategoryService extends Service<ServiceCategory> {

    /**
     * 添加服务类别顶级分类数据
     *
     * @param request
     */
    void save(ServiceCategoryRequest request);

    /**
     * 更新服务类别顶级分类数据
     */
    void update(ServiceCategoryRequest request);
}
