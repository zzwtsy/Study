<%--@elvariable id="count" type="cn.acdt.hwk.day23.action.LoginSvl.count"--%>
<%--@elvariable id="name" type="cn.acdt.hwk.day23.action.LoginSvl"--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/welcome.css">
    <link rel="stylesheet" href="https://at.alicdn.com/t/c/font_3735743_gi1bux4iwbg.css">
    <link href="https://lf3-cdn-tos.bytecdntp.com/cdn/expire-1-M/bootstrap/4.6.1/css/bootstrap.css" type="text/css"
          rel="stylesheet"/>
    <link href="https://lf9-cdn-tos.bytecdntp.com/cdn/expire-1-M/font-awesome/6.0.0/css/all.min.css" type="text/css"
          rel="stylesheet"/>
    <script src="https://lf6-cdn-tos.bytecdntp.com/cdn/expire-1-M/font-awesome/6.0.0/js/all.js"
            type="application/javascript"></script>
    <script src="https://lf26-cdn-tos.bytecdntp.com/cdn/expire-1-M/jquery/3.6.0/jquery.js"
            type="application/javascript"></script>
    <script src="https://lf26-cdn-tos.bytecdntp.com/cdn/expire-1-M/bootstrap/4.6.1/js/bootstrap.js"
            type="application/javascript"></script>
    <title>Document</title>
</head>

<body>
<div class="login">
    <span class="z-index99">当前页面访问量：${count}</span>
    <form class="z-index99" method="post" action="${pageContext.request.contextPath}/CartStatusSvl">
        <div class="row">
            <div class="z-index99 login small-box goods-cart col">
                <label class="z-index99">
                    <i class="iconfont icon-31dianhua" aria-hidden="true"></i>
                    <br>
                    <input class="checkbox" type="checkbox" name="goods" value="电话">
                    电话
                </label>
            </div>
            <div class="z-index99 login small-box goods-cart col">
                <label class="z-index99">
                    <i class="iconfont icon-dianshi" aria-hidden="true"></i>
                    <br>
                    <input class="checkbox" type="checkbox" name="goods" value="电视">
                    电视
                </label>
            </div>
            <div class="z-index99 login small-box goods-cart col">
                <label class="z-index99">
                    <i class="iconfont icon-weibolu"></i>
                    <br>
                    <input class="checkbox" type="checkbox" name="goods" value="微波炉">
                    微波炉
                </label>
            </div>
            <div class="z-index99 login small-box goods-cart col">
                <label class="z-index99">
                    <i class="iconfont icon-bingxiang"></i>
                    <br>
                    <input class="checkbox" type="checkbox" name="goods" value="冰箱">
                    冰箱
                </label>
            </div>
            <div class="z-index99 login small-box goods-cart col">
                <label class="z-index99">
                    <i class="iconfont icon-xiyiji"></i>
                    <br>
                    <input class="checkbox" type="checkbox" name="goods" value="洗衣机">
                    洗衣机
                </label>
            </div>
        </div>
        <div class="add-shop-cart-btn">
            <input class="z-index99" type="submit" value="加入购入车">
        </div>
    </form>
</div>
</body>
</html>
