package com.myshop.test;

import com.myshop.pojo.Good;
import com.myshop.service.GoodService;
import com.myshop.service.impl.GoodServiceImpl;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;

import static org.junit.Assert.*;

public class GoodServiceTest {

    GoodService goodService = new GoodServiceImpl();

    @Test
    public void addGood() {
        goodService.addGood(new Good(null, "新商品", new BigDecimal(11.5), 110, 220, 0, "商品简介"));
    }

    @Test
    public void deleteGoodById() {
        goodService.deleteGoodById(7);
    }

    @Test
    public void updateGood() {
        goodService.updateGood(new Good(9, "更新商品", new BigDecimal(25.5), 11, 22, 1,"更新后商品简介"));
    }

    @Test
    public void queryGoodById() {
        System.out.println(goodService.queryGoodById(9));
    }

    @Test
    public void queryGoods() {
        List<Good> goods = goodService.queryGoods();
        for (Good good : goods) {
            System.out.println(good);
        }
    }

    @Test
    public void searchGoodsByKey() {
        List<Good> goods = goodService.searchGoodsByKey("1");
        for(Good good: goods){
            System.out.println(good);
        }
    }

    @Test
    public void queryForBestSalesByType() {
        List<Good> goods = goodService.queryForBestSalesByType(1);
        for(Good good : goods){
            System.out.println(good);
        }
    }
    @Test
    public void queryForBestSales() {
        List<Good> goods = goodService.queryForBestSales();
        for(Good good : goods){
            System.out.println(good);
        }
    }
}

