<%--@elvariable id="fileUploadPath" type="cn.acdt.study.day23.action.HelloServlet"--%>
<%--@elvariable id="userName" type="cn.acdt.hwk.day23.action.HelloServlet"--%>
<%--
  Created by IntelliJ IDEA.
  User: meng
  Date: 2022/10/14
  Time: 下午12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Status</title>
</head>
<body>
    <span>上传者: ${userName}</span>
    <br>
    <span>文件保存路径：${fileUploadPath}</span>
</body>
</html>
