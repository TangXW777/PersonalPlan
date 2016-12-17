package com.tang.service.impl;

import java.util.List;

import com.tang.dao.TaskDao;
import com.tang.domain.Task;
import com.tang.service.TaskService;

/**
 * TaskServiceImpl
 * 注入TaskDaoImpl
 * @author TangXW
 *
 */
public class TaskServiceImpl implements TaskService{
	// 依赖注入
	private TaskDao taskDao;

	public TaskDao getTaskDao() {
		return taskDao;
	}
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
	
	// 增加任务
	public boolean addTask(Task task) {
		boolean flag = false;
		Integer result = (Integer) taskDao.save(task);
		if(result > 0){
			flag = true;
		}
		return flag;
	}
	
	// 查找该用户的所有任务
	public List<Task> find(Integer userid) {
		return taskDao.find(userid);
	}
	
	// 根据id查找特定task
	public Task get(Integer taskid) {
		return taskDao.get(Task.class, taskid);
	}
	
	public void update(Task task) {
		taskDao.update(task);
	}
	
}
