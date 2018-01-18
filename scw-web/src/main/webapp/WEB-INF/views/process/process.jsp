<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="UTF-8">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	  <%--引入--%>
	  <%@include file="/WEB-INF/include/commons-css.jsp" %>

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
	  pageContext.setAttribute("pageName","流程管理");
	  pageContext.setAttribute("pageUrl", "/scw/web/cert/process.html");
  %>
  <%--引入navbar--%>
  <%@include file="/WEB-INF/include/manager-navbar.jsp" %>

    <div class="container-fluid">
      <div class="row">
		  <%--引入sideBar--%>
		  <%@include file="/WEB-INF/include/manager-sideBar.jsp" %>
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
      <input class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button><span></span>
    <span>${msg}</span>
</form>

<button type="button" id= "uploadFile"  data-toggle="modal" data-target="#myModal" class="btn btn-primary" style="float:right;" onclick="window.location.href='#'"><i class="glyphicon glyphicon-upload"></i> 上传流程定义文件</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
                  <th>流程名称</th>
                  <th>流程版本</th>
                  <th>任务名称</th>
                  <th>申请会员</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody>

                <%--<tr>
                  <td>1 <td>实名认证审批流程</td><td>2</td><td>人工审核</td><td>张三</td></td>
                  <td>实名认证审批流程</td>
                  <td>2</td>
                  <td>人工审核</td>
                  <td>张三</td>
                  <td>
                      <button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-eye-open"></i></button>
                      <button type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>
				  </td>
                </tr>--%>
              </tbody>
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul class="pagination">
								<%--<li class="disabled"><a href="#">上一页</a></li>
								<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">下一页</a></li>--%>
							 </ul>
					 </td>
				 </tr>

			  </tfoot>
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
  <!-- Modal--上传 -->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <h4 class="modal-title" id="myModalLabelRole">资质新增</h4>
			  </div>
			  <div class="modal-body">
                  <form id="addForm"  enctype="multipart/form-data">
                      <div class="form-group">
                          <label>流程文件选择</label>
                          <input type="file" name="file" class="form-control" id="processFile">
                      </div>

                  </form>

			  </div>
			  <div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				  <button type="button" class="btn btn-primary" id="modelForm">上传</button>
			  </div>
		  </div>
	  </div>
  </div>

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
            init();
            var name="${sessionScope.userName.loginacct}";
            /*ajax文件上传*/
            $("#modelForm").click(function () {
                var form = new FormData($("#addForm")[0]);
                form.append("name",name);
                console.log("==========>>>>>>>>>>>"+form);
                $('#myModal').modal('hide')
               /* $("#addForm").submit();*/
                $.ajax({
                    url:"${api}/process/deploy",
                    type:"post",
                    data:form,
                    headers : {"name" :name},
                    contentType:false,//禁用默认设置
                    processData:false,
                    success: function(data) {
                      layer.msg(data.msg);
                      init();
                    },
                    error: function(data) {
                        layer.msg(data.msg);
                    },
                });
            });


            var pn;
            /*构建页面*/
            function init() {
                $.ajax({
                    url:"${api}/process/list",
                    type:"post",
                    data:{"pn":pn}
                }).done(function (data) {
                    $("tbody").empty();
                    buildPage(data);
                    $("ul.pagination").empty();
                    buildPage2(data);

                }).fail(function (data) {
                    layer.msg(data.msg)
                });
            }


            function buildPage(data) {
                var list=data.type;
                var id=1;
                console.log(list);
                var start = $("tbody td");
                $.each(list,function () {
                    var tr=$("<tr></tr>");
                    tr.append("<td>"+ id++ +"</td>").append("<td>"+this.name+"</td>").append("<td>"+this.version+"</td>").append("<td>"+"task"+"</td>")
                        .append("<td>"+name+"</td>").append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append('<button type="button" id ="img"pid='+this.id+' class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-eye-open"></i></button>\n').append("&nbsp;&nbsp;&nbsp;&nbsp")
                        .append('<button type="button" id="del" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>\n').appendTo("tbody");

                       /* $("tbody").append("<tr></tr>").append("<td>"+ id++ +"</td>").append("<td>"+this.name+"</td>").append("<td>"+this.version+"</td>").append("<td>"+"task"+"</td>")
                            .append("<td>"+name+"</td>").append("&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append('<button type="button" id ="img"pid='+this.id+' class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-eye-open"></i></button>\n').append("&nbsp;&nbsp;&nbsp;&nbsp")
                            .append('<button type="button" id="del" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>\n');*/
                })

            };
            /*构建分页条*/
            /*往表格中填加内容*/
            function buildPage2(data) {
                var map=data.map;
                var key = "info"
                var pages=  map[key]
                console.log(pages+"===================================??????????????");
                var firstPage;
                var lastPage;
                var prePage;
                var afterPage;
                var info;
                var cyclePage;

                if(pages.pageNum==pages.firstPage){
                    firstPage = '<li class="disabled" ><a href="#">首页</a></li>';
                    /*这里要注意虽然我们上面写了置空empty()方法，但它只是置空html元素而已，js对象的赋值并没有被清空，因为是成员变量*/
                    //prePage='';
                }else if (pages.pageNum!=1){
                    firstPage = '<li class="jumpLi"><a href="#">首页</a></li>';
                    prePage = '<li class="jumpLi" pn="'+pages.prePage+'"><a href="#">上一页</a></li>';
                }
                if(pages.pages==pages.pageNum){
                    lastPage = '<li class="disabled"><a href="#">末页</a></li>';
                }else if(pages.lastPage != pages.pageNum){
                    afterPage = '<li class="jumpLi" pn="'+pages.nextPage+'"><a href="#">下一页</a></li>'
                    lastPage = '<li class="jumpLi" pn="'+pages.pages+'"><a href="#">末页</a></li>';
                }
                info = $('<li class="disabled"><a href="#">总共有' + pages.pages + '当前第' + pages.pageNum + '页，总共有' + pages.total + '条记录</a></li>')
                var str ='';
                /*页码*/
                $.each(pages.navigatepageNums,function () {
                    var temp ='';
                    if(this==pages.pageNum){
                        temp='<li class="active jumpLi" pn=" '+this+'" pages="'+pages.pageNum+'"><a href="#">'+this+'</a></li>';
                    }else {
                        temp='<li class="jumpLi" pn=" '+this+'" ><a href="#">'+this+'</a></li>';
                    }
                    str+=temp;
                })
                cyclePage=str;
                /*拼接分页条*/
                $('ul.pagination').append(firstPage).append(prePage).append(cyclePage).append(afterPage).append(lastPage).append(info);
                jumpLi();
            };

            /*页面跳转*/
            function jumpLi() {
                $('.jumpLi').click(function () {
                    //alert("ok")
                    var v=$(this).attr('pn')
                    pn=v;
                    init();
                })
            };



                /*点击显示图片*/
            $("body").on("click","#img",function () {

                var id= $(this).attr("pid");
                console.log(id+"=====================");
                var url ="localhost:8080"+"${api}"+"/process/img?id="+id;
                alert(url);
              /*  $.ajax({
                    type:"post",
                    url:"",
                    data:{"id":id},
                });*/

            })


        </script>
  </body>
</html>
