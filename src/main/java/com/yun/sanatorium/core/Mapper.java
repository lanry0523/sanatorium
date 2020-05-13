package com.yun.sanatorium.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @title:Mapper
 * @description:定制版MyBatis Mapper插件接口，如需其他接口参考官方文档自行添加
 * @author:prince
 * @date:2020/5/7 11:01
 */
public interface Mapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {
}
