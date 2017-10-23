<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\12 0012
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
</script>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center"> 欢迎登录!!!</h1>
    <hr/>
    <form action="${pageContext.request.contextPath}/Desk/desk" method="post">
        <table align="center" border="2" cellpadding="0" cellspacing="0">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="登录!"></td></tr>
        </table>
    </form>
    <hr/>
    <h2 align="center"><a href="${pageContext.request.contextPath}/Desk/Home">返回首页</a></h2>
</body>
</html>
