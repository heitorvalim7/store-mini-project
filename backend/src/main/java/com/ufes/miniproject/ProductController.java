package com.ufes.miniproject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //tells Spring that it will receive web requests and its responses will be JSON, not wen pages
@RequestMapping("/products") //it specifies that any method inside this class will only be triggered if the accessed URL ends with /products.
public class ProductController {
    private ProductRepository productRepository;

    //dependency injection
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


}
