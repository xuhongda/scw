<%--
  Created by IntelliJ IDEA.
  User: xuhongda
  Date: 2017/11/10
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tfoot>
<tr>
    <td colspan="6" align="center">
        <ul class="pagination">
            <c:choose>
                <c:when test="${pageInfo.pageNum==1}">
                    <li class="disabled"><a href="${pageUrl}?pn=${pageInfo.prePage}">上一页</a></li>
                </c:when>
                <c:when test="${pageInfo.pageNum!=1}">
                    <li><a href="${pageUrl}?pn=1">首页</a></li>
                    <li><a href="${pageUrl}?pn=${pageInfo.prePage}">上一页</a></li>
                </c:when>
            </c:choose>
            <c:forEach items="${pageInfo.navigatepageNums}" var="pn">
                <c:if test="${pageInfo.pageNum==pn}">
                    <li class="active"><a href="${pageUrl}?pn=${pn}">${pn}<span class="sr-only">(current)</span></a>
                    </li>
                </c:if>
                <c:if test="${pageInfo.pageNum!=pn}">
                    <li><a href="${pageUrl}?pn=${pn}">${pn}</a></li>
                </c:if>
            </c:forEach>
            <c:choose>
                <c:when test="${pageInfo.pageNum==pageInfo.pages}">
                    <li class="disabled"><a href="${pageUrl}?pn=${pageInfo.nextPage}">下一页</a></li>
                </c:when>
                <c:when test="${pageInfo.pageNum!=pageInfo.pages}">
                    <li><a href="${pageUrl}?pn=${pageInfo.nextPage}">下一页</a></li>
                    <li><a href="${pageUrl}?pn=${pageInfo.total}">尾页</a></li>
                </c:when>
            </c:choose>
            <li class="disabled"><a href="#">共有${pageInfo.pages}页，共${pageInfo.total}条记录</a> </li>
        </ul>
    </td>
</tr>
</tfoot>
