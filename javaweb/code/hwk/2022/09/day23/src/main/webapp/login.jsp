<%--@elvariable id="message" type="cn.acdt.hwk.day23.action.Login"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="./css/login.css">
    <script>
        function check() {
            let name = document.getElementById("username").value;
            let pwd = document.getElementById("pwd").value;
            let tmp = "${message}";
            if ("false" === tmp) {
                alert("用户名或密码错误");
                return false;
            } else if (name === "" || name == null) {
                alert("用户名不能为空")
                return false;
            } else if (pwd === "" || pwd == null) {
                alert("密码不能为空")
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>
<body>
<form method="post" action="login">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <label>
                    <input class="userinput" id="username" type="text" name="username" placeholder="请输入用户名">
                </label>
            </td>
        </tr>
        <tr>
            <td>用户密码：</td>
            <td>
                <label>
                    <input class="userinput" id="pwd" type="password" name="password" placeholder="请输入用户密码">
                </label>
            </td>
        </tr>
    </table>
    <div>
        <a href="register.jsp">
            <input class="mr50 button" type="button" name="register" value="注册">
        </a>
        <input class="button" type="submit" name="login" value="登录" onclick="return check()">
    </div>
</form>
</body>
</html>