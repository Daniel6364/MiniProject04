package mybatis.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Product	product = new Product();
		product.setProdName("testProdName");
		product.setProdDetail("testProdDetail");
		product.setManuDate("20171116");
		product.setPrice(66666);
		product.setFileName("testImageFile.jpg");
		
		productService.addProduct(product);
		
//		product = productService.getProduct(product.getProdNo());
		product = productService.getProduct(10129);

		//==> console 확인
		System.out.println("[testAddProduct] : "+product);
		
		//==> API 확인
		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals("20171116", product.getManuDate());
		Assert.assertEquals(66666, product.getPrice());
		Assert.assertEquals("testImageFile.jpg", product.getFileName());
	}
	
	@Test
	public void testGetProduct() throws Exception {
		
		Product	product = new Product();
		//==> 필요하다면...
//		product.setProdName("testProdName");
//		product.setProdDetail("testProdDetail");
//		product.setManuDate("20171116");
//		product.setPrice(66666);
//		product.setFileName("testImageFile.jpg");
		
//		product = productService.getProduct(product.getProdNo());
		product = productService.getProduct(10000);

		//==> console 확인
		System.out.println("[testGetProduct] : "+product);
		
		//==> API 확인
//		Assert.assertEquals("바디샤워", product.getProdName());
//		Assert.assertEquals("롭스", product.getProdDetail());
//		Assert.assertEquals("20150905", product.getManuDate());
//		Assert.assertEquals(9800, product.getPrice());
//		Assert.assertEquals("BodyShower.jpg", product.getFileName());

		Assert.assertNotNull(productService.getProduct(10002));
		Assert.assertNotNull(productService.getProduct(10003));
	}
	
	//@Test
	public void testUpdateProduct() throws Exception{
		 
		Product product = productService.getProduct(10129);
		Assert.assertNotNull(product);

		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals("20171116", product.getManuDate());
		Assert.assertEquals(66666, product.getPrice());
		Assert.assertEquals("testImageFile.jpg", product.getFileName());		
		
		product.setProdName("changeProdname");
		product.setProdDetail("changeProdDetail");
		product.setManuDate("19850607");
		product.setPrice(67000);
		product.setFileName("changeImageFile.jpg");
		
		productService.updateProduct(product);
		
		product = productService.getProduct(10129);
		Assert.assertNotNull(product);
		
		//==> console 확인
		System.out.println("[testUpdateProduct] : "+product);
			
		//==> API 확인
		Assert.assertEquals("changeProdname", product.getProdName());
		Assert.assertEquals("changeProdDetail", product.getProdDetail());
		Assert.assertEquals("19850607", product.getManuDate());
		Assert.assertEquals(67000, product.getPrice());
		Assert.assertEquals("changeImageFile.jpg", product.getFileName());	
		
	 }
	 
	//@Test
	public void testGetProductListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console 확인
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	//==> console 확인
	 	System.out.println("[testGetProdcutProduct] : " + list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	 
}