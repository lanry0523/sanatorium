package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.ServiceCategorySubclass;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.entity.StoreServiceCategorySubclass;

import java.util.List;

/**
 * @title:StoreServiceCategorySubclassService
 * @description:门店关联服务子类表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:01
 */
public interface StoreServiceCategorySubclassService extends Service<StoreServiceCategorySubclass> {

    /**
     * 添加门店关联服务类别子类数据
     *
     * @param serviceCategorySubclass
     * @param storeList
     * @return
     */
    Integer saveByServiceCategorySubclass(ServiceCategorySubclass serviceCategorySubclass, List<Store> storeList);
}
