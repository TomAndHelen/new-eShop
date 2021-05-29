package com.myshop.dao.impl;

import com.myshop.dao.IOLogsDao;
import com.myshop.pojo.IOLogs;

import java.sql.SQLClientInfoException;
import java.util.List;

public class IOLogsDaoImpl extends BaseDao implements IOLogsDao{
    @Override
    public int addIOLogs(IOLogs logs) {
        String sql = "insert into t_iologs(`id`, `ip`, `iotime`, `behaviour`) values(?,?,?,?)";
        return update(sql, logs.getId(), logs.getIp(), logs.getIotime(), logs.getBehaviour());
    }

    @Override
    public List<IOLogs> queryIOLogsById(Integer id) {
        String sql = "select * from t_iologs where `id` = ?";
        return queryForList(IOLogs.class, sql, id);
    }

    @Override
    public List<IOLogs> queryIOLogs() {
        String sql = "select * from t_iologs";
        return queryForList(IOLogs.class, sql);
    }
}
