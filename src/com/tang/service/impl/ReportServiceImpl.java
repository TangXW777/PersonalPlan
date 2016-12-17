package com.tang.service.impl;

import java.util.List;

import com.tang.dao.ReportDao;
import com.tang.domain.Report;
import com.tang.service.ReportService;

/**
 * ReportServiceImpl
 * 注入ReportDaoImpl
 * @author TangXW
 *
 */
public class ReportServiceImpl implements ReportService{
	// 依赖注入
	private ReportDao reportDao;
	
	public ReportDao getReportDao() {
		return reportDao;
	}
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	// 添加report
	public boolean addReport(Report report) {
		boolean flag = false;
		Integer result = (Integer) reportDao.save(report);
		if(result > 0){
			flag = true;
		}
		return flag;
	}
	
	// 查询该用户的所有汇报
	public List<Report> find(Integer userid) {
		return reportDao.find(userid);
	}

}
