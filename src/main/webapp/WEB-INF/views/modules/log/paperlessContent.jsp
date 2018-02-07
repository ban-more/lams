<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>asdasd管理</title>
	<meta name="decorator" content="default"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/amazeui.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/core.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/menu.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/index.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/admin.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/page/typography.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/page/form.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/component.css" />
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
	<style>
		#divcss5{margin-top:100px;}
		#divcss6{border-bottom:2px solid #8e8e8e;color: black;height: 100px;width: auto;font-size: 20px;}
	</style>
</head>
<body>
<header>
<div id="divcss6" >
	<div style="margin-top:15px;margin-left: 15px">
		无纸化数据
	</div>
</div>
</header>
<div class="am-g">
	<!-- Row start -->
	<div class="am-u-md-3">
		<div class="card-box">
			<h4 class="header-title m-t-0 m-b-30">省份</h4>
			<div class="widget-chart-1 am-cf">
				<div id="widget-chart-box-1" style="height: 110px;width: 110px;float: left;">
				</div>

				<div class="widget-detail-1" style="float: right;">
					<h2 class="p-t-10 m-b-0"> ${paperlessContent.paperlessProvinces} </h2>
					<p class="text-muted">无纸化数据</p>
				</div>
			</div>
		</div>
	</div>
	<div class="am-u-md-3">
		<div class="card-box">
			<h4 class="header-title m-t-0 m-b-30">用户数</h4>
			<div class="widget-chart-1 am-cf">
				<div id="widget-chart-box-2" style="height: 110px;width: 110px;float: left;">
				</div>

				<div class="widget-detail-1" style="float: right;">
					<h2 class="p-t-10 m-b-0"> ${paperlessContent.paperlessUsers} </h2>
					<p class="text-muted">无纸化数据</p>
				</div>
			</div>
		</div>
	</div>
	<div class="am-u-md-3">
		<div class="card-box">
			<h4 class="header-title m-t-0 m-b-30">分支机构</h4>
			<div class="widget-chart-1 am-cf">
				<div id="widget-chart-box-3" style="height: 110px;width: 110px;float: left;">
				</div>

				<div class="widget-detail-1" style="float: right;">
					<h2 class="p-t-10 m-b-0"> ${paperlessContent.paperlessBranches} </h2>
					<p class="text-muted">无纸化数据</p>
				</div>
			</div>
		</div>
	</div>

	<!-- Row end -->
</div>
</body>
</html>