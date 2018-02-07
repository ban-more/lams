<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>日志管理</title>
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
	<script type="text/javascript">
        function validate() {
            document.getElementById("searchLogForm").submit();
        }
	</script>
</head>
<body>
<ul class="nav nav-tabs">
	<li class="active"><a href="${ctx}/log/log/list/detalis">日志详情</a></li>
</ul>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><tr>
		<th>服务器ip</th>
		<th>端口号</th>
		<th>节点名</th>
		<th>关键字</th>
		<th>文件名</th>
	</tr></thead>
	<tbody>
		<tr>
			<td>${log1.node.ip }</td>
			<td>${log1.node.port }</td>
			<td>${log1.nodename }</td>
			<td>${log1.keyword }</td>
			<td>${log1.filename }</td>
		</tr>
	</tbody>
</table>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><tr>
		<th>行数及信息</th>
	</tr></thead>
	<tbody>
		<tr>
			<td><c:forEach items="${log1.messages}" var="maps">
				${maps.key } | ${maps.value }<br>
			</c:forEach></td>
		</tr>
	</tbody>
</table>
</body>
</html>
