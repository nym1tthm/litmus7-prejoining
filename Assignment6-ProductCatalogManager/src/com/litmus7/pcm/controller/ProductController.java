package com.litmus7.pcm.controller;


import com.litmus7.pcm.dto.*;
import com.litmus7.pcm.service.*;
import com.litmus7.pcm.exception.*;
import com.litmus7.pcm.exception.IllegalArgumentException;

import java.util.List;

public class ProductController {

    private final ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    public Response<Product> createProduct(Product product) {
        Response<Product> response = new Response<>();
        try {
            productService.createProduct(product);
            response.setStatusCode(Response.SUCCESS_CREATE);
            response.setMessage("Product created successfully.");
            response.setData(product);
        } catch (IllegalArgumentException e) {
            response.setStatusCode(Response.ERROR_VALIDATION);
            response.setMessage(e.getMessage());
        } catch (ServiceException e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("Failed to create product.");
        }catch (Exception e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("An unexpected error occurred.");
        }
        return response;
    }

    public Response<Product> getProductById(int productId) {
        Response<Product> response = new Response<>();
        try {
            Product product = productService.getProductById(productId);
            response.setStatusCode(Response.SUCCESS_SEARCH);
            response.setMessage("Product fetched successfully.");
            response.setData(product);
        } catch (ProductNotFoundException e) {
            response.setStatusCode(Response.ERROR_NOT_FOUND);
            response.setMessage(e.getMessage());
        } catch (ServiceException e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("Error fetching product.");
        }catch (Exception e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("An unexpected error occurred.");
        }
        return response;
    }

    public Response<List<Product>> getAllProducts() {
        Response<List<Product>> response = new Response<>();
        try {
            List<Product> products = productService.getAllProducts();
            if (products.isEmpty()) {
                response.setStatusCode(Response.ERROR_NOT_FOUND);
                response.setMessage("No products found in the catalog.");
            } else {
                response.setStatusCode(Response.SUCCESS_SEARCH);
                response.setMessage("Products fetched successfully.");
            }
            response.setData(products);
        } catch (ServiceException e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("Error fetching products.");
        }
        return response;
    }


    public Response<Product> updateProduct(Product product) {
        Response<Product> response = new Response<>();
        try {
            productService.updateProduct(product);
            response.setStatusCode(Response.SUCCESS_UPDATE);
            response.setMessage("Product updated successfully.");
            response.setData(product);
        } catch (ProductNotFoundException e) {
            response.setStatusCode(Response.ERROR_NOT_FOUND);
            response.setMessage(e.getMessage());
        } catch (ServiceException e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("Error updating product.");
        }catch (Exception e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("An unexpected error occurred.");
        }
        return response;
    }

    public Response<Void> deleteProduct(int productId) {
        Response<Void> response = new Response<>();
        try {
            productService.deleteProduct(productId);
            response.setStatusCode(Response.SUCCESS_DELETE);
            response.setMessage("Product deleted successfully.");
        } catch (ProductNotFoundException e) {
            response.setStatusCode(Response.ERROR_NOT_FOUND);
            response.setMessage(e.getMessage());
        } catch (ServiceException e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("Error deleting product.");
        }catch (Exception e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("An unexpected error occurred.");
        }
        return response;
    }

    public Response<List<Product>> getProductsByCategory(String category) {
        Response<List<Product>> response = new Response<>();
        try {
            List<Product> products = productService.getProductsByCategory(category);
            if (products.isEmpty()) {
                response.setStatusCode(Response.ERROR_NOT_FOUND);
                response.setMessage("No products found in this category.");
            } else {
                response.setStatusCode(Response.SUCCESS_SEARCH);
                response.setMessage("Products fetched successfully.");
            }
            response.setData(products);
        } catch (ServiceException e) {
            response.setStatusCode(Response.ERROR_UNKNOWN);
            response.setMessage("Error fetching products by category.");
        }
        return response;
    }

}

