<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品展示</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1  >商品展示</h1>


    <c:if test="${not empty sessionScope.user}">
        <br />
        欢迎<span style="color: red">${sessionScope.user.username}</span>
        <br />
        <a href="pages/cart/cart.jsp">查看购物车</a>
        <form action="goodServlet?action=searchGoodsByKey" method="post">
            <input type="hidden" name="">
            根据商品名称查询：
            <input type="text" name="Key">
            <input type="submit" value="查询">
        </form>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <a href="pages/user/register.jsp">注册</a> <br />
        <a href="pages/user/login.jsp">登录</a> <br />
    </c:if>

    <hr>
        <table   border="1px" >
            <tr>
                <th>商品名</th>
                <th>价格</th>
                <th>销量</th>
                <th>库存</th>
                <th>种类</th>
                <c:if test="${not empty sessionScope.user}">
                    <th>操作</th>
                </c:if>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="good">
            <tr>
                <c:if test="${empty sessionScope.user}">
                    <td>${good.name}</td>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <td><a href="goodServlet?action=goodDetails&id=${good.id}&pageNo=${requestScope.page.pageNo}">${good.name}</a></td>
                </c:if>
                <td>${good.price}</td>
                <td>${good.sales}</td>
                <td>${good.stock}</td>
                <c:if test="${good.type == 0}">
                    <td>日用品</td>
                </c:if>
                <c:if test="${good.type == 1}">
                    <td>电子产品</td>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <td><a href="cartServlet?action=addItem&id=${good.id}">加入购物车</a></td>
                </c:if>
            </tr>
            </c:forEach>
        </table>
        <%@include file="/pages/common/page_nav.jsp"%>
    <hr>
    <c:if test="${not empty sessionScope.user}">
        猜你喜欢：<br>
        <table   border="1px" >
            <tr>
                <th>商品名</th>
                <th>价格</th>
                <th>销量</th>
                <th>库存</th>
                <th>种类</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.pGood}" var="good">
                <tr>
                    <td><a href="goodServlet?action=goodDetails&id=${good.id}&pageNo=${requestScope.page.pageNo}">${good.name}</a></td>
                    <td>${good.price}</td>
                    <td>${good.sales}</td>
                    <td>${good.stock}</td>
                    <c:if test="${good.type == 0}">
                        <td>日用品</td>
                    </c:if>
                    <c:if test="${good.type == 1}">
                        <td>电子产品</td>
                    </c:if>
                    <td><a href="cartServlet?action=addItem&id=${good.id}">加入购物车</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

        <a href="index.jsp">返回首页</a>
</body>
</html>
