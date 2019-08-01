package com.capsule.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.dao.Task;
import com.capsule.dao.User;
import com.capsule.springboot.UserRepository;

@Service
public class UserServicesimpl {

	@Autowired
	UserRepository urepository;

	@Autowired
	EntityManager entitymanager;

	public User addUser(User u) {

		urepository.save(u);
		return u;
	}

	public int getUserById(int employee) {

		User user = entitymanager.find(User.class, employee);
		int uid = user.getEmployee(); 
		System.out.println(user.getEmployee());
		return uid;

	}

	public List<User> getAllUsers() {

		return (List<User>) urepository.findAll();
	}

	public void deleteUser(int employee) {

		System.out.println("In Deleted user");
		urepository.deleteById(employee);
	}

	public void updateUser(User user) {

		urepository.save(user);
		// return u;
	}

}
