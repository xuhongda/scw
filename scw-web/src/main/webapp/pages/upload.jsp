<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>upload</title>
    <script src="../static/jquery/jquery-3.2.1.js"></script>
</head>
<body>
    <form enctype="multipart/form-data" id="form">
        <%--非文件的普通信息仍可以上传--%>
        姓名：<input name="name" id="name">
        <input type="file" name="file" id="pic" accept="image/gif, image/jpeg" />
    </form>
    <button id="upload">上传</button>
    <script>
     $(function () {
         $("#upload").click(function () {
             //必须写在单机事件后面
             var form = new FormData($("#form")[0]);
             var name = $("#name").val();
             console.log(name);
             /*可以通过 append 方法添加信息*/
             form.append("name","xxx");
             $.ajax({
                 type:'post',
                 url:'http://localhost:8088/scw/api/process/upload',
                 data: form,
                 contentType:false,//禁用默认设置
                 processData:false,
             }).done(function (data) {
                 console.log("success"+data);
             }).fail(function (data) {
                 console.log("fail"+data);
             })
         });
     });


</script>
</body>
</html>