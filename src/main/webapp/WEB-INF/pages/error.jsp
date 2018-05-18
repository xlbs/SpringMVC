<%--
  Created by IntelliJ IDEA.
  User: xielbs
  Date: 2018/3/12
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
    <h1>出错了</h1>
    <%
        Exception e = (Exception)request.getAttribute("exception");
        out.print(e.getMessage());
    %>

</body>
</html>
