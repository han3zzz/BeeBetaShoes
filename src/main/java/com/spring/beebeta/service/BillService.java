package com.spring.beebeta.service;

import com.spring.beebeta.entity.Address;
import com.spring.beebeta.entity.Bill;
import com.spring.beebeta.entity.Customer;
import com.spring.beebeta.entity.Employee;
import com.spring.beebeta.repository.BillRepository;
import com.spring.beebeta.request.BillRequest;
import com.spring.beebeta.request.BillTaiQuayRequest;
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
        return repository.save(bill);

    }
    public Bill updateStatusPay(String code){
    Bill bill = repository.getByCode(code);
    bill.setPayStatus(1);
    bill.setStatus(1);
    bill.setPaymentDate(new Date());
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
        bill.setStatus(request.getStatus());
        bill.setEmployee(Employee.builder().Id(request.getIdEmployee()).build());
        return repository.save(bill);
    }
}
