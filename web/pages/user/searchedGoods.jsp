<%--
  Created by IntelliJ IDEA.
  User: 84016
  Date: 2021/5/18
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询商品结果</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1>查询商品结果</h1>
    <hr>
    <table   border="1px" >
        <tr>
            <th>商品名</th>
            <th>价格</th>
            <th>销量</th>
            <th>库存</th>
            <th>种类</th>
        </tr>
        <c:forEach items="${requestScope.goods}" var="good">
            <tr>
                <td><a href="goodServlet?action=goodDetails&id=${good.id}">${good.name}</a></td>
                <td>${good.price}</td>
                <td>${good.sales}</td>
                <td>${good.stock}</td>
                <c:if test="${good.type == 0}">
                    <td>日用品</td>
                </c:if>
                <c:if test="${good.type == 1}">
                    <td>电子产品</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
    <a href="#">返回首页</a>
</body>
</html>
