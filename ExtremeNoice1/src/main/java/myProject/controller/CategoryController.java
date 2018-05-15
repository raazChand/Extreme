package myProject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myProject.dao.CategoryDAO;
import myProject.model.Category;

@Controller
public class CategoryController {

@Autowired
CategoryDAO categoryDAO;

	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname")String catname,@RequestParam("catdesc")String catdesc,Model m) 
	{
		
		Category category = new Category();
		category.setCategoryName(catname);
		category.setCategoryDesc(catdesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categorylist", listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/DeleteCategory,{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryid,Model m) {
		
		Category category=categoryDAO.getCategory(categoryid);
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categorylist", listCategories);
		
		return "Category";
		
		
	}
	
	@RequestMapping(value="/EditCategory,{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryid,Model m) {
		
		Category category=categoryDAO.getCategory(categoryid);
		m.addAttribute("categoryInfo",category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categorylist", listCategories);
		
		return "UpdateCategory";
		
		
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catid")int catid,@RequestParam("catname")String catname,@RequestParam("catdesc")String catdesc,Model m) 
	{
		
		Category category = categoryDAO.getCategory(catid);
		category.setCategoryName(catname);
		category.setCategoryDesc(catdesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories = categoryDAO.listCategories();
		m.addAttribute("categorylist", listCategories);
		
		return "Category";
	}
	
}
	

