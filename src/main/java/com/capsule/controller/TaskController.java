package com.capsule.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.dao.ParentTask;
import com.capsule.dao.Project;
import com.capsule.dao.Task;
import com.capsule.serviceimpl.ProjectServiceimpl;
import com.capsule.serviceimpl.TaskServicesimpl;
import com.capsule.springboot.TaskRepository;

//import com.capsule.beans.ParentTask;
//import com.capsule.beans.Task;
//import com.capsule.repository.TaskRepository;
//import com.capsule.beans.ParentTask;
//import com.capsule.beans.Task;
//import com.capsule.taskserviceimpl.TaskServicesimpl;
//import com.capsule.springboot.TaskServicesimpl;
//import com.capsule.taskserviceimpl.TaskServicesimpl;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
public class TaskController {

	@Autowired
	TaskServicesimpl taskServiceimpl;

	@Autowired
	ProjectServiceimpl projectServiceimpl;

	TaskRepository taskrepo;

	@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = "/getAllTasks")
	public ResponseEntity<Object> getTasks() {
				
		return ResponseEntity.ok(taskServiceimpl.getAllTasks());
		// return new ResponseEntity<>(taskRepo.values(), HttpStatus.OK);
	}

	/*@RequestMapping("getTask/{id}")
	public ResponseEntity<Object> getArticleById(@PathVariable("id") Integer id) {
		Task article = taskServiceimpl.getTaskById(id);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}*/

	// @CrossOrigin (origins = "*" , allowedHeaders = "*")
	@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = "/addTasks")
	public ResponseEntity<Object> addTask(@RequestBody Task article) {
		
		String pname = article.getProjectname();
		List<Project> listofProjects = projectServiceimpl.getAllProject();
		for(Project pro : listofProjects) {
			if(pro.getProject().equalsIgnoreCase(pname)) {
				int pid = pro.getProjectId();
				article.setPid(pid);
			
				taskServiceimpl.addTasks(article);
			}
		}
		taskServiceimpl.addTasks(article);
		return ResponseEntity.ok("Task Added Successfuly.");

	}
	
	
	@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = "/paddTasks")
	public ResponseEntity<Object> addParentTask(@RequestBody ParentTask article) {
			
		taskServiceimpl.addParentTasks(article);
		
		
		return ResponseEntity.ok("ParentTask Added Successfuly.");

	}

	/*
	 * @RequestMapping(value = "/updateTasks/{id}", method = RequestMethod.PUT)
	 * public ResponseEntity<Object> updateTask(@PathVariable("id") int id) {
	 * 
	 * taskServiceimpl.update(id);
	 * 
	 * return new ResponseEntity<>("Task is updated successsfully", HttpStatus.OK);
	 * }
	 */

	/*@CrossOrigin(origins = { "http://localhost:4200" })
	@RequestMapping(value = "/updateTasks", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateTask(@RequestBody Task article) {

		Task task = new Task();
		// taskServiceimpl.getTaskById(id);
		ParentTask ptask = new ParentTask();
		ptask.setParent_id(article.getParentid());
		ptask.setParenttask(article.getTask());

		System.out.println(article.getTask_id());
		task.setTask_id(article.getTask_id());
		System.out.println(article.getTask_id());
		task.setTask(article.getTask());
		System.out.println(article.getTask());
		task.setParentid(article.getParentid());
		System.out.println(article.getParentid());
		task.setPriority(article.getPriority());
		System.out.println(article.getPriority());
		task.setStartdate(article.getStartdate());
		System.out.println(article.getStartdate());
		task.setEnddate(article.getEnddate());
		System.out.println(article.getEnddate());
		// task.setPtask(ptask);
		System.out.println(task);

		taskServiceimpl.update(article);

		return new ResponseEntity<>("Task is updated successsfully", HttpStatus.OK);
	}*/
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@RequestMapping(value = "/deleteTasks/{task_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteTask(@PathVariable("task_id") String task_id) {
		
		int tid = Integer.parseInt(task_id);
		taskServiceimpl.delete(tid);
		return ResponseEntity.ok("Task is deleted successsfully");

	}
	
	
	   @CrossOrigin(origins = {"http://localhost:4200"})
	   @RequestMapping(value = "/updateTask", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateTask(@RequestBody Task task) { 
		
		
		   taskServiceimpl.update(task);
	
		      return ResponseEntity.ok(" Updated ");
	   }
	
	

}
