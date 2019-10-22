<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8" %>
<html>
<head>
    <title>客户管理</title>
</head>
<body>
<h1>客户列表</h1>
<table>
    <tr>
        <th>客户名称</th>
        <th>电话号码</th>
        <th>操作</th>
    </tr>
    <c:forEach var = "customer" items = "${customerList}">
    <tr>
    <td>${customer.name}</td>
    <td>${customer.phoneTel}</td>
    <td>
    <a href="${BASH}/customer_edit?id={customer.id}">编辑</a>
    <a href="${BASH}/customer_delete?id={customer.id}">删除</a>
    </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>