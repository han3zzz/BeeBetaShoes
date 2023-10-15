package com.spring.beebeta.service;

import com.spring.beebeta.entity.*;
import com.spring.beebeta.repository.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class ProductDetailExelService {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductImageRepository productImageRepository;
    @Autowired
    ProductDetail_MaterialRepository productDetail_materialRepository;
    @Autowired
    ProductDetail_Size_ColorRepository productDetail_size_colorRepository;

    public void importExel(MultipartFile file) throws IOException {
        try(InputStream inputStream =  file.getInputStream()){
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // get sheet đầu tiên
            for (Row row: sheet) {
                //Đọc dữ liệu từng hàng cho vào csdl
               if (row.getRowNum() > 0){
                   String code = row.getCell(0).getStringCellValue();
                   String name = row.getCell(1).getStringCellValue();
                   String url = row.getCell(2).getStringCellValue();
                   Double price = row.getCell(3).getNumericCellValue();
                   Double weight = row.getCell(4).getNumericCellValue();
                   String description = row.getCell(5).getStringCellValue();
                   Double discount = row.getCell(6).getNumericCellValue();
                   Integer dis = discount.intValue();
                   Double category = row.getCell(7).getNumericCellValue();
                   Integer idcate = category.intValue();
                   Double brand = row.getCell(8).getNumericCellValue();
                   Integer idbrand = brand.intValue();
                   Double toe = row.getCell(9).getNumericCellValue();
                   Integer idtoe = toe.intValue();
                   Double sole = row.getCell(10).getNumericCellValue();
                   Integer idsole = sole.intValue();
                   Double shoelace = row.getCell(11).getNumericCellValue();
                   Integer idshoelace = shoelace.intValue();
                   Double heelcushion = row.getCell(12).getNumericCellValue();
                   Integer idheel = heelcushion.intValue();
                   Double design = row.getCell(13).getNumericCellValue();
                   Integer iddesign = design.intValue();
                   String materials = row.getCell(14).getStringCellValue();
                   String [] mate = materials.split(",");
                   String color_size_quanity = row.getCell(15).getStringCellValue();
                   String [] color_size = color_size_quanity.split(",");
                   if (productDetailRepository.getByCode(code) == null){
                       Product product = new Product();
                       product.setCode(code);
                       product.setName(name);
                       product.setStatus(0);
                       product.setDescription(description);
                       product.setCreateDate(new Date());
                       productRepository.save(product);
                       ProductImage productImage = new ProductImage();
                       productImage.setStatus(0);
                       productImage.setMainImage(true);
                       productImage.setUrl(url);
                       productImage.setProduct(Product.builder().Id(product.getId()).build());
                       productImageRepository.save(productImage);
                       ProductDetail productDetail = new ProductDetail();
                       productDetail.setWeight(weight);
                       productDetail.setPrice(BigDecimal.valueOf(price));
                       productDetail.setDescription(description);
                       productDetail.setDiscount(dis);
                       productDetail.setCategory(Category.builder().Id(idcate).build());
                       productDetail.setBrand(Brand.builder().Id(idbrand).build());
                       productDetail.setToe(Toe.builder().Id(idtoe).build());
                       productDetail.setSole(Sole.builder().Id(idsole).build());
                       productDetail.setShoelace(Shoelace.builder().Id(idshoelace).build());
                       productDetail.setHeelcushion(Heelcushion.builder().Id(idheel).build());
                       productDetail.setProduct(Product.builder().Id(product.getId()).build());
                       productDetail.setDesign(Design.builder().Id(iddesign).build());
                       productDetail.setStatus(0);
                       productDetail.setCreateDate(new Date());
                       productDetailRepository.save(productDetail);
                       for (String material:mate) {
                           ProductDetail_Material productDetail_material = new ProductDetail_Material();
                           productDetail_material.setProductDetail(ProductDetail.builder().Id(productDetail.getId()).build());
                           productDetail_material.setMaterial(Material.builder().Id(Integer.parseInt(material)).build());
                           productDetail_materialRepository.save(productDetail_material);
                       }
                       for (String color_size_quantity :color_size) {
                           String [] mang = color_size_quantity.split("-");
                          ProductDetail_Size_Color productDetail_size_color = new ProductDetail_Size_Color();
                          productDetail_size_color.setProductDetail(ProductDetail.builder().Id(productDetail.getId()).build());
                          productDetail_size_color.setSize(Size.builder().Id(Integer.parseInt(mang[1])).build());
                          productDetail_size_color.setColor(Color.builder().Id(Integer.parseInt(mang[0])).build());
                          productDetail_size_color.setQuantity(Integer.parseInt(mang[2]));
                          productDetail_size_colorRepository.save(productDetail_size_color);
                       }
                   }

               }
                
            }
            workbook.close();
            inputStream.close();


        }


    }
}
