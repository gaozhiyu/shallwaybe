package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.LatestCoordinateDAO;

public class LatestCoordinateApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
        String lastShakeTimeString ="2016-03-09 18:30:00";
        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastShakeTime =sdfd1.parse(lastShakeTimeString);
        
        String lastAddressUpdateString ="2016-02-01 12:00:00";
        SimpleDateFormat sdfd2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastAddressUpdate =sdfd2.parse(lastAddressUpdateString);
        
        LatestCoordinateDAO MLC = new LatestCoordinateDAO();
//        MLC.addLatestCoordinate("12", 1.3575, 2.3456778, lastShakeTime, "Singapore", "Marine Parade", lastAddressUpdate);
        MLC.updateLatestCoordinate("2", 3.000004, 2.000009, lastShakeTime, "Singapore", "NUS", lastAddressUpdate);
//        MLC.updateLatestCoordinate("1", 1.000001, 2.0000001, lastShakeTime); 
//        MLC.updateLatestCoordinate("2", "China", "Guang Zhou", lastAddressUpdate);
	}
	

}
