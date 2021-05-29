package com.myshop.dao;

import com.myshop.pojo.OPLogs;

import java.util.List;

public interface OPLogsDao {
    public int addOPLogs(OPLogs logs);

    public List<OPLogs> queryOPLogs();
}
