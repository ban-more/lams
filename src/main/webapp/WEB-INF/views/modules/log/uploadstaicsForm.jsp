<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>sss管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/uploadstaics/">sss列表</a></li>
		<li class="active"><a href="${ctx}/sys/uploadstaics/form?id=${uploadstaics.id}">sss<shiro:hasPermission name="sys:uploadstaics:edit">${not empty uploadstaics.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:uploadstaics:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="uploadstaics" action="${ctx}/sys/uploadstaics/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">PRTNUM：</label>
			<div class="controls">
				<form:input path="prtnum" htmlEscape="false" maxlength="40" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">总保费：</label>
			<div class="controls">
				<form:input path="sumprem" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传状态1:成功,0:失败,H:处理中：</label>
			<div class="controls">
				<form:input path="submitlog" htmlEscape="false" maxlength="40" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传来源:1:N3S,2:PAD,3:P3S：</label>
			<div class="controls">
				<form:input path="source" htmlEscape="false" maxlength="1" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">代理人工号：</label>
			<div class="controls">
				<form:input path="agentcode" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">代理人姓名：</label>
			<div class="controls">
				<form:input path="handler" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">设备类型w: web, A: android,I :iPhone,Un:未知：</label>
			<div class="controls">
				<form:input path="devicetype" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传日期：</label>
			<div class="controls">
				<form:input path="makedate" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传时间：</label>
			<div class="controls">
				<form:input path="maketime" htmlEscape="false" maxlength="8" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">销售渠道：</label>
			<div class="controls">
				<form:input path="salechanne" htmlEscape="false" maxlength="40" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">省机构号：</label>
			<div class="controls">
				<form:input path="provBranchNo" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">市机构号：</label>
			<div class="controls">
				<form:input path="cityBranchNo" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">县机构号：</label>
			<div class="controls">
				<form:input path="townBranchNo" htmlEscape="false" maxlength="6" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:uploadstaics:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>