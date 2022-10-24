<%--@elvariable id="count" type="cn.acdt.hwk.day23.action.Login.count"--%>
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
            margin-top: 45px;
            margin-right: 10px;
        }

        label {
            width: 60%;
            color: #3366CC;
            font-size: 1.2rem;
            display: flex;
            align-items: baseline;
            flex-wrap: wrap;
            margin: 0 auto;
        }

        .button {
            width: 200px;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="login">
        <div class="circle-orange"></div>
        <h1 class="z-index99">欢迎 ${name}</h1>
        <h4 class="z-index99">请选择你喜欢的商品</h4>
        <form class="z-index99" method="post" action="${pageContext.request.contextPath}/hobby">
            <label>
                <input class="checkbox" type="checkbox" name="goods" value="电话">
                电话
                <br>
                <input class="checkbox" type="checkbox" name="goods" value="电视">
                电视
                <br>
                <input class="checkbox" type="checkbox" name="goods" value="微波炉">
                微波炉
                <br>
                <input class="checkbox" type="checkbox" name="goods" value="冰箱">
                冰箱
                <br>
                <input class="checkbox" type="checkbox" name="goods" value="洗衣机">
                洗衣机
            </label>
            <br>
            <input class="button" type="submit" value="加入购入车">
        </form>
        <span class="z-index99">当前页面访问量：${count}</span>
        <div class="circle-blue"></div>
    </div>
</div>
</body>
</html>
