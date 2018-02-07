<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>节点信息管理</title>
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
        function confirmDialog(){
			leader = document.getElementById("ip");
            if(leader && leader.value){
                document.getElementById("searchForm").submit();
			}else{
                alert('输入内容不能为空，请确认输入内容！！');
			}
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/node/node/list">节点信息列表</a></li>
		<shiro:hasPermission name="node:node:edit"><li><a href="${ctx}/node/node/form">节点信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="node" action="${ctx}/node/node/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>ip地址：</label>
				<form:input id="ip" path="ip" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="查询" onclick="confirmDialog()"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>ip地址</th>
				<th>端口号</th>
				<th>节点1</th>
				<th>节点2</th>
				<th>文件路径1</th>
				<th>文件路径2</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="node:node:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="node">
			<tr>
				<td><a href="${ctx}/node/node/form?id=${node.id}">
					${node.ip}
				</a></td>
				<td>
					${node.port}
				</td>
				<td>
					${node.nodename1}
				</td>
				<td>
					${node.nodename2}
				</td>
				<td>
					${node.path1}
				</td>
				<td>
					${node.path2}
				</td>
				<td>
					<fmt:formatDate value="${node.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${node.remarks}
				</td>
				<shiro:hasPermission name="node:node:edit"><td>
    				<a href="${ctx}/node/node/form?id=${node.id}">修改</a>
					<a href="${ctx}/node/node/delete?id=${node.id}" onclick="return confirmx('确认要删除该节点信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>