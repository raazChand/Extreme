package myProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myProject.dao.SupplierDAO;
import myProject.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.POST)
	public String addSupplier(@RequestParam("Sname")String Sname,@RequestParam("Saddress")String Saddress,Model m) 
	{
		
		Supplier supplier = new Supplier();
		supplier.setSupplierName(Sname);
		supplier.setSupplierAddress(Saddress);
		
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist", listSuppliers);
		
		return "Supplier";
	}
	
	
	@RequestMapping(value="/DeleteSupplier,{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")int supplierid,Model m) {
		
		Supplier supplier=supplierDAO.getSupplier(supplierid);
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist", listSuppliers);
		
		return "Supplier";
		
		
	}
	@RequestMapping(value="/EditSupplier,{supplierId}")
	public String editCategory(@PathVariable("supplierId")int supplierId,Model m) 
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		m.addAttribute("supplierInfo",supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist", listSuppliers);
		
		return "UpdateSupplier";
		
		
	}
	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("Sid")int Sid,@RequestParam("Sname")String Sname,@RequestParam("Saddress")String Saddress,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(Sid);
		supplier.setSupplierName(Sname);
		supplier.setSupplierAddress(Saddress);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.listSuppliers();
		m.addAttribute("supplierlist", listSuppliers);
		
		return "Supplier";
		
	}
}