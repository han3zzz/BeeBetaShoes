package com.spring.beebeta.rest;

import com.spring.beebeta.entity.ProductDetail_Size_Color;
import com.spring.beebeta.request.ProductDetail_MaterialRequest;
import com.spring.beebeta.request.ProductDetail_Size_ColorRequest;
import com.spring.beebeta.service.ProductDetail_MaterialService;
import com.spring.beebeta.service.ProductDetail_Size_ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/productdetail_color_size")
public class ProductDetail_Color_SizeRest {
    @Autowired
    ProductDetail_Size_ColorService service;
    @GetMapping("/getbycolor")
    public ResponseEntity<?> getByColor(@RequestParam("IdProduct") Integer IdProduct , @RequestParam("IdColor") Integer IdColor){
        return ResponseEntity.ok(service.getByColor(IdProduct,IdColor));
    }
    @GetMapping("/getQuantityProduct")
    public ResponseEntity<?> getQuantityProduct(@RequestParam("IdProduct") Integer IdProduct){
        return ResponseEntity.ok(service.getQuantityByProduct(IdProduct));
    }
    @GetMapping("/getQuantityProductAndColor")
    public ResponseEntity<?> getQuantityProductAndColor(@RequestParam("IdProduct") Integer IdProduct,@RequestParam("IdColor") Integer IdColor){
        return ResponseEntity.ok(service.getQuantityByProductAndColor(IdProduct,IdColor));
    }
    @GetMapping("/getQuantityProductAndColorAndSize")
    public ResponseEntity<?> getQuantityProductAndColorAndSize(@RequestParam("IdProduct") Integer IdProduct,@RequestParam("IdColor") Integer IdColor,@RequestParam("IdSize") Integer IdSize){
        return ResponseEntity.ok(service.getQuantityByProductAndColorAndSize(IdProduct,IdColor,IdSize));
    }

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ProductDetail_Size_ColorRequest request){
        return ResponseEntity.ok(service.add(request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok("ok");
    }
}
