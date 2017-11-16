package mybatis.service.product.test;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


/*
 * FileName : MyBatisTestApp10.java
 */
public class ProductTestApp10 {
	
	///main method
	public static void main(String[] args) throws Exception{
	
		//==> SqlSessionFactoryBean.getSqlSession()을 이용 SqlSession instance GET
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");
		
		//==> Test 용 User instance 생성  
		Product product = new Product("핸드크림10", "올리브영10", "20160608", 8500, "HandCream10.jpg");
		
		//1. ProductMapper.addProduct Test  ::   
		System.out.println(":: 1. addUser(INSERT)  ? ");
		System.out.println(":: "+ sqlSession.insert("ProductMapper.addProduct", product));
		System.out.println("\n");
		
		//2. ProductMapper.getProduct Test :: 입력값 : prodName = 자전거 : OK 
		System.out.println(":: 2. getProduct(SELECT)  ? ");
		product.setProdNo(10001);
		System.out.println(":: "+sqlSession.selectOne("ProductMapper.getProduct", product.getProdNo()) );
		System.out.println("\n");
		
		//3. ProductMapper.updateProduct Test  :: 입력값 바디샤워 : OK
		System.out.println(":: 3. update(UPDATE)  ? ");
		product.setProdName("바디샤워10");
		product.setProdDetail("롭스10");
		product.setManuDate("20150905");
		product.setPrice(9800);
		product.setFileName("BodyShower10.jpg");
		System.out.println(":: "+ sqlSession.update("ProductMapper.updateProduct", product));
		System.out.println("\n");
		
		//4. ProductMapper.getProductList Test  :: Dynamic Query 확인 no=10002/name= 검색
		System.out.println(":: 4. getProduct(SELECT)  ? ");
		product.setProdNo(10003);
		System.out.println(":: "+sqlSession.selectOne("ProductMapper.getProduct", product.getProdNo()) );
		
		//5. UserMapper10.removeUser Test
//		System.out.println(":: 5. Product.removeProduct (DELETE)  ? ");
//		System.out.println(":: "+sqlSession.delete("ProductMapper.removeProduct", product.getProdNo()) );
		
		System.out.println("\n");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n");
		
		//==> Test 용 Search instance 생성 
		Search search = new Search();
		
		//1. ProductMapper.getProductList Test 
		System.out.println(":: 1. getProductList01(SELECT)  ? ");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper.getProductList", search) );
		
		//2. ProductMapper.getProductList Test 
		System.out.println(":: 2. getProductList01(SELECT)  ? ");
		search.setSearchCondition("0");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("10007");
		arrayList.add("10006");
		search.setProdNo( arrayList );
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper.getProductList", search) );
		
		//3. ProductMapper.getProductList Test 
		System.out.println(":: 3. getProductList01(SELECT)  ? ");
		search.setSearchCondition("1");
		search.setProdName( new String[]{ "바디샤워" } );
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper.getProductList",search) );

		//END::SqlSession  close
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();

		
		
	}//end of main
}//end of class