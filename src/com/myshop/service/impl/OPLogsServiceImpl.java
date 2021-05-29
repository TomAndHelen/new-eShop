package com.myshop.service.impl;

import com.myshop.dao.OPLogsDao;
import com.myshop.dao.impl.OPLogsDaoImpl;
import com.myshop.pojo.OPLogs;
import com.myshop.service.OPLogsService;

import java.util.List;

public class OPLogsServiceImpl implements OPLogsService {
    OPLogsDao opLogsDao = new OPLogsDaoImpl();

    @Override
    public void addOPLogs(OPLogs opLogs) {
        opLogsDao.addOPLogs(opLogs);
    }

    @Override
    public List<OPLogs> queryOPLogs() {
        return opLogsDao.queryOPLogs();
    }
}
