package com.litmus7.pcm.dao;

import java.util.List;
import com.litmus7.pcm.dto.Product;
import com.litmus7.pcm.exception.DaoException;


public interface ProductDao {
	void addProduct(Product product) throws DaoException;
	Product getProductById(int productId) throws DaoException;
	List<Product> getAllProducts() throws DaoException ;
	void updateProduct(Product product) throws DaoException ;
	void deleteProduct(int productId) throws DaoException;
	List<Product> getProductsByCategory(String category) throws DaoException;

		
}
