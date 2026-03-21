package com.inventory.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.loader.ProductDataLoader;
import com.inventory.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        // Insert data (run once)
        ProductDataLoader.loadData(session);

        // 3a. Sort by price ASC
        Query<Product> q1 = session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class);
        System.out.println("\nSorted by Price ASC:");
        q1.list().forEach(System.out::println);

        // 3b. Sort by price DESC
        Query<Product> q2 = session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class);
        System.out.println("\nSorted by Price DESC:");
        q2.list().forEach(System.out::println);

        // 4. Sort by quantity DESC
        Query<Product> q3 = session.createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class);
        System.out.println("\nSorted by Quantity:");
        q3.list().forEach(p -> System.out.println(p.getName() + " - " + p.getQuantity()));

        // 5a. First 3 products
        Query<Product> q4 = session.createQuery("FROM Product", Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);
        System.out.println("\nFirst 3 products:");
        q4.list().forEach(System.out::println);

        // 5b. Next 3 products
        Query<Product> q5 = session.createQuery("FROM Product", Product.class);
        q5.setFirstResult(3);
        q5.setMaxResults(3);
        System.out.println("\nNext 3 products:");
        q5.list().forEach(System.out::println);

        // 6a. Count total
        Long count = session.createQuery("SELECT COUNT(p) FROM Product p", Long.class).uniqueResult();
        System.out.println("\nTotal products: " + count);

        // 6b. Count quantity > 0
        Long countStock = session.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0", Long.class)
                .uniqueResult();
        System.out.println("Products in stock: " + countStock);

        // 6c. Group by description count
        List<Object[]> group = session.createQuery(
                "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description",
                Object[].class).list();

        System.out.println("\nGroup by description:");
        for (Object[] row : group) {
            System.out.println(row[0] + " -> " + row[1]);
        }

        // 6d. Min & Max price
        Object[] minmax = session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p",
                Object[].class).uniqueResult();

        System.out.println("\nMin price: " + minmax[0]);
        System.out.println("Max price: " + minmax[1]);

        // 8. Price range
        Query<Product> range = session.createQuery(
                "FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class);

        range.setParameter("min", 20.0);
        range.setParameter("max", 100.0);

        System.out.println("\nProducts between 20 and 100:");
        range.list().forEach(System.out::println);

        // 9a. LIKE start
        Query<Product> like1 = session.createQuery(
                "FROM Product p WHERE p.name LIKE 'D%'", Product.class);

        System.out.println("\nStarts with D:");
        like1.list().forEach(p -> System.out.println(p.getName()));

        session.close();
        factory.close();
    }
}