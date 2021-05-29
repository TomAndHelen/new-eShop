package com.myshop.test;

import com.myshop.pojo.IOLogs;
import com.myshop.service.IOLogsService;
import com.myshop.service.impl.IOLogsServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class IOLogsServiceTest {

    IOLogsService ioLogsService = new IOLogsServiceImpl();
    @Test
    public void addIOLogs() {
        ioLogsService.addIOLogs(new IOLogs(3, "127.0.0.2", "2021-05-17 09:25:14", "login"));
    }

    @Test
    public void queryIOLogsById() {
        for(IOLogs ioLog : ioLogsService.queryIOLogsById(4)){
            System.out.println(ioLog);
        }
    }

    @Test
    public void queryIOLogs() {
        for(IOLogs ioLog : ioLogsService.queryIOLogs()){
            System.out.println(ioLog);
        }
    }
}