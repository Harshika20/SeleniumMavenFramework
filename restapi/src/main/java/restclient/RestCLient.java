package restclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestCLient {
	
	//Here we have overloader the get method

	//Get Method without Headers
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); // will get connection from the given url
		// with http client will execute your request. It will hit the get url
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet); //returns cloeasable http response
		return httpResponse;
	
	}	
		//Get Method with Headers
		public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url); // will get connection from the given url
			// with http client will execute your request. It will hit the get url
			//Before execution add the Headers
			for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			
				httpGet.addHeader(entry.getKey(),entry.getValue());
			}
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet); //returns cloeasable http response
			return httpResponse;
}
		//POST Method:
		public CloseableHttpResponse post(String url,String entityString, HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
			
			//Initialize Https client
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new StringEntity(entityString)); //for payload
			
			//for header
			for(Map.Entry<String, String> entry : headerMap.entrySet()) {
				httppost.addHeader(entry.getKey(),entry.getValue());
			}
			CloseableHttpResponse httpResponse =  httpClient.execute(httppost);
			return httpResponse;
		}
}
