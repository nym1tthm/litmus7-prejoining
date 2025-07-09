package com.litmus7.pcm.dao;

import com.litmus7.pcm.dto.Product;
import com.litmus7.pcm.util.*;
import com.litmus7.pcm.exception.DaoException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	private static final String INSERT_PRODUCT_SQL = "INSERT INTO products (productId, name, category, price, stockQuantity) VALUES (?, ?, ?, ?, ?)";
	
	private static final String SELECT_PRODUCT_BY_ID = "SELECT productId,name,category,price,stockQuantity FROM products WHERE productId = ?";

	private static final String SELECT_ALL_PRODUCTS = "SELECT productId,name,category,price,stockQuantity FROM products";

	private static final String UPDATE_PRODUCT_SQL = "UPDATE products SET name = ?, category = ?, price = ?, stockQuantity = ? WHERE productId = ?";

	private static final String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE productId = ?";
	
	private static final String SELECT_PRODUCTS_BY_CATEGORY =
		    "SELECT productId, name, category, price, stockQuantity FROM products WHERE category = ?";

	
	@Override
	public void addProduct(Product product ) throws DaoException {
		try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
			preparedStatement.setInt(1,product.getProductId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getCategory());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setInt(5, product.getStockQuantity());

			preparedStatement.executeUpdate();

        } catch (SQLException e) {
        	throw new DaoException("error adding product to database", e);
        }
	}
	
	@Override
    public Product getProductById(int productId) throws DaoException{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {

            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Product(
                        resultSet.getInt("productId"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stockQuantity")
                    );
                }
            }

        } catch (SQLException e) {
        	throw new DaoException("unable to fetch row", e);
        }
        return null;
    }
	
	 @Override
	    public List<Product> getAllProducts() throws DaoException{
	        List<Product> products = new ArrayList<>();
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                Product product = new Product(
	                    resultSet.getInt("productId"),
	                    resultSet.getString("name"),
	                    resultSet.getString("category"),
	                    resultSet.getDouble("price"),
	                    resultSet.getInt("stockQuantity")
	                );
	                products.add(product);
	            }

	        } catch (SQLException e) {
	        	throw new DaoException("cannot access db records", e);
	        }
	        return products;
	    }

	    @Override
	    public void updateProduct(Product product) throws DaoException{
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {

	            preparedStatement.setString(1, product.getName());
	            preparedStatement.setString(2, product.getCategory());
	            preparedStatement.setDouble(3, product.getPrice());
	            preparedStatement.setInt(4, product.getStockQuantity());
	            preparedStatement.setInt(5, product.getProductId());

	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	        	throw new DaoException("error updating database row", e);
	        }
	    }

	    @Override
	    public void deleteProduct(int productId) throws DaoException {
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {

	            preparedStatement.setInt(1, productId);
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	        	throw new DaoException("unable to delete rows", e);
	        }
	    }
	    @Override
	    public List<Product> getProductsByCategory(String category) throws DaoException{
	        List<Product> products = new ArrayList<>();
	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_CATEGORY)) {
	            preparedStatement.setString(1, category);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    Product product = new Product();
	                    product.setProductId(resultSet.getInt("productId"));
	                    product.setName(resultSet.getString("name"));
	                    product.setCategory(resultSet.getString("category"));
	                    product.setPrice(resultSet.getDouble("price"));
	                    product.setStockQuantity(resultSet.getInt("stockQuantity"));
	                    products.add(product);
	                }
	            }
	        } catch (SQLException e) {
	        	throw new DaoException("unable to fetch records by category", e);
	        }
	        return products;
	    }

	    
	    
	    
}
	
	
	
	

	