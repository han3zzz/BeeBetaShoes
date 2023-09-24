package com.spring.beebeta.service;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.ProductDetail;
import com.spring.beebeta.repository.ProductDetailRepository;
import com.spring.beebeta.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository repository;
    public List<ProductDetail> getAll(){
        return repository.findAll();
    }
    public Page<ProductDetail> phanTrang(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return repository.findAll(pageable);
    }
}
