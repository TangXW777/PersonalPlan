package com.tang.dao;

import java.util.List;

import com.tang.base.BaseDao;
import com.tang.domain.User;

/**
 * User Dao
 * 继承BaseDao
 * @author TangXW
 *
 */
public interface UserDao extends BaseDao<User>{
	// 根据账户查找用户
	List<User> findUserByAccount(String account, String password);
}
