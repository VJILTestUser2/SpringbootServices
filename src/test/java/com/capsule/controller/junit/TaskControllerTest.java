
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

import com.capsule.dao.ParentTask;
import com.capsule.dao.Project;
import com.capsule.dao.Task;
import com.capsule.dao.User;
import com.capsule.springboot.main.AbstractTest;

@RestController
public class TaskControllerTest extends AbstractTest {

	@Before
	public void setUp() {
		super.setUp();
	}

	int randomServerPort = 8090;

	@Test public void testGetTaskListSuccess() throws URISyntaxException {
  RestTemplate restTemplate = new RestTemplate();
  
  final String baseUrl = "http://localhost:" + randomServerPort +
  "/getAllTasks"; URI uri = new URI(baseUrl);
  
  ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
  
  //Verify request succeed Assert.assertEquals(200,
  result.getStatusCodeValue();
  
  }

	@Test
	public void getTasksTest() throws Exception {
		String uri = "/getAllTasks";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Task[] tasklist = super.mapFromJson(content, Task[].class);
		assertTrue(tasklist.length > 0);
	}

	@Test
	public void addTaskTest() throws Exception {

		Date d = new Date();
		String uri = "/addTasks";
		Task task = new Task();
		task.setEnddate(d);
		task.setStartdate(d);
		task.setPriority(3);
		task.setPid(45);
		task.setProjectname("Green");
		task.setStatus("CMP");
		task.setTask_id(90);
		task.setTask("uuuu");

		String inputJson = super.mapToJson(task);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString(); //
		assertEquals(content, "Success");
	}
	
	@Test
	public void addParentTasksTest() throws Exception {
		
		String uri = "/paddTasks";
		ParentTask pt = new ParentTask();
		pt.setTask("YYYY");

		String inputJson = super.mapToJson(pt);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString(); //
		//assertEquals(content, "Success");
	}


	@Test
	public void updateTaskTest() throws Exception {
		String uri = "/updateTask";
		Date d = new Date();
		Task task = new Task();
		task.setEnddate(d);
		task.setStartdate(d);
		task.setPriority(3);
		task.setPid(45);
		task.setProjectname("Green");
		task.setStatus("CMP");
		task.setTask_id(90);
		task.setTask("uuuu");

		String inputJson = super.mapToJson(task);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString(); //
		//assertEquals(content, "Product is updated successsfully");
	}

	@Test
	public void deleteTaskTest() throws Exception {
		String uri = "/deleteTasks/75";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString(); //
		assertEquals(content, "Deleted");
	}

}
