package com.tang.action;

import java.util.Locale;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.tang.domain.User;
import com.tang.service.UserService;

/**
 * UserAction
 * @author TangXW
 *
 */
public class UserAction extends ActionSupport
	implements SessionAware{
	private User user;
	
	private Map<String, Object> session;
	// 依赖注入
	private UserService userService;
	
	public String changeLanguage(){
		return SUCCESS;
	}

	@InputConfig(resultName="error")
	public String login(){
		User rightUser = userService.login(user);
		if(rightUser != null){
			this.session.put("user", rightUser);
			return SUCCESS;
		}else{
			addFieldError("user.password", this.getText("login.error"));
			return ERROR;
		}
	}
	
	public String logout(){
		session.remove("user");
		return SUCCESS;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
