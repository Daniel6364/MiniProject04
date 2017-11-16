package mybatis.service.product.test;

import java.util.ArrayList;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductDaoImpl11;

import org.apache.ibatis.session.SqlSession;

/*
 * FileName : MyBatisTestApp10.java
 */
public class ProductTestApp11 {
	
	///main method
	public static void main(String[] args) throws Exception{
	
		//==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");
		
		//==> ProductDaoImpl 생성 및 sqlSession instance setter injection
		ProductDaoImpl11 productDao = new ProductDaoImpl11();
		productDao.setSqlSession(sqlSession);
		System.out.println("\n");
		
		//==> Test 용 Product instance 생성  
		Product product = new Product("핸드크림11", "올리브영11", "20160608", 8500, "HandCream11.jpg");
		
		//1. ProductMapper.addProduct Test  ::   
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		System.out.println(":: " + productDao.addProduct(product));
		System.out.println("\n");
		
		//2. ProductMapper.getProduct Test :: 입력값 : prodName = 자전거 : OK 
		System.out.println(":: 2. getProduct(SELECT)  ? ");
//		product.setProdNo(10002);
		System.out.println(":: "+ productDao.getProduct(product.getProdNo()));
		System.out.println("\n");
		
		//3. ProductMapper.updateProduct Test  :: 입력값 바디샤워 : OK
		System.out.println(":: 3. update(UPDATE)  ? ");
		product.setProdName("바디샤워11");
		System.out.println( productDao.updateProduct(product) );
		System.out.println("\n");
		
		//4. ProductMapper.getProductList Test  :: Dynamic Query 확인 no=10002/name= 검색
		System.out.println(":: 4. getProduct(SELECT)  ? ");
		Search search = new Search();
		search.setSearchCondition("0");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("10000");
		search.setProdNo(arrayList);
		System.out.println(":: "+ productDao.getProductList(search) );
		System.out.println("\n");
		
		//5. ProductMapper.removeProduct Test
		System.out.println(":: 5. Product.removeProduct (DELETE)  ? ");
//		System.out.println(":: "+ productDao.removeProduct(product.getProdNo()));
		System.out.println(":: "+ productDao.removeProduct(10115));
		
		System.out.println("\n");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n");
		
		//6. ProductMapper.getProductList Test 
		System.out.println(":: 6. getProductList01(SELECT)  ? ");
		System.out.println(":: " + productDao.getProductList(search));
		System.out.println("\n");
		
		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();

		
		
	}//end of main
}//end of class