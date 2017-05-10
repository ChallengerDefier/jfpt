<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>费用设置管理</title>
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
		<li class="active"><a href="${ctx}/feeset/feeSet/">费用设置列表</a></li>
		<shiro:hasPermission name="feeset:feeSet:edit"><li><a href="${ctx}/feeset/feeSet/form">费用设置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="feeSet" action="${ctx}/feeset/feeSet/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>医院名称：</label>
				<form:select path="hospitalId" class="input-xlarge required">
					<form:option value="" label=""/>
					<form:options items="${fns:getHospitalList()}" itemLabel="hospitalName" itemValue="id" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>费用类型：</label>
				<form:select path="feeType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('feeType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>费用类型</th>
				<th>医院收费</th>
				<th>平台提成比例</th>
				<shiro:hasPermission name="feeset:feeSet:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="feeSet">
			<tr>
				<td><a href="${ctx}/feeset/feeSet/form?id=${feeSet.id}">
					${feeSet.hospital.hospitalName}
				</a></td>
				<td>
					${fns:getDictLabel(feeSet.feeType, 'feeType', '')}
				</td>
				<td>
					${feeSet.hospitalFee}
				</td>
				<td>
					${feeSet.scale}
				</td>
				<shiro:hasPermission name="feeset:feeSet:edit"><td>
    				<a href="${ctx}/feeset/feeSet/form?id=${feeSet.id}">修改</a>
					<a href="${ctx}/feeset/feeSet/delete?id=${feeSet.id}" onclick="return confirmx('确认要删除该费用设置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>