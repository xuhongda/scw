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
      <link rel="stylesheet" href="${mal}/static/css/login.css">
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
      <form class="form-signin" role="form" id="regForm" method="post" action="${mal}/Register">
          <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
          <%--反馈信息--%>
          <span style="color: rosybrown">${msg}</span>
          <div class="form-group has-success has-feedback">
              <input type="text" class="form-control" id="loginacct_input" placeholder="请输入登录账号" required autofocus
                     name="loginacct">
              <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          <div class="form-group has-success has-feedback">
              <input type="text" class="form-control" id="userpswd_input" placeholder="请输入登录密码"
                     name="userpswd" style="margin-top:10px;">
              <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="form-group has-success has-feedback">
              <input type="text" class="form-control" id="email_input" placeholder="请输入邮箱地址" style="margin-top:10px;"
                     name="email">
              <span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-success has-feedback">
              <select class="form-control">
                  <option>会员</option>
                  <option>管理</option>
              </select>
          </div>
          <div class="checkbox">
              <label>
                  忘记密码
              </label>
              <label style="float:right">
                  <a href="${mal}/login.html">我有账号</a>
              </label>
          </div>
          <a class="btn btn-lg btn-success btn-block" href="#" id="regBtn"> 注册</a>
      </form>
  </div>

  <%--静态引入，jQuery等插件--%>
  <%@include file="/WEB-INF/include/commons-js.jsp" %>
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
          $("#regForm").validate({
              /*规则*/
              rules: {
                  loginacct: {
                      required: true,
                      minlength: 3,
                      maxlength: 12
                  },
                  userpswd: {
                      required: true,
                      minlength: 6,
                      maxlength: 12
                  },
                  email: {
                      required: true,
                      email: true
                  },
              },
              /*信息*/
              messages: {
                  loginacct: {
                      required: "请输入登陆账号",
                      minlength: "登陆账号至少3位",
                      maxlength: "登陆账号最多12位"
                  },
                  userpswd: {
                      required: "请输入登陆密码",
                      minlength: "你的密码最少需要6位",
                      maxlength: "登陆密码最多12位"
                  },
                  email: "请输入有效的邮箱地址",
              }
          });
          $("#regBtn").click(function () {
              $("#regForm").submit();
          })
      });
  </script>
  </body>
</html>