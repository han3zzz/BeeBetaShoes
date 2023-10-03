package com.spring.beebeta.service;

import com.spring.beebeta.entity.*;
import com.spring.beebeta.repository.ProductDetailRepository;
import com.spring.beebeta.request.ProductDetailRequest;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService {
    @Autowired
    ProductDetailRepository repository;
    public List<ProductDetail> getAll(){
        return repository.getAll();
    }
    public List<ProductDetail> getAllbyProductName(String name){
        return repository.getAllByProductName('%'+name+'%');
    }
    public List<ProductDetail> getAllbyFilter(Integer IdColor,Integer IdSize,Integer IdMaterial,Integer IdCategory, Integer IdBrand , Integer IdToe, Integer IdSole,Integer IdShoelace,Integer IdHeelcushion, Integer IdDesign,Double min , Double max,Double minTL , Double maxTL){
        return repository.getAllByFilter(IdColor,IdSize,IdMaterial,IdCategory,IdBrand,IdToe,IdSole,IdShoelace,IdHeelcushion,IdDesign,min,max,minTL,maxTL);
    }
    public Page<ProductDetail> phanTrang(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return repository.findAll(pageable);
    }
    public ProductDetail getById(Integer id){
       ProductDetail productDetail = repository.getById(id);
       return productDetail;
    }
    public ProductDetail add(ProductDetailRequest request){
        ProductDetail productDetail = new ProductDetail();
        productDetail.setWeight(request.getWeight());
        productDetail.setPrice(request.getPrice());
        productDetail.setDiscount(request.getDiscount());
        productDetail.setDescription(request.getDescription());
        productDetail.setProduct(Product.builder().Id(request.getIdProduct()).build());
        productDetail.setBrand(Brand.builder().Id(request.getIdBrand()).build());
        productDetail.setCategory(Category.builder().Id(request.getIdCategory()).build());
        productDetail.setToe(Toe.builder().Id(request.getIdToe()).build());
        productDetail.setDesign(Design.builder().Id(request.getIdDesign()).build());
        productDetail.setSole(Sole.builder().Id(request.getIdSole()).build());
        productDetail.setHeelcushion(Heelcushion.builder().Id(request.getIdHeelcushion()).build());
        productDetail.setShoelace(Shoelace.builder().Id(request.getIdShoelace()).build());
        productDetail.setCreateDate(new Date());
        productDetail.setStatus(0);
        return repository.save(productDetail);
    }
    public ProductDetail delete(Integer IdProductDetail){
        ProductDetail p = repository.getById(IdProductDetail);
        p.setStatus(1);
        return repository.save(p);
    }
    public ProductDetail update(Integer id,ProductDetailRequest request){
        ProductDetail productDetail = repository.getById(id);
        productDetail.setWeight(request.getWeight());
        productDetail.setPrice(request.getPrice());
        productDetail.setDiscount(request.getDiscount());
        productDetail.setDescription(request.getDescription());
        productDetail.setBrand(Brand.builder().Id(request.getIdBrand()).build());
        productDetail.setCategory(Category.builder().Id(request.getIdCategory()).build());
        productDetail.setToe(Toe.builder().Id(request.getIdToe()).build());
        productDetail.setDesign(Design.builder().Id(request.getIdDesign()).build());
        productDetail.setSole(Sole.builder().Id(request.getIdSole()).build());
        productDetail.setHeelcushion(Heelcushion.builder().Id(request.getIdHeelcushion()).build());
        productDetail.setShoelace(Shoelace.builder().Id(request.getIdShoelace()).build());
        productDetail.setUpdateDate(new Date());
        return repository.save(productDetail);
    }
    public ProductDetail getByCode(String code){
        return repository.getByCode(code);
    }

    public List<ProductDetail> getProductByCategory(Integer id){
        return repository.getProductByCategory(id);
    }

}
