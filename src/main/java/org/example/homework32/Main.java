package org.example.homework32;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Show products");
            System.out.println("2. Add product to the bag");
            System.out.println("3. Remove product from cart");
            System.out.println("4. Show cart");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Products:");
                    productRepository.getAllProducts().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Add ID products:");
                    int idToAdd = scanner.nextInt();
                    Product productToAdd = productRepository.getProductById(idToAdd);
                    if (productToAdd != null) {
                        Cart cart = context.getBean(Cart.class);
                        cart.addProduct(productToAdd);
                        System.out.println("Product add to cart: " + productToAdd);
                    } else {
                        System.out.println("Product with such ID not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the ID of the product you want to remove:");
                    int idToRemove = scanner.nextInt();
                    Product productToRemove = productRepository.getProductById(idToRemove);
                    if (productToRemove != null) {
                        Cart cart = context.getBean(Cart.class);
                        cart.removeProductById(idToRemove);
                        System.out.println("Product removed from cart: " + productToRemove);
                    } else {
                        System.out.println("Product with this ID was not found.");
                    }
                    break;
                case 4:
                    System.out.println("Cart::");
                    Cart cart = context.getBean(Cart.class);
                    cart.getProducts().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }
}

