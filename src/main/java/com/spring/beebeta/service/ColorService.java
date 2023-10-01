package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Color;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.ColorRepository;
import com.spring.beebeta.repository.ToeRepository;
import com.spring.beebeta.request.BrandRequest;
import com.spring.beebeta.request.ColorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ColorService {
    @Autowired
    ColorRepository repository;
    public List<Color> getAll(){
        return repository.getAll();
    }

    public List<Color> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    public Color add(ColorRequest request){
        Color color = new Color();
        color.setDescription(request.getDescription());
        color.setName(request.getName());
        color.setCreateDate(new Date());
        color.setStatus(0);
        return repository.save(color);
    }
    public Color update(Integer Id,ColorRequest request){
        Color color = repository.getById(Id);
        color.setDescription(request.getDescription());
        color.setName(request.getName());
        color.setUpdateDate(new Date());
        return repository.save(color);
    }
    public Color delete(Integer Id){
        Color color = repository.getById(Id);
        color.setStatus(1);
        return repository.save(color);
    }
    public Color getById(Integer Id){
        Color color = repository.getById(Id);
        return color;
    }
}
