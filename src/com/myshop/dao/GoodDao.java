package com.myshop.dao;

import com.myshop.pojo.Good;

import java.util.List;

public interface GoodDao {

    public int addGood(Good good);

    public int deleteGoodById(int id);

    public int updateGood(Good good);

    public Good queryGoodById(Integer id);

    public List<Good> queryGoods();

    public Integer queryForPageTotalCount();

    public List<Good> queryForPageItems(int begin, int pageSize);

    public List<Good> searchGoodsByKey(String key);

    public List<Good> queryForBestSalesByType(Integer type);

    public List<Good> queryForBestSales();
}
