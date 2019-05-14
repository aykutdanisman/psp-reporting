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
public class ClientControllerTest extends BaseController{

	@Test
	public void testGetClientByTID() throws Exception {

		String uri = "/api/v3/client";
		
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("transactionId", "111");

		MvcResult mvcResult = doJSonRestCall(uri,jsonRequest,"aa@aa.com");
		log.info(uri+" api response : "+mvcResult.getResponse().getContentAsString());
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals("Status 200 expected", 200, status);
		

	}


}
