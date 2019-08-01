package com.capsule.springboot;

import org.springframework.data.repository.CrudRepository;

import com.capsule.dao.ParentTask;
import com.capsule.dao.Project;

public interface ParentRepository extends CrudRepository<ParentTask,Integer>{

}
