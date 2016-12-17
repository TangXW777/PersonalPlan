package com.tang.service.impl;

import java.util.List;

import com.tang.dao.UserDao;
import com.tang.domain.User;
import com.tang.service.UserService;

/**
 * UserServiceImpl
 * @author TangXW
 *
 */
public class UserServiceImpl implements UserService{
	// 依赖注入
	private UserDao userDao;
	
	// 登录验证
	public User login(User user) {
		User rightUser = null;
		List<User> l = userDao.findUserByAccount(user.getAccount(), user.getPassword());
		if(l != null && l.size() == 1){
			rightUser = l.get(0);
		}
		return rightUser;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
