package com.example.springjpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping
    public String deleteProduct(@PathVariable int id){
        return  service.deleteProduct(id);
    }
}
