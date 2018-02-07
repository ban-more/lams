<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>无纸化数据统计</title>
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
		<li class="active"><a href="${ctx}/log/formlsAsyncStatus/list/findPaperless">无纸化数据</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="formlsAsyncStatus" action="${ctx}/log/formlsAsyncStatus/list/findPaperless" method="post" class="breadcrumb form-search">
		<ul class="ul-form">
			<li><label>起始日期：</label>
				<input name="date1" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					<%--value="<fmt:formatDate value="" pattern="yyyy-MM-dd HH:mm:ss"/>"--%>
					   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li><label>截止日期：</label>
				<input name="date2" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					<%--value="<fmt:formatDate value="" pattern="yyyy-MM-dd HH:mm:ss"/>"--%>
					   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li><label>省份：</label>
				${paperlessContent.paperlessProvinces}
				<label>分支机构：</label>
				${paperlessContent.paperlessBranches}
				<label>用户数：</label>
				${paperlessContent.paperlessUsers}
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<c:if test="${not empty paperless}">
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>#</th>
					<th>统计类型</th>
					<th>数目</th>
					<th>日期</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<th scope="row">1</th>
				<td>总保费</td>
				<td>${paperless.insuranceFee}</td>
				<td>${date}</td>
			</tr>
			<tr>
				<th scope="row">2</th>
				<td>总保单</td>
				<td>${paperless.sumInsurance}</td>
				<td>${date}</td>
			</tr>
			<tr>
				<th scope="row">3</th>
				<td>出单人次</td>
				<td>${paperless.insuranceNop}</td>
				<td>${date}</td>
			</tr>
			</tbody>
		</table>
	</c:if>
	<div class="pagination">${page}</div>
</body>
</html>