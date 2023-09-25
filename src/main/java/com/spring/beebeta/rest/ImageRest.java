package com.spring.beebeta.rest;

import com.spring.beebeta.entity.ProductImage;
import com.spring.beebeta.request.ImageRequest;
import com.spring.beebeta.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/image")
public class ImageRest {
    @Autowired
    ImageService service;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ImageRequest image){
        return ResponseEntity.ok(service.add(image));
    }
}
