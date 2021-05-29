package com.myshop.service.impl;

import com.myshop.dao.IOLogsDao;
import com.myshop.dao.impl.IOLogsDaoImpl;
import com.myshop.pojo.IOLogs;
import com.myshop.service.IOLogsService;

import java.util.List;

public class IOLogsServiceImpl implements IOLogsService{
    IOLogsDao ioLogsDao = new IOLogsDaoImpl();
    @Override
    public void addIOLogs(IOLogs ioLogs){
        ioLogsDao.addIOLogs(ioLogs);
    }

    @Override
    public List<IOLogs> queryIOLogsById(Integer id) {
        return ioLogsDao.queryIOLogsById(id);
    }

    @Override
    public List<IOLogs> queryIOLogs() {
        return ioLogsDao.queryIOLogs();
    }
}
