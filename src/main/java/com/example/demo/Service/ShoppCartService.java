package com.example.demo.Service;

import com.example.demo.Model.ShoppingCart;
import com.example.demo.Repository.ShoppCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppCartService {

    @Autowired
    private ShoppCartRepo repo;

    public ShoppingCart createData(ShoppingCart shoppingCart){
        return repo.save(shoppingCart);
    }

    public ShoppingCart updateData(long id, ShoppingCart shoppingCart){
        ShoppingCart cart = repo.findById(id)
                .orElseThrow(()-> new RuntimeException("Data with this id: " + id + " Not Found!"));
        cart.setProductId(shoppingCart.getProductId());
        cart.setCartId(shoppingCart.getCartId());
        cart.setQtyProduct(shoppingCart.getQtyProduct());
        cart.setTotalPrice(shoppingCart.getTotalPrice());
        return repo.save(cart);
    }

    public List<ShoppingCart> getAllShoppingCart(){
        List<ShoppingCart> repoAll = repo.findAll();
        return repoAll;
    }

}
