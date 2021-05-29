package com.myshop.dao.impl;

import com.myshop.dao.OPLogsDao;
import com.myshop.pojo.OPLogs;

import java.util.List;

public class OPLogsDaoImpl extends BaseDao implements OPLogsDao {
    @Override
    public int addOPLogs(OPLogs logs) {
        String sql = "insert into t_oplogs(`id`, `ip`, `optime`, `behaviour`, `obj` )values(?,?,?,?,?)";
        return update(sql, logs.getId(), logs.getIp(), logs.getOptime(), logs.getBehaviour(), logs.getObj());
    }

    @Override
    public List<OPLogs> queryOPLogs() {
        String sql = "select * from t_oplogs";
        return queryForList(OPLogs.class, sql);
    }
}
