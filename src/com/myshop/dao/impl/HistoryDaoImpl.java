package com.myshop.dao.impl;


import com.myshop.dao.HistoryDao;
import com.myshop.pojo.History;

import java.util.List;

public class HistoryDaoImpl extends BaseDao implements HistoryDao {
    @Override
    public int addHistory(History history) {
        String sql = "insert into t_history(`userid`, `goodid`, `name`, `type`, `time`) values(?,?,?,?,?)";
        return update(sql, history.getUserId(), history.getGoodId(), history.getName(), history.getType(), history.getTime());
    }

    @Override
    public List<History> queryHistoryByUserId(Integer userId) {
        String sql = "select * from t_history where `userid` = ?";
        return queryForList(History.class, sql, userId);
    }

    @Override
    public Integer countByType(Integer type) {
        String sql = "select count(*) from t_history where `type` = ?";
        Number count = (Number) queryForSingleValue(sql, type);
        return count.intValue();
    }

    @Override
    public Integer countByTypeAndId(Integer type, Integer id) {

        String sql = "select count(*) from t_history where `type` = ? and `userid` = ?";
        Number count = (Number) queryForSingleValue(sql, type, id);
        return count.intValue();
    }
}
