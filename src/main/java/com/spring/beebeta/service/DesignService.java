package com.spring.beebeta.service;

import com.spring.beebeta.entity.Design;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.DesignRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignService {
    @Autowired
    DesignRepository repository;
    public List<Design> getAll(){
        return repository.getAll();
    }
}
