package com.spring.beebeta.rest;

import com.spring.beebeta.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductDetailRest {
    @Autowired
    private ProductDetailService service;

    @GetMapping("/phantrang")
    public ResponseEntity<?> phanTrang(@RequestParam(value = "page",defaultValue = "0") Integer page){
        return ResponseEntity.ok(service.phanTrang(page));
    }
}
