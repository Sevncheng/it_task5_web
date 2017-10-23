<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\20 0020
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>header页面</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta charset="utf-8" name="viewport" content="width=device-width" initial-scale=1  maximum-scale=1  minimum-scale=1  user-scalable=no>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/task8-home.css">
    <!-- <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script> -->
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="top">
    <p>客服电话:010-594-78634</p>
    <p2>

        <c:choose>
        <c:when test="${fstudent!=null}">
            欢迎你!${fstudent.name} ,您本次登录时间为<fmt:formatDate value="${time}" type="both"></fmt:formatDate>
            <a href="${pageContext.request.contextPath}/Desk/Student">列表展示</a>
            <a href="${pageContext.request.contextPath}/Home">退出登录</a>
        </c:when>
        <c:otherwise>
                <a href="${pageContext.request.contextPath}/Desk/addUI">注册</a>
            <a href="${pageContext.request.contextPath}/Desk/loginUI">登录</a>
        </c:otherwise>
        </c:choose>
    </p2>
    <div class="top-right">
        <div class="wexin"></div>
        <div class="qq"></div>
        <div class="sina"></div>
        <div></div>
    </div>
</div>
<div class="header-center">
    <div class="center-right">
        <a href="${pageContext.request.contextPath}/Desk/Home">首页</a>
        <a href="${pageContext.request.contextPath}/u/Two">职业</a>
        <a href="${pageContext.request.contextPath}/Desk/Three">推荐</a>
        <a href="#">关于</a>
    </div>
</div>
</body>
</html>
