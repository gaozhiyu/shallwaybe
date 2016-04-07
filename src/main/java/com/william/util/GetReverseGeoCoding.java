package com.william.util;

import org.apache.http.util.TextUtils;


import com.william.util.Geo.Result;
import com.william.util.Geo.Result.Address_component;

public class GetReverseGeoCoding {
    private String Address1 = "", Address2 = "", City = "", State = "", Country = "", County = "", PIN = "";

    public void getAddress() {
        Address1 = "";
        Address2 = "";
        City = "";
        State = "";
        Country = "";
        County = "";
        PIN = "";

        try {

            Geo jsonObj = ParserJsonUtil.getJSONfromURL("http://maps.google.com/maps/api/geocode/json?latlng=34.123231,112.091446&language=zh-EN&sensor=true");
            String Status = jsonObj.status;//getString("status");
            if (Status.equalsIgnoreCase("OK")) {
                Result[] results = jsonObj.results;//getJSONArray("results");
                Result zero = results[0];//.getJSONObject(0);
                Address_component[] address_components = zero.address_components;//getJSONArray("address_components");

                for (int i = 0; i < address_components.length; i++) {
                    Address_component zero2 = address_components[i];
                    String long_name = zero2.short_name;//getString("long_name");
                    String[] mtypes = zero2.types;
                    String Type = mtypes[0];

                    if (TextUtils.isEmpty(long_name) == false || !long_name.equals(null) || long_name.length() > 0 || long_name != "") {
                        if (Type.equalsIgnoreCase("street_number")) {
                            Address1 = long_name + " ";
                        } else if (Type.equalsIgnoreCase("route")) {
                            Address1 = Address1 + long_name;
                        } else if (Type.equalsIgnoreCase("sublocality")) {
                            Address2 = long_name;
                        } else if (Type.equalsIgnoreCase("locality")) {
                            // Address2 = Address2 + long_name + ", ";
                            City = long_name;
                        } else if (Type.equalsIgnoreCase("administrative_area_level_2")) {
                            County = long_name;
                        } else if (Type.equalsIgnoreCase("administrative_area_level_1")) {
                            State = long_name;
                        } else if (Type.equalsIgnoreCase("country")) {
                            Country = long_name;
                        } else if (Type.equalsIgnoreCase("postal_code")) {
                            PIN = long_name;
                        }
                    }
                    	
                    // JSONArray mtypes = zero2.getJSONArray("types");
                    // String Type = mtypes.getString(0);
                    // Log.e(Type,long_name);
                }
                System.out.println(Country+"\t"+State+"\t"+City);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getAddress1() {
        return Address1;

    }

    public String getAddress2() {
        return Address2;

    }

    public String getCity() {
        return City;

    }

    public String getState() {
        return State;

    }

    public String getCountry() {
        return Country;

    }

    public String getCounty() {
        return County;

    }

    public String getPIN() {
        return PIN;

    }

}