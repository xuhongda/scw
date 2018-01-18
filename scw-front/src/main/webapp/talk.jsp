<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/12/10
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告</title>
</head>
　<script type="text/javascript">
    var time = 8; //时间,秒
    function Redirect() {
       window.location.href = "http://localhost:8080/scw/front/mobile.jsp";
       // window.location.href
    }
    var i = 0;
    function dis() {
        document.all.s.innerHTML = "还剩" + (time - i) + "秒";
        i++;
    }
    timer = setInterval('dis()', 1000); //显示时间
    timer = setTimeout('Redirect()', time * 1000); //跳转
</script>
<%@include file="/WEB-INF/include/commons-js.jsp"%>
<%@include file="/WEB-INF/include/commons-css.jsp"%>
<body>
<h1><p class="text-center">公告</p></h1><br/><br/>

<h3>
    <p class="text-center">手机版为测试项目，想获得完整项目体验请访问web版</p>
    <p class="text-center">默认八秒后访问手机版</p>

</h3>

            <center>
                <a href="http://localhost:8080/scw/front/mobile.jsp">
                    <span class="label label-success">立即访问</span>

                </a>&nbsp;&nbsp;
                <a href="http://localhost:8080/scw/web/index.jsp">
                    <span class="label label-default">访问web版</span></a>
                    <br/>
                    <br/>
                    <br/>

                <button type="button" class="btn btn-info"><span id="s"></span></button>
            </center>

</body>
</html>
