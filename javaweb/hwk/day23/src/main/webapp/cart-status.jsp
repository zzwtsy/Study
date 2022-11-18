<%--@elvariable id="addGoodsTotal" type="cn.acdt.hwk.day23.action.CartStatusSvl"--%>
<%--@elvariable id="addGoodsNum" type="cn.acdt.hwk.day23.action.CartStatusSvl"--%>
<%--
  Created by IntelliJ IDEA.
  User: 孟繁兴
  Date: 2022/11/18
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/ShowCartSvl.css">
    <link rel="stylesheet" href="./css/welcome.css">
    <style>
        .button {
            width: 90%;
        }

        .add-shop-cart-btn {
            margin: 20px auto 0 auto;
        }

        a {
            color: #fff;
        }

        a:hover {
            color: #0066cc;
        }
    </style>
    <title>购物车状态</title>
</head>
<body>
<div class=\"login\">
    <form class=\"z-index99\">
        <h3>您添加了 ${addGoodsNum} 件商品</h3>
        <h3>当前购物车已添加 ${addGoodsTotal} 件商品</h3>
        <div class="add-shop-cart-btn">
            <a class="z-index99" href="${pageContext.request.contextPath}/WelcomeSvl">继续购物</a>
        </div>
        <div class="add-shop-cart-btn">
            <a class="z-index99" href="${pageContext.request.contextPath}/ShowCartSvl">查看购物车</a>
        </div>
        <div class="add-shop-cart-btn">
            <a class="z-index99" href="${pageContext.request.contextPath}/LogoutSvl">退出</a>
        </div>
    </form>
</div>
</body>
</html>
