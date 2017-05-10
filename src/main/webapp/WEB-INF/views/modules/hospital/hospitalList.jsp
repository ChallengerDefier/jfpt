<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医院管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/hospital/hospital/">医院列表</a></li>
		<shiro:hasPermission name="hospital:hospital:edit"><li><a href="${ctx}/hospital/hospital/form">医院添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="hospital" action="${ctx}/hospital/hospital/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>医院名称：</label>
				<form:input path="hospitalName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>医院编号：</label>
				<form:input path="hospitalNo" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li>
			<li><label>医院等级：</label>
				<form:select path="level" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('hospitalType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>医院名称</th>
				<th>地址</th>
				<th>医院编号</th>
				<th>医院等级</th>
				<shiro:hasPermission name="hospital:hospital:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="hospital">
			<tr>
				<td><a href="${ctx}/hospital/hospital/form?id=${hospital.id}">
					${hospital.hospitalName}
				</a></td>
				<td>
					${hospital.address}
				</td>
				<td>
					${hospital.hospitalNo}
				</td>
				<td>
					${fns:getDictLabel(hospital.level, 'hospitalType', '')}
				</td>
				<shiro:hasPermission name="hospital:hospital:edit"><td>
    				<a href="${ctx}/hospital/hospital/form?id=${hospital.id}">修改</a>
					<a href="${ctx}/hospital/hospital/delete?id=${hospital.id}" onclick="return confirmx('确认要删除该医院吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>