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
			pageContext.setAttribute("pageName","角色维护");
			pageContext.setAttribute("pageUrl", "/scw/web/role/list.html");
		%>
        <%--引入navbar--%>
        <%@include file="/WEB-INF/include/manager-navbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <%--引入sideBar--%>
                <%@include file="/WEB-INF/include/manager-sideBar.jsp" %>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <!-- Button trigger modal -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-inline" role="form" style="float:left;">
                                <div class="form-group has-feedback">
                                    <div class="input-group">
                                        <div class="input-group-addon">查询条件</div>
                                        <input class="form-control has-success" type="text" placeholder="请输入查询条件" id="seachInp">
                                    </div>
                                </div>
                                <button type="button" class="btn btn-warning" id="subSeaBtn"><i class="glyphicon glyphicon-search"></i>
                                    查询
                                </button>&nbsp;&nbsp;<span style="color: red">${msg}</span>
                            </form>
                            <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"
                                    id="deleteAllbtn"><i class=" glyphicon glyphicon-remove"></i> 删除
                            </button>
                            <button type="button" class="btn btn-primary" style="float:right;" data-toggle="modal"
                                    data-target="#myModal" id="addRole">
                                <i class="glyphicon glyphicon-plus"></i> 新增
                            </button>

<br>
    <hr style="clear:both;">
                       <span style="margin-left: auto;color: #5a5a5a"><font size="2">百度科技</font> </span>
                            <hr style="clear:both;">

                            <div class="table-responsive">
                            <table class="table  table-bordered" id="roleTable">
                                <thead>
                                <tr>
                                    <th width="30">#</th>
                                    <th width="30"><input type="checkbox" class="checkAllBox"></th>
                                    <th>名称</th>
                                    <th width="100">操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="6" align="center">
                                        <ul class="pagination">
                                            <%--页码--%>
                                        </ul>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>

        <%--引入--%>
        <%@include file="/WEB-INF/include/commons-js.jsp" %>
        <%--引入ly--%>
        <script src="${mal}/static/layer/layer.js"></script>

        <!-- Modal--新增 -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabelRole">角色新增</h4>
                    </div>
                    <div class="modal-body">
                        <form class="addForm">
                            <input type="text" class="form-control" placeholder="请输入名称" name="name" id="addForm">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="modelForm">保存</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal--修改 -->
        <div class="modal fade" id="myModalEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">角色修改</h4>
                    </div>
                    <div class="modal-body">
                        <form class="editForm">
                            <input type="text" class="form-control" placeholder="请输入名称" name="name"  id="editForm">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" id="editBtn">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <%--权限分配--%>
        <div class="modal fade" id="myModalPermission" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="permissionId">分配许可</h4>
                    </div>
                    <div class="modal-body">
                        <ul id="treeDemoPermission" class="ztree"></ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="savePermission">分配权限</button>
                        <button type="button" class="btn btn-danger" id="deletePermission">清空权限</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript"></script>
        <script>
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
            $("tbody .btn-success").click(function(){
                window.location.href = "../user/assignRole.jsp";
            });


            /*搜索条件*/
            var seaVal;
            $("#subSeaBtn").click(function () {
                seaVal= $("#seachInp").val();
                console.log(seaVal);
                getRoles();
            });

            /*ajax请求获取页面*/
            $(function () {
                getRoles();
            });
            var lastPageSize=1;
            var page={pn:1,ps:5,lastPageSize:lastPageSize};

            function getRoles() {
                var index = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
                $.ajax({
                    url:"${mal}/role/allRoles",
                    data:{pn:page.pn,ps:page.ps,"condition":seaVal},

                    success:function (data,textStatus,jqXHR ) {
                        //加载层
                        initData(data);
                        showRoles(data);
                        layer.close(index);
                    },
                    type:'post'
                })
            }
            function showRoles(data) {
                /*在构建之前先清空*/
                $('ul.pagination').empty();
                $('#roleTable tbody').empty();

                buildTable(data);
                buildPage(data);
            };

            /*创建表格框架*/
            function buildTable(data){

                var roleData = data.list;
                $.each(roleData,function(){
                    var tr = $("<tr></tr>"); //创建这个tr对象
                    var btnTd = $("<td> </td>");
                    /*操作按钮*/
                    btnTd.append('<button type="button" class="btn btn-success btn-xs" id="permindssionBtn" roleId='+this.id+'><i class="glyphicon glyphicon-check"></i></button>')
                        .append('&nbsp;<button type="button" class="btn btn-primary btn-xs" data-toggle="modal"  data-target="#myModalEdit" id="editRole" roleId='+this.id+'><i class="glyphicon glyphicon-pencil"></i></button>')
                        .append('&nbsp;<button type="button" class="btn btn-danger btn-xs" roleId='+this.id+'><i class="glyphicon glyphicon-remove"></i></button>');
                    /*表格body*/
                    tr.append("<td  roleId="+this.id+">"+this.id+"</td>")
                        .append("<td class=RoleId roleId="+this.id+"><input type='checkbox' class='checkBox' roleId="+this.id+" ></td>")
                        .append("<td>"+this.name+"</td>")
                        .append(btnTd).appendTo($("#roleTable tbody"));
                })};

            /*往表格中填加内容*/
            function buildPage(data) {
                var firstPage;
                var lastPage;
                var prePage;
                var afterPage;
                var info;
                var cyclePage;

                if(data.pageNum==data.firstPage){
                    firstPage = '<li class="disabled" ><a href="#">首页</a></li>';
                    /*这里要注意虽然我们上面写了置空empty()方法，但它只是置空html元素而已，js对象的赋值并没有被清空，因为是成员变量*/
                    //prePage='';
                }else if (data.pageNum!=1){
                    firstPage = '<li class="jumpLi"><a href="#">首页</a></li>';
                    prePage = '<li class="jumpLi" pn="'+data.prePage+'"><a href="#">上一页</a></li>';
                }
                if(data.pages==data.pageNum){
                    lastPage = '<li class="disabled"><a href="#">末页</a></li>';
                }else if(data.lastPage != data.pageNum){
                    afterPage = '<li class="jumpLi" pn="'+data.nextPage+'"><a href="#">下一页</a></li>'
                    lastPage = '<li class="jumpLi" pn="'+data.pages+'"><a href="#">末页</a></li>';
                }
                info = $('<li class="disabled"><a href="#">总共有' + data.pages + '当前第' + data.pageNum + '页，总共有' + data.total + '条记录</a></li>')
                var str ='';
                /*页码*/
                $.each(data.navigatepageNums,function () {
                    var temp ='';
                    if(this==data.pageNum){
                        temp='<li class="active jumpLi" pn=" '+this+'" pages="'+data.pageNum+'"><a href="#">'+this+'</a></li>';
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
                    page.pn=v;
                    getRoles();
                })
            };
            /*新增*/
            /* $("#addRole").click(function () {
                     不能把下面那个回调函数写在这里面
             })*/

            $("#modelForm").click(function () {
                $('#myModal').modal('hide')
                var url = '${mal}/role/addRoles';
                //$(".addForm").submit();
                //把表格里的数据弄成JSON格式
                var data = $("#addForm").serialize();
                $.get(
                    url,
                    data,
                    function (data) {
                        getRoles();
                    }
                )
            });
            /*修改*/
            $("body").on('click','#editRole',function () {
                var id =$(this).attr('roleId');

                $.get('${mal}/role/selectOne',{"roleId":id},function (data) {
                    var name=data.name;
                    $('#editForm').attr('placeholder',name);
                });
                $("#editBtn").click(function () {
                    // var data = $("#addForm").serialize();
                    var name =$("#editForm").val();
                    $.get(
                        '${mal}/role/edit',
                        {id:id,name:name},
                        function (data) {
                            $('#myModalEdit').modal('hide');
                            var p =$(".active").attr('pages');
                            page.pn=p;
                            getRoles();
                            layer.msg(data.msg);
                        }
                    );
                });
            });

            /*删除单个*/
            $(function () {
                $('body').on('click', 'tbody .btn-danger', function () {
                    var id = $(this).attr('roleId');
                    layer.confirm('你确定要删除吗？', {
                        skin: 'layui-layer-molv' //样式类名
                        ,closeBtn: 0,
                        btn: ['删除','取消'] //按钮
                    }, function(){
                        $.ajax({
                                url: url,
                                data: {ids: id},
                                success: function (data, b, c) {
                                    var pages=$('.active').attr('pages');
                                    page.pn=pages;
                                    getRoles();
                                    layer.msg(data.msg, {icon: 1});
                                },
                                error: function (data) {
                                    layer.msg(data.msg, {icon: 1});
                                }
                                })
                            }
                        );
                });
            });
                var url ='${mal}/role/delete';
            /*批量删除，，，，重点*/
            $(function () {
                var ids = '';
                /*怎样获取到选中的id值*/

                /*获取一，普通获取多个*/
                $('body').on('click', '.checkBox:checked', function () {
                    $(this).each(function () {
                        ids += $(this).attr('roleId') + ",";
                    })
                });
                /*获取二，点击全选按钮框时*/
                $('body').on('click', '.checkAllBox', function () {
                    $('.checkBox:checked').each(function () {
                        ids += $(this).attr('roleId') + ",";
                        // alert(ids);

                    })
                });
                /*发送删除请求*/
                $('#deleteAllbtn').click(function () {
                    if (confirm('你确定要删除吗')) {
                       /* $.get(
                            url,
                            {ids: ids},
                            function (data, b, c) {
                                var pages=$('.active').attr('pages');
                                page.pn=pages;
                                getRoles();
                            }
                        );*/


                        $.ajax({
                            url: url,
                            data: {"ids": ids},
                            success: function (data, b, c) {
                                var pages=$('.active').attr('pages');
                                page.pn=pages;
                                getRoles();
                                layer.msg(data.msg, {icon: 1});
                            },
                            error: function (data) {
                                layer.msg(data.msg, {icon: 1});
                            }
                        })

                        /*发送后取消选中*/
                        $('.checkAllBox').prop('checked', false);
                    }


                });
            });



            function initData(data){
                page.pn=data.pages+1;
            };

            // checked();

            /*角色id和已选中的权限id */
            var perId={};
            var treeObj;

            /*权限分配功能*/
            $('body').on('click','#permindssionBtn',function () {
                perId.roleId=$(this).attr('roleId');
                initPermission();
                /*自定义模态框*/
                $('#myModalPermission').modal({
                    backdrop:'static',
                    show:true
                });
            });
            /*清空权限*/
            $("#deletePermission").click(function () {
               // alert("ok")
                treeObj.checkAllNodes(false);
                /*发送分配权限请求*/
                $.ajax({
                    url:'${mal}/permission/deletePermission',
                    data:perId,
                    success:function (data) {
                        $('#myModalPermission').modal('hide');
                        layer.open({
                            skin: 'layui-layer-lan',
                            title: '消息'
                            ,content: data.msg
                        });
                    },
                    error:function (dada) {
                        layer.open({
                            skin: 'layui-layer-molv', //样式类名
                            title: '消息'
                            ,content: data.msg
                        });
                    }
                });
            });
            /*初始化模态框*/
            function initPermission(){
                var setting = {
                    view: {
                        addDiyDom: addDiyDom
                    },
                    check: {
                        enable: true,
                        autoCheckTrigger:true
                    },
                    data: {
                        key:{url:"null"},
                        simpleData: {
                            enable: true,
                            idKey: "id",
                            pIdKey: "pid",
                            rootPId: 0
                        }
                    }
                };
                /*获取所有权限*/
                $.get('${mal}/permission/getTree',function (data) {
                    treeObj= $.fn.zTree.init($("#treeDemoPermission"), setting,data);
                    treeObj.expandAll(true);

                    /*获取已选中的权限*/
                    $.get('${mal}/permission/getRoled',{"roleId":perId.roleId},function (data) {
                        console.log(data.content);
                        var roles=data.content;
                        $.each(roles,function () {
                            var nodes = treeObj.getNodeByParam("id",this.id, null);
                            console.log(nodes);
                            treeObj.checkNode(nodes,true,false);
                        })
                    })
                })};

            /*进行权限分配*/
            $('#savePermission').click(function () {
                var temp='';
                var nodes=treeObj.getCheckedNodes(true);
                $.each(nodes,function () {
                    temp+=this.id+',';
                });
                perId.pid=temp;
                /*发送分配权限请求*/
                $.ajax({
                    url:'${mal}/permission/allocation',
                    data:perId,
                    success:function (data,b,c) {
                        $('#myModalPermission').modal('hide');
                        layer.open({
                            skin: 'layui-layer-lan',
                            title: '消息'
                            ,content: data.msg
                        });
                    },
                    error:function (dada,b,c) {
                        layer.open({
                            skin: 'layui-layer-molv', //样式类名
                            title: '消息'
                            ,content: data.msg
                        });
                    }
                });
            });

            function addDiyDom(treeId, treeNode) {
                var id=treeNode.tId;
                $("#"+id+"_ico").remove();
                $("#"+id+"_span").before("<span class= '"+treeNode.icon+"'</span>")
            };



            /*选择框*/
            $('body').on('click','.checkAllBox',function () {
                $('.checkBox').prop('checked', $(this).prop('checked'));
            });

            $('body').on('click','.checkBox',function () {
                $('.checkAllBox').prop("checked",$('.checkBox').length == $('.checkBox:checked').length);
            });

        </script>
  </body>
</html>
