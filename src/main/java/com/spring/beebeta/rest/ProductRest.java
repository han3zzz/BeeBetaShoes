package com.spring.beebeta.rest;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.request.ProductReqest;
import com.spring.beebeta.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sanpham")
public class ProductRest {
    @Autowired
    ProductService service;
    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody ProductReqest product, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
            return ResponseEntity.ok(service.add(product));


    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody ProductReqest product){
        return ResponseEntity.ok(service.update(id,product));
    }
}
