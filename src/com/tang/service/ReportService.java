package com.tang.service;

import java.io.Serializable;
import java.util.List;

import com.tang.domain.Report;

/**
 * ReportService
 * @author TangXW
 *
 */
public interface ReportService {
	// 保存汇报
	boolean addReport(Report report);
	
	// 查询该用户的所有汇报
	List<Report> find(Integer userid);
}
