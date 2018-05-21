<%--
  Created by IntelliJ IDEA.
  User: xielbs
  Date: 2018/5/17
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 这段代码的意思是获取当前项目的路径，如：http://localhost:8080/项目名称。 -->
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>jsp测试页面</title>
</head>
<body>

    <img src="static/img/testimg.jpg">
    <div id="echartsId" style="height:400px;"></div>
    <div id="echartsId1" style="height:400px;"></div>

    <script type="text/javascript" src="plugs/js/jquery.min.js"></script>
    <script type="text/javascript" src="plugs/js/echarts.js"></script>
    <script type="text/javascript" src="static/js/echarts/echartsTest.js"></script>

</body>
</html>
