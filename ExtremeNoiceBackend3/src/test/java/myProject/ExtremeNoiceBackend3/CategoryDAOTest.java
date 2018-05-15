package myProject.ExtremeNoiceBackend3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import myProject.dao.CategoryDAO;
import myProject.model.Category;


public class CategoryDAOTest {
	
	
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void preExecution() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("myProject.**");
		context.refresh();
		
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	
	
	@Test
	public void addCategoryTest() 
	{
	Category category=new Category();
	category.setCategoryName("Bluetooth");
	category.setCategoryDesc("All bluetooth speakers");
	
	assertTrue("Problem in adding category",categoryDAO.addCategory(category));
		
	}
	
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategoryName("Home Theartre");
		assertTrue("Problem in updating category",categoryDAO.updateCategory(category));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest() 
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in adding category",categoryDAO.deleteCategory(category));
	}
	
	
	@Ignore
	@Test
	public void listCategoryTest()
	{
		List<Category>listCategories=categoryDAO.listCategories();
		assertNotNull("problem in retrieving"+listCategories);
		
	}
	
}
