package net.javaguides.userManagement.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Transaction;

import net.javaguides.userManagement.model.User;
import net.javaguides.userManagement.util.HibernateUtil;

/**
 *
 */
public class UserDAO {
	
	/**
	 * Save User
	 * @param user
	 */
	public void saveUser(User user) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try  {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
			
			
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	/**
	 * Update User
	 * @param user
	 */
	public void updateUser(User user) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try  {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(user);
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	/**
	 * Delete User
	 * @param id
	 */
	public void deleteUser(int id) {

		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try  {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
				System.out.println("user is deleted");
			}

			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	/**
	 * Get User By ID
	 * @param id
	 * @return
	 */
	public User getUser(int id) {

		Transaction transaction = null;
		User user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
	
	/**
	 * Get all Users
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {

		Transaction transaction = null;
		List<User> listOfUser = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try  {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfUser = session.createQuery("from User").getResultList();
			
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return listOfUser;
	}
}