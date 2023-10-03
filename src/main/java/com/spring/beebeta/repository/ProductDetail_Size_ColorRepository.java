package com.spring.beebeta.repository;

import com.spring.beebeta.entity.ProductDetail_Material;
import com.spring.beebeta.entity.ProductDetail_Size_Color;
import com.spring.beebeta.entity.Toe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetail_Size_ColorRepository extends JpaRepository<ProductDetail_Size_Color,Integer> {
    @Query(value = "Select e from ProductDetail_Size_Color  e where  e.productDetail.Id =:id")
    List<ProductDetail_Size_Color> getAllById(@Param("id") Integer id);
    @Query(value = "Select p from ProductDetail_Size_Color p \n" +
            "where p.productDetail.Id= :idProduct and p.color.Id= :idColor")
    List<ProductDetail_Size_Color> getAllByIdProductAndIdColor(@Param("idProduct") Integer IdProduct, @Param(("idColor")) Integer IdColor);

    @Query(value = "Select SUM(p.Quantity) from ProductDetail_Size_Color p\n" +
            "where p.productDetail.Id = :id")
    Integer getQuantityByProduct(@Param("id") Integer id);
    @Query(value = "Select SUM(p.Quantity) from ProductDetail_Size_Color p\n" +
            "where p.productDetail.Id = :id and p.color.Id = :idcolor")
    Integer getQuantityByProductAndColor(@Param("id") Integer id,@Param("idcolor") Integer idcolor);
    @Query(value = "Select SUM(p.Quantity) from ProductDetail_Size_Color p\n" +
            "where p.productDetail.Id = :id and p.color.Id = :idcolor and p.size.Id = :idsize")
    Integer getQuantityByProductAndColorAndSize(@Param("id") Integer id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);
}
