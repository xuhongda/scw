<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/11/4
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="col-sm-3 col-md-2 sidebar">
    <div class="tree">
        <ul style="padding-left:0px;" class="list-group">
            <li class="list-group-item tree-closed" >
                <a href="main.jsp"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
            </li>
            <c:forEach items="${allMenus}" var="menu">
                <li class="list-group-item tree-closed">
                    <span><i class="${menu.getIcon()}"></i> ${menu.getName()}
                        <span class="badge" style="float:right">${fn:length(menu.getChilds())}</span>
                    </span>
                    <c:if test="${!empty(menu.getChilds())}">
                        <ul style="margin-top:10px;display:none;">
                            <c:forEach items="${menu.getChilds()}" var="child">
                                <li style="height:30px;">
                                    <a href="${mal}/${child.url}"><i class="${child.getIcon()}"></i>&nbsp;${child.getName()}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>