package myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myProject.dao.UserDAO;
import myProject.model.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user,Model m) {
		System.out.println(user.getPassword());
		
		String password = user.getPassword();
		BCryptPasswordEncoder passwordencoder = new BCryptPasswordEncoder();
		user.setPassword(passwordencoder.encode(password));
		
		System.out.println(passwordencoder.encode(password));
		
		user.setEnabled(true);
		
		userDAO.registerUser(user);
		
		User user1 = new User();
		m.addAttribute(user1);
		
		return "Signup";
	}
}
