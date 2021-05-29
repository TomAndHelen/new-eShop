package com.myshop.dao;

import com.myshop.pojo.History;

import java.util.List;

public interface HistoryDao {
    public int addHistory(History history);

    public List<History> queryHistoryByUserId(Integer userId);

    public Integer countByType(Integer type);

    public Integer countByTypeAndId(Integer type, Integer id);
}
