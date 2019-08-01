package com.capsule.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.Columns;

@Entity
@Table(name = "taskdetails")
public class Task implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	public Integer task_id;

	/*
	 * @Column(name = "parentid") public int parentid;
	 */
	
	@Column(name = "pid")
	public int pid;
	@Column(name = "task")
	public String task;
	@Column(name = "startdate")
	public Date startdate;
	@Column(name = "enddate")
	public Date enddate;
	@Column(name = "priority")
	public int priority;
	@Column(name = "status")
	public String status;
	@Column(name = "projectname")
	public String projectname;
	
	public Task() {
		
	}
	public Task(String pname,int task_id,int parentid,int projet_id, 
			String project,int pri, int status) {
		
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid",referencedColumnName="project_id", insertable = false, updatable = false)
	public Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	/*
	 * public int getParentid() { return parentid; }
	 * 
	 * public void setParentid(int parentid) { this.parentid = parentid; }
	 */

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * public int getParentid() { return parentid; } public void setParentid(int
	 * parentid) { this.parentid = parentid; }
	 * 
	 * @Column(name="task") public String task;
	 * 
	 * @Column(name="priority") public int priority;
	 * 
	 * @Column(name="startdate") public String startdate;
	 * 
	 * @Column(name="enddate") public String enddate;
	 * 
	 * @OneToOne(targetEntity=ParentTask.class,cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="task_id" , referencedColumnName="parent_id") public
	 * ParentTask ptask;
	 * 
	 * public ParentTask getPtask() { return ptask; } public void
	 * setPtask(ParentTask ptask) { this.ptask = ptask; } public int getTask_id() {
	 * return task_id; } public void setTask_id(int task_id) { this.task_id =
	 * task_id; }
	 * 
	 * public String getTask() { return task; } public void setTask(String task) {
	 * this.task = task; } public String getStartdate() { return startdate; } public
	 * void setStartdate(String startdate) { this.startdate = startdate; } public
	 * String getEnddate() { return enddate; } public void setEnddate(String
	 * enddate) { this.enddate = enddate; } public int getPriority() { return
	 * priority; } public void setPriority(int priority) { this.priority = priority;
	 * }
	 */

}
