package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {
    @Query(value = "Select e from ProductDetail e where e.Id = :id")
    public ProductDetail getById(@Param("id") Integer id);
    @Query(value = "Select e from ProductDetail e where e.Status = 0 Order by e.CreateDate desc")
    public List<ProductDetail> getAll();
    @Query(value = "Select e from ProductDetail e where e.Status = 0 and e.product.Name like :name Order by e.CreateDate desc")
    public List<ProductDetail> getAllByProductName(@Param("name") String name);
    @Query(value = "Select e from ProductDetail  e where e.category.Id = :idcategory and e.brand.Id = :idbrand and e.toe.Id = :idtoe" +
            " and e.sole.Id = :idsole and e.shoelace.Id = :idshoelace and e.heelcushion.Id = :idheelcushion and e.design.Id = :iddesign and e.Status = 0 Order by e.CreateDate desc")
    public List<ProductDetail> getAllByFilter(@Param("idcategory") Integer IdCategory , @Param("idbrand") Integer IdBrand ,@Param("idtoe") Integer IdToe,@Param("idsole") Integer IdSole,@Param("idshoelace") Integer IdShoelcae,@Param("idheelcushion") Integer IdHeelcushion,@Param("iddesign") Integer IdDesign);
}
