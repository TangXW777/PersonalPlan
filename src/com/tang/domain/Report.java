package com.tang.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Report(汇报)PO类
 * @author TangXW
 *
 */
@Entity
@Table(name="report")
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reportid")
	private Integer reportid; // 汇报id
	
	@Column(name="task")
	private String task; // 今日完成任务
	
	@Column(name="question")
	private String question; // 今日遇到问题
	
	@Column(name="plan")
	private String plan; // 明日计划
	
	@Column(name="remark")
	private String remark; // 备注
	
	@Column(name="date")
	private Date date; // 修改时间
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="userid", referencedColumnName="userid",
			nullable=false)
	private User user; // 所属用户
	
	public Report(){
		
	}

	public Integer getReportid() {
		return reportid;
	}

	public void setReportid(Integer reportid) {
		this.reportid = reportid;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
