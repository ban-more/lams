<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保单数据统计</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/amazeui.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/core.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/menu.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/index.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/admin.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/page/typography.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/page/form.css" />
	<meta name="decorator" content="default"/>
	<style>
		body{ text-align:center;overflow-y:auto;overflow-x:hidden;}
		#divcss6{margin-top:50px;}
		#divcss5{margin-top:100px;}
	</style>
</head>
<body>
<header class="am-topbar am-topbar-fixed-top">
	<div class="contain">
		<ul class="am-nav am-navbar-nav am-navbar-left">

			<li><h4 class="page-title">上传数据统计<hr /></h4></li>

		</ul>
	</div>
</header>

<div id="divcss5" class="content-page">
	<!-- Start content -->
	<div class="content">
		<div class="am-g">
			<div class="am-u-sm-6">
				<div class="card-box">
					<!-- col start -->
					<table class="am-table">
						<thead>
						<tr>
							<th>月份</th>
							<th>累计上传件数</th>
							<th>累计上传保费</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${mulds}" var="base">
							<tr>
								<td>${base.dat}</td>
								<td>${base.policys}</td>
								<td>${base.insurance}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<!-- col end -->
				</div>
			</div>
			<div  class="am-u-md-6">
				<div class="card-box">
					<table class="am-table am-table-striped">
						<thead>
							<tr>
								<th>日期</th>
								<th>累计上传件数</th>
								<th>累计上传保费</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${dulds}" var="base">
							<tr>
								<td>${base.dat}</td>
								<td>${base.policys}</td>
								<td>${base.insurance}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="am-g">
			<div class="am-u-sm-6">
				<div class="card-box">
					<!-- col start -->
					<table class="am-table  am-table-hover">
						<thead>
						<tr>
							<th>时间</th>
							<th>累计上传件数</th>
							<th>累计上传保费</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${hulds}" var="base">
							<tr>
								<td>${base.dat}</td>
								<td>${base.policys}</td>
								<td>${base.insurance}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<!-- col end -->
				</div>
			</div>
			<!-- Row end -->
		</div>
		</div>
	</div>
</div>
	</body>
</html>