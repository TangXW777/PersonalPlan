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
 * Task(任务)PO类
 * @author TangXW
 *
 */
@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="taskid")
	private Integer taskid; // 任务id
	
	@Column(name="content")
	private String content; // 任务内容
	
	@Column(name="date")
	private Date date; // 创建时间
	
	@Column(name="remark")
	private String remark; // 备注
	
	@Column(name="status")
	private String status; // 状态
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="userid", referencedColumnName="userid",
			nullable=false)
	private User user; // 所属用户

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
