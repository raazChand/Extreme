package myProject.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import myProject.dao.CategoryDAO;
import myProject.dao.ProductDAO;
import myProject.dao.SupplierDAO;
import myProject.model.Category;
import myProject.model.Product;
import myProject.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	SupplierDAO supplierDAO;
	
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/product")
	public String productpage(Model m) {
		Product product = new Product();
		m.addAttribute(product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("supplierList",this.getSuppliers());

		return "Product";
	}
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("productImage")MultipartFile filedetail,Model m) 
	{
	productDAO.addProduct(product);
	
	Product product1 = new Product();
	m.addAttribute(product1);
	
	m.addAttribute("categoryList",this.getCategories());
	m.addAttribute("supplierList",this.getSuppliers());
	
	List<Product> listProducts = productDAO.listProducts();
	m.addAttribute("productlist", listProducts);
	
	String path="G:\\New Workspace\\ExtremeNoice1\\src\\main\\webapp\\resources\\pImages\\";
	path=path+String.valueOf(product.getProductId())+".jpg";
	File file=new File(path);
	
	if(!filedetail.isEmpty())
	{
		try
		{
			byte[] buffer=filedetail.getBytes();
			FileOutputStream fos=new FileOutputStream(file);
			BufferedOutputStream bs=new BufferedOutputStream(fos);
			bs.write(buffer);
			bs.close();
		}
		catch(Exception e)
		{
			m.addAttribute("errorInfo","Exception Arised:"+e.getMessage());
		}
	}
	else
	{
		m.addAttribute("errorInfo","There is System Problem No Image Insertion");
	}
	
	return "Product";
	
	}
	
	@RequestMapping(value="/DeleteProduct,{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
	 Product product=productDAO.getProduct(productId);
	 productDAO.deleteProduct(product);
	 
	 m.addAttribute("categoryList",this.getCategories());
	 m.addAttribute("supplierList",this.getSuppliers());
	 
	 List<Product> listProducts = productDAO.listProducts();
	 m.addAttribute("productlist", listProducts);
		
	 Product product1 = new Product();
	 m.addAttribute(product1);	
	 
	 return "Product";
	 	 
	}
	
	@RequestMapping(value="/EditProduct,{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
	 Product product=productDAO.getProduct(productId);
	 m.addAttribute("productInfo", product);
	 
	 List<Product> listProducts = productDAO.listProducts();
	 m.addAttribute("productlist", listProducts);
	 
	 m.addAttribute("categoryList",this.getCategories());
	 m.addAttribute("supplierList",this.getSuppliers());
	
	 Product product1 = new Product();
	 m.addAttribute(product1);
	 
	 return "UpdateProduct";
	
	}
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m)
    {
	productDAO.updateProduct(product);
	
	List<Product> listProducts = productDAO.listProducts();
	 m.addAttribute("productlist", listProducts);
	 
	 m.addAttribute("categoryList",this.getCategories());
	 m.addAttribute("supplierList",this.getSuppliers());
	 
	 Product product1 = new Product();
	 m.addAttribute(product1);
	
	 return "Product";
	 
    }
	
	public LinkedHashMap<Integer,String> getCategories()
	{

	List<Category> listCategories=categoryDAO.listCategories();
	
	LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
	for(Category category:listCategories) 
	{
		categoryList.put(category.getCategoryId(), category.getCategoryName());
		
	}
		return categoryList;
		
	}
	
	public LinkedHashMap<Integer,String> getSuppliers()
	{

	List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	
	LinkedHashMap<Integer,String> supplierList=new LinkedHashMap<Integer,String>();
	
	for(Supplier supplier:listSuppliers) 
	{
		supplierList.put(supplier.getSupplierId(), supplier.getSupplierName());
		
	}
		return supplierList;
		
	} 
	

}


