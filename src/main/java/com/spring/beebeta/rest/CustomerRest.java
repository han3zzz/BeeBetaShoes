package com.spring.beebeta.rest;

import com.spring.beebeta.request.ColorRequest;
import com.spring.beebeta.request.CustomerReques;
import com.spring.beebeta.service.ColorService;
import com.spring.beebeta.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
public class CustomerRest {
    @Autowired
    CustomerService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search/{fullname}")
    public ResponseEntity<?> getAllByProductName(@PathVariable("fullname") String fullname){
        return ResponseEntity.ok(service.getAllbyFullName(fullname));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody CustomerReques request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.add(request));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer Id,@Valid @RequestBody CustomerReques request, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.update(Id,request));
    }
    @PutMapping("/delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable("id") Integer id ){
        return ResponseEntity.ok(service.delete(id));
    }




}
