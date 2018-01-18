<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
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
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>

  <body>
		<%	/*基本信息*/
			pageContext.setAttribute("pageName","用户维护");
			pageContext.setAttribute("pageUrl", "/scw/web/user/list.html");
		%>

        <%--引入navbar--%>
        <%@include file="/WEB-INF/include/manager-navbar.jsp" %>
        <%--引入ly--%>
        <script src="${mal}/static/layer/layer.js"></script>
    <div class="container-fluid">
      <div class="row">
		  <%--引入sideBar--%>
       <%@include file="/WEB-INF/include/manager-sideBar.jsp"%>
	  </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input class="form-control has-success" type="text" placeholder="请输入用户名称" id="searchValue">
    </div>
  </div>
  <button type="button" class="btn btn-warning" id="searchBtn"><i class="glyphicon glyphicon-search"></i> 查询</button>&nbsp;&nbsp;<span style="color: red">${msg}</span>
</form>
<button type="button" class="btn btn-danger" style="float:right;margin-left:10px;" id="deleteAllbtn"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='add.html'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox" class="checkAllBox"></th>
                  <th>账号</th>
                  <th>名称</th>
                  <th>邮箱地址</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${pageInfo.list}" var="user">
                  <tr userId ="${user.id}" class="redBiaozhi" id ="redLine" name="ses">
                      <td>${user.id}</td>
                      <td><input type="checkbox" class="checkBox" userId=${user.id}></td>
                      <td>${user.loginacct}</td>
                      <td>${user.username}</td>
                      <td>${user.email}</td>
                      <td>
                          <button type="button" class="btn btn-success btn-xs" userId=${user.id} ><i class=" glyphicon glyphicon-check"></i></button>
                          <button type="button" class="btn btn-primary btn-xs" userId=${user.id}> <i class=" glyphicon glyphicon-pencil"></i></button>
                          <button type="button" class="btn btn-danger btn-xs" userId=${user.id}><i class=" glyphicon glyphicon-remove"></i></button>
                      </td>
                  </tr>
              </c:forEach>
              </tbody>

                <%--引入分页--%>
                <%@include file="/WEB-INF/include/commons-tfoot.jsp"%>

            </table>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>
        <%--引入--%>
        <%@include file="/WEB-INF/include/commons-js.jsp" %>
        <%--引入ly--%>
        <script src="${mal}/static/layer/layer.js"></script>

        <script type="text/javascript">
            /*搜索*/
            $("#searchBtn").click(function () {
                console.log("ok");
                var name = $("#searchValue").val();
                window.location.href = "${mal}/user/list.html?userName=" + name;
            });

            var seachMsg = "${seachMsg}";
            if(seachMsg=="用户已搜索出😘"){
                layer.msg(seachMsg);
                var searchId="${searchId}";
                console.log("搜索id"+searchId);

                var l=$(".redBiaozhi")
                for(var i=0;i<l.length;i++){
                    $(".redBiaozhi[userId="+searchId+"]").css("background-color","red");
                }

                /*坑了好久好久*/
                /*$(".redBiaozhi").each(function () {
                    $(".redBiaozhi[userId="+searchId+"]").css("background-color","red");
                })*/

            }


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

            /*角色分配*/
            $("tbody .btn-success").click(function(){
                console.log("queryAllRole");
               // window.location.href="${mal}/user/allocateRole.html";
                /*先查出所有角色*/
                var id = $(this).attr('userId');
                $.ajax({
                    url:'${mal}/user/queryAllRole',
                    data:{"userId":id},
                    success:function () {
                       window.location.href="${mal}/user/allocateRole?userId="+id;
                    },
                    error:function () {

                    }
                })
            });

            $("tbody .btn-primary").click(function () {
                var id =$(this).attr("userId");
                /*前往修改页面*/
                window.location.href="${mal}/user/edit.html?userId="+id+"&pn="+${pageInfo.pageNum}
            })

            /*删除*/
            $("tbody .btn-danger").click(function () {
                var id =$(this).attr("userId");
                confirm("你确定要删除吗？")(
                    window.location.href="${mal}/user/delete?ids="+id
                )
            })
            /*全选，*/
            $(".checkAllBox").click(function () {
                $(".checkBox").prop("checked",$(this).prop("checked"))
            })

            $(".checkBox").click(function () {
                $(".checkAllBox").prop("checked",$(".checkBox").length == $(".checkBox:checked").length);
            })

            /*批量删除*/
            $("#deleteAllbtn").click(function () {
                var ids="";
                $(".checkBox:checked").each(function () {
                        //关键步骤，拼字符串,+
                        ids+=$(this).attr("userId")+",";
                    }
                );
                console.log(ids)
                confirm("你确定要删除吗？")(
                    window.location.href="${mal}/user/delete?ids="+ids
                )
            })
        </script>
  </body>
</html>
