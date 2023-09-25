package com.spring.beebeta.service;

import com.spring.beebeta.entity.Category;
import com.spring.beebeta.entity.ProductDetail;
import com.spring.beebeta.repository.CategoryRepository;
import com.spring.beebeta.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;
    public List<Category> getAll(){
        return repository.findAll();
    }
}
