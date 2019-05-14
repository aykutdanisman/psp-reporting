package com.reporting.demo;

import org.json.JSONObject;
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
public class TransactionControllerTest extends BaseController {




	@Test
	public void testGetTransactionReport() throws Exception {

		String uri = "/api/v3/transactions/report";
		
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("fromDate", "2019-01-01");
		jsonRequest.put("toDate", "2019-01-01");
		jsonRequest.put("merchant", "1");
		jsonRequest.put("acquirer", "1");

		MvcResult mvcResult = doJSonRestCall(uri,jsonRequest,"aa@aa.com");
		
		
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals("Status 200 expected", 200, status);

	}


}
