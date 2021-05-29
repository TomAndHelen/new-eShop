package com.myshop.pojo;

import java.math.BigDecimal;

public class Good {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private Integer type;
    private String detail;

    public Good() {
    }

    public Good(Integer id, String name, BigDecimal price, Integer sales, Integer stock, Integer type, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.type = type;
        this.detail = detail;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", type=" + type +
                ", detail='" + detail + '\'' +
                '}';
    }
}
