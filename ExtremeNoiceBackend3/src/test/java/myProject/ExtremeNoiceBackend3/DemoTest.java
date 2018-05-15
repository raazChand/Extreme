package myProject.ExtremeNoiceBackend3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import myProject.dao.CategoryDAO;
import myProject.model.Category;

public class DemoTest {
	
	public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("myProject.*");
		context.refresh();
		
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		Category category=new Category();
		category.setCategoryName("Home Theatre");
		category.setCategoryDesc("Sony 5.1 surround system");
		categoryDAO.addCategory(category);
		System.out.println("Category inserted");
		context.close();
	}

}
