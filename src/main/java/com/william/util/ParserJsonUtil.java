package com.william.util;

import org.apache.http.util.TextUtils;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.mysql.jdbc.StringUtils;
import com.william.to.AddressDTO;


public class ParserJsonUtil {
	
	//private static HttpClient client = HttpClientBuilder.create().build();
	private final static String USER_AGENT = "Mozilla/5.0";
	
	public AddressDTO getAddress(double lat1,double long1) {
    	AddressDTO address = new AddressDTO();

    	try {
			GeoApiContext context = new GeoApiContext();
			context.setApiKey("AIzaSyBiO3BkXmztiLF0R5YW8gtcR9-q6pkpTVc");
			GeocodingResult[] results = GeocodingApi.newRequest(context)
			        .latlng(new LatLng(lat1, long1)).await();
			
			for(int j =0;j<results.length;j++){
				GeocodingResult zero = results[j];//.getJSONObject(0);
	            AddressComponent[] address_components = zero.addressComponents;//getJSONArray("address_components");
	           // AddressDTO address = new AddressDTO();
	            if (address_components!= null && address_components.length>0) {
	            	AddressComponent zero2 = address_components[0];
	                String long_name = zero2.longName;//getString("long_name");
	                AddressComponentType[] mtypes = zero2.types;
	                AddressComponentType type = mtypes[0];
	                
	                if (TextUtils.isEmpty(long_name) == false || !long_name.equals(null) || long_name.length() > 0 || long_name != "") {
	                    if (AddressComponentType.LOCALITY.equals(type)) {
	                        // Address2 = Address2 + long_name + ", ";
	                        address.setCity(long_name);
	                    } else if (AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_2.equals(type)) {
	                        address.setCounty(long_name);
	                    } else if (AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1.equals(type)) {
	                    	address.setProvince(long_name);
	                    } else if (AddressComponentType.COUNTRY.equals(type)) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(address!=null && StringUtils.isEmptyOrWhitespaceOnly(address.getProvince())){
			address.setProvince(address.getCity());
		}
        return address;
    }
	  /*
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
    }*/
}
