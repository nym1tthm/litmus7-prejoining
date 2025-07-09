package com.litmus7.pcm.service;

import com.litmus7.pcm.dto.Product;
import com.litmus7.pcm.exception.*;
import com.litmus7.pcm.exception.IllegalArgumentException;
import com.litmus7.pcm.dao.*;
import java.util.List;

public class ProductService {

    private final ProductDao productDAO;

    public ProductService() {
        this.productDAO = new ProductDaoImpl();
    }

    public void createProduct(Product product) throws IllegalArgumentException, ServiceException {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (product.getProductId() == null) {
            throw new IllegalArgumentException("Product ID cannot be empty.");
        }
        try {
            productDAO.addProduct(product);
        } catch (DaoException e) {
            throw new ServiceException("Error creating product", e);
        }
    }

    public Product getProductById(int productId) throws ServiceException, ProductNotFoundException {
        try {
            Product product = productDAO.getProductById(productId);
            if (product == null) {
                throw new ProductNotFoundException("Product not found.");
            }
            return product;
        } catch (DaoException e) {
            throw new ServiceException("Error fetching product by ID", e);
        }
    }

    public List<Product> getAllProducts() throws ServiceException {
        try {
            return productDAO.getAllProducts();
        } catch (DaoException e) {
            throw new ServiceException("Error fetching all products", e);
        }
    }

    public void updateProduct(Product product) throws ServiceException, ProductNotFoundException {
        try {
            Product existing = productDAO.getProductById(product.getProductId());
            if (existing == null) {
                throw new ProductNotFoundException("Product not found.");
            }
            productDAO.updateProduct(product);
        } catch (DaoException e) {
            throw new ServiceException("Error updating product", e);
        }
    }

    public void deleteProduct(int productId) throws ServiceException, ProductNotFoundException {
        try {
            Product existing = productDAO.getProductById(productId);
            if (existing == null) {
                throw new ProductNotFoundException("Product not found.");
            }
            productDAO.deleteProduct(productId);
        } catch (DaoException e) {
            throw new ServiceException("Error deleting product", e);
        }
    }

    public List<Product> getProductsByCategory(String category) throws ServiceException {
        try {
            return productDAO.getProductsByCategory(category);
        } catch (DaoException e) {
            throw new ServiceException("Error fetching products by category", e);
        }
    }
}
