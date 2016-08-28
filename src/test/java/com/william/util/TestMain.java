package com.william.util;

import java.io.File;
import java.net.InetAddress;

import org.apache.http.util.TextUtils;
import org.junit.Test;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;
import com.william.to.AddressDTO;

public class TestMain {

	private GeoApiContext context;

	@Test
	public void maxMindDecode() {
		File database = new File("F:\\shallway\\db\\GeoLite2-City.mmdb");

		// This creates the DatabaseReader object, which should be reused across
		// lookups.
		DatabaseReader reader;
		try {
			reader = new DatabaseReader.Builder(database).build();

			InetAddress ipAddress = InetAddress.getByName("137.132.42.211");

			// Replace "city" with the appropriate method for your database,
			// e.g.,
			// "country".
			CityResponse response = reader.city(ipAddress);

			Country country = response.getCountry();
			System.out.println(country.getIsoCode()); // 'US'
			System.out.println(country.getName()); // 'United States'
			System.out.println(country.getNames().get("zh-CN")); // '美国'

			Subdivision subdivision = response.getMostSpecificSubdivision();
			System.out.println(subdivision.getName()); // 'Minnesota'
			System.out.println(subdivision.getIsoCode()); // 'MN'

			City city = response.getCity();
			System.out.println(city.getName()); // 'Minneapolis'

			Postal postal = response.getPostal();
			System.out.println(postal.getCode()); // '55455'

			Location location = response.getLocation();
			System.out.println(location.getLatitude()); // 44.9733
			System.out.println(location.getLongitude()); // -93.2323

			// response.getLocation()

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		try {
			GeoApiContext context = new GeoApiContext();
			context.setApiKey("AIzaSyBiO3BkXmztiLF0R5YW8gtcR9-q6pkpTVc");
			GeocodingResult[] results = GeocodingApi.newRequest(context)
			        .latlng(new LatLng(-33.8674869, 151.2069902)).await();
			System.out.println(results.toString());
			for(int j =0;j<results.length;j++){
				GeocodingResult zero = results[j];//.getJSONObject(0);
	            AddressComponent[] address_components = zero.addressComponents;//getJSONArray("address_components");
	            AddressDTO address = new AddressDTO();
	            for (int i = 0; i < address_components.length; i++) {
	            	AddressComponent zero2 = address_components[i];
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
		
	}
}
