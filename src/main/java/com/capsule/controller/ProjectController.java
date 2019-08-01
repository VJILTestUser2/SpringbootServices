package com.capsule.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.dao.Project;
import com.capsule.dao.Task;
import com.capsule.dao.User;
import com.capsule.serviceimpl.ProjectServiceimpl;
import com.capsule.serviceimpl.TaskServicesimpl;
import com.capsule.serviceimpl.UserServicesimpl;

@RestController
public class ProjectController {

	@Autowired
	ProjectServiceimpl projectServiceimpl;
	
	@Autowired
	TaskServicesimpl taskServiceimpl;


	@CrossOrigin(origins = {"http://localhost:4200"})
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ResponseEntity<Object> addProject(@RequestBody Project project) {
		if(project.getStart_date() == null && project.getEnd_date() == null && project.getProject().equalsIgnoreCase("")) {
			System.out.println(" Request is not in proper format");
		}else {
			projectServiceimpl.addProject(project);
		}
			
		
		return ResponseEntity.ok("Success");
	}
	
	@RequestMapping(value = "/getallProject", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllProjects() {
		Project p1 = new Project();
		int taskcount = 0;
		int taskcmpcount = 0;
		List<Project> project = projectServiceimpl.getAllProject();
		List<Task> task = taskServiceimpl.getAllTasks();
		
		for(Project p : project) {
			int pid = p.getProjectId();
			for(Task t : task) {
				int tid = t.getPid();
				if(pid == tid) {
					System.out.println(tid);
					List<Integer> totaltaskcount = new ArrayList<Integer>();
					List<Integer> totaltaskcmpcount = new ArrayList<Integer>();
					int notask = totaltaskcount.size();
					taskcount = taskcount + 1;
					p.setNotasks(taskcount);
					p.setStatus_count(taskcmpcount);
					projectServiceimpl.addProject(p);
					if((t.getProjectname().equalsIgnoreCase(p.getProject())) &&( t.getStatus().equalsIgnoreCase("CMP"))) {
						taskcmpcount = taskcmpcount + 1;
					//	totaltaskcount.add(taskcount);
						totaltaskcmpcount.add(taskcmpcount);
						p.setStatus_count(taskcmpcount);
						projectServiceimpl.addProject(p);
					}else if ((t.getProjectname().equalsIgnoreCase(p.getProject())) &&( t.getStatus().equalsIgnoreCase("PENDING"))){
						taskcmpcount = 0;
						p.setStatus_count(taskcmpcount);
						projectServiceimpl.addProject(p);
						System.out.println("Task is in Pending Status.");
					}
					System.out.println(totaltaskcount.size());
					
					System.out.println(p.getProject());
				}else {
					taskcount = 0;
					//p.setNotasks(taskcount);
					//projectServiceimpl.addProject(p);
				}
			}
		}
		System.out.println(task.size() + " FFFFFFFFFFFFF ");

		
		return ResponseEntity.ok(projectServiceimpl.getAllProject());
		// return new ResponseEntity<>(taskRepo.values(), HttpStatus.OK);
	}
	@CrossOrigin(origins = {"http://localhost:4200"})
	@RequestMapping(value = "/deleteProject/{priority}", method = RequestMethod.DELETE )
	public ResponseEntity<Object> deleteProject(@PathVariable("priority") String priority) {
		try {
			System.out.println(" Deleted 01 " + priority);
			int pid = Integer.parseInt(priority);
			projectServiceimpl.deleteProject(pid);
		}catch(Exception e) {
			System.out.println(e);
		}
		return ResponseEntity.ok(" Deleted ");
	}	
	
	   @CrossOrigin(origins = {"http://localhost:4200"})
	   @RequestMapping(value = "/updateproject", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProject(@RequestBody Project project) { 
		
		
		projectServiceimpl.updateProject(project);
	
		      return ResponseEntity.ok(" Updated ");
	   }
	
	

}
