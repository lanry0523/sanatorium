package com.yun.sanatorium.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * @title:Service
 * @description: Service层基础接口，其他Service接口请继承该接口
 * @author:prince
 * @date:2020/5/7 11:01
 */
public interface Service<T> {

    /**
     * 持久化
     *
     * @param model
     * @return
     */
    Integer save(T model);

    /**
     * 批量持久化
     *
     * @param models
     * @return
     */
    Integer save(List<T> models);

    /**
     * 通过主鍵刪除
     *
     * @param id
     * @return
     */
    Integer deleteById(String id);

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     *
     * @param ids
     * @return
     */
    Integer deleteByIds(String ids);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    Integer update(T model);

    /**
     * 通过ID查找
     *
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     *
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个ID查找//eg：ids -> “1,2,3,4”
     *
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查找
     *
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);

    /**
     * 获取所有
     *
     * @return
     */
    List<T> findAll();
}
