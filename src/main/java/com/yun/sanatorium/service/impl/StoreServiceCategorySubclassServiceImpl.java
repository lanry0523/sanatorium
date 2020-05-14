package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.StoreServiceCategorySubclassMapper;
import com.yun.sanatorium.model.entity.ServiceCategorySubclass;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.entity.StoreServiceCategorySubclass;
import com.yun.sanatorium.service.StoreService;
import com.yun.sanatorium.service.StoreServiceCategorySubclassService;
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
 * @title:StoreServiceCategorySubclassServiceImpl
 * @description:门店关联服务子类表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:58:01
 */
@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceCategorySubclassServiceImpl extends AbstractService<StoreServiceCategorySubclass> implements StoreServiceCategorySubclassService {

    @Resource
    private StoreService storeService;

    @Resource
    private StoreServiceCategorySubclassMapper storeServiceCategorySubclassMapper;

    @Override
    public Integer saveByServiceCategorySubclass(ServiceCategorySubclass serviceCategorySubclass, List<Store> storeList) {

        // 初始化
        List<StoreServiceCategorySubclass> list = new ArrayList<>();

        // 1.如果storeList是空，则说明适用于所有门店
        if (CollectionUtils.isEmpty(storeList)) {
            storeList = storeService.findAll();
        }

        // 2.循环编辑数据添加至list
        for (Store store : storeList) {
            StoreServiceCategorySubclass StoreServiceCategorySubclass = new StoreServiceCategorySubclass();
            StoreServiceCategorySubclass.setId(Util.getUUID());
            StoreServiceCategorySubclass.setStoreId(store.getId());
            StoreServiceCategorySubclass.setStoreName(store.getName());
            StoreServiceCategorySubclass.setServiceCategoryId(serviceCategorySubclass.getId());
            StoreServiceCategorySubclass.setServiceCategoryName(serviceCategorySubclass.getName());
            StoreServiceCategorySubclass.setServiceCategorySubclassId(serviceCategorySubclass.getId());
            StoreServiceCategorySubclass.setServiceCategorySubclassName(serviceCategorySubclass.getName());
            StoreServiceCategorySubclass.setCreateTime(DateUtils.getCurrentTime());
            list.add(StoreServiceCategorySubclass);
        }

        // 3.更新数据库
        return storeServiceCategorySubclassMapper.insertList(list);
    }
}
