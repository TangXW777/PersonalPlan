package com.tang.base;

import java.io.Serializable;
import java.util.List;

/**
 * 基础Dao
 * 定义了一些基本的CRUD操作
 * @author TangXW
 *
 * @param <T>
 */
public interface BaseDao<T> {
	// 根据id加载实体
	T get(Class<T> entityClazz, Serializable id);
	
	// 保存实体
	Serializable save(T entity);
	
	// 更新实体
	void update(T entity);
	
	// 删除实体
	void delete(T entity);
	
	// 根据id删除实体
	void delete(Class<T> entityClazz, Serializable id);
	
	// 获取全部的实体
	List<T> findAll(Class<T> entityClazz);
	
	// 获取实体总数
	long findCount(Class<T> entityClazz);
}
