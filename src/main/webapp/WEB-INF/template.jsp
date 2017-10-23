<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>

<body>
<table border="1" cellpadding="2" cellspacing="2" align="center">

       <tiles:insertAttribute name="header" />
       <tiles:insertAttribute name="body" />
       <tiles:insertAttribute name="footer" />

</table>
</body>
</html>