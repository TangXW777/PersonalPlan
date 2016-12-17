package com.tang.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tang.domain.Task;
import com.tang.domain.User;
import com.tang.service.TaskService;

public class TaskAction extends ActionSupport
implements SessionAware,ServletRequestAware{
	private Task task;
	private Map<String, Object> session;
	private HttpServletRequest request;
	private List<Task> tList;
	
	// 依赖注入
	private TaskService taskService;

	public TaskService getTaskService() {
		return taskService;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
	// 增加任务
	public String addTask(){
		User user = (User) session.get("user");
		task.setUser(user);
		if(taskService.addTask(task)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	// 查找该用户所有的任务
	public String showTask(){
		System.out.println("showTask " + ServletActionContext.getRequest().getSession()
				.getAttribute("WW_TRANS_I18N_LOCALE"));
		Integer userid = ((User)session.get("user")).getUserid();
		tList = taskService.find(userid);
		if(tList != null && tList.size() > 0){
			System.out.println("查找任务成功");
			return SUCCESS;
		}else{
			System.out.println("该用户还没有任务");
			return ERROR;
		}
		
	}
	
	// 修改Task前的查找特定Task
	public String preModify(){
		Integer taskid = Integer.parseInt(request.getParameter("taskid"));
		System.out.println(taskid);
		Task task = taskService.get(taskid);
		String[] status = {this.getText("task.status0"), this.getText("task.status1"), this.getText("task.status2")};
		for(String s :status){
			System.out.println(s);
		}
		if(task != null){
			request.setAttribute("task", task);
			request.setAttribute("status", status);
			System.out.println("查找特定task成功");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	// 修改Task
	public String modify(){
		User user = (User) session.get("user");
		task.setUser(user);
		taskService.update(task);
		System.out.println("修改task成功");
		return SUCCESS;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public List<Task> gettList() {
		return tList;
	}
	public void settList(List<Task> tList) {
		this.tList = tList;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
}
