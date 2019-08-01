package com.capsule.dao;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="userdetails")
//@Access(value= AccessType.FIELD)
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
		
	}
	@Column(name="projectid")
	int projectid;
	
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	@Column(name="task")
	int task;
	
	
	@Column(name="firstname")
	String firstname;
	
	@Column(name="lastname")
	String lastname;
	
	@Column(name="employee")
	int employee;
	
	public int getEmployee() {
		return employee;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setEmployee(int employee) {
		this.employee = employee;
	}
	
	public int getTask() {
		return task;
	}
	public void setTask(int task) {
		this.task = task;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		
	

}
