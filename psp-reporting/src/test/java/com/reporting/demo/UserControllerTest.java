package com.reporting.demo;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest extends BaseController{

	@Test
	public void testGetByEmail() throws Exception {

		String uri = "/api/v3/merchant/user/getByEmail";
		
		//prepare the request Json object
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("email", "aa@aa.com");

		//call the api
		MvcResult mvcResult = doRequestParamRestCall(uri,jsonRequest,"aa@aa.com");
		
		//pars result to json
		JSONObject jsonResponse = new JSONObject(mvcResult.getResponse().getContentAsString());
		//chack if the data queried successfully by asserting the id value  
		Assert.assertEquals("id is expected 1 for the given user aa@aa.com", 1, jsonResponse.get("id"));
		

	}


}
