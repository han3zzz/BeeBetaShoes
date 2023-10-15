package com.spring.beebeta.rest;

import com.spring.beebeta.request.BillDetailRequest;
import com.spring.beebeta.request.BillRequest;
import com.spring.beebeta.request.BillTaiQuayRequest;
import com.spring.beebeta.request.CartDetailRequest;
import com.spring.beebeta.service.BillDetailService;
import com.spring.beebeta.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bill")
public class BillRest {

    @Autowired
    BillService service;

    @Autowired
    BillDetailService billDetailService;
    @PostMapping
    public ResponseEntity<?> addBill(@RequestBody BillRequest request){
        return ResponseEntity.ok(service.add(request));
    }
    @PostMapping("/billTaiQuay")
    public ResponseEntity<?> billTaiQuay(@RequestBody BillTaiQuayRequest request){
        return ResponseEntity.ok(service.addBillTaiQuay(request));
    }
    @GetMapping("/billByCustomer")
    public ResponseEntity<?> billByCustomer(@RequestParam(value = "status",required = false) Integer status , @RequestParam("idCustomer") Integer idCustomer){
        return ResponseEntity.ok(service.getBillByCustomer(status,idCustomer));
    }
    @GetMapping("/billAll")
    public ResponseEntity<?> billAll(){
        return ResponseEntity.ok(service.getAllBill());
    }
    @PostMapping("/addBillDetail")
    public ResponseEntity<?> addToBillDetail(@RequestBody BillDetailRequest billDetailRequest){
        return ResponseEntity.ok(billDetailService.addBillDetail(billDetailRequest));
    }
    @PutMapping("/updateBillDetail/{id}")
    public ResponseEntity<?> updateBillDetail(@PathVariable("id") Integer id,@RequestBody BillDetailRequest billDetailRequest){
        return ResponseEntity.ok(billDetailService.updateBillDetail(id,billDetailRequest));
    }
    @PutMapping("/{code}")
    public ResponseEntity<?> addToBillDetail(@PathVariable("code") String code){
        return ResponseEntity.ok(service.updateStatusPay(code));
    }
    @GetMapping("/huy/{code}")
    public ResponseEntity<?> huyBill(@PathVariable("code") String code){
        service.huyBill(code);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/getbilldetail/{id}")
    public ResponseEntity<?> getbilldetail(@PathVariable("id") Integer id){
        return ResponseEntity.ok(billDetailService.getById(id));
    }
    @GetMapping("/getbycode/{code}")
    public ResponseEntity<?> getbycode(@PathVariable("code") String code){
        return ResponseEntity.ok(service.getByCode(code));
    }
    @GetMapping("/getbystatus/{status}")
    public ResponseEntity<?> getbystatus(@PathVariable("status") Integer status){
        return ResponseEntity.ok(service.getAllByStatus(status));
    }
    @GetMapping("/getallbybill/{code}")
    public ResponseEntity<?> getallbybill(@PathVariable("code") String code){
        return ResponseEntity.ok(billDetailService.getAllbyBill(code));
    }
    @GetMapping("/deleteBillDetail/{id}")
    public ResponseEntity<?> deleteBillDetail(@PathVariable("id") Integer id){
        billDetailService.deleteBillDetail(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/getallbyproduct/{id}")
    public ResponseEntity<?> getallbyproduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(billDetailService.getAllByIdProduct(id));
    }



}
