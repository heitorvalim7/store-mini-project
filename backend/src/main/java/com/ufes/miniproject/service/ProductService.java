package com.ufes.miniproject.service;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.ufes.miniproject.dtos.ProductRequestDTO;
import com.ufes.miniproject.dtos.ProductResponseDTO;
import com.ufes.miniproject.model.Product;
import com.ufes.miniproject.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService{
    private final ProductRepository productRepository;

    //dependency injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //read

    public List<ProductResponseDTO> getAllProduct(){
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> list = new ArrayList<>();
        for(Product p : products){
            ProductResponseDTO DTO = new ProductResponseDTO(p.getId(), p.getName(), p.getPrice(), p.getAmountInStorage());
            list.add(DTO);
        }
        return list;
    }

    //create

    public void addProduct(ProductRequestDTO product){
        Product p = new Product();
        p.setName(product.name());
        p.setPrice(product.price());
        p.setAmountInStorage(product.amountInStore());

        productRepository.save(p);
    }

    //update

    public void updateProduct(int id, ProductRequestDTO updateData){
        List<Product> products = productRepository.findAll();
        for(Product p : products){
            if(p.getId() == id){
                p.setName(updateData.name());
                p.setPrice(updateData.price());
                p.setAmountInStorage(updateData.amountInStore());
                productRepository.save(p);
            }
        }

    }

    //delete

    public void deleteProduct(int id){
        List<Product> products = productRepository.findAll();
        for(Product p : products){
            if(p.getId() == id){
                productRepository.delete(p);
            }
        }
    }

    public List<ProductResponseDTO> getProductByName(String name){
        List<ProductResponseDTO> list = new ArrayList<>();
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        for(Product p : products){
            list.add(new ProductResponseDTO(p.getId(), p.getName(), p.getPrice(), p.getAmountInStorage()));
        }
        return list;
    }

}
