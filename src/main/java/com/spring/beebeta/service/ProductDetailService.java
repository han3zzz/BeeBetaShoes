package com.spring.beebeta.service;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public List<Product> getAll(){
        return repository.findAll();
    }
    public Page<Product> phanTrang(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return repository.findAll(pageable);
    }
}
