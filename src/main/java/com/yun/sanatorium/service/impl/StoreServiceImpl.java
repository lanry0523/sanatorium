package com.yun.sanatorium.service.impl;

import com.yun.sanatorium.core.AbstractService;
import com.yun.sanatorium.dao.StoreMapper;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.request.StoreRequest;
import com.yun.sanatorium.model.vo.StoreVo;
import com.yun.sanatorium.service.StoreService;
import com.yun.sanatorium.utils.DateUtils;
import com.yun.sanatorium.utils.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @title:StoreServiceImpl
 * @description:门店表service层接口实现类
 * @author:CodeGenerator
 * @date:2020/05/13 17:44:34
 */
@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreServiceImpl extends AbstractService<Store> implements StoreService {

    @Resource
    private StoreMapper storeMapper;

    @Override
    public Integer save(StoreRequest request) {

        // 1.初始化操作
        Store store = new Store();
        String id = Util.getUUID();
        String createTime = DateUtils.getCurrentTime();

        // 2.编辑数据

        // 2.1 门店基础数据
        BeanUtils.copyProperties(request, store);
        store.setId(id);
        store.setCreateTime(createTime);

        // 2.2 TODO

        // 3.更新数据库
        return storeMapper.insert(store);
    }

    @Override
    public Integer updateByPrimaryKeySelective(StoreRequest request) {

        // 1.初始化操作
        Store store = new Store();
        String id = Util.getUUID();
        String currentTime = DateUtils.getCurrentTime();

        // 2.编辑数据

        // 2.1 门店基础数据
        BeanUtils.copyProperties(request, store);
        store.setId(id);
        store.setUpdateTime(currentTime);

        // 2.2 TODO

        // 3.更新数据库
        return storeMapper.updateByPrimaryKeySelective(store);
    }

    @Override
    public StoreVo findVoById(String id) {

        // 初始化返回结果集
        StoreVo storeVo = new StoreVo();

        // 1.查询门店基础数据
        Store store = storeMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(store, storeVo);

        // 2.TODO

        // 返回结果集
        return storeVo;
    }
}
