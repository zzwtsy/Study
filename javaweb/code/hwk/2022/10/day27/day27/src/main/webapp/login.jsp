<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AutoLoginSvl" method="post">
    <table align="center">
        <tr>
            <td height=200></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="uname"></td>
        </tr>
        <tr>
            <td>密 码：</td>
            <td><input type="password" name="upwd"></td>
        </tr>
        <tr>
            <td>保存用户名：</td>
            <td>
                <input type="radio" name="choice" value="10">10秒
                <input type="radio" name="choice" value="3600">1小时
                <input type="radio" name="choice" value="86400">一天
                <input type="radio" name="choice" value="604800">1周
            </td>
        </tr>
        <td colspan="2" align="center">
            <input type="submit" value="登录">
        </td>
    </table>
</form>
</body>
</html>