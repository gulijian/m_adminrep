<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="permission" varStatus="permissionindex" items="${datas}">
	<tr>
		<td>
			${permission.id}
			<c:if test="${permissionindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${permission.name}</td>	
		<td>${permission.userId}</td>	
		<td class="tmui-tips" tip="${gu:formatDate(permission.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${gu:timeFormat(permission.createTime)}
		</td>	
		<td>
			<gu:if test="${permission.isDelete==0}">
				<gu:then><a href="javascript:void(0)" opid="${permission.id}" mark="isDelete" val="1" onclick="guAdmin.op(this);" class="red">否</a></gu:then>
				<gu:else><a href="javascript:void(0)" opid="${permission.id}" mark="isDelete" val="0" onclick="guAdmin.op(this);" class="green">是</a></gu:else>
			</gu:if>	
		</td>	
		<td>
			<gu:if test="${permission.status==0}">
				<gu:then><a href="javascript:void(0)" opid="${permission.id}" mark="status" val="1" onclick="guAdmin.op(this);" class="red">否</a></gu:then>
				<gu:else><a href="javascript:void(0)" opid="${permission.id}" mark="status" val="0" onclick="guAdmin.op(this);" class="green">是</a></gu:else>
			</gu:if>	
		</td>	
		<td><a href="javascript:void(0);">未删除</a></td>
	</tr>
</c:forEach>
