package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.model.Userss;
import com.poly.utils.JpaUtils;



public class DaoUserss {
//  public static void main(String[] args) {
//      create();
//}
//
//private static void create() {
//	
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
//	EntityManager em = emf.createEntityManager();
//	
//	try {
//		em.getTransaction().begin();
//		
//	   Userss entity = new Userss();
//	   entity.setUserid("fffff");
//	   entity.setPassword("nghia");
//	   entity.setFullname("tran nghia");
//	   entity.setEmail("anhtaau@gmail.com");
//	   entity.setAdmin(false);
//	   em.persist(entity);
//	   em.getTransaction().commit();
//	   System.out.println("Them moi thanh cong");
//	} catch (Exception e) {
//		em.getTransaction().rollback();
//		System.out.println();
//	}
//}
	
	public void insertUser(Userss user) {
		EntityManager eManager = JpaUtils.getEntityManager();
		
		EntityTransaction transaction = eManager.getTransaction();
		
		try {
			transaction.begin();
			
			eManager.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();//rollback la quay ve trang thai ban dau chua co hanh dong xay ra voi csdl
		    throw e;
		}finally {
			
			eManager.close();
		}
	}
	
	public void updatetUser(Userss user) {
		EntityManager eManager = JpaUtils.getEntityManager();
		
		EntityTransaction transaction = eManager.getTransaction();
		
		try {
			transaction.begin();
			
			eManager.merge(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();//rollback la quay ve trang thai ban dau chua co hanh dong xay ra voi csdl
			throw e;
		}finally {
			eManager.close();
		}
	}
	
	public void deleteUser(String userid) throws Exception{
		EntityManager eManager = JpaUtils.getEntityManager();
		
		EntityTransaction transaction = eManager.getTransaction();
		
		try {
			transaction.begin();
			//timf kieems user theo khoa chinh
			Userss userss = eManager.find(Userss.class, userid);
			if(userss != null) {
				eManager.remove(userss);
			}else {
				throw new Exception("Khong tim thay thong tin user");
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();//rollback la quay ve trang thai ban dau chua co hanh dong xay ra voi csdl
		    throw e;
		}finally {
			eManager.close();
		}
	}
	
	public Userss findByIdUser(String userid) {
		EntityManager eManager = JpaUtils.getEntityManager();
		
		Userss userss = eManager.find(Userss.class, userid);
		
		return userss;
	}
	
	public List<Userss> findAll(){
		EntityManager eManager = JpaUtils.getEntityManager();
		
		TypedQuery<Userss> lisTypedQuery = eManager.createNamedQuery("Userss.findAll", Userss.class);
		
		
		return lisTypedQuery.getResultList();
	}
	//tra ve du lieu theo dang phan trang
	
	public List<Userss> findAll(int page, int pageSize){
		EntityManager eManager = JpaUtils.getEntityManager();
		
		TypedQuery<Userss> lisTypedQuery = eManager.createNamedQuery("Userss.findAll", Userss.class);
		
		lisTypedQuery.setFirstResult(page*pageSize);
		lisTypedQuery.setMaxResults(pageSize);
		return lisTypedQuery.getResultList();
	}
	public Userss checkLogin(String userid, String password){
		EntityManager eManager = JpaUtils.getEntityManager();
		String jqpl = "select u from Userss u where u.userid = :userid and u.password = :password";
		
		TypedQuery<Userss> lisTypedQuery = eManager.createQuery(jqpl, Userss.class);
		
		lisTypedQuery.setParameter("userid", userid);
		lisTypedQuery.setParameter("password", password);
		return lisTypedQuery.getSingleResult();//tra ve doi tuong user
	}
	
	public List<Userss> findByFullName(String fullname){
		EntityManager eManager = JpaUtils.getEntityManager();
		String jqpl = "select u from Userss u where u.fullname like :fullname";
		TypedQuery<Userss> lisTypedQuery = eManager.createQuery(jqpl, Userss.class);
		
		lisTypedQuery.setParameter("fullname", "%" +fullname+"%");
		
		return lisTypedQuery.getResultList();
	}
	
	public int count(){
		EntityManager eManager = JpaUtils.getEntityManager();
		String jqpl = "select count(u) from Userss u";
		
		Query query =  eManager.createQuery(jqpl);
		
		return ((Long)query.getSingleResult()).intValue();
	
	}
}
