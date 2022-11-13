<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2022/11/2
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--jstl--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登入</title>
    <link href="../css/user.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="http://localhost:8080/youxiang/login/user" id="form" method="get">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${err} ${register_msg}</div>

        <p>Name:<input id="name" name="name" value="${cookie.username.value}"  type="text"></p>
        <p>Password:<input id="password" name="password" value="${cookie.userpassword.value}" type="password"> </p>
        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="aaa">
        <a href="login.jsp" name="switch" >切换到管理员登入界面</a>
        </div>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
