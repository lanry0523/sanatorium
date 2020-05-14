package com.yun.sanatorium.service;

import com.yun.sanatorium.core.Service;
import com.yun.sanatorium.model.entity.Store;
import com.yun.sanatorium.model.request.StoreRequest;
import com.yun.sanatorium.model.vo.StoreVo;

/**
 * @title:StoreService
 * @description:门店表service层接口
 * @author:CodeGenerator
 * @date:2020/05/13 17:44:34
 */
public interface StoreService extends Service<Store> {

    /**
     * 添加门店
     *
     * @param request
     */
    void save(StoreRequest request);

    /**
     * 修改门店信息
     *
     * @param request
     */
    void updateByPrimaryKeySelective(StoreRequest request);

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    StoreVo findVoById(String id);
}
