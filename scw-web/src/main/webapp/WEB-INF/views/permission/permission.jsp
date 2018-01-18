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
	  <%@include file="/WEB-INF/include/commons-css.jsp"%>
	  <link rel="stylesheet" href="${mal}/static/css/main.css">
	<link rel="stylesheet" href="${mal}/static/css/doc.min.css">
	<link rel="stylesheet" href="${mal}/static/ztree/zTreeStyle.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	</style>
  </head>

  <body>
  <%	/*基本信息*/
	  pageContext.setAttribute("pageName","许可维护");
	  pageContext.setAttribute("pageUrl", "/scw/web/permission.html");
  %>


  <%--引入navbar--%>
  <%@include file="/WEB-INF/include/manager-navbar.jsp" %>


    <div class="container-fluid">
      <div class="row">
		  <%--引入sideBar--%>
		  <%@include file="/WEB-INF/include/manager-sideBar.jsp"%>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<%--植入tree --%>
			<ul id="treeDemo" class="ztree"> </ul>


				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<%--输入框--%>
							<div class="col-lg-6">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="修改权限信息" id="newName">
									<span class="input-group-btn">
        							<button class="btn btn-default" type="button" id="edit">Go!</button>
        							<button class="btn btn-default" type="button" id="exit">exit!</button>
     							 	</span>
								</div><!-- /input-group -->
							</div><!-- /.col-lg-6 -->

						</div>
					</div>
				</div>
		</div>
    </div>

  <!-- Modal2 -->
  <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
		  <div class="modal-content">
			  <div class="col-lg-6">
				  <div class="input-group">
					  <input type="text" class="form-control" placeholder="增加权限信息" id="addName">
					  <input type="text" class="form-control" placeholder="增加ICON" id="addIcon">
					  <span class="input-group-btn">
        							<button class="btn btn-default" type="button" id="edit2">Go!</button>
        							<button class="btn btn-default" type="button" id="exit2">exit!</button>
     							 	</span>
				  </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->

		  </div>
	  </div>
  </div>

  <!-- Modal 3-->
  <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <h4 class="modal-title" id="myModalLabel">删除许可</h4>
			  </div>
			  <div class="modal-body">
				  你确定删除该许可吗？
			  </div>
			  <div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				  <button type="button" class="btn btn-primary" id="deleteName">确定</button>
			  </div>
		  </div>
	  </div>
  </div>

  <%--引入--%>
  <%@include file="/WEB-INF/include/commons-js.jsp" %>
  <%--引入ly--%>
  <script src="${mal}/static/layer/layer.js"></script>
        <script type="text/javascript">

			$(function () {

                $(".list-group-item").click(function () {
                    if ($(this).find("ul")) {
                        $(this).toggleClass("tree-closed");
                        if ($(this).hasClass("tree-closed")) {
                            $("ul", this).hide("fast");
                        } else {
                            $("ul", this).show("fast");
                        }
                    }
                });
                /*获取所有Permission*/
                init();
            });
            /*获取所有Permission*/

            /*获取点击的节点id*/
            var id;
            var eventC;
            /*获得回调函数的json数据*/
            var jsonJ;
			function  init() {

                var setting = {
                    data: {
                        key: {url: "null"},
                        simpleData: {
                            enable: true,
                            idKey: "id",
                            pIdKey: "pid",
                            rootPId: 0
                        }
                    },

                    view: {
                        selectedMulti: false,
                        /*图标设置*/
                        addDiyDom: addDiyDom,
                        /*移入鼠标*/
                        addHoverDom: addHoverDom,
                        /*移出鼠标*/
                        removeHoverDom: removeHoverDom,

                    },

                    async: {
                        enable: true,
                        url: "tree.txt",
                        autoParam: ["id", "name=n", "level=lv"]
                    },
                    callback: {
                        onClick: function (event, treeId, json) {
                            id = treeId;
							eventC=event;
							jsonJ = json;
                        }
                    }


                };
                function addDiyDom(treeId, treeNode) {
                    console.log(treeNode)
                    var id = treeNode.tId;
                    $("#" + id + "_ico").remove();
                    $("#" + id + "_span").before("<span class= '" + treeNode.icon + "'></span>")
                };
                function addHoverDom(treeId, treeNode) {

                    var aObj = $("#" + treeNode.tId + "_span"); // tId = permissionTree_1, ==> $("#permissionTree_1_a")
                    aObj.attr("href", "javascript:;");
                    if (treeNode.editNameFlag || $("#btnGroup" + treeNode.tId).length > 0) return;
                    var s = '<span id="btnGroup' + treeNode.tId + '">';
                    if (treeNode.level == 0) {
                        s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  id=' + treeNode.tId + '+ data-toggle="modal" data-target="#myModal" title="修改权限信息">&nbsp;&nbsp;<i  class="fa fa-fw fa-edit rbg " id=' + treeNode.id + ' ></i></a>';

                        s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" class="addd" id=' + treeNode.tId + '+ data-toggle="modal" data-target="#myModal2" >&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg " class="mark_it" id=' + treeNode.id + ' ></i></a>';
                    } else if (treeNode.level == 1) {
                        s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  data-toggle="modal" data-target="#myModal" title="修改权限信息">&nbsp;&nbsp;<i class="fa fa-fw fa-edit rbg " id=' + treeNode.id + '></i></a>';
                        s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  data-toggle="modal" data-target="#myModal3">&nbsp;&nbsp;<i class="fa fa-fw fa-times rbg " id=' + treeNode.id + '></i></a>';
                    }
                    s += '</span>';
                    aObj.after(s);
                };
                function removeHoverDom(treeId, treeNode) {

                    $("#btnGroup" + treeNode.tId).remove();
                };

                var treeObj;
                /*先发送AJAX请求获取所有节点*/
                $.ajax({
                    url:"${mal}/permission/getTree",
                    success:function (data) {
                        treeObj =  $.fn.zTree.init($("#treeDemo"), setting, data);
                        treeObj.expandAll(true);
                    },
                    error:function () {
                        layer.msg("网络不畅，请重试")
                    }
                });

            };

			/*怎样获取id */
			$("body").on("click",".addd",function () {
               // alert("ok");
				console.log("<<<<<<<<<<<<<<<<<<<<<<KKKKKKKKKKKKKKKKKKK>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
            });
			//var aid =$(".addd").attr("id");


			/*执行修改操作*/

			$("#exit").click(function () {
                $('#myModal').modal('hide');
            });

			$("#edit").click(function () {
                var name = $("#newName").val();
                console.log("---------------iiiiiiiiiiddddddddddd"+jsonJ.id);
			    $.ajax({
					url:"${mal}/permission/reName",
					data:{"id":jsonJ.id,"name":name},
					success:function (data) {
					    console.log("===========>>>>success")
					    layer.msg(data.msg+"😘");
                        $('#myModal').modal('hide');
                        init() ;


                    },
					error:function () {
						layer.msg("网络不顺畅，请重试😂")
                    }

				})


            });

			/*添加*/
			$("#exit2").click(function () {
                $('#myModal2').modal('hide');
            })
			/*获取id*/
			$("#edit2").click(function () {
                var name = $("#addName").val();
                var icon = $("#addIcon").val();
				$.ajax({
					url:"${mal}/permission/addName",
					data:{"pid":jsonJ.id,"icon":icon,"name":name},
					success:function (data) {
						layer.msg(data.msg+"😘");
                        /**/
                        $('#myModal2').modal('hide');
                        init() ;
                    },
					error:function (data) {
                        layer.msg(data.msg)
                    }
				})
            });

			/*删除*/
			$("#deleteName").click(function () {
				$.ajax(
					{
                        url:"${mal}/permission/deleteName",
                        data:{"id":jsonJ.id},
                        success:function (data) {
                            layer.msg(data.msg+"😘");
                            $('#myModal3').modal('hide');
                            init() ;
                        },
                        error:function (data) {
                            layer.msg(data.msg)
                        }
                    })
					}
				);
        </script>
  </body>
</html>
