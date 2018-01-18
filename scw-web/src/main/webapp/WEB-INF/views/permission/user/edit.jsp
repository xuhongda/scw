<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<!DOCTYPE html>
<html lang="UTF-8">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	  <%	/*基本信息*/
		  pageContext.setAttribute("pageName","用户维护");
		  pageContext.setAttribute("pageUrl", "/scw/web/user/list.html");
	  %>

	<%@include file="/WEB-INF/include/commons-css.jsp"%>
	<link rel="stylesheet" href="${mal}/static/css/main.css">
	<link rel="stylesheet" href="${mal}/static/css/doc.min.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	</style>
  </head>

  <body>
  	<%@include file="/WEB-INF/include/manager-navbar.jsp"%>

    <div class="container-fluid">
      <div class="row">
       <%@include file="/WEB-INF/include/manager-sideBar.jsp"%>
			</div>
        </div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据列表</a></li>
			<li class="active">修改</li>
		</ol>
		<div class="panel panel-default">
			<div class="panel-heading">表单数据
				<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i
						class="glyphicon glyphicon-question-sign"></i></div>
			</div>
			<div class="panel-body">
				<form role="form" id="updateForm" method="post" action="${mal}/user/CRUD">
					<input type="hidden" name="id" value="${userId}">
					<input type="hidden" name="pn" value="${param.pn}">
					<input type="hidden" name="_method" value="put">
					<div class="form-group">
						<label for="exampleInputPassword1" >登陆账号</label>
						<input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入登陆账号" name="loginacct" value="${user.loginacct}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">用户名称</label>
						<input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入用户名称" name="username" value="${user.username}">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1" >邮箱地址</label>
						<input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入邮箱地址" name="email" value="${user.email}">
						<p class="help-block label label-warning">请输入合法的邮箱地址, 格式为： xxxx@xxxx.com</p>
					</div>
					<button type="button" class="btn btn-success" id="addBtn"><i
							class="glyphicon glyphicon-plus"></i> 修改
					</button>
					<button type="button" class="btn btn-danger" id="resetBtn"><i class="glyphicon glyphicon-refresh"></i> 重置
					</button>
				</form>
				&nbsp;&nbsp;<span style="color: red">${msg}</span>
			</div>
		</div>
	</div>
	</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<h4 class="modal-title" id="myModalLabel">帮助</h4>
		  </div>
		  <div class="modal-body">
			<div class="bs-callout bs-callout-info">
				<h4>测试标题1</h4>
				<p>测试内容1，测试内容1，测试内容1，测试内容1，测试内容1，测试内容1</p>
			  </div>
			<div class="bs-callout bs-callout-info">
				<h4>测试标题2</h4>
				<p>测试内容2，测试内容2，测试内容2，测试内容2，测试内容2，测试内容2</p>
			  </div>
		  </div>
		  <!--
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button>
		  </div>
		  -->
		</div>
	  </div>
	</div>
    <%@include file="/WEB-INF/include/commons-js.jsp"%>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
            });

            $(function () {
                /*提交*/
				$("#addBtn").click(function () {
					$("#updateForm").submit();
                })

				/*重置*/
				$("#resetBtn").click(function () {
                    $("#updateForm")[0].reset();
                })
            })




            $.validator.setDefaults({
                showErrors:function(errors){
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
                        $(ele).after("<p class='help-block label label-warning'>"
                            + msg + "</p>");
                    });
                }
            });
            $("#updateForm").validate({
                rules:{
                    loginacct:{
                        required: true,
                        minlength: 3,
                        maxlength: 12
                    },
                    username:{
                        required: true,
                        minlength: 3,
                        maxlength: 12
                    },
                    email:{
                        required: true,
                        email: true
                    }
                },
                messages:{
                    loginacct : {
                        required : "用户账号必须填写而且唯一",
                        minlength : "用户账户必须2位以上",
                        maxlength : "用户账户必须12位以下"
                    },
                    username : {
                        required : "用户名必须填写",
                        minlength : "用户账户必须2位以上",
                        maxlength : "用户名必须在12位以下"
                    },
                    email : {
                        required : "邮箱必须填写",
                        email : "邮箱必须合法的格式"
                    }
                }
            })
        </script>
  </body>
</html>
