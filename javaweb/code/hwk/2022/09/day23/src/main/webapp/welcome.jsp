<%--@elvariable id="name" type="cn.acdt.hwk.day23.action.Login"--%>
<%--
  Created by IntelliJ IDEA.
  User: 32262
  Date: 2022/9/23
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>欢迎页面</title>
    <link rel="stylesheet" href="./css/style.css">
    <style>
        h1 {
            z-index: 99;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="login">
        <div class="circle-orange"></div>
        <h1>Welcome ${name}</h1>
        <div class="circle-blue"></div>
    </div>
</div>
</body>
</html>
