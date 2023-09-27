package com.spring.beebeta.service;

import com.spring.beebeta.entity.Heelcushion;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.HeelcushionRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeelcushionService {
    @Autowired
    HeelcushionRepository repository;
    public List<Heelcushion> getAll(){
        return repository.getAll();
    }
}
