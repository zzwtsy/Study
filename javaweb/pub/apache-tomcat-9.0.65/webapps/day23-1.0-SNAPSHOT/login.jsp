<%--@elvariable id="message" type="cn.acdt.hwk.day23.action.Login"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="./css/style.css">
    <script>
        let tmp = "${message}";
        if ("*用户名或密码错误*".localeCompare(tmp)) {
            login = 'false';
        }

        function check() {
            let name = document.getElementById("username").value;
            let pwd = document.getElementById("userpwd").value;
            if (name === "" || name == null) {
                alert("用户名不能为空")
                return false;
            } else if (pwd === "" || pwd == null) {
                alert("密码不能为空")
                return false;
            } else return !login.localeCompare('false');
        }
    </script>
</head>
<body>
<div class="content">
    <form class="login" action="login" method="post">
        <div class="circle-orange"></div>
        <h2 class="z-index99">登录页面</h2>
        <span class="z-index99" style="color:red">${message}</span>
        <label class="z-index99">
            <input type="text" name="username" id="username" placeholder="用户名">
        </label>
        <label class="z-index99">
            <input type="password" name="userpwd" id="userpwd" placeholder="用户密码">
        </label>
        <div class="z-index99 button-box">
            <a href="register.jsp">
                <button class="button" type="button" value="注册">注册</button>
            </a>
            <button class="button" type="submit" value="登录" onclick="return check()">登录</button>
        </div>
        <div class="circle-blue"></div>
    </form>
</div>
</body>
</html>