package myProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myProject.dao.CategoryDAO;
import myProject.dao.ProductDAO;
import myProject.dao.SupplierDAO;
import myProject.model.Category;
import myProject.model.Supplier;
import myProject.model.User;


@Controller
public class PageController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/index","/home"})
	public String indexpage() {
		return "index";
	}
	
	@RequestMapping(value="/category")
	public String categorypage(Model m) {
				
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categorylist", listCategories);

		return "Category";
	}
	
	@RequestMapping(value="/supplier")
	public String supplierpage(Model  m) {
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist", listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/contactUs")
	public String contactUsPage() {
		return "Contact Us";
	}
	
	@RequestMapping(value="/aboutUs")
	public String aboutUsPage() {
		return "About Us";
	}
	
	@RequestMapping(value="/signUp")
	public String signUpPage(Model m) {
		User user = new User();
		m.addAttribute(user);
		
		return "Signup";
	}
}
