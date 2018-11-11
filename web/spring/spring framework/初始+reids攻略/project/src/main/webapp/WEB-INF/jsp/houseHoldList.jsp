<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"
            +request.getServerName()+":" + request.getServerPort() + path+"/";
%>
<html>
    <head>
        <base href=" <%=basePath%>">
        <title>家庭物品分类</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>物品分类</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${list}" varStatus="status">
                    <tr>
                        <td>${item}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
