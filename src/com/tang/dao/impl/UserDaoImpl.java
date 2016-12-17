package com.tang.dao.impl;

import java.util.List;

import com.tang.base.impl.BaseDaoImpl;
import com.tang.dao.UserDao;
import com.tang.domain.User;

/**
 * User Dao Impl
 * 继承BaseDaoImpl
 * 实现了UserDao接口
 * @author TangXW
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> 
	implements UserDao{
	// 根据账户查找用户
	public List<User> findUserByAccount(String account, String password) {
		return this.find("from User u where u.account = ?0 and u.password = ?1", account, password);
	}

}
