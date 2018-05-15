package myProject.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import myProject.model.User;

public class UserDAOimpl implements UserDAO {


	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public boolean deleteUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
			
		}
		
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
		return false;	
		}
	}
	
	@Transactional
	public boolean registerUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
		
	}

	@Transactional
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}

	@Transactional
	public User getUser(int userId) {
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,userId);
		session.close();
		return user;
	}

	public boolean approveUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	



	

}
