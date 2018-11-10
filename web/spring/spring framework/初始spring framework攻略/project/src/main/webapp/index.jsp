<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"
            +request.getServerName()+":" + request.getServerPort() + path+"/";
%>
<html>
    <head>
        <base href=" <%=basePath%>">
        <title>欢迎</title>
    </head>
    <body>
        <h1>欢迎</h1>
        <a href="houseHoldGoods.do">物品分类</a>
    </body>
</html>
