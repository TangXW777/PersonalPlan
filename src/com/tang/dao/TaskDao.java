package com.tang.dao;

import java.util.List;

import com.tang.base.BaseDao;
import com.tang.domain.Task;

/**
 * Task Dao
 * 继承BaseDao
 * @author TangXW
 *
 */
public interface TaskDao extends BaseDao<Task>{
	// 查找该用户的所有任务
	List<Task> find(Integer userid);
}
