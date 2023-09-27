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
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> getAllByProductName(@PathVariable("name") String name){
        return ResponseEntity.ok(service.getAllbyProductName(name));
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getAllByFilter(@RequestParam("idcategory") Integer IdCategory,
                                            @RequestParam("idbrand") Integer IdBrand,
                                            @RequestParam("idtoe") Integer IdToe,
                                            @RequestParam("idsole") Integer IdSole,
                                            @RequestParam("idshoelace") Integer IdShoelace,
                                            @RequestParam("idheelcushion") Integer IdHeelcushion,
                                            @RequestParam("iddesign") Integer IdDesign,
                                            @RequestParam("min") Double min,
                                            @RequestParam("max") Double max,
                                            @RequestParam("minTL") Double minTL,
                                            @RequestParam("maxTL") Double maxTL){
        return ResponseEntity.ok(service.getAllbyFilter(IdCategory,IdBrand,IdToe,IdSole,IdShoelace,IdHeelcushion,IdDesign,min,max,minTL,maxTL));
    }

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
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody ProductDetailRequest request){
        return ResponseEntity.ok(service.update(id,request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
}
