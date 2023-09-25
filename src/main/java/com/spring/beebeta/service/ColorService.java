package com.spring.beebeta.service;

import com.spring.beebeta.entity.Color;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.ColorRepository;
import com.spring.beebeta.repository.ToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    ColorRepository repository;
    public List<Color> getAll(){
        return repository.findAll();
    }
}
