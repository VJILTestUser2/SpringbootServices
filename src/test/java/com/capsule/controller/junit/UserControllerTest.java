package com.capsule.controller.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.capsule.dao.Project;
import com.capsule.dao.User;
import com.capsule.springboot.main.AbstractTest;


@RestController
public class UserControllerTest extends AbstractTest{
	
	@Before
	   public void setUp() {
	      super.setUp();
	   }
	
	int randomServerPort = 8090;
	int deleteId;

	@Test
	public void testGetUserListSuccess() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + randomServerPort + "/getallUsers";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	  
	}
	
	@Test
	public void getAllUsersTest() throws Exception {
	   String uri = "/getallUsers";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   User[] userList = super.mapFromJson(content, User[].class);
	   assertTrue(userList.length > 0);
	}
	
	@Test
	public void addUserTest() throws Exception {
		
	   String uri = "/addUser";
	   User user = new User();
	  // project.setProject_id(89);
	   user.setId(89);
	   user.setFirstname("cccc");
	   user.setLastname("tttt");
	   user.setEmployee(12);
	   user.setProjectid(90);
	   user.setTask(90);
	   
	   String inputJson = super.mapToJson(user);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	  // assertEquals(content, "Success");
	}
	
	@Test
	public void updateUserTest() throws Exception {
		deleteId = 345;
	   String uri = "/updateusers";
	   User user = new User();
	   user.setId(89);
	   user.setFirstname("cccc");
	   user.setLastname("Tej");
	   user.setEmployee(12);
	   user.setProjectid(90);
	   user.setTask(90);
	  
	   
	   String inputJson = super.mapToJson(user);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	 //  assertEquals(content, "User is updated successsfully");
	}
	
	@Test
	public void deleteUserTest() throws Exception {
		
	   String uri = "/deleteUser/44";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	  // i= i+1;
	  // assertEquals(content, "Deleted");
	}
	
	
}
