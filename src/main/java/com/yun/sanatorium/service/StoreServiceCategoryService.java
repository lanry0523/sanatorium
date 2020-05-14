package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.ServiceCategory;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.entity.StoreServiceCategory;

import java.util.List;

/**
 * @title:StoreServiceCategoryService
 * @description:门店关联服务类别顶级分类表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
public interface StoreServiceCategoryService extends Service<StoreServiceCategory> {

    /**
     * 添加门店关联服务类别顶级分类数据
     *
     * @param serviceCategory
     * @param storeList
     * @return
     */
    Integer saveByServiceCategory(ServiceCategory serviceCategory, List<Store> storeList);
}
