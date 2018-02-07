/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * fdfdfEntity
 * @author wangzhenwei
 * @version 2018-01-12
 */
public class FormlsAsyncStatus extends DataEntity<FormlsAsyncStatus> {
	
	private static final long serialVersionUID = 1L;
	private String prtnum;		// 投保单流水号
	private String salesmenNo;		// 业务员工号
	private String manageCom;		// 省机构号
	private String saleCode;		// 所属机构
	private String saleChannel;		// 渠道
	private String insuredPdfStatus;		// 投保单pdf状态0-没有生成，1-已生成
	private String insuredTiffStatus;		// 投保单tiff状态0-没有生成，1-已生成
	private String informPdfStatus;		// 业务员告知书pdf状态0-没有生成，1-已生成
	private String informTiffStatus;		// 业务员告知书tiff状态0-没有生成，1-已生成
	private String associationStatus;		// 影像关联状态，0-失败，1-成功
	private String registerStatus;		// 批量注册状态，0-失败，1-成功
	private String checkStatus;		// 审核状态，0-失败，1-成功
	private Date createdTime;		// 创建时间
	private Date updatedTime;		// 更新时间
	private String insuredNos;		// 投保单号
	private String tiffPages;		// 投保单tiff页数
	private String deleteStatus;		// 废弃影像件删除状态
	private String needTipsPdf;		// need_tips_pdf
	private String tipsPdfStatus;		// tips_pdf_status
	private String needAuthPdf;		// need_auth_pdf
	private String authPdfStatus;		// auth_pdf_status
	private String tipsTiffStatus;		// 人身投保提示书tiff状态，0-失败，1-成功
	private String authTiffStatus;		// 未成年人投保授权书tiff状态，0-失败，1-成功
	private String questionnaireTiffStatus;		// 重庆需求问卷tiff状态，0-失败，1-成功
	
	public FormlsAsyncStatus() {
		super();
	}

	public FormlsAsyncStatus(String id){
		super(id);
	}

	@Length(min=1, max=40, message="投保单流水号长度必须介于 1 和 40 之间")
	public String getPrtnum() {
		return prtnum;
	}

	public void setPrtnum(String prtnum) {
		this.prtnum = prtnum;
	}
	
	@Length(min=0, max=20, message="业务员工号长度必须介于 0 和 20 之间")
	public String getSalesmenNo() {
		return salesmenNo;
	}

	public void setSalesmenNo(String salesmenNo) {
		this.salesmenNo = salesmenNo;
	}
	
	@Length(min=0, max=10, message="省机构号长度必须介于 0 和 10 之间")
	public String getManageCom() {
		return manageCom;
	}

	public void setManageCom(String manageCom) {
		this.manageCom = manageCom;
	}
	
	@Length(min=0, max=10, message="所属机构长度必须介于 0 和 10 之间")
	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}
	
	@Length(min=0, max=10, message="渠道长度必须介于 0 和 10 之间")
	public String getSaleChannel() {
		return saleChannel;
	}

	public void setSaleChannel(String saleChannel) {
		this.saleChannel = saleChannel;
	}
	
	@Length(min=0, max=2, message="投保单pdf状态0-没有生成，1-已生成长度必须介于 0 和 2 之间")
	public String getInsuredPdfStatus() {
		return insuredPdfStatus;
	}

	public void setInsuredPdfStatus(String insuredPdfStatus) {
		this.insuredPdfStatus = insuredPdfStatus;
	}
	
	@Length(min=0, max=2, message="投保单tiff状态0-没有生成，1-已生成长度必须介于 0 和 2 之间")
	public String getInsuredTiffStatus() {
		return insuredTiffStatus;
	}

	public void setInsuredTiffStatus(String insuredTiffStatus) {
		this.insuredTiffStatus = insuredTiffStatus;
	}
	
	@Length(min=0, max=2, message="业务员告知书pdf状态0-没有生成，1-已生成长度必须介于 0 和 2 之间")
	public String getInformPdfStatus() {
		return informPdfStatus;
	}

	public void setInformPdfStatus(String informPdfStatus) {
		this.informPdfStatus = informPdfStatus;
	}
	
	@Length(min=0, max=2, message="业务员告知书tiff状态0-没有生成，1-已生成长度必须介于 0 和 2 之间")
	public String getInformTiffStatus() {
		return informTiffStatus;
	}

	public void setInformTiffStatus(String informTiffStatus) {
		this.informTiffStatus = informTiffStatus;
	}
	
	@Length(min=0, max=2, message="影像关联状态，0-失败，1-成功长度必须介于 0 和 2 之间")
	public String getAssociationStatus() {
		return associationStatus;
	}

	public void setAssociationStatus(String associationStatus) {
		this.associationStatus = associationStatus;
	}
	
	@Length(min=0, max=2, message="批量注册状态，0-失败，1-成功长度必须介于 0 和 2 之间")
	public String getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}
	
	@Length(min=0, max=2, message="审核状态，0-失败，1-成功长度必须介于 0 和 2 之间")
	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	@Length(min=0, max=512, message="投保单号长度必须介于 0 和 512 之间")
	public String getInsuredNos() {
		return insuredNos;
	}

	public void setInsuredNos(String insuredNos) {
		this.insuredNos = insuredNos;
	}
	
	@Length(min=0, max=10, message="投保单tiff页数长度必须介于 0 和 10 之间")
	public String getTiffPages() {
		return tiffPages;
	}

	public void setTiffPages(String tiffPages) {
		this.tiffPages = tiffPages;
	}
	
	@Length(min=0, max=2, message="废弃影像件删除状态长度必须介于 0 和 2 之间")
	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	@Length(min=0, max=2, message="need_tips_pdf长度必须介于 0 和 2 之间")
	public String getNeedTipsPdf() {
		return needTipsPdf;
	}

	public void setNeedTipsPdf(String needTipsPdf) {
		this.needTipsPdf = needTipsPdf;
	}
	
	@Length(min=0, max=2, message="tips_pdf_status长度必须介于 0 和 2 之间")
	public String getTipsPdfStatus() {
		return tipsPdfStatus;
	}

	public void setTipsPdfStatus(String tipsPdfStatus) {
		this.tipsPdfStatus = tipsPdfStatus;
	}
	
	@Length(min=0, max=2, message="need_auth_pdf长度必须介于 0 和 2 之间")
	public String getNeedAuthPdf() {
		return needAuthPdf;
	}

	public void setNeedAuthPdf(String needAuthPdf) {
		this.needAuthPdf = needAuthPdf;
	}
	
	@Length(min=0, max=2, message="auth_pdf_status长度必须介于 0 和 2 之间")
	public String getAuthPdfStatus() {
		return authPdfStatus;
	}

	public void setAuthPdfStatus(String authPdfStatus) {
		this.authPdfStatus = authPdfStatus;
	}
	
	@Length(min=0, max=2, message="人身投保提示书tiff状态，0-失败，1-成功长度必须介于 0 和 2 之间")
	public String getTipsTiffStatus() {
		return tipsTiffStatus;
	}

	public void setTipsTiffStatus(String tipsTiffStatus) {
		this.tipsTiffStatus = tipsTiffStatus;
	}
	
	@Length(min=0, max=2, message="未成年人投保授权书tiff状态，0-失败，1-成功长度必须介于 0 和 2 之间")
	public String getAuthTiffStatus() {
		return authTiffStatus;
	}

	public void setAuthTiffStatus(String authTiffStatus) {
		this.authTiffStatus = authTiffStatus;
	}
	
	@Length(min=0, max=2, message="重庆需求问卷tiff状态，0-失败，1-成功长度必须介于 0 和 2 之间")
	public String getQuestionnaireTiffStatus() {
		return questionnaireTiffStatus;
	}

	public void setQuestionnaireTiffStatus(String questionnaireTiffStatus) {
		this.questionnaireTiffStatus = questionnaireTiffStatus;
	}
	
}