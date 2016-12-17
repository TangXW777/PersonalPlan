package com.tang.dao;

import java.util.List;

import com.tang.base.BaseDao;
import com.tang.domain.Report;

/**
 * Report Dao
 * 继承BaseDao
 * @author TangXW
 *
 */
public interface ReportDao extends BaseDao<Report>{
	// 查找改用户的所有汇报
	List<Report> find(Integer userid);
}
