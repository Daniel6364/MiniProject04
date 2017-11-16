package mybatis.service.product.test;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService12;


/*
 * FileName : MyBatisTestApp13.java
  * :: Business Layer unit Test : Service + Persistence (Spring +mybatis + DAO)
  */
public class ProductTestApp13 {
	
	///main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "/config/commonservice13.xml", "/config/productservice13.xml" });
		System.out.println("\n");

		ProductService12 productService = (ProductService12)context.getBean("productServiceImpl12");
		System.out.println("\n");
		
		Product product = new Product("핸드크림12", "올리브영12", "20160608", 8500, "HandCream12.jpg");

		//1. addProduct Test  
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		System.out.println(":: "+ productService.addProduct(product) ); 
		System.out.println("\n");
		
		//2. getProduct Test :: 주몽 inert 확인 
		System.out.println(":: 2. getProduct(SELECT)  ? ");
//		System.out.println(":: "+ productService.getProduct(product.getProdNo()) );
		System.out.println(":: "+ productService.getProduct(10000) );
		System.out.println("\n");

		//3. uadateUser Test  :: 주몽 ==> 온달 수정
		product.setProdName("바디샤워13");
		product.setProdDetail("롭스13");
		product.setManuDate("20150905");
		product.setPrice(9800);
		product.setFileName("BodyShower13.jpg");
		product.setProdNo(10004);
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		System.out.println(":: "+ productService.updateProduct(product));
		System.out.println("\n");
		
		//4. getUserList Test ::
		System.out.println(":: 4. getProductList(SELECT)  ? ");
		Search search = new Search();
		search.setSearchCondition("0");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("10004");
		search.setProdNo( arrayList );
		
		System.out.println("List<Product> 내용 : "+productService.getProductList(search) );
		System.out.println("\n");
		
		//5. removeUser Test
//		System.out.println(":: 5. removeProduct (DELETE)  ? ");
//		System.out.println(":: "+productService.removeProduct(product.getProdNo()));
//		System.out.println("\n");
		
		//6. getUserList Test 
		System.out.println(":: 6. getProductList(SELECT)  ? ");
		System.out.println("List<Product> 내용 : "+ productService.getProductList(search) );
		System.out.println("\n");
	
	}//end of main
}//end of class