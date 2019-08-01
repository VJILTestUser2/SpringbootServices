package com.capsule.springboot;

import org.springframework.data.repository.CrudRepository;

import com.capsule.dao.Project;

public interface ProjectRepository extends CrudRepository<Project,Integer>{

}
