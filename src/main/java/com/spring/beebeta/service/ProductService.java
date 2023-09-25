package com.spring.beebeta.service;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.repository.ProductRepository;
import com.spring.beebeta.request.ProductReqest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product add(ProductReqest reqest){
        Product product = new Product();
        product.setCode(reqest.getCode());
        product.setName(reqest.getName());
        product.setDescription(reqest.getDescription());
        product.setCreateDate(new Date());
        product.setStatus(0);
        return repository.save(product);
    }
}
