<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/10/27
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="${mal}/static/jquery/jquery-3.2.1.js"></script>
<script src="${mal}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${mal}/static/script/docs.min.js"></script>
<script src="${mal}/static/script/back-to-top.js"></script>
<%--前端校验--%>
<script src="${mal}/static/jquery-validation-1.13.1/dist/jquery.validate.min.js"></script>
<%--错误信息国际化--%>
<script src="${mal}/static/jquery-validation-1.13.1/dist/localization/messages_zh.js"></script>
<%--引入ztree--%>
<script type="text/javascript" src="${mal}/static/zTree_v3-3.5.28/js/jquery.ztree.all.js"></script>
<%--高亮以及显示--%>
<script>
    /*高亮标签*/
    $(function(){
        //拿到浏览器地址栏上的地址；
        var currentUrl = "${pageUrl}";
        //找到这个a标签，高亮
        $("a[href='"+currentUrl+"']").css("color","red");
        //找到这个a标签所在的ul列表组，把他显示出来
        $("a[href='"+currentUrl+"']").parent().parent().show();
    });
</script>
