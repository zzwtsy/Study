<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://unpkg.com/boltcss/bolt.min.css">
<title>Welcome</title>
<style type="text/css">
	div {
		text-align: center;
		position: absolute;
    	top: 50%;
    	left: 50%;
    	transform: translate(-50%,-50%);
	}
</style>
</head>
<body>
	<div>
		<span>欢迎 ${ username }</span>
		<br>
		<span>用户身份：${ ident }</span>
	</div>
</body>
</html>