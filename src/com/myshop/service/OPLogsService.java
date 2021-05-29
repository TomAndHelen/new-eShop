package com.myshop.service;

import com.myshop.pojo.OPLogs;

import java.util.List;

public interface OPLogsService {
    public void addOPLogs(OPLogs opLogs);

    public List<OPLogs> queryOPLogs();
}
