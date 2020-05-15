package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.StoreServiceCategoryMapper;
import com.yun.sanatorium.model.entity.ServiceCategory;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.entity.StoreServiceCategory;
import com.yun.sanatorium.service.StoreService;
import com.yun.sanatorium.service.StoreServiceCategoryService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:StoreServiceCategoryServiceImpl
 * @description:门店关联服务类别顶级分类表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:57:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceCategoryServiceImpl extends AbstractService<StoreServiceCategory> implements StoreServiceCategoryService {

    @Resource
    private StoreService storeService;

    @Resource
    private StoreServiceCategoryMapper storeServiceCategoryMapper;

    @Override
    public Integer saveByServiceCategory(ServiceCategory serviceCategory, List<Store> storeList) {

        // 初始化
        List<StoreServiceCategory> list = new ArrayList<>();

        // 1.如果storeList是空，则说明适用于所有门店
        if (CollectionUtils.isEmpty(storeList)) {
            storeList = storeService.findAll();
        }

        // 2.循环编辑数据添加至list
        for (Store store : storeList) {
            StoreServiceCategory storeServiceCategory = new StoreServiceCategory();
            storeServiceCategory.setId(Util.getUUID());
            storeServiceCategory.setStoreId(store.getId());
            storeServiceCategory.setStoreName(store.getName());
            storeServiceCategory.setServiceCategoryId(serviceCategory.getId());
            storeServiceCategory.setServiceCategoryName(serviceCategory.getName());
            storeServiceCategory.setCreateTime(DateUtils.getCurrentTime());
            list.add(storeServiceCategory);
        }

        // 3.更新数据库
        return storeServiceCategoryMapper.insertList(list);
    }
}
