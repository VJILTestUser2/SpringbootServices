package com.capsule.springboot;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capsule.dao.User;
	
	//@Repository
	public interface UserRepository extends CrudRepository<User,Integer> {
		
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query("UPDATE User c SET c.firstname = :firstname c.lastname = :lastname WHERE c.employee = :employee"
	 * ) void updateUser(@Param("employee") int employee);
	 */
			
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query("UPDATE Company c SET c.address = :address WHERE c.id = :companyId")
	 * int updateAddress(@Param("companyId") int companyId, @Param("address") String
	 * address);
	 */

	}



