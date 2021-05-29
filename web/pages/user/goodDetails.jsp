
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1>商品详情</h1><br>
    <table border="1 solid">
        <tr>
            <th>商品名</th>
            <th>价格</th>
            <th>销量</th>
            <th>库存</th>
            <th>种类</th>
        </tr>
        <tr>
            <td>${requestScope.good.name}</td>
            <td>${requestScope.good.price}</td>
            <td>${requestScope.good.sales}</td>
            <td>${requestScope.good.stock}</td>
            <c:if test="${requestScope.good.type == 0}">
                <td>日用品</td>
            </c:if>
            <c:if test="${requestScope.good.type == 1}">
                <td>电子产品</td>
            </c:if>
        </tr>
    </table>
    <h2>详情</h2>
    <p>${requestScope.good.detail}</p>
    <a href="goodServlet?action=back">返回</a>
</body>
</html>
