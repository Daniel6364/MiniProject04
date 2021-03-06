package com.model2.mvc.service.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao11;

public class ProductDaoImpl11 implements ProductDao11 {

	/// Field
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" + getClass() + ".setSqlSession() Call......");
		this.sqlSession = sqlSession;
	}
	
	public ProductDaoImpl11() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("ProductMapper.addProduct", product);
	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return (Product)sqlSession.selectOne("ProductMapper.getProduct", prodNo);
	}

	@Override
	public List<Product> getProductList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ProductMapper.getProductList", search);
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("ProductMapper.updateProduct", product);
	}

	@Override
	public int removeProduct(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("ProductMapper.removeProduct", prodNo);
	}

}
