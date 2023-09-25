package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Category;
import com.spring.beebeta.repository.BrandRepository;
import com.spring.beebeta.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository repository;
    public List<Brand> getAll(){
        return repository.findAll();
    }
}
