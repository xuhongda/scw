<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<!DOCTYPE html>
<html lang="UTF-8">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
      <%@include file="/WEB-INF/include/commons-css.jsp"%>
      <link rel="stylesheet" href="${mal}/static/css/theme.css">
	<style>
#footer {
    padding: 15px 0;
    background: #fff;
    border-top: 1px solid #ddd;
    text-align: center;
}
#topcontrol {
  color: #fff;
  z-index: 99;
  width: 30px;
  height: 30px;
  font-size: 20px;
  background: #222;
  position: relative;
  right: 14px !important;
  bottom: 11px !important;
  border-radius: 3px !important;
}

#topcontrol:after {
  /*top: -2px;*/
  left: 8.5px;
  content: "\f106";
  position: absolute;
  text-align: center;
  font-family: FontAwesome;
}

#topcontrol:hover {
    color: #fff;
    background: #18ba9b;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}

.label-type, .label-status, .label-order {
    background-color: #fff;
    color: #f60;
    padding : 5px;
    border: 1px #f60 solid;
}
#typeList  :not(:first-child) {
    margin-top:20px;
}
.label-txt {
    margin:10px 10px;
    border:1px solid #ddd;
    padding : 4px;
    font-size:14px;
}
.panel {
    border-radius:0;
}

.progress-bar-default {
    background-color: #ddd;
}
	</style>
  </head>
  <body>
 <div class="navbar-wrapper">
      <div class="container">
          <%--引入导航栏--%>
            <%@include file="/WEB-INF/include/member-navber.jsp"%>

      </div>

    <div class="container theme-showcase" role="main">

        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <%@include file="/WEB-INF/include/member-navber2.jsp"%>
                </div>
            </div>
        </div>


        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="panel panel-default">
                        <%--引入步骤--%>
                        <%@include file="/WEB-INF/include/process-panel.jsp" %>
                        <div class="container-fluid">
                            <div class="panel-body">
                                <div class="container-fluid">

	<div class="row clearfix">
		<div class="col-md-12 column">
			<blockquote style="border-left: 5px solid #f60;color:#f60;padding: 0 0 0 20px;">
				<b>
					项目及发起人信息
				</b>
			</blockquote>
		</div>
		<div class="col-md-12 column">
			<div class="page-header" style="    border-bottom-style: dashed;">
				<h3>
					项目信息
				</h3>
			</div>
            <form class="form-horizontal">
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">分类信息</label>
                <div class="col-sm-10" id="type">
                    <%-- <label class="radio-inline">
                      <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 科技
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 设计
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 公益
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 农业
                    </label>--%>
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">标签</label>
                <div class="col-sm-10">
                    <ul style="list-style:none;padding-left:0;" id="tags">
                       <%-- <li style="margin:10px 0">[手机]
                            <span class="label-txt">手机</span> <span class="label-txt">快充</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span>
                        </li>
                        <li style="margin:10px 0">[数码]
                            <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span>
                        </li>
                        <li style="margin:10px 0">[电脑]
                            <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span>
                        </li>--%>
                    </ul>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">项目名称</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" >
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">一句话简介</label>
                <div class="col-sm-10">
                  <textarea class="form-control" rows="5"></textarea>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">筹资金额（元）</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" style="width:100px;" >
                  <label class="control-label">筹资金额不能低于100元,不能高于1000000000元</label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">筹资天数（天）</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" style="width:100px;" >
                  <label class="control-label">一般10-90天，建议30天</label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">项目头图</label>
                  <div class="col-sm-10">
                      <input type="file" id="imgShow" multiple="multiple" style="display: none">
                      <button type="button" class="btn btn-primary btn-lg active " id="uploadimg" >上传图片</button>
                      <label class="control-label">图片上无文字,支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：740*457px</label>
                      <br/>
                      <div class="progress" id="jingdu" style="display: none">
                          <div id = "processBar" class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">

                          </div>
                      </div>
                     <%-- <img id="xmTanImg" style="max-height: 200px">--%>
                  </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">项目详情</label>
                <div class="col-sm-10">
                    <input type="file" id="imgShow2" style="display: none">
                  <button type="button" class="btn btn-primary btn-lg active" id="uploadimg2">上传图片</button>
                  <label class="control-label">支持jpg、jpeg、png、gif格式，大小不超过2M，建议尺寸：宽740px</label>
                </div>
              </div>
            </form>
		</div>
		<div class="col-md-12 column">
			<div class="page-header" style="    border-bottom-style: dashed;">
				<h3>
					发起人信息
				</h3>
			</div>
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">自我介绍</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="一句话自我介绍，不超过40字">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">详细自我介绍</label>
                <div class="col-sm-10">
                  <textarea class="form-control" rows="5" placeholder="向支持者详细介绍你自己或你的团队及项目背景，让支持者在最短时间内了解你，不超过160字"></textarea>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="此信息不会显示在项目页面">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">客服电话</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="此信息显示在项目页面">
                </div>
              </div>
            </form>
		</div>
	</div>
</div>
                        </div>
                        <div class="panel-footer" style="text-align:center;">
                            <button type="button" class="btn  btn-warning btn-lg"  id="submitBtn">下一步</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        <div class="container" style="margin-top:20px;">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div id="footer">
                        <div class="footerNav">
                             <a rel="nofollow" href="http://www.layoutit.cn">关于我们</a> | <a rel="nofollow" href="http://www.layoutit.cn">服务条款</a> | <a rel="nofollow" href="http://www.layoutit.cn">免责声明</a> | <a rel="nofollow" href="http://www.layoutit.cn">网站地图</a> | <a rel="nofollow" href="http://www.layoutit.cn">联系我们</a>
                        </div>
                        <div class="copyRight">
                            Copyright ?2017-2017layoutit.cn 版权所有
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
      
    </div> <!-- /container -->

 <%@include file="/WEB-INF/include/commons-js.jsp"%>

 <script src="${mal}/static/echarts/echarts.min.js"></script>
	<script>
        $('#myTab a').click(function (e) {
            e.preventDefault()
            $(this).tab('show')
        });
        init();
        /*初始化页面*/
        function init() {
            $.ajax({
                url:"${api}/getType",
                success:function (data) {
                    buildPage(data);
                    layer.msg(data.msg);
                },
                error:function () {
                    layer.msg(data.msg);
                }
            });

            $.ajax({
                url:"${api}/getTag",
                success:function (data) {

                    buildTags(data);
                    layer.msg(data.msg);

                },
                error:function (data) {
                    layer.msg(data.msg);
                }
            });
            
        };
        function buildPage(data) {
                var num=0;
                var v;
            $.each(data, function () {
                 v= data.type;
            });
            $.each(v,function () {
                var map =v[num++];
                // var type=map["name"]; js 中map可直接取值
                $("#type").append('<label class="radio-inline"> ' +
                    '<input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> ' + map.name + '</label>')
            })


        }
        /**/
        function buildTags(data) {
            /*
           * <li style="margin:10px 0">[手机]
                           <span class="label-txt">手机</span> <span class="label-txt">快充</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span> <span class="label-txt">文字标签</span>
                       </li>
                       */
            var num = 0 ;
            var v;
            $.each(data,function () {
                v=data.type;
            });

            $.each(v,function () {
               var map= v[num++];
                var li =$("<li style='margin:10px 0'></li>").append("["+map.name+"]");
               var childs= map.childs;
               var num2=0;
               $.each(childs,function () {
                   var tag=childs[num2++];
                   li.append('<input type="button"  id = "btn" iid="'+tag.id+' " value="'+tag.name+' " class="label-txt">').appendTo("#tags")
               })
            })
        }

        $("body").on("click","#btn",function () {
            $(this).toggleClass('.btn btn-success');
          var v=  $("input:button");
          alert(v.length)
        });
        /*上传图片*/
        $("#uploadimg").click(function () {
            $("#imgShow").click();
        })

        $("#imgShow").change(function () {
            var file = $(this)[0].files[0];
            $(this).nextAll("label").html(file.name);
            /*动态添加 img标签*/
            var preview=$(this).nextAll("label").after("<img src=''/>");
            previewFile(file);
        });
        /*显示*/
        function previewFile(file) {
            //var preview = document.querySelector('img');
            var preview = $("img")[0];
         /*  var file    = document.querySelector('input[type=file]').files[0]*/;
            var reader  = new FileReader();

            reader.addEventListener("load", function () {
                preview.src = reader.result;
            }, false);
            //判断对象是否存在
            if (file) {
                reader.readAsDataURL(file);
            }
        }


        $("#uploadimg2").click(function () {
            $("#imgShow2").click();
        });

        $("#imgShow2").change(function () {
            var file = $(this)[0].files[0];
            $(this).nextAll("label").html(file.name);
            /*动态添加 img标签*/
            var preview=$(this).nextAll("label").after("<img src=''/>");
            previewFile(file);
        });
        /*显示*/
        function previewFile(file) {
            //var preview = document.querySelector('img');
            var preview = $("img")[0];
         /*  var file    = document.querySelector('input[type=file]').files[0]*/;
            var reader  = new FileReader();

            reader.addEventListener("load", function () {
                preview.src = reader.result;
            }, false);
            //判断对象是否存在
            if (file) {
                reader.readAsDataURL(file);
            }
        }
        /*上传进度条*/
        $("#submitBtn").click(function () {
            disPlay();
            send();

        });
        /*显示进度出条*/
        function disPlay() {
            $("#jingdu").show()
        };

        /*发送ajax请求上传文件*/
        function send() {
            var value = $("#imgShow")[0].files;
            var form = new FormData();
            console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>"+value.length)
            for (var i =0;i<value.length;i++){
                form.append("files",value[i])
            }

            $.ajax({
                url:"${api}/uploadImg",
                type:"post",
                contentType:false,
                processData:false,
                data:form,
                xhr:function () {
                    var xhr = new XMLHttpRequest();
                    console.log(xhr)
                    xhr.upload.onprogress=function (ev) {
                        console.log(ev);
                        var per = ev.loaded/ev.total;
                        var number = Math.ceil(per)*100;
                        $("#processBar").css("width",number+"%")
                        $("#processBar").text(number+"%")
                    };

                    return xhr
                },
                success:function () {
                },
                error:function(){

                }
            })
        };
	</script>
  </body>
</html>>