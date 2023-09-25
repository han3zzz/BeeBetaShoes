package com.spring.beebeta.rest;

import com.spring.beebeta.entity.ProductDetail;
import com.spring.beebeta.request.ProductDetailRequest;
import com.spring.beebeta.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductDetailRest {
    @Autowired
     ProductDetailService service;

    @GetMapping("/phantrang")
    public ResponseEntity<?> phanTrang(@RequestParam(value = "page",defaultValue = "0") Integer page){
        return ResponseEntity.ok(service.phanTrang(page));
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDetailRequest productDetail){
        return ResponseEntity.ok(service.add(productDetail));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
}
