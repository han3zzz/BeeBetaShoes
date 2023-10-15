package com.spring.beebeta.service;

import com.spring.beebeta.entity.Address;
import com.spring.beebeta.repository.AddressRepository;
import com.spring.beebeta.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository repository;

    public List<Address> getAddressByCustomer(Integer Id){
        return repository.getAddressByCustomer(Id);
    }
    public Address getAddressById(Integer Id){
        return repository.getAddressById(Id);
    }
    public AddressResponse getAddressByBill(String code){
        return repository.getAddressByBill(code);
    }
}

