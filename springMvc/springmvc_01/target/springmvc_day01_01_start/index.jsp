<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2020/3/29
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>springmvc入门案列</title>
</head>
<body>
    <a href="hello">入门案列</a>
    <a href="${pageContext.request.contextPath}/hello">入门案列</a>
    <a href="user/testRequestMapping?username=heihei">RequestMapping注解</a>
    <a href="${pageContext.request.contextPath}/user/testRequestMapping?username=heihei">RequestMapping注解</a>
</body>
</html>
