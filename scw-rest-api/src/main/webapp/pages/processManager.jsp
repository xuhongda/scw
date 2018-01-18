<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/12/16
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--引入ly--%>
<script src="${api}/js/jquery-3.2.1.js"></script>
    <form enctype="multipart/form-data" id="addForm">
        <p>上传文件： <input type="file" name="file" /></p>
        <input type="button" value="提交" id="submitBtn">
    </form>



    <script>
        var v=$("#addForm")[0];
        console.log("===========>>>>>"+v);
        var form = new FormData(v);
        console.log("============........."+form);
        $("#submitBtn").click(function () {
            $.ajax({
                type:"POST",
                url:"${api}/process/testDe",
                data:form,
                contentType:false,
                processData:false,

            }).done(
                function (data) {
                   alert(data.msg)
                }
            ).fail(
                function (data) {
                    alert(data.msg)
                }
            );
        });

    </script>
</body>
</html>
