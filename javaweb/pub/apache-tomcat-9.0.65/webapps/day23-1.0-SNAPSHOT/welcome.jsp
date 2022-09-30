<%--@elvariable id="name" type="cn.acdt.hwk.day23.action.Login"--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>欢迎页面</title>
    <link rel="stylesheet" href="./css/style.css">
    <style>
        .checkbox {
            height: 15px;
            width: 100px;
        }

        .button {
            width: 200px;
        }

        h4, h1 {
            color: #0066CC;
        }

        label {
            color: #3366CC;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="login">
        <div class="circle-orange"></div>
        <h1 class="z-index99">欢迎 ${name}</h1>
        <h4 class="z-index99">请选择你的爱好</h4>
        <form class="z-index99" method="post" action="hobby">
            <label>
                <input class="checkbox" type="checkbox" name="hobby" value="篮球">
                篮球
            </label>
            <br>
            <label>
                <input class="checkbox" type="checkbox" name="hobby" value="足球">
                足球
            </label>
            <br>
            <label>
                <input class="checkbox" type="checkbox" name="hobby" value="计算机">
                计算机
            </label>
            <br>
            <label>
                <input class="checkbox" type="checkbox" name="hobby" value="健美操">
                健美操
            </label>
            <br>
            <input class="button" type="submit" value="提交">
        </form>
        <div class="circle-blue"></div>
    </div>
</div>
</body>
</html>
