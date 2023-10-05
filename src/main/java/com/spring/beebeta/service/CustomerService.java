package com.spring.beebeta.service;

import com.spring.beebeta.entity.Color;
import com.spring.beebeta.entity.Customer;
import com.spring.beebeta.entity.Sole;
import com.spring.beebeta.repository.CustomerRepository;
import com.spring.beebeta.request.CustomerReques;
import com.spring.beebeta.rest.CustomerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    // hien thi tat ca
    public List<Customer> getAll(){
        return customerRepository.getAll();
    }

    // Tim khach hang
    public List<Customer> getAllbyFullName(String fullname){
        return customerRepository.searchByFullName('%'+fullname+'%');
    }
    // add khach hang
    public Customer add(CustomerReques reques){
        Customer customer = new Customer();
        customer.setCode(reques.getCode());
        customer.setFullname(reques.getFullname());
        customer.setUsername(reques.getUsername());
        customer.setPassword(reques.getPassword());
        customer.setImage(reques.getImage());
        customer.setGender(reques.getGender());
        customer.setPhone(reques.getPhone());
        customer.setEmail(reques.getEmail());
        customer.setStatus(0);
        return customerRepository.save(customer);
    }
    // update khach hang
    public  Customer update(Integer id , CustomerReques reques){
        Customer customer = customerRepository.getById(id);
        customer.setCode(reques.getCode());
        customer.setFullname(reques.getFullname());
        customer.setUsername(reques.getUsername());
        customer.setPassword(reques.getPassword());
        customer.setImage(reques.getImage());
        customer.setGender(reques.getGender());
        customer.setPhone(reques.getPhone());
        customer.setEmail(reques.getEmail());
        customer.setStatus(0);
        return customerRepository.save(customer);
    }
    // xoa khach hang
    public  Customer delete(Integer id ){
        Customer customer = customerRepository.getById(id);
        customer.setStatus(1);
        return  customerRepository.save(customer);
    }
    // de tai khach hang
    public Customer getById(Integer Id){
        Customer customer = customerRepository.getById(Id);
        return customer;
    }
}
