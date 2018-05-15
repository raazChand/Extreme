package myProject.ExtremeNoiceBackend3;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import myProject.dao.CategoryDAO;
import myProject.dao.CategoryDAOimpl;
import myProject.dao.ProductDAO;
import myProject.dao.ProductDAOimpl;
import myProject.dao.SupplierDAO;
import myProject.dao.SupplierDAOimpl;
import myProject.dao.UserDAO;
import myProject.dao.UserDAOimpl;
import myProject.model.Category;
import myProject.model.Product;
import myProject.model.Supplier;
import myProject.model.User;

@Configuration
@EnableTransactionManagement
public class DBconfig {
	
	@Bean(name="DataSource")
	public DriverManagerDataSource getH2DataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("");
		
		System.out.println("DataSource object created");
		return datasource;
		}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateprop=new Properties();
		hibernateprop.put("hibernate.hbm2ddl.auto", "update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateprop.put("hibernate.show_sql","true");
		System.out.println("Tables created");
		
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateprop);
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(User.class);
		SessionFactory sessionFactory=factory.buildSessionFactory();
		System.out.println("SessionFactory object created");
		return sessionFactory;
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO() 
	{
		System.out.println("---Category Bean Created---");
		return new CategoryDAOimpl();
		
	}
	
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("------Product Bean Created-------");
		return new ProductDAOimpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("------Supplier Bean Created-------");
		return new SupplierDAOimpl();
	}
	
	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("--------User Bean Created-------");
		return new UserDAOimpl();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Hibernate Transaction Bean created---");
		return new HibernateTransactionManager(sessionFactory);
		
	}
}


