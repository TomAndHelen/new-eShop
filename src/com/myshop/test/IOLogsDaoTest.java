package com.myshop.test;

import com.myshop.dao.IOLogsDao;
import com.myshop.dao.impl.IOLogsDaoImpl;
import com.myshop.pojo.IOLogs;
import org.junit.Test;

import javax.sound.midi.Soundbank;

import java.util.List;

import static org.junit.Assert.*;

public class IOLogsDaoTest {

    IOLogsDao ioLogsDao = new IOLogsDaoImpl();
    @Test
    public void addIOLogs() {
        int status = ioLogsDao.addIOLogs(new IOLogs(2, "127.0.0.1", "2021-05-17 10:23:14", "login"));
        if (status != -1){
            System.out.println("新增记录成功");
        }else {
            System.out.println("新增失败");
        }
    }

    @Test
    public void queryIOLogsById() {
        List<IOLogs> ioLogs = ioLogsDao.queryIOLogsById(1);
        if (ioLogs != null) {
            System.out.println("查找成功");
            for(IOLogs ioLog : ioLogs){
                System.out.println(ioLog);
            }
        }else {
            System.out.println("查找失败");
        }

    }

    @Test
    public void queryIOLogs() {
        List<IOLogs> ioLogs = ioLogsDao.queryIOLogs();
        if(ioLogs != null){
            System.out.println("查找成功");
            for(IOLogs ioLog : ioLogs){
                System.out.println(ioLog);
            }
        }else {
            System.out.println("查找失败");
        }
    }
}