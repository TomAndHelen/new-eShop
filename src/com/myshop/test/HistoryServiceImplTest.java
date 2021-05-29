package com.myshop.test;

import com.myshop.pojo.History;
import com.myshop.service.HistoryService;
import com.myshop.service.impl.HistoryServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HistoryServiceImplTest {

    HistoryService historyService = new HistoryServiceImpl();
    @Test
    public void addHistory() {
        historyService.addHistory(new History(1, 1, "商品1号", 0, "2021-05-18 11:00:33"));
    }

    @Test
    public void queryHistoryByUserId() {
        List<History> histories = historyService.queryHistoryByUserId(1);
        for(History history: histories){
            System.out.println(history);
        }
    }

    @Test
    public void countByType() {
        int num = historyService.countByType(0);
        System.out.println("日用品的浏览次数为："+ num);
    }

    @Test
    public void countByTypeAndId() {
        int num = historyService.countByTypeAndId(0, 1);
        System.out.println("编号为1的用户浏览日用品的次数为：" + num);

    }
}