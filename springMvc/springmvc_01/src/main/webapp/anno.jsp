<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2020/3/31
  Time: 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <a href="anno/testRequestParam?name=哈哈">RequestParam</a>
    <br/>
    <form action="anno/testRequestBody" method="post">
        用户姓名:<input type="text" name="username"/><br/>
        用户年龄:<input type="text" name="age"/><br/>
        <input type="submit" value="提交">
    </form>
    <a href="anno/testPathVariable/10">testPathVariable</a>
    <a href="anno/testRequestHeader">RequestHeader</a>
    <a href="anno/testCookieValue">CookieValue</a>
    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <hr>>

    <a href="anno/testSessionAttributes">testSessionAttributes</a>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>
</body>
</html>
