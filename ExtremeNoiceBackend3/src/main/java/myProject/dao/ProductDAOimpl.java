package myProject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import myProject.model.Product;

public class ProductDAOimpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addProduct(Product product) 
	{
		try
		{
			sessionFactory.openSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Excetpion Arised:"+e);
			return false;
		
		}

	}

	@Transactional
	public boolean deleteProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
	
		}
		
	}

	@Transactional
	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
	    }
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}

	@Transactional
	public Product getProduct(int productId) 
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productId);
		session.close();
		return product;
		
		
	}

	@Transactional
	public List<Product> listProducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
	    List<Product> list=(List<Product>)query.list();
	    session.close();
	    return list;
	}

	

	
	}


