package com.myshop.pojo;

import java.math.BigDecimal;

/**
 * 购物车商品项
 */
public class CartItem {
    private Integer id;
    private String name;
    private Integer type;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;

    public CartItem() {
    }

    public CartItem(Integer id, String name,Integer type, BigDecimal price, Integer count, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

