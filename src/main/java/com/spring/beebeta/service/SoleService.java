package com.spring.beebeta.service;

import com.spring.beebeta.entity.Sole;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.SoleRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoleService {
    @Autowired
    SoleRepository repository;
    public List<Sole> getAll(){
        return repository.findAll();
    }
}
