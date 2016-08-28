package com.william.util;

import java.io.File;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;
import com.william.to.AddressDTO;

public class GeoIPUtil {
	
	public static AddressDTO getAddress(String ip){
		
		AddressDTO adto = new AddressDTO();

		try {
			File database = new File("F:\\shallway\\db\\GeoLite2-City.mmdb");
			DatabaseReader reader = new DatabaseReader.Builder(database).build();


		InetAddress ipAddress = InetAddress.getByName(ip);

		// Replace "city" with the appropriate method for your database, e.g.,
		// "country".
		CityResponse response = reader.city(ipAddress);
		
		

		Country country = response.getCountry();
		System.out.println(country.getIsoCode());            // 'US'
		System.out.println(country.getName());               // 'United States'
		adto.setCountry(country.getName());
		System.out.println(country.getNames().get("zh-CN")); // '美国'

		Subdivision subdivision = response.getMostSpecificSubdivision();
		System.out.println(subdivision.getName());    // 'Minnesota'
		System.out.println(subdivision.getIsoCode()); // 'MN'
		adto.setProvince(subdivision.getName());

		City city = response.getCity();
		System.out.println(city.getName()); // 'Minneapolis'
		adto.setCity(city.getName());

		Postal postal = response.getPostal();
		System.out.println(postal.getCode()); // '55455'

		Location location = response.getLocation();
		System.out.println(location.getLatitude());  // 44.9733
		System.out.println(location.getLongitude()); // -93.2323
		
//		response.getLocation() 
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adto;
	}
}
