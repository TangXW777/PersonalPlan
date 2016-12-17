package com.tang.service;

import java.util.List;

import com.tang.domain.Task;

/**
 * TaskService
 * @author TangXW
 *
 */
public interface TaskService {
	// 保存任务
	boolean addTask(Task task);
	
	// 查找该用户的所有任务
	List<Task> find(Integer userid);
	
	// 根据特定id查找Task
	Task get(Integer taskid);
	
	// 更新Task
	void update(Task task); 
}
