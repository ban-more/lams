<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>asdasd管理</title>
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
		<li><a href="${ctx}/sys/formlsAsyncStatus/">asdasd列表</a></li>
		<li class="active"><a href="${ctx}/sys/formlsAsyncStatus/form?id=${formlsAsyncStatus.id}">asdasd<shiro:hasPermission name="sys:formlsAsyncStatus:edit">${not empty formlsAsyncStatus.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:formlsAsyncStatus:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="formlsAsyncStatus" action="${ctx}/sys/formlsAsyncStatus/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">投保单流水号：</label>
			<div class="controls">
				<form:input path="prtnum" htmlEscape="false" maxlength="40" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务员工号：</label>
			<div class="controls">
				<form:input path="salesmenNo" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">省机构号：</label>
			<div class="controls">
				<form:input path="manageCom" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属机构：</label>
			<div class="controls">
				<form:input path="saleCode" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">渠道：</label>
			<div class="controls">
				<form:input path="saleChannel" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投保单pdf状态0-没有生成，1-已生成：</label>
			<div class="controls">
				<form:input path="insuredPdfStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投保单tiff状态0-没有生成，1-已生成：</label>
			<div class="controls">
				<form:input path="insuredTiffStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务员告知书pdf状态0-没有生成，1-已生成：</label>
			<div class="controls">
				<form:input path="informPdfStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务员告知书tiff状态0-没有生成，1-已生成：</label>
			<div class="controls">
				<form:input path="informTiffStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">影像关联状态，0-失败，1-成功：</label>
			<div class="controls">
				<form:input path="associationStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">批量注册状态，0-失败，1-成功：</label>
			<div class="controls">
				<form:input path="registerStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审核状态，0-失败，1-成功：</label>
			<div class="controls">
				<form:input path="checkStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建时间：</label>
			<div class="controls">
				<input name="createdTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${formlsAsyncStatus.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">更新时间：</label>
			<div class="controls">
				<input name="updatedTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${formlsAsyncStatus.updatedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投保单号：</label>
			<div class="controls">
				<form:input path="insuredNos" htmlEscape="false" maxlength="512" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">投保单tiff页数：</label>
			<div class="controls">
				<form:input path="tiffPages" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">废弃影像件删除状态：</label>
			<div class="controls">
				<form:input path="deleteStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">need_tips_pdf：</label>
			<div class="controls">
				<form:input path="needTipsPdf" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">tips_pdf_status：</label>
			<div class="controls">
				<form:input path="tipsPdfStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">need_auth_pdf：</label>
			<div class="controls">
				<form:input path="needAuthPdf" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">auth_pdf_status：</label>
			<div class="controls">
				<form:input path="authPdfStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">人身投保提示书tiff状态，0-失败，1-成功：</label>
			<div class="controls">
				<form:input path="tipsTiffStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">未成年人投保授权书tiff状态，0-失败，1-成功：</label>
			<div class="controls">
				<form:input path="authTiffStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">重庆需求问卷tiff状态，0-失败，1-成功：</label>
			<div class="controls">
				<form:input path="questionnaireTiffStatus" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sys:formlsAsyncStatus:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>