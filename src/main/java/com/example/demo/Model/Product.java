package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name", length = 20, nullable = false)
    private String name;

    @Column(name = "product_description", nullable = false)
    private String desc;

    @Column(name = "price", nullable = false)
    private double price;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image", nullable = true)
    private byte[] image;


    @OneToMany(mappedBy = "productId")
    Set<ShoppingCart> shoppingCarts;


}
