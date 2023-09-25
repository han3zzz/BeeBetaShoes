package com.spring.beebeta.rest;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.request.ProductReqest;
import com.spring.beebeta.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sanpham")
public class ProductRest {
    @Autowired
    ProductService service;
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ProductReqest product){
        return ResponseEntity.ok(service.add(product));
    }
}
