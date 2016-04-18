<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="adminstat" varStatus="adminstatindex" items="${datas}">
	<tr>
		<td>
			${adminstat.id}
			<c:if test="${adminstatindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${adminstat.name}</td>	
		<td>${adminstat.userId}</td>	
		<td class="tmui-tips" tip="${gu:formatDate(adminstat.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${gu:timeFormat(adminstat.createTime)}
		</td>	
		<td>
			<tz:if test="${adminstat.isDelete==0}">
				<tz:then><a href="javascript:void(0)" opid="${adminstat.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${adminstat.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${adminstat.status==0}">
				<tz:then><a href="javascript:void(0)" opid="${adminstat.id}" mark="status" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${adminstat.id}" mark="status" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);">未删除</a></td>
	</tr>
</c:forEach>
