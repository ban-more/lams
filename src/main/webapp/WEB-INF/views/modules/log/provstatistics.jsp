<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>分省数据统计</title>
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
	<li class="active"><a href="${ctx}/log/uploadstaics/list/findUploadByProv">总保单数据统计</a></li>
</ul>
<form:form id="searchForm" modelAttribute="uploadstaics" action="${ctx}/log/uploadstaics/list/findUploadByProv" method="post" class="breadcrumb form-search">
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
		<li class="clearfix"></li>
	</ul>
</form:form>
	<sys:message content="${message}"/>
<c:if test="${not empty prov}">
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th>省机构号</th>
			<th>累计上传件数</th>
			<th>累计上传保费</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${prov}" var="ProvBase">
			<tr>
				<td>${ProvBase.prov}</td>
				<td>${ProvBase.policys}</td>
				<td>${ProvBase.insurance}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>

<div class="pagination">${page}</div>
</body>
</html>