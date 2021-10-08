package com.revature.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;
//import com.revature.util.HibernateSessionFactory;

//import io.javalin.http.Context;


@Repository("userRepository")
public class UserRepository {
	
	/*
	 * denotes dependency on container-managed EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;	
	
//	public User logIn(String userName) {
//		System.out.println("5");
//        Session s = null;
//        Transaction tx = null;
//        User user = null;
//       // Context ctx = null;
//
//        try {
//            s = HibernateSessionFactory.getSession();
//            tx = s.beginTransaction();
//
//            CriteriaBuilder cb = s.getCriteriaBuilder();
//            CriteriaQuery<User> cq = cb.createQuery(User.class);
//            Root<User> root = cq.from(User.class);
//            cq.select(root).where(cb.equal(root.get("userName"), userName));
//            Query<User> query = s.createQuery(cq);
//            user = query.getSingleResult();
//        
////            if(user != null) {
////            	return true;
////            }
//        	 tx.commit();
//        	// s.close();
//        }catch(HibernateException e) {
//            tx.rollback();
//            e.printStackTrace();
//        }
//        return user;
//    }
  
	
	public List<User> findAll(){
			
		return entityManager.createQuery("FROM User", User.class).getResultList();
	}
	
//	    List<User> users = null;
//		// We need a session to do work on our DB
//		Session s = null;
//		Transaction tx = null;
//		
//		try {
//			s = HibernateSessionFactory.getSession();
//			tx = s.beginTransaction();
//			/*
//			 * Hibernate has its own query language called "HQL" - Hibernate Query Language.
//			 * HQL allows us to emphasize our Java models rather than the entities in our DB when we
//			 * are making queries. It provides a more object-oriented approach to data persistence.
//			 * 
//			 * I should point out that you have the option to use native SQL (i.e. plain old SQL). You can simply
//			 * do so by calling "createNativeQuery".
//			 */
//			users = s.createQuery("FROM User", User.class).getResultList();
//			tx.commit();
//		}catch(HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			s.close();
//		}
//		
//		
//		return users;
//	}
	
	public void save(User user) {
		this.entityManager.persist(user);
}	
		
//		session = null;
//		Transaction tx = null;
//		try {
//			session = HibernateSessionFactory.getSession();
//			tx = session.beginTransaction();
//			session.save(user);
//			tx.commit();
//		}catch (HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//	}
	
//	public User findUserById(String userId) {
//        Session s = null;
//        Transaction tx = null;
//        User user = null;
//
//        try {
//            s = HibernateSessionFactory.getSession();
//            tx = s.beginTransaction();
//
//            CriteriaBuilder cb = s.getCriteriaBuilder();
//            CriteriaQuery<User> cq = cb.createQuery(User.class);
//            Root<User> root = cq.from(User.class);
//            cq.select(root).where(cb.equal(root.get("userId"), userId));
//            Query<User> query = s.createQuery(cq);
//            user = query.getSingleResult();
//            //tx.commit();
//        }catch(HibernateException e) {
//           // tx.rollback();
//            e.printStackTrace();
//        }finally {
//            s.close();
//        }
//        return user;
//    }
	
	public User findByUserName(String userName) {
        
		TypedQuery<User> query = 
				this.entityManager.createQuery("FROM User where userName = :userName", User.class);
				query.setParameter("userName", userName);
				return query.getSingleResult();
	}				
//		Session s = null;
//        Transaction tx = null;
//        User user = null;
//
//        try {
//            s = HibernateSessionFactory.getSession();
//            tx = s.beginTransaction();
//
//            CriteriaBuilder cb = s.getCriteriaBuilder();
//            CriteriaQuery<User> cq = cb.createQuery(User.class);
//            Root<User> root = cq.from(User.class);
//            CriteriaQuery<User> all = cq.select(root).where(cb.equal(root.get("userName"), userName));
//           
//            TypedQuery<User> query = s.createQuery(all);
//            user = query.getSingleResult();
//            tx.commit();
//        }catch(HibernateException e) {
//            tx.rollback();
//            e.printStackTrace();
//        }finally {
//            s.close();
//        }
//        return user;
//    }
}
