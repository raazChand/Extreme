package myProject.ExtremeNoiceBackend3;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import myProject.dao.UserDAO;
import myProject.model.User;

public class UserDAOTest {
	
	static UserDAO userDAO;
	
	@BeforeClass
	public static void PreExecution()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("myProject.*");
	context.refresh();
	
	userDAO=(UserDAO)context.getBean("userDAO");
	
	}
	
	
	@Ignore
	@Test
	public void registerUserTest()
	{
		User user=new User();
		user.setUsername("karun");
		user.setPassword("HeyBuddy");
		user.setCustomerName("Pratap singh");
		user.setCustomerAddress("MVP Colony");
		user.setMobile("9999900000");
		user.setEmail("Pratap123@gmail.com");
		user.setRole("User");
		user.setEnabled(true);
		
		assertTrue("Problem in registering a new user",userDAO.registerUser(user));
		
		
	}
	
    @Ignore
	@Test
	public void deleteUserTest()
	{
		User user=userDAO.getUser(1);
		assertTrue("Problem in deleteing user",userDAO.deleteUser(user));
		
	}
	
	
	
	
    @Ignore
    @Test
	public void UpdateUserTest()
	{
		User user=userDAO.getUser(2);
		user.setUsername("Ashok");
		assertTrue("Problem in updating user",userDAO.updateUser(user));
	}
	

}
