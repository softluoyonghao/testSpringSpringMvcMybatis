	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="/WEB-INF/pages/common/taglib.jsp" %>
    <!--${status.index}输出行号，从0开始, varStatus="status" 这个属性就是对行号做处理 -->
	<c:forEach var="content" varStatus="contentindex" items="${datas}">
		<tr>
				<td>${content.id}
				<c:if test="${contentindex.index==0}"><input type="hidden" id="count" value="${count}"></c:if>
				</td>	
				<td>${content.title}</td>
				<td>${content.userId}</td>
				<td>${tz:formatDate(content.createTime,'yyyy-MM-dd HH:mm:ss')}</td>	
				<td>${tz:formatDate(content.updateTime,'yyyy-MM-dd HH:mm:ss')}</td>	
				<td>${content.isTop}</td>	
				<td>${content.isDelete}</td>	
				<td>${content.status}</td>	
				<td>${content.channelId}</td>	
				<td>${content.isComment}</td>
				<td><a href="javascript:void(0);">未删除</a></td>
			</tr>
	 	 </c:forEach>