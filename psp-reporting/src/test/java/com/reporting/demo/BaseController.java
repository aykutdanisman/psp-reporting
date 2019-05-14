package com.reporting.demo;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class BaseController {
	
	private MockMvc mockMvc;
	private static Map<String, String> tokenMap; // keeps the authentication tokes with the key "email"
	private static Map<String, String> userLoginData;//keeps the authentication data of the test users <username, password>
	private static final String loginURI = "/api/v3/merchant/user/login";
	
	
	public BaseController() {
		
		//initialize the test user data
		BaseController.userLoginData = new HashMap<>();
		BaseController.userLoginData.put("aa@aa.com", "1234");
		userLoginData.put("cc@cc.com", "1234");
		
		//initialize the token Map
		tokenMap = new HashMap<String, String>(); 
	}
	
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	public MockMvc getMockMvc() {
		if (mockMvc == null)
			return mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
		
		return mockMvc;
	}
	
	/**
	 * entry point of the rest calls with JSon request
	 * @param uri : the uri of the rest api to be called --> ex:/api/v3/transactions/report
	 * @param jsonRequest : the request body
	 * @param authenticatedUser : the logined username(email). It is used to get new token if needed.  
	 * @return
	 * @throws Exception
	 */
	public MvcResult doJSonRestCall(String uri, JSONObject jsonRequest,String authenticatedUser) throws Exception {
		
		return getMockMvc().perform(MockMvcRequestBuilders
											.get(uri)
											.headers(getHeadersForJson(authenticatedUser))
											.contentType(MediaType.APPLICATION_JSON)
											.content(jsonRequest.toString())
											.accept(MediaType.APPLICATION_JSON)).andReturn();
	}
	
	/**
	 * entry point of the rest calls with request parameters
	 * @param uri : the uri of the rest api to be called --> ex:/api/v3/transactions/report
	 * @param jsonRequest : the request body
	 * @param authenticatedUser : the logined username(email). It is used to get new token if needed.  
	 * @return
	 * @throws Exception
	 */
	public MvcResult doRequestParamRestCall(String uri, JSONObject jsonRequest,String authenticatedUser) throws Exception {
		
		MockHttpServletRequestBuilder mockReqBuilder =  MockMvcRequestBuilders
															.get(uri)
															.headers(getHeadersForJson(authenticatedUser))
															.contentType(MediaType.APPLICATION_JSON)
															.accept(MediaType.APPLICATION_JSON);
		//dinamically add each attribute in JSonObject as a request parameter
		Iterator<String> it = jsonRequest.keys();
		while(it.hasNext()) {
			String key = it.next();
			mockReqBuilder.param(key, (String)jsonRequest.get(key));
		}
		
		
		return getMockMvc().perform(mockReqBuilder).andReturn();
	}
	
	/**
	 * prepares the header of the request.
	 * @param authenticatedUser
	 * @return
	 * @throws Exception
	 */
	protected HttpHeaders getHeadersForJson(String authenticatedUser) throws Exception {
		String token = getAuthorizationToken(authenticatedUser);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Accept", "application/json");
		httpHeaders.add("Content-Type", "application/json");
		httpHeaders.add("Authorization", "Bearer " + token);

		return httpHeaders;
	}

	/**
	 * checks weather authenticatedUser has already a token.
	 * if needed get a new token by calling login API
	 * @param authenticatedUser
	 * @return
	 * @throws Exception
	 */
	protected String getAuthorizationToken(String authenticatedUser) throws Exception {
		
		//if the user already has a token, return that
		if(BaseController.tokenMap.containsKey(authenticatedUser)) {
			return BaseController.tokenMap.get(authenticatedUser);
		}
		
		//else get a new token by login api
		String username = authenticatedUser; 
		String password = BaseController.userLoginData.get(authenticatedUser);
		
		JSONObject loginJSonRequest = new JSONObject();
		loginJSonRequest.put("email", username);
		loginJSonRequest.put("password", password);


		RequestBuilder requestBuilder = MockMvcRequestBuilders
											.post(loginURI)
											.accept(MediaType.APPLICATION_JSON)
											.content(loginJSonRequest.toString())
											.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = getMockMvc().perform(requestBuilder).andReturn();
		
		JSONObject obj = new JSONObject(result.getResponse().getContentAsString());
		String token = obj.getString("token");
		
		//put the optained token to the cache
		BaseController.tokenMap.put(authenticatedUser, token);
		return token;

	}
	
	
	
	

}
