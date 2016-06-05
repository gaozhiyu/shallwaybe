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
import org.apache.http.util.TextUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.william.to.AddressDTO;
import com.william.to.GeoDTO;
import com.william.to.GeoDTO.Result;
import com.william.to.GeoDTO.Result.Address_component;


public class ParserJsonUtil {
	
	//private static HttpClient client = HttpClientBuilder.create().build();
	private final static String USER_AGENT = "Mozilla/5.0";
	
	public AddressDTO getAddress(String lat1,String long1) {
    	AddressDTO address = new AddressDTO();

        try {

            GeoDTO jsonObj = getJSONfromURL("http://maps.google.com/maps/api/geocode/json?latlng="+lat1+","+long1+"&language=zh-EN&sensor=true");
            String Status = jsonObj.status;//getString("status");
            if (Status.equalsIgnoreCase("OK")) {
                Result[] results = jsonObj.results;//getJSONArray("results");
                Result zero = results[1];//.getJSONObject(0);
                Address_component[] address_components = zero.address_components;//getJSONArray("address_components");
                address = new AddressDTO();
                for (int i = 0; i < address_components.length; i++) {
                    Address_component zero2 = address_components[i];
                    String long_name = zero2.long_name;//getString("long_name");
                    String[] mtypes = zero2.types;
                    String Type = mtypes[0];
                    
                    if (TextUtils.isEmpty(long_name) == false || !long_name.equals(null) || long_name.length() > 0 || long_name != "") {
                        if (Type.equalsIgnoreCase("locality")) {
                            // Address2 = Address2 + long_name + ", ";
                            address.setCity(long_name);
                        } else if (Type.equalsIgnoreCase("administrative_area_level_2")) {
                            address.setCounty(long_name);
                        } else if (Type.equalsIgnoreCase("administrative_area_level_1")) {
                        	address.setProvince(long_name);
                        } else if (Type.equalsIgnoreCase("country")) {
                        	address.setCountry(long_name);
                        }
                    }
                    	
                    // JSONArray mtypes = zero2.getJSONArray("types");
                    // String Type = mtypes.getString(0);
                    // Log.e(Type,long_name);
                }
                System.out.println(address.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }
	  
    public static GeoDTO getJSONfromURL(String url) {

        // initialize
        InputStream is = null;
        StringBuffer result = new StringBuffer();
        GeoDTO geo = null;
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
            //objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            objectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, false);
            JsonNode tree = objectMapper.readTree(result.toString());
            geo = objectMapper.readValue(tree.traverse(), GeoDTO.class);
            //geo.results.toString();
        } catch (Exception e) {
        	e.printStackTrace();
           // Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return geo;
    }
}
