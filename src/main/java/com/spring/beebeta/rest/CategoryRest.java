package com.spring.beebeta.rest;

import com.spring.beebeta.service.CategoryService;
import com.spring.beebeta.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/category")
public class CategoryRest {
    @Autowired
    CategoryService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
