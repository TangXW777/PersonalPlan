package com.tang.dao.impl;

import java.util.List;

import com.tang.base.impl.BaseDaoImpl;
import com.tang.dao.TaskDao;
import com.tang.domain.Task;

/**
 * Task Dao Impl
 * 继承BaseDaoImpl
 * 实现了TaskDao接口
 * @author TangXW
 *
 */
public class TaskDaoImpl extends BaseDaoImpl<Task> 
	implements TaskDao{
	// 查找该用户的所有任务
	public List<Task> find(Integer userid) {
		return this.find("from Task where user.userid = ?0", userid);
	}
	
}
