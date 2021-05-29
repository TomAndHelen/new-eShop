package com.myshop.web;

import com.myshop.pojo.*;
import com.myshop.service.GoodService;
import com.myshop.service.HistoryService;
import com.myshop.service.OPLogsService;
import com.myshop.service.impl.GoodServiceImpl;
import com.myshop.service.impl.HistoryServiceImpl;
import com.myshop.service.impl.OPLogsServiceImpl;
import com.myshop.utils.WebUtils;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GoodServlet extends BaseServlet{
    GoodService goodService = new GoodServiceImpl();
    OPLogsService logsService = new OPLogsServiceImpl();

    /**
     * 新增商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //根据form中的信息生成对应的Good对象
        Good good = WebUtils.copyParamToBean(req.getParameterMap(), new Good());
        //生成新增日志
        String ip = req.getRemoteAddr();
        Date optime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String temp = sdf.format(optime);
        logsService.addOPLogs(new OPLogs(1, ip, temp, "add", good.getName()));

        //保存该good对象
        goodService.addGood(good);

        //回显
        resp.sendRedirect(req.getContextPath()+"/goodServlet?action=page");
    }

    /**
     * 删除商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Good good = goodService.queryGoodById(id);
        //生成删除日志
        String ip = req.getRemoteAddr();
        Date optime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String temp = sdf.format(optime);
        logsService.addOPLogs(new OPLogs(1, ip, temp, "del", good.getName()));
        //通过id删除对应的商品
        goodService.deleteGoodById(id);
        resp.sendRedirect(req.getContextPath()+"/goodServlet?action=page");

    }

    /**
     * 商品修改请求处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void change(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //根据商品id查找到对应的Good对象
        Good good = goodService.queryGoodById(id);

        //将该该good对象放进request域中
        req.setAttribute("good",good);

        //回显
        req.getRequestDispatcher("/pages/manager/good_edit.jsp").forward(req,resp);
//        resp.sendRedirect(req.getContextPath()+"/pages/manager/good_edit.jsp");

    }

    /**
     * 更新商品信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void writeBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //根据form中的信息生成对应的Good对象
        Good good = WebUtils.copyParamToBean(req.getParameterMap(), new Good());

        //新增修改日志
        String ip = req.getRemoteAddr();
        Date optime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String temp = sdf.format(optime);
        logsService.addOPLogs(new OPLogs(1, ip, temp, "alter", good.getName()));

        System.out.println(good);
        //更新对应的good的信息
        goodService.updateGood(good);

        //回显
        resp.sendRedirect(req.getContextPath()+ "/goodServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    /**
     * 处理分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取pageNo，pageSize两个参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //根据以上两个参数得到对应的分页显示
        Page<Good> page = goodService.page(pageNo, pageSize);

        //设置分页选项中的url地址
        page.setUrl("goodServlet?action=page");

        //将page保存到request域中
        req.setAttribute("page", page);

        //回显
        req.getRequestDispatcher("/pages/manager/good_manager.jsp").forward(req,resp);
    }

    /**
     * 商品展示界面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") != null){
            HistoryService historyService = new HistoryServiceImpl();
            GoodService goodService = new GoodServiceImpl();
            User user = (User) req.getSession().getAttribute("user");
            int num1 = historyService.countByTypeAndId(0, user.getId());
            int num2 = historyService.countByTypeAndId(1, user.getId());

            if (num1 > num2){
                List<Good> pGood = goodService.queryForBestSalesByType(0);
                req.getSession().setAttribute("pGood", pGood);
//            System.out.println("推测用户更喜欢日用品，将按日用品购买量降序排列前5推荐");
            }
            if (num1 < num2){
                List<Good> pGood = goodService.queryForBestSalesByType(1);
                req.getSession().setAttribute("pGood", pGood);
//            System.out.println("推测用户喜欢电子产品，将按电子产品购买量降序排列前5推荐");
            }

            if(num1 == num2){
                List<Good> pGood = goodService.queryForBestSales();
                req.getSession().setAttribute("pGood", pGood);
//            System.out.println("因无法推测则按所有商品的购买量降序排列前5推荐");
            }
        }
        //除了url地址以及回显不同其余都与page函数相同
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Good> page = goodService.page(pageNo, pageSize);

        page.setUrl("goodServlet?action=show");

        req.setAttribute("page", page);
        System.out.println(page);

        req.getRequestDispatcher("/pages/user/showGoods.jsp").forward(req,resp);
    }


    /**
     * 显示商品详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void goodDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HistoryService historyService = new HistoryServiceImpl();
        //获取时间
        Date iotime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String temp = sdf.format(iotime);
        System.out.println(temp);

        //获取用户id
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();
        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Good good = goodService.queryGoodById(id);
        //保存浏览记录
        historyService.addHistory(new History(userId, id, good.getName(), good.getType(), temp));
        req.setAttribute("good",good);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        System.out.println(pageNo);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Good> page = goodService.page(pageNo, pageSize);
        req.getSession().setAttribute("page",page);

        req.getRequestDispatcher("pages/user/goodDetails.jsp").forward(req,resp);
    }

    /**
     * 从商品详情页返回商品浏览页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void back(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page page = (Page) req.getSession().getAttribute("page");

//        resp.sendRedirect(req.getHeader("Rerferer"));
        resp.sendRedirect(req.getContextPath()+ "/goodServlet?action=page2&pageNo="+page.getPageNo());
    }

    /**
     * 处理分页，保留翻页结果
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取pageNo，pageSize两个参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //根据以上两个参数得到对应的分页显示
        Page<Good> page = goodService.page(pageNo, pageSize);

        //设置分页选项中的url地址
        page.setUrl("goodServlet?action=page2");

        //将page保存到request域中
        req.setAttribute("page", page);

        //回显
        req.getRequestDispatcher("/pages/user/showGoods.jsp").forward(req,resp);
    }

    /**
     * 根据商品名称关键字查询商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void searchGoodsByKey(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String key = req.getParameter("Key");
        List<Good> goods = goodService.searchGoodsByKey(key);
        req.setAttribute("goods", goods);
        req.getRequestDispatcher("pages/user/searchedGoods.jsp").forward(req,resp);
    }
}
