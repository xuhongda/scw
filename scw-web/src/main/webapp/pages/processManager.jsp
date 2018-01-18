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
<%--引入--%>
<%@include file="/WEB-INF/include/commons-js.jsp" %>
<%--引入ly--%>
<script src="${mal}/static/layer/layer.js"></script>
    <form enctype="multipart/form-data" id="addForm">
        <p>指定文件名： <input type="text" name="filename" value="" /></p>
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
                url:"${mal}/deploy",
                data:form,
                contentType:false,
                processData:false,

            }).done(
                function () {
                    layer.msg("success")
                }
            ).fail(
                function () {
                    layer.msg("error")
                }
            ).always(
                function () {
                    layer.msg("永远守候")
                }
            );
        });

    </script>
</body>
</html>
