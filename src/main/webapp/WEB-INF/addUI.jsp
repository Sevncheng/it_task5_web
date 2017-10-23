<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\13 0013
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">这里是注册页面,欢迎注册!</h1>
    <form action="${pageContext.request.contextPath}/Desk/Student" method="post">
        <table align="center" border="2" cellpadding="0" cellspacing="0" >
            <tr>
                <td align="center">用户名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td align="center">用户密码</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td align="center">请选择您要学习的类型</td>
                <td align="center">
                    <select name="studytype" >
                        <option value="前端开发">前端开发</option>
                        <option value="后端开发">后端开发</option>
                        <option value="移动开发">移动开发</option>
                        <option value="整站开发">整站开发</option>
                        <option value="运营维护">运营维护</option>
                    </select>
                </td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="注册!"></td></tr>
        </table>
    </form>
    <hr/>
    <h2 align="center"><a href="${pageContext.request.contextPath}/Desk/Home">返回首页</a></h2>
</body>
</html>
