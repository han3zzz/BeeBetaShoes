package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Heelcushion;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.HeelcushionRepository;
import com.spring.beebeta.repository.ToeRepository;
import com.spring.beebeta.request.BrandRequest;
import com.spring.beebeta.request.HeelcushionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HeelcushionService {
    @Autowired
    HeelcushionRepository repository;
    public List<Heelcushion> getAll(){
        return repository.getAll();
    }

    public List<Heelcushion> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    public Heelcushion add(HeelcushionRequest request){
        Heelcushion heelcushion = new Heelcushion();
        heelcushion.setDescription(request.getDescription());
        heelcushion.setName(request.getName());
        heelcushion.setCreateDate(new Date());
        heelcushion.setStatus(0);
        return repository.save(heelcushion);
    }
    public Heelcushion update(Integer Id,HeelcushionRequest request){
        Heelcushion heelcushion = repository.getById(Id);
        heelcushion.setDescription(request.getDescription());
        heelcushion.setName(request.getName());
        heelcushion.setUpdateDate(new Date());
        return repository.save(heelcushion);
    }
    public Heelcushion delete(Integer Id){
        Heelcushion heelcushion = repository.getById(Id);
        heelcushion.setStatus(1);
        return repository.save(heelcushion);
    }
    public Heelcushion getById(Integer Id){
        Heelcushion heelcushion = repository.getById(Id);
        return heelcushion;
    }
}
