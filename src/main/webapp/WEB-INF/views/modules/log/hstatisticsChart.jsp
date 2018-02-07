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
	<script src="${pageContext.request.contextPath}/static/assets/js/charts/echarts.min.js"></script>
</head>
<body>
<ul class="nav nav-tabs">
	<li class="active"><a href="${ctx}/log/uploadstaics/list/findLineChartByHour">图表展示</a></li>
</ul>
<form:form id="searchForm" modelAttribute="uploadstaics" action="${ctx}/log/uploadstaics/list/findLineChartByHour" method="post" class="breadcrumb form-search">
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
<div style="height: 400px;width: 1200px;">
	<div id="main" style="height:400px;width: 600px;float:left"></div>
	<div id="main1" style="height:400px;width: 600px;float:left"></div>
</div>
<div style="height: 400px;width: 1200px;">
	<div id="main2" style="height:400px;width: 600px;float:left"></div>
	<div id="main3" style="height:400px;width: 600px;float:left"></div>
</div>
	<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '保单上传统计'
            },
            tooltip: {formatter: '{a0}:{c0}'},
            legend: {
                data:['件数']
            },
            xAxis: {
                data: ${map.dat},
				name:["小时"]
            },
            yAxis: {
                name:["件数"]
			},
            series: [{
                name: '件数',
                type: 'bar',
                data: ${map.policys}
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
	</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main2'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '保单上传统计'
        },
        tooltip: {formatter: '{a0}:{c0}'},
        legend: {
            data:['件数']
        },
        xAxis: {
            data: ${map.dat},
            name:["小时"]
        },
        yAxis: {
            name:["件数"]
        },
        series: [{
            name: '件数',
            type: 'line',
            data: ${map.policys}
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '保费统计'
        },
        tooltip: { formatter: '{a0}:{c0}'},
        legend: {
            data:['保费']
        },
        xAxis: {
            data: ${map.dat},
			name: ["小时"]
        },
        yAxis: {
            name:["万元"]
		},
        series: [{
            name: '保费',
            type: 'bar',
            data: ${map.insurance}
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main3'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '保费统计'
        },
        tooltip: { formatter: '{a0}:{c0}'},
        legend: {
            data:['保费']
        },
        xAxis: {
            data: ${map.dat},
            name: ["小时"]
        },
        yAxis: {
            name:["万元"]
        },
        series: [{
            name: '保费',
            type: 'line',
            data: ${map.insurance}
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>