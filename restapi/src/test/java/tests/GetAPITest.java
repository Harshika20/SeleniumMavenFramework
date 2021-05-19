package tests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restapi.TestBaseClass;
import restclient.RestCLient;
import util.TestUtil;

public class GetAPITest extends TestBaseClass{
	TestBaseClass testBase;
	RestCLient restClient;
	String serviceurl;
	String apiurl;
	String url;
	CloseableHttpResponse httpResponse;
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testBase = new TestBaseClass();
		 serviceurl = prop.getProperty("URL");
		 apiurl = prop.getProperty("serviceURL");
		
		 url = serviceurl+apiurl;
			}
	
	@Test
	public void getTestWithoutHeaders() throws ClientProtocolException, IOException{
		restClient = new RestCLient();
		httpResponse = restClient.get(url);
		
		//Status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is : "+statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200" );
		
		//json string
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject jsonObj = new JSONObject(responseString);
		System.out.println("Response is : "+jsonObj);
		
		//per_page
		String perpageValue = TestUtil.getValueByJPath(jsonObj,"/per_page");
		System.out.println("PerPage value is : "+perpageValue);
		
		Assert.assertEquals(Integer.parseInt(perpageValue), 6);
		
		//total
		String totalValue = TestUtil.getValueByJPath(jsonObj,"/total");
		System.out.println("Total value is : "+totalValue);
				
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		
		//data
//		String dataValueLastName = TestUtil.getValueByJPath(jsonObj,"/data[0]/last_name");
//		String dataValueId = TestUtil.getValueByJPath(jsonObj,"/data[0]/id");
//		String dataValueAvatar = TestUtil.getValueByJPath(jsonObj,"/data[0]/avatar");
//		String dataValueFirstName = TestUtil.getValueByJPath(jsonObj,"/data[0]/first_name");
//		System.out.println("LastName value is : "+dataValueLastName);
//		System.out.println("Id value is : "+dataValueId);
//		System.out.println("Avatar value is : "+dataValueAvatar);
//		System.out.println("FirstName value is : "+dataValueFirstName);
		
		//Assert.assertEquals(Integer.parseInt(dataValue), 6);
		
		
		//all headers
		Header[] headersArray = httpResponse.getAllHeaders();
		//convert headersarray into hashmap so its easy to iterate
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for(Header header : headersArray) {
			
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers are : "+allHeaders);
	}
	
	@Test
	public void getTestWithHeaders() throws ClientProtocolException, IOException{
		restClient = new RestCLient();
		httpResponse = restClient.get(url);
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		//Status code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is : "+statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200" );
		
		//json string
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject jsonObj = new JSONObject(responseString);
		System.out.println("Response is : "+jsonObj);
		
		//per_page
		String perpageValue = TestUtil.getValueByJPath(jsonObj,"/per_page");
		System.out.println("PerPage value is : "+perpageValue);
		
		Assert.assertEquals(Integer.parseInt(perpageValue), 6);
		
		//total
		String totalValue = TestUtil.getValueByJPath(jsonObj,"/total");
		System.out.println("Total value is : "+totalValue);
				
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		
		//data
//		String dataValueLastName = TestUtil.getValueByJPath(jsonObj,"/data[0]/last_name");
//		String dataValueId = TestUtil.getValueByJPath(jsonObj,"/data[0]/id");
//		String dataValueAvatar = TestUtil.getValueByJPath(jsonObj,"/data[0]/avatar");
//		String dataValueFirstName = TestUtil.getValueByJPath(jsonObj,"/data[0]/first_name");
//		System.out.println("LastName value is : "+dataValueLastName);
//		System.out.println("Id value is : "+dataValueId);
//		System.out.println("Avatar value is : "+dataValueAvatar);
//		System.out.println("FirstName value is : "+dataValueFirstName);
		
		//Assert.assertEquals(Integer.parseInt(dataValue), 6);
		
		
		//all headers
		Header[] headersArray = httpResponse.getAllHeaders();
		//convert headersarray into hashmap so its easy to iterate
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for(Header header : headersArray) {
			
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers are : "+allHeaders);

	}
	
	
}


