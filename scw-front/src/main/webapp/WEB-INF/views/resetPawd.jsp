<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/12/11
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/12/11
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <%--静态包含，引入bootStrap--%>
    <%@ include file="/WEB-INF/include/commons-css.jsp" %>
    <link rel="stylesheet" href="${front}/static/css/login.css">
    <style>
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <form class="form-signin" role="form" id="findPswd">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 重置密码</h2>
        <%--反馈信息--%>
        <span style="color: rosybrown" id="msg_g">${msg}</span>

        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" id="email_input" placeholder="请输入密码" style="margin-top:10px;"
                   name="userpswd">
            <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
            <input type="password" class="form-control" id="email_input_re" placeholder="确认密码" style="margin-top:10px;"
                   name="userpswd">
        </div>
        <a class="btn btn-lg btn-success btn-block" href="#" id="regBtn"> 提交</a>
    </form>
</div>

<%--静态引入，jQuery等插件--%>
<%@include file="/WEB-INF/include/commons-js.jsp" %>

<%--引入ly--%>
<script src="${front}/static/layer/layer.js"></script>
<%--开启前端校验--%>
<%--自定义校验--%>
<script>
    $(function () {
        $.validator.setDefaults({
            /*回调函数*/
            showErrors: function (errors) {
                //如何能获取到哪些是校验成功，哪些校验失败；
                //封装了所有成功的dom对象
                var suc = this.successList;
                $.each(suc, function () {
                    //移除错误状态
                    $(this).parent(".form-group").removeClass("has-error");
                    $(this).parent(".form-group").find(".help-block").remove();
                });


                var list = this.errorList;
                /*Map里面封装了所有的错误信息**/
                $.each(list, function () {
                    var msg = this.message;
                    var ele = this.element;
                    //alert(msg+"===>"+ele)
                    //将父.form-group的div添加上校验状态（bootstrap里面有这个规则）
                    $(ele).parent(".form-group").addClass("has-error");
                    //先删除之前的校验错误
                    $(ele).parent(".form-group").find(".help-block").remove();
                    //给父.form-group的div后面添上错误消息提示（bootstrap里面有这个规则）
                    $(ele).parent(".form-group").append("<span class='help-block'>" + msg + "</span>");
                });
            }
        });

        // validate signup form on keyup and submit
        $("#findPswd").validate({
            /*规则*/
            rules: {

                userpswd: {
                    required: true,
                    minlength: 6,
                    maxlength: 12
                },
            },
            /*信息*/
            userpswd: {
                required: "请输入登陆密码",
                minlength: "你的密码最少需要6位",
                maxlength: "登陆密码最多12位"
            },
        });


        $("#regBtn").click(function () {
           if($("#email_input").val()==$("#email_input_re").val()){
               //移除密码不一致消息
               $("#msg_g").text("");
               var token="${param.token}" ;
               var pswd = $("#email_input").val();
               var data ={"token":token,"pswd":pswd};
               var url="${api}/password/resetPswd";
               //将邮件地址交给api层
               $.ajax({
                   url:url,
                   data:data,
                   success:function (data) {
                       layer.msg(data.msg);
                   },
                   error:function (data) {
                       layer.data(data.msg);
                   }
               });
           }else {
                    $("#msg_g").text("密码不一致，请重新输入");
           }

        })
    });
</script>
</body>
</html>

