package com.indra.product.controller;

import com.indra.product.model.Product;
import com.indra.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Add product
    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return repo.save(p);
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min,
                                @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sorted
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.findAllSortedByPrice();
    }

    // Expensive
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }
}