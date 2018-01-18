<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/12/4
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
            <h1>springMVC包装类上传文件</h1>
            <form name="userForm2" action="${front}/upload" enctype="multipart/form-data" method="post">
                <div id="newUpload2">
                    <input type="file" name="file">
                </div>
                <input type="submit" value="上传">
            </form>
</body>
</html>
