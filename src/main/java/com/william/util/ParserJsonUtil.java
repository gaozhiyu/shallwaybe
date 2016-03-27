package com.william.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ParserJsonUtil {
	
	//private static HttpClient client = HttpClientBuilder.create().build();
	private final static String USER_AGENT = "Mozilla/5.0";
	  
    public static Geo getJSONfromURL(String url) {

        // initialize
        InputStream is = null;
        StringBuffer result = new StringBuffer();
        Geo geo = null;
        //String url = "http://www.google.com/search?q=httpClient";

    	HttpClient client = HttpClientBuilder.create().build();
    	HttpGet request = new HttpGet(url);

    	// add request header
    	request.addHeader("User-Agent", USER_AGENT);
    	HttpResponse response;
		try {
			response = client.execute(request);
			System.out.println("Response Code : " 
                    + response.getStatusLine().getStatusCode());

    	BufferedReader rd = new BufferedReader(
    		new InputStreamReader(response.getEntity().getContent()));
    	String line = "";
    	while ((line = rd.readLine()) != null) {
    		result.append(line);
    	}
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	
    	

        // try parse the string to a JSON object
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode tree = objectMapper.readTree(result.toString());
            geo = objectMapper.readValue(tree.traverse(), Geo.class);
            //geo.results.toString();
        } catch (Exception e) {
        	e.printStackTrace();
           // Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return geo;
    }
}
