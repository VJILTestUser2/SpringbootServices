package com.capsule.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.dao.Project;
import com.capsule.dao.User;
import com.capsule.springboot.ProjectRepository;
import com.capsule.springboot.UserRepository;

@Service
public class ProjectServiceimpl {
	
	@Autowired
	ProjectRepository prepository;

	public Project addProject(Project project) {

		prepository.save(project);
		return project;
	}

	public List<Project> getAllProject() {

		return (List<Project>) prepository.findAll();
	}
	
	public void deleteProject(int project_id) {
		
		System.out.println("In Deleted user");
		prepository.deleteById(project_id);
		
	}
	
	public void updateProject(Project project) {

		prepository.save(project);
		// return u;
	}
}
