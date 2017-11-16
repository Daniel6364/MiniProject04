package com.model2.mvc.service.product.impl;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao11;
import com.model2.mvc.service.product.ProductService12;

public class ProductServiceImpl12 implements ProductService12 {

	/// Field
	ProductDao11 productDao;
	
	public void setProductDao(ProductDao11 productDao) {
		System.out.println("::" + getClass() + ".setProductDao Call......");
		this.productDao = productDao;
	}
	
	public ProductServiceImpl12() {
		System.out.println("::" + getClass() + " default Constructor Call......");
	}

	@Override
	public int addProduct(Product product) throws Exception {
		return productDao.addProduct(product);
	}

	@Override
	public Product getProduct(int prodNo) throws Exception {
		return productDao.getProduct(prodNo);
	}

	@Override
	public List<Product> getProductList(Search search) throws Exception {
		return productDao.getProductList(search);
	}

	@Override
	public int updateProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
	}

	@Override
	public int removeProduct(int prodNo) throws Exception {
		return productDao.removeProduct(prodNo);
	}

}
