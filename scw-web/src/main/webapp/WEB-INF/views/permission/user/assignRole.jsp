<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<%--引入--%>
	<%@include file="/WEB-INF/include/commons-css.jsp"%>
	<link rel="stylesheet" href="${mal}/static/css/main.css">
	<style>
		.tree li {
			list-style-type: none;
			cursor:pointer;
		}
	</style>
</head>

<body>

<%	/*基本信息*/
	pageContext.setAttribute("pageName","用户维护");
	pageContext.setAttribute("pageUrl", "/scw/web/user/list.html");
%>

<%--引入navbar--%>
<%@include file="/WEB-INF/include/manager-navbar.jsp"%>

<div class="container-fluid">
	<div class="row">
		<%--引入sideBar--%>
		<%@include file="/WEB-INF/include/manager-sideBar.jsp"%>

		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
				<li><a href="#">数据列表</a></li>
				<li class="active">分配角色</li>
			</ol>
			<div class="panel panel-default">
				<div class="panel-body">
					<form role="form" class="form-inline">
						<div class="form-group">
							<label for="exampleInputPassword1">未分配角色列表</label><br>
							<select class="form-control" multiple size="10" style="width:200px;overflow-y:auto;" id="noSeleced">
								<c:forEach var="allRoles" items="${allRoles}">
									<option value="${allRoles.name}" id="${allRoles.id}" class="sss">${allRoles.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<ul>
								<li class="btn btn-default glyphicon glyphicon-chevron-right" id ="add" ></li>
								<br>
								<li class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;" id="dec"></li>
							</ul>
						</div>
						<div class="form-group" style="margin-left:40px;">

							<label for="exampleInputPassword1">已分配角色列表</label><br>

							<select class="form-control" multiple size="10" style="width:200px;overflow-y:auto;" id="seleced">
								<c:forEach var="roles" items="${tRoles}">
									<option value="${roles.name}" id="${roles.id}">${roles.name}</option>
								</c:forEach>
							</select>

						</div>
					</form>
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
	/*添加*/
    $("#add").click(function () {
        var userId = "${userId}";
		console.log(userId);
		var s=$(".sss:selected");


    	var id=$("#noSeleced option:selected").attr("id");
		var d;
		var ids="";
		$.each(s,function () {
				 d=$(this).attr("id");
				 ids+=d+","
        });
		//alert(ids);
    	$.ajax({
			url:"${mal}/user/addRole",
			data:{"roleid":ids,"userid":userId},
			success:function (data) {
			    /*重新加载页面*/
			    window.location.reload();
				layer.msg(data.msg)
            },
			error:function (data) {
				layer.msg(data.msg)
            }
		})
    });

	/*删除*/
    $("#dec").click(function () {
        var userId = "${userId}";
        console.log(userId);
        var id=$("#seleced option:selected").attr("id");
        $.ajax({
            url:"${mal}/user/dec",
            data:{"roleid":id,"userid":userId},
            success:function (data) {
                window.location.reload();
                layer.msg(data.msg)
            },
            error:function (data) {
                layer.msg(data.msg)
            }
        })
    })
</script>
</body>
</html>

