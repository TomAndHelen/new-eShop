package com.myshop.web;

import com.myshop.pojo.IOLogs;
import com.myshop.pojo.OPLogs;
import com.myshop.pojo.User;
import com.myshop.service.IOLogsService;
import com.myshop.service.OPLogsService;
import com.myshop.service.impl.IOLogsServiceImpl;
import com.myshop.service.impl.OPLogsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LogsServlet extends BaseServlet{
    IOLogsService ioLogsService = new IOLogsServiceImpl();
    OPLogsService opLogsService = new OPLogsServiceImpl();


    /**
     * 根据ID显示用户的登录注销日志信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showIOLogsById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{

        User user = (User) req.getSession().getAttribute("user");
        List<IOLogs> ioLogs = ioLogsService.queryIOLogsById(user.getId());
        req.setAttribute("IOLogs", ioLogs);
        req.getRequestDispatcher("/pages/manager/showIOLogs.jsp").forward(req,resp);
    }

    /**
     * 显示所有的登录注销日志信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllIOLogs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<IOLogs> ioLogs = ioLogsService.queryIOLogs();
        req.setAttribute("IOLogs", ioLogs);
        req.getRequestDispatcher("/pages/manager/showIOLogs.jsp").forward(req,resp);
    }

    /**
     * 显示所有商品操作日志信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showALLOPLogs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<OPLogs> opLogs = opLogsService.queryOPLogs();
        req.setAttribute("OPLogs", opLogs);
        req.getRequestDispatcher("/pages/manager/showOPLogs.jsp").forward(req,resp);
    }
}
