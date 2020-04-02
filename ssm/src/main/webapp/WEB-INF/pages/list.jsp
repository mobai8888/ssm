<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2020/4/1
  Time: 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示所有账户</title>
</head>
<body>
    <h3>展示所有账户</h3>
    <c:forEach items="${list}" var="account">
        ${account.name}--${account.money}
    </c:forEach>
</body>
</html>
