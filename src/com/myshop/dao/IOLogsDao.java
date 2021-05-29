package com.myshop.dao;

import com.myshop.pojo.IOLogs;

import java.util.List;

public interface IOLogsDao {
    public int addIOLogs(IOLogs logs);

    public List<IOLogs> queryIOLogsById(Integer id);

    public List<IOLogs> queryIOLogs();
}
