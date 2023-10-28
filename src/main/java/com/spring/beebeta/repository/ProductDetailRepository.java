package com.spring.beebeta.repository;

import com.spring.beebeta.entity.Product;
import com.spring.beebeta.entity.ProductDetail;
import com.spring.beebeta.entity.Voucher;
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
    @Query(value = "Select e.Id,e.Price,e.Discount,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdProduct,e.IdBrand,e.IdToe,e.IdShoelace,e.IdCategory,e.IdHeelcushion,e.IdSole,e.IdDesign,e.Weight,e.DiscountDate from ProductDetail e \n" +
            "join Product p on p.Id = e.IdProduct\n" +
            "where e.Status = 0\n" +
            "and (CONTAINS(p.Name, :name) OR CONTAINS(p.Code, :name))" , nativeQuery = true)
    public List<ProductDetail> getAllByProductName(@Param("name") String name);
    @Query(value = "Select e.Id,e.Price,e.Discount,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdProduct,e.IdBrand,e.IdToe,e.IdShoelace,e.IdCategory,e.IdHeelcushion,e.IdSole,e.IdDesign,e.Weight,e.DiscountDate from ProductDetail e join ProductDetail_Material m on m.IdProductDetail = e.Id\n" +
            " join Material ma on ma.Id = m.IdMaterial\n" +
            " join ProductDetail_Color_Size p on p.IdProductDetail = e.Id\n" +
            " join Color c on c.Id = p.IdColor\n" +
            " join Product pro on pro.Id = e.IdProduct\n" +
            " join Size s on s.Id = p.IdSize \n" +
            " where (CONTAINS(pro.Name, :name) OR CONTAINS(pro.Code, :name) or :name = 'null') and (ma.Id = :idmaterial or :idmaterial is null) and (c.Id = :idcolor or :idcolor is null) and (s.Id = :idsize or :idsize is null) and (e.IdCategory = :idcategory or :idcategory is null) and (e.IdBrand = :idbrand or :idbrand is null) and (e.IdToe = :idtoe or :idtoe is null) " +
            " and (e.IdSole = :idsole or :idsole is null) and (e.IdShoelace = :idshoelace or :idshoelace is null) and (e.IdHeelcushion = :idheelcushion or :idheelcushion is null) and (e.IdDesign = :iddesign or :iddesign is null) and e.Price >= :min and e.Price <= :max and e.Weight >= :minTL and e.Weight <= :maxTL\n" +
            " group by e.Id,e.Price,e.Discount,e.Description,e.CreateDate,e.UpdateDate,e.CreateBy,e.UpdateBy,e.Status,e.IdProduct,e.IdBrand,e.IdToe,e.IdShoelace,e.IdCategory,e.IdHeelcushion,e.IdSole,e.IdDesign,e.Weight,e.DiscountDate\n" +
            " having (SUM(p.Quantity) < :soLuong and SUM(p.Quantity) > :soLuong1  OR :soLuong IS NULL) and e.Status = 0 order by e.createDate desc" +
            " ",nativeQuery = true)
    public List<ProductDetail> getAllByFilter(@Param("name") String name,@Param("idcolor") Integer IdColor , @Param("idsize") Integer IdSize,@Param("idmaterial") Integer IdMaterial,@Param("idcategory") Integer IdCategory , @Param("idbrand") Integer IdBrand ,@Param("idtoe") Integer IdToe,@Param("idsole") Integer IdSole,@Param("idshoelace") Integer IdShoelcae,@Param("idheelcushion") Integer IdHeelcushion,@Param("iddesign") Integer IdDesign,@Param("min") Double min ,@Param("max") Double max,@Param("minTL") Double minTL ,@Param("maxTL") Double maxTL,@Param("soLuong") Integer soLuong,@Param("soLuong1") Integer soLuong1);
    @Query("Select e from ProductDetail  e where e.product.Code = :code")
    public ProductDetail getByCode(@Param("code") String code);
    @Query(value = "select  e from ProductDetail e where e.Status = 0 and e.category.Id = :id")
    public List<ProductDetail> getProductByCategory(@Param("id") Integer id);
    @Query(value = "Select SUM(b.Quantity) from BillDetail b \n" +
            "join Bill  c on c.Id = b.bill.Id \n" +
            "where b.productDetail.Id = :id and c.Status = 3")
    public Integer quantitySold(@Param("id") Integer id);
    @Query(value = "Select SUM (b.Quantity * b.UnitPrice) from BillDetail b \n" +
            "join Bill  c on c.Id = b.bill.Id \n" +
            "where b.productDetail.Id = :id and c.Status = 3")
    public Double totalSale(@Param("id") Integer id);
    @Query(value = "Select e from Voucher e \n" +
            "where e.IsVoucher = true\n" +
            "and e.Status = 0")
    public List<Voucher> getVoucher();

    @Query(value = "Select e from Voucher  e " +
            "where e.Status = 0")
    public List<Voucher> getAllVoucher();

}
