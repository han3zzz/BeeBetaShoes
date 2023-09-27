package com.spring.beebeta.service;

import com.spring.beebeta.entity.Shoelace;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.ShoelaceRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoelaceService {
    @Autowired
    ShoelaceRepository repository;
    public List<Shoelace> getAll(){
        return repository.getAll();
    }
}
