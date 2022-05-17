package com.example.demo.Repository;

import com.example.demo.Model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppCartRepo extends JpaRepository<ShoppingCart, Long> {

//    @Query(value = "SELECT * FROM tb_shoppingcart", nativeQuery = true)
//    List<Shopping_Cart> getAllShoppingCartData();


//    @Query(value = "SELECT ")
//    Shopping_Cart getShoppingCartDataById(long id);

}
