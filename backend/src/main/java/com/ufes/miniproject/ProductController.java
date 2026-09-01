package com.ufes.miniproject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //tells Spring that it will receive web requests and its responses will be JSON, not web pages
@RequestMapping("/products") //it specifies that any method inside this class will only be triggered if the accessed URL ends with /products.
public class ProductController {
    private final ProductService productService;

    //dependency injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody ProductRequestDTO productRequestDTO){
        productService.addProduct(productRequestDTO);
    }

    @PutMapping("/{id}")
    public void updateProduct (@PathVariable Integer id, @RequestBody ProductRequestDTO productRequestDTO){
        productService.updateProduct(id, productRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

}
