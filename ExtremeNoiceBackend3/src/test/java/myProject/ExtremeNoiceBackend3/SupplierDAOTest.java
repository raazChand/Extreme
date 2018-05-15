package myProject.ExtremeNoiceBackend3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import myProject.dao.SupplierDAO;
import myProject.model.Supplier;

public class SupplierDAOTest {

static SupplierDAO supplierDAO;

@BeforeClass
public static void preExecution()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("myProject.*");
	context.refresh();
	
	supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
}


@Ignore
@Test
public void addSupplierTest()
{
	Supplier supplier=new Supplier();
	supplier.setSupplierName("SONY");
	supplier.setSupplierAddress("Gajuwaka");
	
	assertTrue("Problem in adding supplier",supplierDAO.addSupplier(supplier));
	
	
}
@Ignore
@Test
public void deleteSupplierTest()
{
	Supplier supplier=supplierDAO.getSupplier(2);
	assertTrue("Problem in deleting Supplier",supplierDAO.deleteSupplier(supplier));
	
}

@Ignore
@Test
public  void UpdateSupplier()
{
	Supplier supplier=supplierDAO.getSupplier(3);
	supplier.setSupplierName("S.Chandan Raj");
	assertTrue("Problem in updating supplier",supplierDAO.updateSupplier(supplier));
	
}

@Ignore
@Test
public void listSuppliersTest()
{
	List<Supplier>listSuppliers=supplierDAO.listSuppliers();
	assertNotNull("Problem in retrieving"+listSuppliers);
	
}


}


