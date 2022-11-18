<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://unpkg.com/boltcss/bolt.min.css">
<title>Login Page</title>
<style type="text/css">
	form {
		text-align: center;
		position: absolute;
    	top: 50%;
    	left: 50%;
    	transform: translate(-50%,-50%);
	}
</style>
</head>
<body>
<form action="/JDBCDemo01/LoginSvl" method="post">
	<label for="username">用户名：</label>
  	<input type="text" id="username" name="username" placeholder="请输入用户名" /><br>
  	<label for="userpassword">密码：</label>
  	<input type="password" id="userpassword" name="userpassword" placeholder="请输入密码" /><br>
  	<label><input type="checkbox" id="choice" name="choice"value="0">不保存用户</label>
  	<input type="submit" value="登录">
</form>
</body>
</html>