package com.example.demo.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CartService{

    @Autowired
    CartRepo repo;


    public Cart createData(Cart cart) throws IOException {
        return repo.save(cart);
    }


    public Cart updateData(long id, Cart cart) throws IOException {
        Cart dataCart = repo.findById(id)
                .orElseThrow(()-> new RuntimeException("Data with this id:" + id + " Not Found!"));
        dataCart.setName(cart.getName());

        return repo.save(dataCart);
    }


    public List<Cart> getAllCart() {

        List<Cart> carts = repo.findAll();
        return carts;
    }


    public Cart getCartById(long id) {
        Cart cart= repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data with this id : " + id + " Not Found!"));
        return cart;
    }


    public Cart deleteProduct(long id) {
        return null;
    }
}
