package com.spring.beebeta.service;

import com.spring.beebeta.entity.ProductDetail;
import com.spring.beebeta.entity.Supplier;
import com.spring.beebeta.repository.SupplierRepository;
import com.spring.beebeta.request.SupplierRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository repository;

    public Supplier add(SupplierRequest request){
        Supplier supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setPhone(request.getPhone());
        supplier.setAddress(request.getAddress());
        supplier.setAgree(request.getAgree());
        supplier.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        return repository.save(supplier);
    }
    public void delete(Integer id){
        List<Supplier> suppliers = repository.getAllById(id);
        for (Supplier supplier: suppliers
             ) {
            repository.delete(supplier);
        }
    }
}
