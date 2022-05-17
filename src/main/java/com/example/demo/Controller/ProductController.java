package com.example.demo.Controller;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/data")
public class ProductController {

    @Autowired
    private ProductService service;


    private ModelMapper modelMapper;

    @GetMapping("/product")
    public List<Product> getAllData(){
        return service.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id) {
        Product product = service.getProductById(id);

        return ResponseEntity
                .ok()
                .body(product);
    }

//    @RequestMapping(path = "/product",method = POST, consumes = {
//            MediaType.MULTIPART_FORM_DATA_VALUE
//    })
//    public String postData(@ModelAttribute ProductDTO dto, @RequestPart MultipartFile file) throws IOException {
//
//        //Convert DTO to Entity
//        Product prodReq = modelMapper.map(dto, Product.class);
//        Product product = service.createData(prodReq, file);
//        product.setImage(file.getBytes());
//
//        //Convert Entity to DTO
//        ProductDTO response = modelMapper.map(product, ProductDTO.class);
//        return "Data Uploaded!";
//    }

    @RequestMapping(path = "/product",method = POST, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String postData(@ModelAttribute Product wrap, @RequestPart MultipartFile file) throws IOException {

        Product product = service.createData(wrap, file);
        product.setImage(file.getBytes());
        return "Data Uploaded!";
    }

    @RequestMapping(path = "/product/{id}", method = PUT, consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public String putData(@ModelAttribute ProductDTO wrap, @RequestPart MultipartFile file, @PathVariable long id) throws IOException {
        Product product = service.updateData(id, wrap, file);
        product.setImage(file.getBytes());
        return "Data Updated!";
    }

    @DeleteMapping("/product/{id}")
    public String deleteData(@PathVariable long id){
        Product product = service.deleteProduct(id);
        return "Data Deleted!";
    }

//    private ProductDTO convertToDto(Product product){
//        ProductDTO dto = modelMapper.map(product, ProductDTO.class);
//        dto.setName(product.getName());
//        dto.setDesc(product.getDesc());
//        dto.setPrice(product.getPrice());
//        dto.setImage(product.getImage());
//        return dto;
//    }
//
//    private Product convertToEntity(ProductDTO productDTO){
//        Product product = modelMapper.map(productDTO, Product.class);
//        product.setName(productDTO.getName());
//        product.setDesc(productDTO.getDesc());
//        product.setPrice(productDTO.getPrice());
//        product.setImage(productDTO.getImage());
//
//        if(productDTO.getId() != null){
//            Product oldPost = service.getProductById(productDTO.getId());
//
//        }
//    }
}
