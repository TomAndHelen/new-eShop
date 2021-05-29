package com.myshop.service.impl;

import com.myshop.dao.HistoryDao;
import com.myshop.dao.impl.HistoryDaoImpl;
import com.myshop.pojo.History;
import com.myshop.service.HistoryService;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    HistoryDao historyDao = new HistoryDaoImpl();

    @Override
    public void addHistory(History history) {
        historyDao.addHistory(history);
    }

    @Override
    public List<History> queryHistoryByUserId(Integer id) {
        return historyDao.queryHistoryByUserId(id);
    }

    @Override
    public Integer countByType(Integer type) {
        return historyDao.countByType(type);
    }

    @Override
    public Integer countByTypeAndId(Integer type, Integer id) {
        return historyDao.countByTypeAndId(type, id);
    }
}
