package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Shoelace;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.ShoelaceRepository;
import com.spring.beebeta.repository.ToeRepository;
import com.spring.beebeta.request.BrandRequest;
import com.spring.beebeta.request.ShoelaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShoelaceService {
    @Autowired
    ShoelaceRepository repository;
    public List<Shoelace> getAll(){
        return repository.getAll();
    }

    public List<Shoelace> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    public Shoelace add(ShoelaceRequest request){
        Shoelace shoelace = new Shoelace();
        shoelace.setDescription(request.getDescription());
        shoelace.setName(request.getName());
        shoelace.setCreateDate(new Date());
        shoelace.setStatus(0);
        return repository.save(shoelace);
    }
    public Shoelace update(Integer Id,ShoelaceRequest request){
        Shoelace shoelace = repository.getById(Id);
        shoelace.setDescription(request.getDescription());
        shoelace.setName(request.getName());
        shoelace.setUpdateDate(new Date());
        return repository.save(shoelace);
    }
    public Shoelace delete(Integer Id){
        Shoelace shoelace = repository.getById(Id);
        shoelace.setStatus(1);
        return repository.save(shoelace);
    }
    public Shoelace getById(Integer Id){
        Shoelace shoelace = repository.getById(Id);
        return shoelace;
    }
}
