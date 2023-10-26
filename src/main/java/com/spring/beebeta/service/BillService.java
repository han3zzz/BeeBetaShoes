package com.spring.beebeta.service;

import com.spring.beebeta.entity.*;
import com.spring.beebeta.repository.BillRepository;
import com.spring.beebeta.request.BillRequest;
import com.spring.beebeta.request.BillTaiQuayRequest;
import com.spring.beebeta.request.BillTaiQuayUpdateRequest;
import com.spring.beebeta.request.UpdateThanhToanTaiQuay;
import com.spring.beebeta.response.BillAllResponse;
import com.spring.beebeta.response.BillResponse;
import com.spring.beebeta.response.BillTaiQuayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class BillService {
    @Autowired
    BillRepository repository;

    public String genCode(){
        // Tạo đối tượng Random
        String code = "HD";
        Random random = new Random();
        for (int i = 0 ; i < 9 ; i++){
            Integer so = random.nextInt(9);
            code  += String.valueOf(so);
        }
    return code;
    }

    public Bill add(BillRequest request){
        Bill bill = new Bill();
        bill.setCode(genCode());
        bill.setPurchaseDate(new Date());
        bill.setNote(request.getNote());
        bill.setShipPrice(request.getShipPrice());
        bill.setTotalPrice(request.getTotalPrice());
        bill.setTotalPriceLast(request.getTotalPriceLast());
        bill.setPayStatus(request.getPayStatus());
        bill.setPayType(request.getPayType());
        bill.setIdCoupon(request.getIdCoupon());
        bill.setAddress(Address.builder().Id(request.getIdAddress()).build());
        bill.setCustomer(Customer.builder().Id(request.getIdCustomer()).build());
        bill.setStatus(request.getStatus());
        bill.setTypeStatus(request.getTypeStatus());
        return repository.save(bill);

    }
    public Bill update(String code, BillTaiQuayUpdateRequest request){
        Bill bill = repository.getByCode(code);
        bill.setNote(request.getNote());
        bill.setShipPrice(request.getShipPrice());
        bill.setTotalPrice(request.getTotalPrice());
        bill.setTotalPriceLast(request.getTotalPriceLast());
        bill.setPayStatus(request.getPayStatus());
        bill.setPayType(request.getPayType());
        bill.setIdCoupon(request.getIdCoupon());
       if(request.getIdAddress() != 0){
           bill.setAddress(Address.builder().Id(request.getIdAddress()).build());
       }
        bill.setStatus(request.getStatus());
        bill.setPaymentDate(request.getPaymentDate());
        bill.setDelyveryDate(request.getDelyveryDate());
        if(request.getIdCustomer() != 0){
            bill.setCustomer(Customer.builder().Id(request.getIdCustomer()).build());
        }
        if(request.getIdVoucher() != 0 && request.getIdVoucher() != null){
            bill.setVoucher(Voucher.builder().Id(request.getIdVoucher()).build());
        }
        return repository.save(bill);
    }
    public Bill updateStatus(String code, UpdateThanhToanTaiQuay request){
        Bill bill = repository.getByCode(code);

        bill.setStatus(request.getStatus());
        bill.setDelyveryDate(request.getDeliveryDate());
        bill.setPayStatus(request.getPayStatus());
        bill.setPaymentDate(request.getPaymentDate());
        return repository.save(bill);

    }
    public Bill updateStatus1(String code, UpdateThanhToanTaiQuay request){
        Bill bill = repository.getByCode(code);
        bill.setDelyveryDate(new Date());
        bill.setPayStatus(request.getPayStatus());
        bill.setPaymentDate(new Date());
        return repository.save(bill);

    }
    public Bill updateStatusPay(String code){
    Bill bill = repository.getByCode(code);
    bill.setPayStatus(1);
    bill.setStatus(0);
    bill.setPaymentDate(new Date());
    return repository.save(bill);
    }
    public Bill updateStatus(String code,Integer status){
        Bill bill = repository.getByCode(code);
        bill.setStatus(status);
        return repository.save(bill);
    }
    public void huyBill(String code){
        Bill bill = repository.getByCode(code);
        bill.setStatus(4);
        repository.save(bill);
    }
    public List<BillResponse> getBillByCustomer(Integer status , Integer idCustomer){
        return repository.getBillByCustomer(status,idCustomer);
    }
    public List<BillAllResponse> getAllBill(){
        return repository.getAllBill();
    }
    public BillResponse getByCode(String code){
        return repository.getBillBycode(code);
    }
    public List<BillResponse> getAllByStatus(Integer status){
        return repository.getBillByStatus(status);
    }
    public Bill addBillTaiQuay(BillTaiQuayRequest request){
        Bill bill = new Bill();
        bill.setCode(genCode());
        bill.setPurchaseDate(new Date());
        bill.setTypeStatus(request.getTypeStatus());
        bill.setStatus(request.getStatus());
        bill.setEmployee(Employee.builder().Id(request.getIdEmployee()).build());
        return repository.save(bill);
    }
    public List<BillResponse> getAll(){
        return repository.getAll();
    }
}
