<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>小时据查询</title>
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
	<li class="active"><a href="${ctx}/log/uploadstaics/list/findUploadByHour">基础数据</a></li>
</ul>
<form:form id="searchForm" modelAttribute="uploadstaics" action="${ctx}/log/uploadstaics/list/findUploadByHour" method="post" class="breadcrumb form-search">
	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
	<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	<ul class="ul-form">
		<li><label>日期：</label>
			<input name="date1" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
				<%--value="<fmt:formatDate value="" pattern="yyyy-MM-dd HH:mm:ss"/>"--%>
				   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
		</li>
		<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
		<li class="clearfix"></li>
	</ul>
</form:form>
<sys:message content="${message}"/>
<c:if test="${not empty ulds}">
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th>时间</th>
			<th>累计上传件数</th>
			<th>累计上传保费</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${ulds}" var="base">
			<tr>
				<td>${base.dat}</td>
				<td>${base.policys}</td>
				<td>${base.insurance}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">10</div>
</c:if>
</body>
</html>