package com.example.demo.Service;


import com.example.demo.DTO.ProductDTO;
import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;


    public Product createData(Product product, MultipartFile file) throws IOException {
        product.setImage(file.getBytes());
        return repo.save(product);
    }


    public Product updateData(long id, Product product, MultipartFile file) throws IOException {
        Product dataProduct = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data with this id:" + id + " Not Found!"));
        dataProduct.setName(product.getName());
        dataProduct.setDesc(product.getDesc());
        dataProduct.setPrice(product.getPrice());
        dataProduct.setImage(file.getBytes());
        return repo.save(dataProduct);
    }


    public List<Product> getAllProduct() {
        List<Product> products = repo.findAll();
        return products;
    }


    public Product getProductById(long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data with this id : " + id + " Not Found!"));
        return product;
    }


    public Product deleteProduct(long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data with this id : " + id + " Not Found!"));
        repo.delete(product);
        return product;
    }

}
