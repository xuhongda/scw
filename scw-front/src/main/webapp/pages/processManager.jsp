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
<script src="${front}/static/layer/layer.js"></script>
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
                url:"${front}/upload2",
                data:form,
                contentType:false,
                processData:false,

            }).done(
                function (data) {
                    console.log(data.msg)
                    layer.msg(data.msg,{  icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        },
                        function () {

                    })
                }
            ).fail(
                function () {
                    layer.msg("error")
                }
            );
        });

    </script>
</body>
</html>
