package com.myshop.test;

import com.myshop.pojo.OPLogs;
import com.myshop.service.OPLogsService;
import com.myshop.service.impl.OPLogsServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OPLogsServiceTest {

    OPLogsService opLogsService = new OPLogsServiceImpl();
    @Test
    public void addOPLogs() {
        opLogsService.addOPLogs(new OPLogs(1, "127.0.0.1", "2021-05-17 19:39:20", "add", "商品1号"));
    }

    @Test
    public void queryOPLogs() {
        List<OPLogs> opLogs = opLogsService.queryOPLogs();
        for(OPLogs opLog :opLogs){
            System.out.println(opLog);
        }
    }
}