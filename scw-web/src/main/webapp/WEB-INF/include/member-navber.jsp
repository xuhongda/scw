<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/12/18
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" style="float:right;">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> ${sessionScope.userName.loginacct}<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${mal}/member.html"><i class="glyphicon glyphicon-scale"></i> 会员中心</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                        <li class="divider"></li>
                        <li><a href="${front}/index.jsp"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
