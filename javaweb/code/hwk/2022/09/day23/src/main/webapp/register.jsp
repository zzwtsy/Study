<%--
  Created by IntelliJ IDEA.
  User: 32262
  Date: 2022/9/23
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="./css/style.css">
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
    <form class="login" action="register" method="post">
        <div class="circle-orange"></div>
        <h2 class="z-index99">注册页面</h2>
        <label class="z-index99">
            <input type="text" name="rusername" id="rusername" placeholder="请输入用户名">
        </label>
        <label class="z-index99">
            <input type="password" name="rpassword1" id="rpassword1" placeholder="请输入密码">
        </label>
        <label class="z-index99">
            <input type="password" name="rpassword2" id="rpassword2" placeholder="再次输入密码">
        </label>
        <div class="z-index99 button-box">
            <a href="login.jsp">
                <button class="button" type="button" value="登录">登录</button>
            </a>
            <button class="button" type="submit" value="注册" onclick="return check()">注册</button>
        </div>
        <div class="circle-blue"></div>
    </form>
</div>
</body>
</html>
