package myProject.ExtremeNoiceBackend3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import myProject.dao.ProductDAO;
import myProject.model.Product;

public class ProductDAOTest {

	static ProductDAO productDAO;
	
	@BeforeClass
	public static void preExcution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("myProject.*");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Sony 123 bluetooth speaker");
		product.setProductDesc("Best bluetooth device with 80w sound output ");
		
		assertTrue("Problem in adding product",productDAO.addProduct(product));
		
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(1);
		product.setProductName("Sony bluetooth model-345");
		assertTrue("Problem in updating product",productDAO.updateProduct(product));
		
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(1);
		assertTrue("problem in deleting poduct",productDAO.deleteProduct(product));
		
	}
	
	@Ignore
	@Test
	public void listProductsTest()
	{
		List<Product>listProducts=productDAO.listProducts();
		assertNotNull("problem in retrieving"+listProducts);
		
	}
}
