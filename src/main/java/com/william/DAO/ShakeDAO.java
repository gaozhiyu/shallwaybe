package com.william.DAO;

import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;


import com.william.to.AddressHistoryOutDTO;
import com.william.to.ShakeDTO;
import com.william.to.ShakeInDTO;
import com.william.util.HibernateUtil;

public class ShakeDAO {
	
	private static ShakeDAO instance;
	
	public static ShakeDAO getInstance() {
		if (instance == null) {
			instance = new ShakeDAO();
		}
		return instance;
	}
	

	/**
	 * @param args
	 * @throws SystemException
	 * @throws IllegalStateException
	 */
	public ShakeDTO[] shakeForList(ShakeInDTO shakeInDTO) {
		// TODO Auto-generated method stub
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ShakeDTO[] shakeDTOArray = null;
		try {
			tx = (Transaction) session.beginTransaction();
			String sql = "select TIME_TO_SEC(timediff(CURRENT_TIMESTAMP,c.lastshaketimeraw))*1.5*0.3/1000 + 0.7* c.distance  as weight,c.* from (select b.distance as distance, p.userintid as userIntID,  p.nickname as nickname,p.PROFILEPHOTO as photoFlag, p.signature as signature, DATE_FORMAT(b.lastshaketime,'%b %d %Y %h:%i %p') as shakeTime, b.lastshaketime as lastshaketimeraw from (select calculateDistance(?,?,a.longitude,a.latitude) as distance, a.userintid, a.lastshaketime from latestcoordinate a where a.userintid != ?) b inner join profile p on b.userintid = p.userintid) c order by weight asc limit 10;";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(0, ""+shakeInDTO.getLatitude());
			query.setString(1, ""+shakeInDTO.getLongitude());
			query.setString(2, shakeInDTO.getUserIntID());
			query.setResultTransformer(Transformers.aliasToBean(ShakeDTO.class));
			List<ShakeDTO> shakeDTOList = query.list();

			if (shakeDTOList != null) {
				shakeDTOArray = new ShakeDTO[shakeDTOList.size()];
				for (int i = 0; i < shakeDTOList.size(); i++) {
					shakeDTOArray[i] = shakeDTOList.get(i);
				}
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return shakeDTOArray;
	}
	
	public ShakeDTO[] shakeForUnknownList(ShakeInDTO shakeInDTO, String country, String province, String city) {
		// TODO Auto-generated method stub
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		ShakeDTO[] shakeDTOArray = null;
		try {
			tx = (Transaction) session.beginTransaction();
			String sql = "select TIME_TO_SEC(timediff(CURRENT_TIMESTAMP,c.lastshaketimeraw))*1.5*0.3/1000 + 0.7* c.distance  as weight,c.* from (select b.distance as distance, p.userintid as userIntID,  p.nickname as nickname,p.PROFILEPHOTO as photoFlag, p.signature as signature, DATE_FORMAT(b.lastshaketime,'%b %d %Y %h:%i %p') as shakeTime, b.lastshaketime as lastshaketimeraw from (select calculateDistance(?,?,a.longitude,a.latitude) as distance, a.userintid, a.lastshaketime from latestcoordinate a where a.userintid != ?) b inner join profile p on b.userintid = p.userintid where p.GoogleCountry != ? or GoogleProvince != ? or GoogleCity != ?) c order by weight asc limit 10;";
			//String sql = "select b.distance as distance, p.userintid as userIntID,  p.nickname as nickname,p.PROFILEPHOTO as photoFlag, p.signature as signature, DATE_FORMAT(b.lastshaketime,'%b %d %Y %h:%i %p') as shakeTime from (select calculateDistance(?,?,a.longitude,a.latitude) as distance, a.userintid, a.lastshaketime from latestcoordinate a where a.userintid != ?) b inner join profile p on b.userintid = p.userintid where p.GoogleCountry != ? or GoogleProvince != ? or GoogleCity != ? ;";
			SQLQuery query = session.createSQLQuery(sql);
			query.setString(0, ""+shakeInDTO.getLatitude());
			query.setString(1, ""+shakeInDTO.getLongitude());
			query.setString(2, shakeInDTO.getUserIntID());
			query.setString(3, country);
			query.setString(4, province);
			query.setString(5, city);
			query.setResultTransformer(Transformers.aliasToBean(ShakeDTO.class));
			List<ShakeDTO> shakeDTOList = query.list();

			if (shakeDTOList != null) {
				shakeDTOArray = new ShakeDTO[shakeDTOList.size()];
				for (int i = 0; i < shakeDTOList.size(); i++) {
					shakeDTOArray[i] = shakeDTOList.get(i);
				}
			}

			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return shakeDTOArray;
	}

}
