<%--
  Created by IntelliJ IDEA.
  User: tomot
  Date: 2020/11/12
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h2>用户注册</h2>
    <form action="${pageContext.request.contextPath}/regist" method="post">
        用户名:<input type="text" name="id"><br>
        密码:<input type="password" name="pwd" ><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
