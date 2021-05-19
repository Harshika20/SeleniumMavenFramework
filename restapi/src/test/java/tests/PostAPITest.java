package tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.Users;
import restapi.TestBaseClass;
import restclient.RestCLient;

public class PostAPITest extends TestBaseClass{
	TestBaseClass testBase;
	String serviceURL;
	String apiUrl;
	String url;
	RestCLient restClient;
	@BeforeMethod
	public void setup() {
		testBase = new TestBaseClass();
		serviceURL = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		
		url = serviceURL+apiUrl;
	}
	
	@Test
	public void postApiTest() throws JsonGenerationException, JsonMappingException, IOException {
		restClient = new RestCLient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		//Jackson API//conversion of java object to json and from json to java
		ObjectMapper mapper = new ObjectMapper();
		Users users =new Users("Ramanuj","Leader");
		

		//Convert Object to json file
		mapper.writeValue(new File("/Users/hdhamank/eclipse-workspace/restapi/src/main/java/data/users.json"), users);
		
		//Object to json string
		String userJsonString = mapper.writeValueAsString(users);
		System.out.println(userJsonString);
		
		//call post method
		CloseableHttpResponse httpsresponse =restClient.post(url, userJsonString, headerMap);
		//return httpsresponse;
		
		//Status code:
		int statusCode = httpsresponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, TestBaseClass.RESPONSE_STATUS_CODE_201);
		
		//jsonString
		String responseString = EntityUtils.toString(httpsresponse.getEntity(),"UTF-8");
		//convert response string to json
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response from API is : "+responseJson);
		//Validate the response
		//json to java obj
		Users userObj = mapper.readValue(responseString, Users.class);
		System.out.println(userObj);
		
		//java to json - marshalling
		//json to java - unmarshalling
		
		Assert.assertTrue(users.getName().equals(userObj.getName()));
		Assert.assertTrue(users.getJob().equals(userObj.getJob()));
		
		System.out.println(userObj.getId());
		System.out.println(userObj.getCreatedAt());
		
	}
	

}
