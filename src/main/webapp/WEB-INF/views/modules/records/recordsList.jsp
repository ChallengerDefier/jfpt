<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>阅片记录管理</title>
	<meta name="decorator" content="default"/>
	<style type="text/css">
		.total_bottom{
			position: absolute;
			bottom:0;
			width: 100%;
		}
		#totalTable{
			margin-top: 10px;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出明细数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/records/records/export");
						$("#searchForm").submit();
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
			});
			/* $("#requestHospital.id").change(function(){
				var text = $("#requestHospital.id").find("option[selected=selected]").text();
				alert(text);
			}) */;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               		
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
		var data = ${lineDatas};//图形报表数据
		var total = ${totalRecords}; //合计数据	
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/records/records/">阅片记录列表</a></li>
		<shiro:hasPermission name="records:records:edit"><li><a href="${ctx}/records/records/form">阅片记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="records" action="${ctx}/records/records/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<input id="hospital_name" name="requestHospital.hospitalName" type="hidden" value="" />
		<input id="fee_type" name="feeName" type="hidden" value="" />
		<ul class="ul-form">
			<li>
				<label>医院名称：</label>
				<form:select path="requestHospital.id" class="input-medium required">
					<form:option value="" label=""/>
					<form:options items="${fns:getHospitalList()}" itemLabel="hospitalName" itemValue="id" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>检查类型：</label>
				<form:select path="feeSet.feeType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('feeType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>回传日期：</label>
				<input name="beginBackDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${records.beginBackDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endBackDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${records.endBackDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>阅片专家：</label>
				<form:input path="responseProfessorName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>患者编号：</label>
				<form:input path="patientNo" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>患者姓名：</label>
				<form:input path="patientName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li>
				<label>收入支出：</label>
				<form:radiobuttons path="moneyInOut" items="${fns:getDictList('money_in_out')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<ul class="nav nav-tabs">
		<li class="active">
			<a href="#recordsList" data-toggle="tab">
				明细列表
			</a>
		</li>
		<li><a href="#chartShow" data-toggle="tab">图形报表</a></li>
	</ul>
	<div class="tab-content">
		<!-- 详情列表 -->
		<div id="recordsList" class="tab-pane fade in active">
			<table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>					
						<th>请求阅片日期</th>
						<th>阅片回传日期</th>
						<th>检查类型</th>
						<th>申请阅片医院</th>
						<th>申请阅片专家</th>
						<th>合作中心医院</th>
						<th>合作阅片专家</th>
						<th>诊疗号</th>
						<th>患者编号</th>
						<th>患者姓名</th>
						<th>性别</th>
						<th>患者年龄</th>
						<th>检查部位</th>
						<shiro:hasPermission name="records:records:edit"><th>操作</th></shiro:hasPermission>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.list}" var="records">
					<tr>
						<td>
							<fmt:formatDate value="${records.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<fmt:formatDate value="${records.backDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td><a href="${ctx}/records/records/form?id=${records.id}">
							${fns:getDictLabel(records.feeSet.feeType, 'feeType', '')}
						</a></td>
						<td>
							${records.requestHospital.hospitalName}
						</td>
						<td>
							${records.requestProfessorName}
						</td>
						<td>
							${records.responseHospital.hospitalName}
						</td>
						<td>
							${records.responseProfessorName}
						</td>
						<td>
							${records.treatmentNo}
						</td>
						<td>
							${records.patientNo}
						</td>
						<td>
							${records.patientName}
						</td>
						<td>
							${fns:getDictLabel(records.sex,"sex","")}
						</td>
						<td>
							${records.patientAge}
						</td>
						<td>
							${records.checkContent}
						</td>
						<shiro:hasPermission name="records:records:edit"><td>
		    				<a href="${ctx}/records/records/form?id=${records.id}">修改</a>
							<a href="${ctx}/records/records/delete?id=${records.id}" onclick="return confirmx('确认要删除该阅片记录吗？', this.href)">删除</a>
						</td></shiro:hasPermission>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="pagination">${page}</div>
			<!-- 合计 -->
			<div class="total_bottom">
			    <span>合计：</span>
				<table id="totalTable" class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>记录数</th>
							<th>CR/DR</th>
							<th>CT</th>
							<th>MR</th>
							<th>BC</th>
							<th>MG</th>
							<th>NJ</th>
							<th>心电</th>
							<th>医院收入</th>
							<th>医院支出</th>
							<th>平台收入</th>
						</tr>
					</thead>
					<tbody>
				
					</tbody>
				</table>
			</div>
		</div>
		<!-- 图形报表 -->
		<div id="chartShow" class="tab-pane fade">
			<!-- 柱状图 -->
			<div id="bar_chart" style="width: 800px;height:400px;"></div>
		    <!-- 饼状图 -->
		    <div id="pie_chart" style="width: 800px;height:400px;"></div>
		    <!-- 折线图 -->
		    <div id="line_chart" style="width: 800px;height:400px;"></div>    
		</div>
	</div>
	<script type="text/javascript">
		var shtml = "<tr><td>"+total.recordsCount+"</td><td>"+total.crCount+"</td><td>"+total.ctCount+"</td>\
		<td>"+total.mrCount+"</td><td>"+total.bcCount+"</td><td>"+total.mgCount+"</td><td>"+total.njCount+"</td>\
		<td>"+total.xdCount+"</td><td>"+total.hospitalIn+"</td><td>"+total.hospitalOut+"</td><td>"+total.platformFee+"</td></tr>";
		$("#totalTable").find("tbody").append(shtml);
	</script>
	<script type="text/javascript" src="${ctxStatic}/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/echarts/my_chart.js"></script>	
</body>
</html>
