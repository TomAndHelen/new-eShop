package com.myshop.dao.impl;

import com.myshop.dao.GoodDao;
import com.myshop.pojo.Good;

import java.sql.SQLClientInfoException;
import java.util.List;

public class GoodDaoImpl extends BaseDao implements GoodDao {
    @Override
    public int addGood(Good good) {
        String sql = "insert into t_good(`name`, `price`, `sales`, `stock`, `type`, `detail`) values(?,?,?,?,?,?)";
        return update(sql, good.getName(), good.getPrice(), good.getSales(), good.getStock(), good.getType(), good.getDetail());
    }

    @Override
    public int deleteGoodById(int id) {
        String sql = "delete from t_good where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateGood(Good good) {
        String sql = "update t_good set `name` = ?, `price` = ?, `sales` =?, `stock` =?, `type` =?, `detail` =? where `id` =?";
        return update(sql, good.getName(), good.getPrice(), good.getSales(), good.getStock(), good.getType(), good.getDetail(), good.getId());
    }

    @Override
    public Good queryGoodById(Integer id) {
        String sql  = "select * from t_good where `id` = ?";
        return queryForOne(Good.class, sql, id);
    }

    @Override
    public List<Good> queryGoods() {
        String sql = "select * from t_good";
        return queryForList(Good.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_good";

        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Good> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`, `name`, `price`, `sales`, `stock`, `type`, `detail` from t_good limit ?,?";
        return queryForList(Good.class, sql, begin, pageSize);
    }

    @Override
    public List<Good> searchGoodsByKey(String key) {
        if(key == null){
            key = "";
        }else {
            key = "%" + key + "%";
        }
        String sql = "select * from t_good where name like ?";
        return queryForList(Good.class, sql, key);
    }

    @Override
    public List<Good> queryForBestSalesByType(Integer type) {
        String sql = "select * from t_good where type = ? order by sales desc limit 0, 5";
        return queryForList(Good.class, sql, type);
    }

    @Override
    public List<Good> queryForBestSales() {
        String sql = "select * from t_good order by sales desc limit 0, 5";
        return queryForList(Good.class, sql);
    }
}
