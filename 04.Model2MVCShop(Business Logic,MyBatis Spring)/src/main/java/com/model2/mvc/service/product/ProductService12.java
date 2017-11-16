package com.model2.mvc.service.product;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


//==> 회원관리에서 서비스할 내용 추상화/캡슐화한 Service  Interface Definition  
public interface ProductService12 {
	
	public int addProduct(Product product) throws Exception;
	
	public Product getProduct(int prodNo) throws Exception;
	
	public List<Product> getProductList(Search search) throws Exception;
	
	public int updateProduct(Product product) throws Exception;
	
	public int removeProduct(int prodNo) throws Exception;
	
}