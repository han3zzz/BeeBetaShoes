package com.spring.beebeta.service;

import com.spring.beebeta.entity.Address;
import com.spring.beebeta.repository.AddressRepository;
import com.spring.beebeta.request.AddressKhachLe;
import com.spring.beebeta.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Address add(AddressKhachLe addressKhachLe){
        Address address = new Address();
        address.setAddress(addressKhachLe.getAddress());
        address.setFullname(addressKhachLe.getFullname());
        address.setPhone(addressKhachLe.getPhone());
        address.setCityName(addressKhachLe.getCityName());
        address.setDistrictName(addressKhachLe.getDistrictName());
        address.setWardName(addressKhachLe.getWardName());
        address.setCityId(addressKhachLe.getCityId());
        address.setDistrictId(addressKhachLe.getDistrictId());
        address.setWardId(addressKhachLe.getWardId());
        address.setCreateDate(new Date());
        address.setStatus(0);
        return  repository.save(address);
    }
}

