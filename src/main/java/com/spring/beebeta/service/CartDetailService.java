package com.spring.beebeta.service;

import com.spring.beebeta.entity.Cart;
import com.spring.beebeta.entity.CartDetail;
import com.spring.beebeta.entity.ProductDetail;
import com.spring.beebeta.repository.CartDetailRepository;
import com.spring.beebeta.repository.CartRepository;
import com.spring.beebeta.request.CartDetailRequest;
import com.spring.beebeta.response.CartDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService {
    @Autowired
    CartDetailRepository repository;
    @Autowired
    CartRepository cartRepository;
    public List<CartDetail> getCartByCustomer(Integer Id){
        return repository.getCartByCustomer(Id);
    }
    public void deleteAllCart(Integer Id){
        List<CartDetail> cartDetails = repository.getCartByCustomer(Id);
        for (CartDetail cartDetail: cartDetails) {
            repository.delete(cartDetail);
        }
    }
    public CartDetail addToCart(CartDetailRequest request){
        CartDetail cartDetail = new CartDetail();
        cartDetail.setCart(Cart.builder().Id(request.getIdCart()).build());
        cartDetail.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        cartDetail.setIdColor(request.getIdColor());
        cartDetail.setIdSize(request.getIdSize());
        cartDetail.setQuantity(request.getQuantity());
        cartDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(cartDetail);
    }
    public void deleteToCart(Integer Id){
        CartDetail cartDetail = repository.getById(Id);
         repository.delete(cartDetail);
    }
    public CartDetail updateToCart(CartDetailRequest request , Integer id){
        CartDetail cartDetail = repository.getById(id);
        cartDetail.setCart(Cart.builder().Id(request.getIdCart()).build());
        cartDetail.setProductDetail(ProductDetail.builder().Id(request.getIdProductDetail()).build());
        cartDetail.setIdColor(request.getIdColor());
        cartDetail.setIdSize(request.getIdSize());
        cartDetail.setQuantity(request.getQuantity());
        cartDetail.setUnitPrice(request.getUnitPrice());
        return repository.save(cartDetail);
    }
    public Integer getQuantityByCartDetail(Integer id){
        return repository.getQuantityByCartDetail(id);
    }

    public Cart getByIdCart(Integer id){
        return cartRepository.getByIdCart(id);
    }


}
