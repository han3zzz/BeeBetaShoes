package com.spring.beebeta.service;

import com.spring.beebeta.entity.Brand;
import com.spring.beebeta.entity.Category;
import com.spring.beebeta.repository.BrandRepository;
import com.spring.beebeta.repository.CategoryRepository;
import com.spring.beebeta.request.BrandRequest;
import com.spring.beebeta.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepository repository;
    public List<Brand> getAll(){
        return repository.getAll();
    }

    public List<Brand> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }
    public Brand add(BrandRequest request){
        Brand brand = new Brand();
        brand.setDescription(request.getDescription());
        brand.setName(request.getName());
        brand.setCreateDate(new Date());
        brand.setStatus(0);
        return repository.save(brand);
    }
    public Brand update(Integer Id,BrandRequest request){
        Brand brand = repository.getById(Id);
        brand.setDescription(request.getDescription());
        brand.setName(request.getName());
        brand.setUpdateDate(new Date());
        return repository.save(brand);
    }
    public Brand delete(Integer Id){
        Brand brand = repository.getById(Id);
        brand.setStatus(1);
        return repository.save(brand);
    }
    public Brand getById(Integer Id){
        Brand brand = repository.getById(Id);
        return brand;
    }
}
