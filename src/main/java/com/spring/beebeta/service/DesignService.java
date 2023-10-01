package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Design;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.DesignRepository;
import com.spring.beebeta.repository.ToeRepository;
import com.spring.beebeta.request.BrandRequest;
import com.spring.beebeta.request.DesignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DesignService {
    @Autowired
    DesignRepository repository;
    public List<Design> getAll(){
        return repository.getAll();
    }

    public List<Design> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    public Design add(DesignRequest request){
        Design design = new Design();
        design.setDescription(request.getDescription());
        design.setName(request.getName());
        design.setCreateDate(new Date());
        design.setStatus(0);
        return repository.save(design);
    }
    public Design update(Integer Id,DesignRequest request){
        Design design = repository.getById(Id);
        design.setDescription(request.getDescription());
        design.setName(request.getName());
        design.setUpdateDate(new Date());
        return repository.save(design);
    }
    public Design delete(Integer Id){
        Design design = repository.getById(Id);
        design.setStatus(1);
        return repository.save(design);
    }
    public Design getById(Integer Id){
        Design design = repository.getById(Id);
        return design;
    }
}
