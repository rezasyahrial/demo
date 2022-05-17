package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @EmbeddedId
    PrimaryKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product productId;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    Cart cartId;

    @Column(name = "qty_product")
    private int qtyProduct;

    @Column(name = "total_price")
    private double totalPrice;
}
