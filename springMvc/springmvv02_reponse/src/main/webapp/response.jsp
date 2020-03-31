<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2020/3/31
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>response</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                alert("1566");
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehei","password":"123456","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">测试testString</a>
    <br/>
    <a href="user/testVoid" >testVoid</a>
    <br/>

    <a href="user/testModelAndView" >testModelAndView</a>

    <br/>
    <br/>

    <a href="user/testForwardOrRedirect" >testForwardOrRedirect</a>

    <br/>

    <button id="btn">发送ajax的请求</button>

</body>
</html>
