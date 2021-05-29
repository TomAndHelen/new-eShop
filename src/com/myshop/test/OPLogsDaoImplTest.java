package com.myshop.test;

import com.myshop.dao.OPLogsDao;
import com.myshop.dao.impl.OPLogsDaoImpl;
import com.myshop.pojo.OPLogs;
import org.junit.Test;

import java.util.List;

public class OPLogsDaoImplTest {

    OPLogsDao opLogsDao = new OPLogsDaoImpl();
    @Test
    public void addOPLogs() {
        opLogsDao.addOPLogs(new OPLogs(1, "127.0.0.1", "2021-05-17 16:46:08", "add", "商品1"));
    }

    @Test
    public void queryOPLogs() {
        List<OPLogs> opLogs = opLogsDao.queryOPLogs();
        for (OPLogs opLog :opLogs){
            System.out.println(opLog);
        }
    }
}