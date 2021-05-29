package com.myshop.service;

import com.myshop.pojo.History;

import java.util.List;

public interface HistoryService {
    public void addHistory(History history);

    public List<History> queryHistoryByUserId(Integer id);

    public Integer countByType(Integer type);

    public Integer countByTypeAndId(Integer type, Integer id);

}
