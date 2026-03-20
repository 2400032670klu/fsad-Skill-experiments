package com.inventory.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        while (true) {
            System.out.println("\n--- INVENTORY MENU ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    dao.saveProduct(new Product(name, desc, price, qty));
                    System.out.println("Product added successfully");
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    Product p = dao.getProduct(id);

                    if (p != null) {
                        System.out.println("Name: " + p.getName());
                        System.out.println("Description: " + p.getDescription());
                        System.out.println("Price: " + p.getPrice());
                        System.out.println("Quantity: " + p.getQuantity());
                    } else {
                        System.out.println("Product not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    dao.updateProduct(uid, newPrice, newQty);
                    System.out.println("Product updated");
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    int did = sc.nextInt();

                    dao.deleteProduct(did);
                    break;

                case 5:
                    HibernateUtil.getSessionFactory().close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}