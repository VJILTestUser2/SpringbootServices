package com.capsule.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "projects", uniqueConstraints = {
		@UniqueConstraint(columnNames = "project", name = "uniqueNameConstraint") })
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	Integer projectId;

	@Column(unique = true)
//	@Column(name = "project")
	String project;

	@Column(name = "start_date")
	Date start_date;

	@Column(name = "end_date")
	Date end_date;

	@Column(name = "priority")
	int priority;

	@Column(name = "notasks")
	int notasks;
	
	@Column(name = "status_count")
	public int status_count;

	/*@ManyToOne(optional = false)
	@JoinColumn(name = "project_id", referencedColumnName = "projectid", insertable = false, updatable = false)
	public User user;*/

	public int getNotasks() {
		return notasks;
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/

	public void setNotasks(int notasks) {
		this.notasks = notasks;
	}

	

	/*
	 * @OneToOne(cascade=CascadeType.ALL) public Task task;
	 * 
	 * public Task getTask() { return task; }
	 * 
	 * public void setTask(Task task) { this.task = task; }
	 */

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	/*
	 * @OneToMany(cascade = { CascadeType.ALL })
	 * 
	 * @JoinColumn(name="project_id")
	 * 
	 * @OrderColumn(name="type") private List<Task> task;
	 * 
	 * public List<Task> getTask() { return task; }
	 * 
	 * public void setTask(List<Task> task) { this.task = task; }
	 */
	public Project() {

	}

	public int getStatus_count() {
		return status_count;
	}

	public void setStatus_count(int status_count) {
		this.status_count = status_count;
	}

	public Project(int projectId, String project, Date i, Date j, int priority) {

	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setprojectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
