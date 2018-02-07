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
	</script>
	<script type="text/javascript">
        var checkedAll = false;
        function selectAll(formName,checkboxName){
            var form = document.all.item(formName);
            var elements = form.elements[checkboxName];
            for (var i=0;i<elements.length;i++){
                var e = elements[i];
                if(checkedAll){
                    e.checked = false;
                    form.alls.checked = false;
                } else {
                    e.checked = true;
                    form.alls.checked = true;
                }
            }
            if(checkedAll){
                checkedAll = false;
            } else {
                checkedAll = true;
            }
        }
        function checkAll(formName,checkboxName){
            var hasCheck = false;
            var form = document.all.item(formName);
            var elements = form.elements[checkboxName];
            for (var i=0;i<elements.length;i++){
                var e = elements[i];
                if(e.checked){
                    hasCheck = true;
                }
            }
            return hasCheck;
        }
        function do_action(){
            if (!checkAll("formName","no")){
                alert("没有checkbox被选中，提示用户至少选择一个！");
            } else {
                validate();
            }
        }
        function validate() {
            document.getElementById("checkNodeForm").submit();
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/log/node/check">选取节点</a></li>
	</ul>
	<sys:message content="${message}"/>
	<form:form id="checkNodeForm" name="nodeCheck" action="${ctx}/node/node/chuancan" method="post" class="breadcrumb form-search">
		<%--<input id="ip" name="ip" type="hidden" value="${node.ip}"/>--%>
		<%--<input id="port" name="port" type="hidden" value="${node.port}"/>--%>
		<%--<input id="username" name="username" type="hidden" value="${node.username}"/>--%>
		<%--<input id="password" name="password" type="hidden" value="${node.password}"/>--%>
		<%--<input id="nodename1" name="nodename1" type="hidden" value="${node.nodename1}"/>--%>
		<%--<input id="nodename2" name="nodename2" type="hidden" value="${node.nodename2}"/>--%>
		<%--<input id="path1" name="path1" type="hidden" value="${node.path1}"/>--%>
		<%--<input id="path2" name="path2" type="hidden" value="${node.path2}"/>--%>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th><input type="checkbox" name="alls" onClick="selectAll('nodeCheck','nodeids')" title="全选/取消全选"></th>
				<th>ip地址</th>
				<th>端口号</th>
				<th>节点1</th>
				<th>节点2</th>
				<th>文件路径1</th>
				<th>文件路径2</th>
				<th>更新时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="node" varStatus="status">
			<tr>
				<td>
					<input name="nodeids" type="checkbox" value=${node.id}>
				</td>
				<td>
					${node.ip}
				</td>
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
				<%--<td>--%>
					<%--${node.remarks}--%>
				<%--</td>--%>

		</c:forEach>

		</tbody>
	</table>
		<%--<input type="button" name="actionButton" value="提交" onClick="do_action()"/>--%>
		<input type="submit" value="提交" />
	</form:form>
	<div class="pagination">${page}</div>
</body>
</html>