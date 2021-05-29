<%--
  Created by IntelliJ IDEA.
  User: 84016
  Date: 2021/5/18
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品浏览记录</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1>商品浏览记录</h1>
    <hr>
    <c:if test="${empty requestScope.histories}">
        您还没有浏览过商品详情 <br>
    </c:if>
    <c:if test="${not empty requestScope.histories}">
        <table border="1 solid">
            <tr>
                <th>用户id</th>
                <th>商品编号</th>
                <th>商品名</th>
                <th>商品种类</th>
                <th>浏览时间</th>
            </tr>
            <c:forEach items="${requestScope.histories}" var="history">
                <tr>
                    <th>${history.userId}</th>
                    <th>${history.goodId}</th>
                    <th>${history.name}</th>
                    <c:if test="${history.type == 0}">
                        <th>日用品</th>
                    </c:if>
                    <c:if test="${history.type == 1}">
                        <th>电子产品</th>
                    </c:if>
                    <th>${history.time}</th>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <table>

        <a href="index.jsp">返回首页</a>
    </table>
</body>
</html>
