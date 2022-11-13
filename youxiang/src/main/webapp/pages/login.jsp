<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2022/11/1
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="../css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="http://localhost:8080/youxiang/login/admin" id="form" method="get">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${err}</div>

        <p>Name:<input id="name" name="name"  type="text"></p>
        <p>Password:<input id="password" name="password"  type="password"></p>
        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="aaa">
            <a href="user.jsp" id="switch">切换到用户登入界面</a>
        </div>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp" >没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
