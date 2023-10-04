package com.spring.beebeta.rest;

import com.spring.beebeta.entity.CartDetail;
import com.spring.beebeta.request.CartDetailRequest;
import com.spring.beebeta.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cart")
public class CartRest {
    @Autowired
    CartDetailService service;
    @GetMapping("/{id}")
    public ResponseEntity<?> getCartByCustomer(@PathVariable("id") Integer id){
    return ResponseEntity.ok(service.getCartByCustomer(id));
    }
    @GetMapping("/getQuantityByCartDetail/{id}")
    public ResponseEntity<?> getQuantityByCartDetail(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getQuantityByCartDetail(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToCart(@PathVariable("id") Integer id){
        service.deleteToCart(id);
        return ResponseEntity.ok("ok");
    }
    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody CartDetailRequest cartDetail){
        return ResponseEntity.ok(service.addToCart(cartDetail));
    }
    @PutMapping("/updateCart/{id}")
    public ResponseEntity<?> updateToCart(@RequestBody CartDetailRequest cartDetail,@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.updateToCart(cartDetail,id));
    }

}
