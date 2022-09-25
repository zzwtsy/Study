<%--@elvariable id="name" type="cn.acdt.hwk.day23.Login"--%>
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
    <style>
        body {
            background-image: url(./img/bg.png);
        }

        div {
            position: absolute;
            width: 400px;
            height: 280px;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            border: none;
            margin: auto;
            padding: 15px;
            border-radius: 20px;
            background-image: linear-gradient(135deg, #6772FF 0, #00F9E5 100%)
        }

        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h1>Welcome ${name}</h1>
</div>
</body>
</html>
