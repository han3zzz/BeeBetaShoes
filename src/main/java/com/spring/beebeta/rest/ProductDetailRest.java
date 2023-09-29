package com.spring.beebeta.rest;

import com.spring.beebeta.entity.ProductDetail;
import com.spring.beebeta.request.ProductDetailRequest;
import com.spring.beebeta.request.ValidateForm;
import com.spring.beebeta.service.ProductDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> getAllByFilter(@RequestParam(name = "idcategory",required = false) Integer IdCategory,
                                            @RequestParam(name = "idmaterial",required = false) Integer IdMaterial,
                                            @RequestParam(name = "idcolor",required = false) Integer IdColor,
                                            @RequestParam(name = "idsize",required = false) Integer IdSize,
                                            @RequestParam(name = "idbrand",required = false) Integer IdBrand,
                                            @RequestParam(name = "idtoe",required = false) Integer IdToe,
                                            @RequestParam(name = "idsole",required = false) Integer IdSole,
                                            @RequestParam(name = "idshoelace",required = false) Integer IdShoelace,
                                            @RequestParam(name = "idheelcushion",required = false) Integer IdHeelcushion,
                                            @RequestParam(name = "iddesign",required = false) Integer IdDesign,
                                            @RequestParam("min") Double min,
                                            @RequestParam("max") Double max,
                                            @RequestParam("minTL") Double minTL,
                                            @RequestParam("maxTL") Double maxTL){

        return ResponseEntity.ok(service.getAllbyFilter(IdColor,IdSize,IdMaterial,IdCategory,IdBrand,IdToe,IdSole,IdShoelace,IdHeelcushion,IdDesign,min,max,minTL,maxTL));
    }

    @GetMapping("/phantrang")
    public ResponseEntity<?> phanTrang(@RequestParam(value = "page",defaultValue = "0") Integer page){
        return ResponseEntity.ok(service.phanTrang(page));
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody ProductDetailRequest productDetail, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(service.add(productDetail));
    }
    @PostMapping("/validate")
    public ResponseEntity<?> add(@Valid @RequestBody ValidateForm validateForm, BindingResult result){
        if (result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(validateForm);
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
