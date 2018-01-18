<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/11/13
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
    <span>yyyyyyy</span>
    <%--<script href="${mal}/static/jquery/jquery-3.2.1.js"></script>--%>
    <%@include file="/WEB-INF/include/commons-js.jsp"%>
    <script>
        $.get(
            "${mal}/role/allRoles",
            {pn:1,ps:4},
            function(data){ alert(data.length) }
            )
    </script>
</body>
</html>
