package com.william.DAO;

import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.to.Stock;

public class SearchDAO {

	/**
	 * @param args
	 * @throws SystemException 
	 * @throws IllegalStateException 
	 */
	public Stock search()  {
		// TODO Auto-generated method stub
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Stock stock= null;
        try{
           tx = (Transaction) session.beginTransaction();
           String sql = "select * from stock";
           SQLQuery query = session.createSQLQuery(sql);
           query.addEntity(Stock.class);
           List<Stock> data = query.list();
           
           
           if(data!= null)
        	    stock = data.get(0);
           
           stock.setStockCode("47152");
           stock.setStockName("GENM2");
           
           session.save(stock);
           tx.commit();
           
        }catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
		return stock;
	}

}
