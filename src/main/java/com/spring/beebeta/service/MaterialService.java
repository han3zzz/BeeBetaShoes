package com.spring.beebeta.service;

import com.spring.beebeta.entity.Material;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.MaterialRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialRepository repository;
    public List<Material> getAll(){
        return repository.findAll();
    }
}
