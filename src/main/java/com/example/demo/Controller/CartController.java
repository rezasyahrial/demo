package com.example.demo.Controller;

import com.example.demo.Model.Cart;
import com.example.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/data")
public class CartController {

    @Autowired
    CartService service;

    @GetMapping("/cart")
    public List<Cart> getAllData(){
        return service.getAllCart();
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getProductById(@PathVariable(name = "id") Long id) {
        Cart product = service.getCartById(id);

        return ResponseEntity
                .ok()
                .body(product);
    }

    @RequestMapping(path = "/cart",method = POST, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String postData(@ModelAttribute Cart wrap) throws IOException {

        Cart product = service.createData(wrap);
        return "Data Uploaded!";
    }

    @RequestMapping(path = "/cart/{id}", method = PUT, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String putData(@ModelAttribute Cart wrap, @PathVariable long id) throws IOException {
        Cart product = service.updateData(id, wrap);
        return "Data Updated!";
    }



}
