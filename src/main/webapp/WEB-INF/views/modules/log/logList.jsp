<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
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
        function checkn(){
            node = document.getElementById("nodeids");
            keyword = document.getElementById("kw");
            if(keyword && keyword.value) {
                if (node && node.value) {
                    document.getElementById("searchForm").submit();
                } else {
                    if (confirm("还未添加节点，是否使用默认查询全部服务器节点？")) {
                        document.getElementById("searchForm").submit();
                    }
                }
            }else{
                alert('关键字不能为空，请输入内容！');
			}
        }
	</script>
	<script type="text/javascript">
        function validate(index,line) {
            if(line != 0) {
                document.getElementById("searchLogForm" + index).submit();
            }else{
                alert('未查到日志信息，无法查看详细信息');
			}
        }
	</script>
</head>
<body>
<ul class="nav nav-tabs">
	<li class="active"><a href="${ctx}/log/log/list">日志列表</a></li>
</ul>
<%--<%String nodeids[] = request.getParameterValues("nodeid");%>--%>
<form:form id="searchForm" action="${ctx}/log/log/list/bynew" method="post" class="breadcrumb form-search">
<ul class="ul-form">
	<li><label>关键字：</label>
		<input id="kw" name="keyword" type="text" maxlength="100" class="input-medium"/>
	</li>
	<li><label>日期：</label>
		<input name="date" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
			   <%--value="<fmt:formatDate value="" pattern="yyyy-MM-dd HH:mm:ss"/>"--%>
			   onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
	</li>
	<c:forEach items="${nodeids}" var="nodeids" varStatus="status">
	<input id="nodeids" name="nodeids" type="hidden" value="${nodeids}"/>
	</c:forEach>
	<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="button" value="查询" onclick="checkn()"/></li>

	<c:if test="${empty nodeids}">
		<li style="text-align:right">
		<%--<a href="${ctx}/node/node/check">添加节点</a>--%>
		<li class="btns"><input type="button" onclick="window.location.href='${ctx}/node/node/check'"style="color: #0bbbee" class="searchbut" value="添加节点"></li>
		</li>
	</c:if>
</ul>

</form:form>
<%--<%--%>
	<%--boolean flag =true;--%>
	<%--if(nodeids != null){--%>
     <%--flag = false;--%>
<%--}%>--%>

<%--<c:otherwise>--%>
<%--</c:otherwise>--%>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead><tr>
		<shiro:hasPermission name="log:log:view">
		<th>服务器ip</th>
		<th>端口号</th>
		<th>节点名</th>
		<th>关键字</th>
		<th>文件名</th>
		<th>行数</th>
		<th>信息</th>
		<%--<shiro:hasPermission name="log:log:view"><th>操作</th></shiro:hasPermission>--%>
		</shiro:hasPermission>
	</tr></thead>
	<tbody>
	<c:forEach items="${logs}" var="log" varStatus="status">

		<tr>
			<td>${log.node.ip }</td>
			<td>${log.node.port }</td>
			<td>${log.nodename }</td>
			<td>${log.keyword }</td>
			<td>${log.filename }</td>
			<form:form id="searchLogForm${status.index }" modelAttribute="log" action="${ctx}/log/log/list/detalis" method="post" class="breadcrumb form-search">
				<input id="node.ip" name="node.ip" type="hidden" value="${log.node.ip}"/>
				<input id="node.port" name="node.port" type="hidden" value="${log.node.port}"/>
				<input id="node.username" name="node.username" type="hidden" value="${log.node.username}"/>
				<input id="node.password" name="node.password" type="hidden" value="${log.node.password}"/>
				<input id="nodename" name="nodename" type="hidden" value="${log.nodename}"/>
				<input id="keyword" name="keyword" type="hidden" value="${log.keyword}"/>
				<input id="keyword" name="filename" type="hidden" value="${log.filename}"/>

			<c:forEach var="maps" items="${log.messages}">
				<%--<td>${maps.key}</td>--%>
				<input id="line" name="line" type="hidden" value="${maps.key}"/>
					<%--<td><a href="JavaScript:validate(${status.index })">${maps.key }</a></td>--%>
					<%--<td><a href="JavaScript:validate(${status.index })">${maps.value }</a></td>--%>
				<c:choose>
					<c:when test = "${maps.key ==0}"><td>null</td>
						<td>${maps.value }</td></c:when>
					<c:otherwise><td><a href="JavaScript:validate(${status.index })">${maps.key }</a></td>
						<td><a href="JavaScript:validate(${status.index })">${maps.value }</a></td></c:otherwise>
				</c:choose>
			</c:forEach>
			</form:form>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
