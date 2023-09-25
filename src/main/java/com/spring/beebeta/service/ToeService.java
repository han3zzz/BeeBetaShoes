package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.BrandRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToeService {
    @Autowired
    ToeRepository repository;
    public List<Toe> getAll(){
        return repository.findAll();
    }
}
