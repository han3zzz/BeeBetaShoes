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
    @Query(value = "Select e from ProductDetail e join ProductDetail_Material m on m.productDetail.Id = e.Id\n" +
            "join Material ma on ma.Id = m.material.Id join ProductDetail_Size_Color p on p.productDetail.Id = e.Id\n" +
            "join Color c on c.Id = p.color.Id\n" +
            "join Size s on s.Id = p.size.Id where (ma.Id = :idmaterial or :idmaterial is null) and (c.Id = :idcolor or :idcolor is null) and (s.Id = :idsize or :idsize is null) and (e.category.Id = :idcategory or :idcategory is null) and (e.brand.Id = :idbrand or :idbrand is null) and (e.toe.Id = :idtoe or :idtoe is null)" +
            " and (e.sole.Id = :idsole or :idsole is null) and (e.shoelace.Id = :idshoelace or :idshoelace is null) and (e.heelcushion.Id = :idheelcushion or :idheelcushion is null) and (e.design.Id = :iddesign or :iddesign is null) and e.Price >= :min and e.Price <= :max and e.Weight >= :minTL and e.Weight <= :maxTL and e.Status = 0 Order by e.CreateDate desc")
    public List<ProductDetail> getAllByFilter(@Param("idcolor") Integer IdColor , @Param("idsize") Integer IdSize,@Param("idmaterial") Integer IdMaterial,@Param("idcategory") Integer IdCategory , @Param("idbrand") Integer IdBrand ,@Param("idtoe") Integer IdToe,@Param("idsole") Integer IdSole,@Param("idshoelace") Integer IdShoelcae,@Param("idheelcushion") Integer IdHeelcushion,@Param("iddesign") Integer IdDesign,@Param("min") Double min ,@Param("max") Double max,@Param("minTL") Double minTL ,@Param("maxTL") Double maxTL);
    @Query("Select e from ProductDetail  e where e.product.Code = :code")
    public ProductDetail getByCode(@Param("code") String code);
    @Query(value = "select  e from ProductDetail e where e.Status = 0 and e.category.Id = :id")
    public List<ProductDetail> getProductByCategory(@Param("id") Integer id);
}
