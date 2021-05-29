package com.myshop.test;

import com.myshop.dao.HistoryDao;
import com.myshop.dao.impl.HistoryDaoImpl;
import com.myshop.pojo.History;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HistoryDaoImplTest {
    HistoryDao historyDao = new HistoryDaoImpl();

    @Test
    public void addHistory() {
        if (historyDao.addHistory(new History(1, 1, "商品1号", 0, "2021-5-18 10:50:33")) != -1){
            System.out.println("新增历史记录成功");
        }else {
            System.out.println("新增失败");
        }
    }

    @Test
    public void queryHistoryByUserId() {
        List<History> histories = historyDao.queryHistoryByUserId(1);
        for (History history : histories){
            System.out.println(history);
        }
    }

    @Test
    public void countByType() {
        int num = historyDao.countByType(0);
        System.out.println("日用品浏览被次数为："+ num);
    }

    @Test
    public void countByTypeAndId() {
        int num = historyDao.countByTypeAndId(0, 1);
        System.out.println("id为1的用户浏览日用品次数为："+ num);
    }
}