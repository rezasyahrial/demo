package com.example.demo.Controller;

import com.example.demo.Model.ShoppingCart;
import com.example.demo.Service.ShoppCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/data")
public class ShoppingCartController {

    @Autowired
    private ShoppCartService service;

    @GetMapping("/shopcart")
    public List<ShoppingCart> getAllData(){
        return service.getAllShoppingCart();
    }

    @RequestMapping(path = "/shopcart",method = POST, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String postData(@ModelAttribute ShoppingCart wrap) throws IOException {

        ShoppingCart shoppingCartDTO = service.createData(wrap);
        return "Data Uploaded!";
    }

}
