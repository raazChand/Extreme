package myProject.dao;

import java.util.List;

import myProject.model.Category;



public interface CategoryDAO 
{

public boolean addCategory(Category category);
public boolean deleteCategory(Category category);
public boolean updateCategory(Category category);
public Category getCategory(int categoryId);
public List<Category> listCategories();

}
