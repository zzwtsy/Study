<%--@elvariable id="registerStatus" type="cn.acdt.hwk.day23.action.RegisterSvl.registerStatus"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/login.css">
    <style>
        .login {
            width: 400px !important;
            height: 445px !important;
        }

        input {
            width: 250px;
            height: 50px;
            border-radius: 35px;
        }
    </style>
    <script type="text/javascript">
        function check() {
            let name = document.getElementById("rusername").value;
            let pwd1 = document.getElementById("rpassword1").value;
            let pwd2 = document.getElementById("rpassword2").value;
            if (name === "" || name == null) {
                alert("用户名不能为空")
                return false;
            } else if (pwd1 === "" || pwd1 == null) {
                alert("密码不能为空")
                return false;
            } else if (pwd2 === "" || pwd2 == null) {
                alert("密码不能为空")
                return false;
            } else if (pwd1 === pwd2) {
                return true;
            } else {
                alert("两次密码不一致")
                return false;
            }
        }
    </script>
</head>
<body>
<div class="content">
    <form class="login" action="${pageContext.request.contextPath}/RegisterSvl" method="post">
        <div class="circle-orange"></div>
        <h2 class="z-index99">注册页面</h2>
        <span class="z-index99">${registerStatus}</span>
        <br>
        <label class="z-index99">
            <input type="text" name="rusername" id="rusername" placeholder="请输入用户名">
        </label>
        <label class="z-index99">
            <input type="password" name="rpassword1" id="rpassword1" placeholder="请输入密码">
        </label>
        <label class="z-index99">
            <input type="password" name="rpassword2" id="rpassword2" placeholder="再次输入密码">
        </label>
        <div class="button-box">
            <a class="z-index99 add-shop-cart-btn" href="${pageContext.request.contextPath}/LoginSvl">
                <button class="z-index99 button" type="button" value="注册">登录</button>
            </a>
            <div class="z-index99 add-shop-cart-btn">
                <button class="z-index99 button" type="submit" value="登录" onclick="return check()">注册</button>
            </div>
        </div>
        <div class="circle-blue"></div>
    </form>
</div>
</body>
</html>
