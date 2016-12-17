package com.tang.dao.impl;

import java.util.List;

import com.tang.base.impl.BaseDaoImpl;
import com.tang.dao.ReportDao;
import com.tang.domain.Report;

/**
 * Report Dao Impl
 * 继承BaseDaoImpl
 * 实现了ReportDao接口
 * @author TangXW
 *
 */
public class ReportDaoImpl extends BaseDaoImpl<Report> 
	implements ReportDao{
	// 查找该用户的所有汇报
	public List<Report> find(Integer userid) {
		return this.find("from Report where user.userid = ?0", userid);
	}
}
