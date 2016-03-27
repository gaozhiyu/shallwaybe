package com.william.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class CorToCItyUtil {

	private final static String USER_AGENT = "Mozilla/5.0";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String url = "http://maps.google.com/maps/api/geocode/json?latlng=34.123231,112.091446&language=zh-EN&sensor=true";

			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);

			// add request header
			request.addHeader("User-Agent", USER_AGENT);
			HttpResponse response = client.execute(request);

//			System.out.println("Response Code : "
//					+ response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	


}
