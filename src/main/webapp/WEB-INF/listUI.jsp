<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tags" prefix="date"%>
<html>
<body>
    <h2 align="center">亲!欢迎你${fstudent.name}登录,这是列表展示页面请勿随意删除他人账号哦</h2>
<table align="center" border="3" cellspacing="0" width="40%">
    <tr>
        <td>用户名称</td>
        <td>在学状态</td>
        <td>学习类型</td>
        <td>用户创建时间</td>
        <td align="center" >操作栏</td>
    </tr>
    <c:forEach items="${studentlist}" var="s" varStatus="st">
    <tr>
        <td>${s.name}</td>
        <td>${s.states}</td>
        <td>${s.studytype}</td>
        <td><date:date value ="${s.createtime}" /></td>
        <td align="center">
            <form action="${pageContext.request.contextPath}/Desk/Student/${s.id}" method="post" >
                <input type="submit" value="删除">
                <input type="hidden" name="_method" value="delete">
            </form>
            <form action="${pageContext.request.contextPath}/Desk/Student/${s.id}" method="get" >
                <input type="submit" value="更新">
            </form>
        </td>
        <input type="hidden" name="id" value="${s.id}">
    </tr>
    </c:forEach>
</table>
    <hr/>
    <h2 align="center"><a href="${pageContext.request.contextPath}/Desk/Home">返回首页</a></h2>
</body>
</html>
