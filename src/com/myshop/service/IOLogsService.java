package com.myshop.service;

import com.myshop.pojo.IOLogs;
import java.util.List;

public interface IOLogsService {
    public void addIOLogs(IOLogs ioLogs);

    public List<IOLogs> queryIOLogsById(Integer id);

    public List<IOLogs> queryIOLogs();
}
