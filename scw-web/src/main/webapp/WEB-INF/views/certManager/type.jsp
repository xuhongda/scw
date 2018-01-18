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

    <%--引入layui--%>


	<%@include file="/WEB-INF/include/commons-css.jsp"%>
    <link rel="stylesheet" href="${mal}/static/css/main.css">


	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
    
    input[type=checkbox] {
        width:18px;
        height:18px;        
    }
	</style>
  </head>

  <body>

  <%
    pageContext.setAttribute("pageName","分类管理");
    pageContext.setAttribute("pageUrl","/scw/web/typeCert/getType");

  %>
    <%@include file="/WEB-INF/include/manager-navbar.jsp"%>

    <div class="container-fluid">
      <div class="row">
          <%@ include file="/WEB-INF/include/manager-sideBar.jsp" %>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据矩阵</h3>
			  </div>
			  <div class="panel-body">
          <div class="table-responsive">
            <table class="table  table-bordered" id="tableId">
              <thead>
                <tr >
                  <th>名称</th>
                    <c:forEach items="${acctTypeEnmu}" var="acctName">
                        <th style="text-align: center">${acctName.getName()}</th>
                    </c:forEach>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${certList}" var="listCert">
                <tr>
                  <td>${listCert.name}</td>
                  <c:forEach items="${acctTypeEnmu}" var="acctName">
                    <%--a_id表示转户类型id  c_id表示证件id--%>
                    <td style="text-align: center"><input type="checkbox" a_id="${acctName.id}" c_id="${listCert.id}" id="checkBoxId" class="num"></td>
                  </c:forEach>
                </tr>
              </c:forEach>
              </tbody>
              <tfoot>
              <tr><td colspan="4"></td>

                <td style="text-align: center">
                <button type="button" class="btn btn-info" id="submitBtn">提交</button>
                  &nbsp;
                  &nbsp;
                  &nbsp;
                  &nbsp;
                  &nbsp;
                <button type="button" class="btn btn-danger" id="resetBtn">重置</button>
              </td></tr>
              </tfoot>
            </table>
          </div>
			  </div>
			</div>
        </div>
      </div>
    </div>

    <%@include file="/WEB-INF/include/commons-js.jsp"%>
    <script src="${mal}/static/layer/layer.js"></script>
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

            /*重置*/
            $('#resetBtn').click(function () {
                console.log("ok")
               var v=$('.num');
                $.each(v,function () {
                   $(this).prop("checked",false);
                })

            })
            /*在发送执行请求之前，获取已分配的资质*/
            $.get('${mal}/typeCert/getCert',function (data) {
                var ids=data.content;
                $.each(ids,function () {
                    var aid = this.a_id;
                    var cid = this.c_id;
                    /*带有属性的选择*/
                    var length = $("input[a_id='" + aid + "'][c_id='" + cid + "'").length;
                    console.log(length);
                    $("input[a_id='" + aid + "'][c_id='" + cid + "'").prop("checked", true);
                });
                });


            /*发送ajax请求*/
            $("#submitBtn").click(function () {
                var a_id='';
                var c_id='';
                var subId="[";
                var testId='';

                /*查找出所有勾选的checkbox*/
                var a_ids=$('#checkBoxId:checked');
                $.each(a_ids,function () {
                    a_id = $(this).attr('a_id');
                    c_id = $(this).attr('c_id');
                    //重点，拼接json字符串
                    subId += '{"a_id":"' + a_id + '","c_id":"' + c_id + '"},';
                    //这是对象格式
                    testId += {'a_id': a_id, 'c_id': c_id};

                });
                /*
                截取字符串开始到结束;
                注意这里有坑，如果不开一个新变量直接等于的话，空串截取会把‘【’截掉
                */
                if(subId.length>1){
                    subId=subId.substring(0,subId.length-1);
                }else {
                    subId=subId;
                }

                subId+=']';
                console.log(subId+"==============subId")
                console.log(testId+"==============testId");

                /*发送ajax请求*/
                $.ajax({
                    url:"${mal}/typeCert/allocateCert",
                    data:{"subId":subId},
                    success:function (data) {
                        layer.msg(data.msg)
                    },
                    error:function (data) {
                        layer.alert(data.msg, {
                                skin: 'layui-layer-molv' //样式类名
                                ,closeBtn: 0
                            }
                        );
                    }
                });
                
            });

        </script>
  </body>
</html>
