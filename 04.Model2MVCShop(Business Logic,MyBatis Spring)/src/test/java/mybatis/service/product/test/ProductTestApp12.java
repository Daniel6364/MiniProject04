package mybatis.service.product.test;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductDaoImpl11;
import com.model2.mvc.service.product.impl.ProductServiceImpl12;


/*
 * FileName : MyBatisTestApp12.java
  * :: Business Layer unit Test : Service + Persistence (MyBatis + DAO)
  */
public class ProductTestApp12 {
	
	///main method
	public static void main(String[] args) throws Exception{

		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		
		ProductDaoImpl11 productDao = new ProductDaoImpl11();
		productDao.setSqlSession(sqlSession);
		
		ProductServiceImpl12 productService = new  ProductServiceImpl12();
		productService.setProductDao(productDao);
		System.out.println("\n");
		
		Product product = new Product("핸드크림12", "올리브영12", "20160608", 8500, "HandCream12.jpg");
		
		//1. addProduct Test  
		System.out.println(":: 1. addUser(INSERT)  ? ");
		System.out.println(":: "+ productService.addProduct(product) ); 
		System.out.println("\n");
		
		//2. getProduct Test :: 주몽 inert 확인 
		System.out.println(":: 2. getUser(SELECT)  ? ");
		System.out.println(":: "+ productService.getProduct(product.getProdNo()) );
		System.out.println("\n");

		//3. uadateProduct Test  :: 주몽 ==> 온달 수정
		product.setProdName("바디샤워12");
		System.out.println(":: 3. update(UPDATE)  ? ");
		System.out.println(":: "+ productService.updateProduct(product));
		System.out.println("\n");
		
		//4. getProductList Test ::
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		Search search = new Search();
		search.setSearchCondition("0");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("10114");
		search.setProdNo( arrayList );
		
		System.out.println("List<Product> 내용 : "+productService.getProductList(search) );
		System.out.println("\n");
		
		//5. removeProduct Test
		System.out.println(":: 5. removeUser (DELETE)  ? ");
		System.out.println(":: "+productService.removeProduct(product.getProdNo()) );
		System.out.println("\n");
		
		//6. getProductList Test 
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		System.out.println("List<User> 내용 : "+ productService.getProductList(search) );
		System.out.println("\n");
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
		
	}//end of main
}//end of class