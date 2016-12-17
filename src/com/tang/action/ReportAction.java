package com.tang.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tang.domain.Report;
import com.tang.domain.User;
import com.tang.service.ReportService;

/**
 * ReportAction
 * @author TangXW
 *
 */
public class ReportAction extends ActionSupport
	implements SessionAware{
	private Report report;
	private List<Report> rList;
	
	private Map<String, Object> session;
	// 依赖注入
	private ReportService reportService;
	
	// 增加汇报
	public String addReport(){
		User user = (User) session.get("user");
		// 映射关系注入
		report.setUser(user);
		if(reportService.addReport(report)){
			System.out.println("添加汇报成功");
			return SUCCESS;
		}
		return ERROR;
	}
	
	// 查找该用户的所有汇报
	public String showReport(){
		Integer userid = ((User)session.get("user")).getUserid();
		rList = reportService.find(userid);
		System.out.println("showReport " + ServletActionContext.getRequest().getSession()
		.getAttribute("WW_TRANS_I18N_LOCALE"));
		if(rList != null && rList.size() > 0){
			System.out.println("查找用户汇报成功");
			return SUCCESS;
		}else{
			System.out.println("该用户还没有汇报");
			return ERROR;
		}
	}

	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public ReportService getReportService() {
		return reportService;
	}
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	public List<Report> getrList() {
		return rList;
	}
	public void setrList(List<Report> rList) {
		this.rList = rList;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
