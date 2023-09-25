package com.spring.beebeta.service;

import com.spring.beebeta.entity.Size;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.SizeRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    @Autowired
    SizeRepository repository;
    public List<Size> getAll(){
        return repository.findAll();
    }
}
