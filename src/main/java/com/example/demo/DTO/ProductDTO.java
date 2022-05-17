package com.example.demo.DTO;

import com.example.demo.Model.Product;
import lombok.Data;

@Data
public class ProductDTO extends Product {

    private long id;
    private String name;
    private String desc;
    private double price;
    private byte[] image;



}
