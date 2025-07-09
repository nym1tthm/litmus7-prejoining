package com.litmus7.pcm.ui;


import com.litmus7.pcm.controller.ProductController;
import com.litmus7.pcm.dto.*;


import java.util.List;
import java.util.Scanner;

public class ProductManagerApp {

    public static void main(String[] args) {
        ProductController controller = new ProductController();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Product Manager ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. View Products by Category");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Product newProduct = new Product();
                    System.out.print("Enter Product ID: ");
                    newProduct.setProductId(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Enter Product Name: ");
                    newProduct.setName(scanner.nextLine());
                    System.out.print("Enter Category: ");
                    newProduct.setCategory(scanner.nextLine());
                    System.out.print("Enter Price: ");
                    newProduct.setPrice(Double.parseDouble(scanner.nextLine()));
                    System.out.print("Enter Stock Quantity: ");
                    newProduct.setStockQuantity(Integer.parseInt(scanner.nextLine()));
                    Response<Product> response = controller.createProduct(newProduct);
                    System.out.println(response.getMessage());
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Response<Product> searchResponse = controller.getProductById(id);
                    if (searchResponse.getData() != null) {
                        System.out.println(searchResponse.getData());
                    }
                    System.out.println(searchResponse.getMessage());
                    break;

                case 3:
                    Response<List<Product>> getAllResponse = controller.getAllProducts();
                    List<Product> products = getAllResponse.getData();
                    if (products != null) {
                        products.forEach(System.out::println);
                    }
                    System.out.println(getAllResponse.getMessage());
                    break;

                case 4:
                    Product updateProduct = new Product();
                    System.out.print("Enter Product ID to update: ");
                    updateProduct.setProductId(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Enter New Name: ");
                    updateProduct.setName(scanner.nextLine());
                    System.out.print("Enter New Category: ");
                    updateProduct.setCategory(scanner.nextLine());
                    System.out.print("Enter New Price: ");
                    updateProduct.setPrice(Double.parseDouble(scanner.nextLine()));
                    System.out.print("Enter New Stock Quantity: ");
                    updateProduct.setStockQuantity(Integer.parseInt(scanner.nextLine()));
                    Response<Product> updateResponse = controller.updateProduct(updateProduct);
                    System.out.println(updateResponse.getMessage());
                    break;

                case 5:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    Response<Void> deleteResponse = controller.deleteProduct(deleteId);
                    System.out.println(deleteResponse.getMessage());
                    break;

                case 6:
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    Response<List<Product>> getCategoryResponse = controller.getProductsByCategory(category);
                    List<Product> categoryProducts = getCategoryResponse.getData();
                    if (categoryProducts != null) {
                        categoryProducts.forEach(System.out::println);
                    }
                    System.out.println(getCategoryResponse.getMessage());
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
