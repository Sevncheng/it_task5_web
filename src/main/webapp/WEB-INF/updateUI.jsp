<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\13 0013
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">更新用户界面</h1>
<form action="${pageContext.request.contextPath}/Desk/Student/${id}" method="post">
    <table align="center" border="2" cellpadding="0" cellspacing="0">
        <tr>
            <td>当前用户为</td>
            <td>${studentup.name}</td>
        </tr>
        <tr>
            <td>在学状态</td>
            <td>
                学习中<input type="radio" name="states" value="学习中" ${studentup.states=='学习中'?'checked':'' } />
                已就业<input type="radio" name="states" value="已就业" ${studentup.states=='已就业'?'checked':'' } />
            </td>
        </tr>
        <tr>
            <td align="center">学习的类型</td>
            <td>
                <select name="studytype">
                    <option value="前端开发" ${studentup.studytype=='前端开发'?'selected':''}>前端开发</option>
                    <option value="后端开发" ${studentup.studytype=='后端开发'?'selected':''}>后端开发</option>
                    <option value="移动开发" ${studentup.studytype=='移动开发'?'selected':''}>移动开发</option>
                    <option value="整站开发" ${studentup.studytype=='整站开发'?'selected':''}>整站开发</option>
                    <option value="运营维护" ${studentup.studytype=='运营维护'?'selected':''}>运营维护</option>
                </select>
            </td>
        </tr>
        <tr><td colspan="2" align="center"><input type="submit" value="更新!"></td></tr>
        <input type="hidden" name="id" value="${studentup.id}">
        <input type="hidden" name="createtime" value="${studentup.createtime}">
        <input type="hidden" name="_method" value="put">
    </table>
</form>
</body>
</html>
