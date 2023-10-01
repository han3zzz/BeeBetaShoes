package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Size;
import com.spring.beebeta.entity.Toe;
import com.spring.beebeta.repository.SizeRepository;
import com.spring.beebeta.repository.ToeRepository;
import com.spring.beebeta.request.BrandRequest;
import com.spring.beebeta.request.SizeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SizeService {
    @Autowired
    SizeRepository repository;
    public List<Size> getAll(){
        return repository.getAll();
    }

    public List<Size> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    public Size add(SizeRequest request){
        Size size = new Size();
        size.setDescription(request.getDescription());
        size.setName(request.getName());
        size.setCreateDate(new Date());
        size.setStatus(0);
        return repository.save(size);
    }
    public Size update(Integer Id,SizeRequest request){
        Size size = repository.getById(Id);
        size.setDescription(request.getDescription());
        size.setName(request.getName());
        size.setUpdateDate(new Date());
        return repository.save(size);
    }
    public Size delete(Integer Id){
        Size size = repository.getById(Id);
        size.setStatus(1);
        return repository.save(size);
    }
    public Size getById(Integer Id){
        Size size = repository.getById(Id);
        return size;
    }
}
