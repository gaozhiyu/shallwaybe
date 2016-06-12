package com.william.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;

import com.william.entity.WorldCitiesEntity;
import com.william.to.AddressDTO;
import com.william.to.CoordinateDTO;
import com.william.util.HibernateUtil;

public class WorldCitiesDAO {
	
	public String[] getCountryList(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    String[] countryListArray= null;
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select distinct country from world_cities_table;";
		      SQLQuery query = session.createSQLQuery(sql);  
//		      query.setString(0, userIntID);
//		      query.setString(1, placeType);
//		      query.addEntity(WorldCitiesEntity.class);
//		      query.setResultTransformer(Transformers.aliasToBean(AddressHistoryOutDTO.class));
		      
		      @SuppressWarnings("unchecked")
		      List<String> worldCitiesList = query.list();	
		      countryListArray = new String[worldCitiesList.size()];
	    	  
		      if (worldCitiesList!=null && worldCitiesList.size()>0 ){
		    	  for (int i=0;i<worldCitiesList.size();i++){
		    		  countryListArray[i] = worldCitiesList.get(i);
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return countryListArray;
		
	}
	
	public String[] getProvinceList(String country){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    String[] provinceListArray= null;
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select distinct province from world_cities_table where country = ? order by province;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, country);
//		      query.setString(1, placeType);
//		      query.addEntity(WorldCitiesEntity.class);
//		      query.setResultTransformer(Transformers.aliasToBean(AddressHistoryOutDTO.class));
		      
		      @SuppressWarnings("unchecked")
		      List<String> provinceList = query.list();	
		      provinceListArray = new String[provinceList.size()];
	    	  
		      if (provinceList!=null && provinceList.size()>0 ){
		    	  for (int i=0;i<provinceList.size();i++){
		    		  provinceListArray[i] = provinceList.get(i);
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return provinceListArray;		
	}
	
	public String[] getCityList(String country, String province){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    String[] cityListArray= null;
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select city from world_cities_table where country = ? and province = ? order by city;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, country);
		      query.setString(1, province);
//		      query.addEntity(WorldCitiesEntity.class);
//		      query.setResultTransformer(Transformers.aliasToBean(AddressHistoryOutDTO.class));
		      
		      @SuppressWarnings("unchecked")
		      List<String> cityList = query.list();	
		      cityListArray = new String[cityList.size()];
	    	  
		      if (cityList!=null && cityList.size()>0 ){
		    	  for (int i=0;i<cityList.size();i++){
		    		  cityListArray[i] = cityList.get(i);
		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return cityListArray;		
		
	}
	
	public CoordinateDTO getCoordinateList(AddressDTO addressDTO){
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    
	    String country= addressDTO.getCountry();
	    String province= addressDTO.getProvince();
	    String city = addressDTO.getCity();
	    
	    CoordinateDTO coordinateDTO = new CoordinateDTO();
	    
	    try{
		      tx = session.beginTransaction();

		      String sql = "select lat as latitude, lng as longitude from world_cities_table where country = ? and province = ? and city = ?;";
		      SQLQuery query = session.createSQLQuery(sql);  
		      query.setString(0, country);
		      query.setString(1, province);
		      query.setString(2, city);
		      query.addScalar("latitude", new DoubleType());
		      query.addScalar("longitude", new DoubleType());
//		      query.addEntity(WorldCitiesEntity.class);
		      query.setResultTransformer(Transformers.aliasToBean(CoordinateDTO.class));
		      
		      @SuppressWarnings("unchecked")
		      List<CoordinateDTO> coordinateList = query.list();	
//		      cityListArray = new String[cityList.size()];
	    	  
		      if (coordinateList!=null && coordinateList.size()>0 ){
		    	  coordinateDTO = coordinateList.get(0);
//		    	  for (int i=0;i<cityList.size();i++){
//		    		  cityListArray[i] = cityList.get(i);
//		    	  }
		      }
	
		      tx.commit();   
		    }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		    }finally {
		      session.close(); 
		    }	
	    return coordinateDTO;			
	}

}
