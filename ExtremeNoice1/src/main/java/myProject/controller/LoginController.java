package myProject.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public String loginpage() {
		return "Login";
	}
	
	@RequestMapping(value="/login_success",method=RequestMethod.GET)
	public String loginpage(Model model,HttpSession session) {
		
		String page=null;
		boolean loggedIn=false;
		
		SecurityContext securitycontext = SecurityContextHolder.getContext();
		Authentication authentication = securitycontext.getAuthentication();
		
		String username = authentication.getName();
		//Return all roles
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role: authorities) {
			
			session.setAttribute("role",role.getAuthority());
			System.out.println(role.getAuthority());
			if(role.getAuthority().equals("ROLE_USER")) {
					loggedIn=true;
					page = "User";
					session.setAttribute("loggedIn", loggedIn);
					session.setAttribute("username", username);
					
			}
			else {
					loggedIn=true;
					page = "Admin";
					session.setAttribute("username", username);
					session.setAttribute("loggedIn", loggedIn);
			}
		}
		return page;
	}
	
	@RequestMapping(value="/loginfailed")
	public String loginfailed() {
		return "Login";
	}
}
