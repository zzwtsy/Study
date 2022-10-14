<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./css/index.css">
    <title>JSP - Hello World</title>
</head>
<body>
<h1>请上传文件</h1>
<form method="post" action="${pageContext.request.contextPath}/hello-servlet" enctype="multipart/form-data">
    <label>
        <span>请输入你的姓名</span>
        <input type="text" id="rusername" name="userName">
        <br>
        <input type="file" id="uploadImg" name="uploadImg">
        <br>
        <input type="submit" value="上传">
    </label>
</form>
</body>
</html>