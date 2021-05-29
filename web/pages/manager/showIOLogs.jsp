<%--
  Created by IntelliJ IDEA.
  User: 84016
  Date: 2021/5/17
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录注销日志</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1>登录注销日志</h1>
    <table   border="1px">
        <tr>
            <th>id</th>
            <th>时间</th>
            <th>ip地址</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.IOLogs}" var="log">
            <tr>
                <td>${log.id}</td>
                <td>${log.iotime}</td>
                <td>${log.ip}</td>
                <td>${log.behaviour}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="#">返回首页</a>
</body>
</html>
