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
    <link rel="stylesheet" href="./css/login.css">
    <style>
        form {
            height: 370px;
        }
    </style>
    <script type="text/javascript">
        function check() {
            let name = document.getElementById("username").value;
            let pwd1 = document.getElementById("pwd1").value;
            let pwd2 = document.getElementById("pwd2").value;
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
<form method="post" action="register">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <label>
                    <input class="userinput" id="username" type="text" name="rusername" placeholder="请输入用户名">
                </label>
            </td>
        </tr>
        <tr>
            <td>用户密码：</td>
            <td>
                <label>
                    <input class="userinput" id="pwd1" type="password" name="rpassword1" placeholder="请输入用户密码">
                </label>
            </td>
        </tr>
        <tr>
            <td>再次输入密码：</td>
            <td>
                <label>
                    <input class="userinput" id="pwd2" type="password" name="rpassword2"
                           placeholder="请再次输入用户密码" onblur="check()">
                </label>
            </td>
        </tr>
    </table>
    <div>
        <a href="login.jsp">
            <input class="mr50 button" type="button" name="login" value="去登录">
        </a>
        <input class="button" type="submit" name="register" value="注册" onclick="return check()">
    </div>
</form>
</body>
</html>
