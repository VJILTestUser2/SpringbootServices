
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
import com.capsule.springboot.main.AbstractTest;

@RestController
public class ProjectControllerTest extends AbstractTest {

	@Before
	public void setUp() {
		super.setUp();
	}

	int randomServerPort = 8090;

	@Test
	public void testGetProjectsListSuccess() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort + "/getallProject";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void getAllProjectsTest() throws Exception {
		String uri = "/getallProject";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Project[] productlist = super.mapFromJson(content, Project[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void addProjectTest() throws Exception {

		Date d = new Date();
		String uri = "/addProject";
		Project project = new Project();
		project.setprojectId(89);
		project.setProject(null);
		project.setStart_date(d);
		project.setEnd_date(d);
		project.setPriority(3);
		project.setNotasks(1);
		project.setStatus_count(1);

		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		//assertEquals(content, "Success");
	}

	@Test
	public void updateProjectTest() throws Exception {
		String uri = "/updateproject";
		Date d = new Date();
		Project project = new Project();
		project.setprojectId(89);
		project.setProject(null);
		project.setStart_date(d);
		project.setEnd_date(d);
		project.setPriority(3);
		project.setNotasks(1);
		project.setStatus_count(1);

		String inputJson = super.mapToJson(project);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		// assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString(); //
		assertEquals(content, " Updated ");
	}

	@Test
	public void deleteProjectTest() throws Exception {
		String uri = "/deleteProject/56";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString(); //
		assertEquals(content, " Deleted ");
	}

}
