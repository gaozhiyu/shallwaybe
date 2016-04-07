package com.william.DAO;

import java.util.List;
import com.william.util.HibernateUtil;

import javax.transaction.SystemException;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.william.entity.StockEntity;

public class SearchDAO {

	/**
	 * @param args
	 * @throws SystemException 
	 * @throws IllegalStateException 
	 */
	public StockEntity search()  {
		// TODO Auto-generated method stub
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        StockEntity stock= null;
        try {
           tx = (Transaction) session.beginTransaction();
           String sql = "select * from stock";
           SQLQuery query = session.createSQLQuery(sql);
           query.addEntity(StockEntity.class);
           
           @SuppressWarnings("unchecked")
           List<StockEntity> data = query.list();
           
           
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
