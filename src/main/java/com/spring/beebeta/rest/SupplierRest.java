package com.spring.beebeta.rest;

import com.spring.beebeta.request.SupplierRequest;
import com.spring.beebeta.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/supplier")
public class SupplierRest {
    @Autowired
    SupplierService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody SupplierRequest request){
        return ResponseEntity.ok(service.add(request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
