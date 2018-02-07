/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * daEntity
 * @author wangzhenwei
 * @version 2018-01-11
 */
public class Uploadstaics extends DataEntity<Uploadstaics> {
	
	private static final long serialVersionUID = 1L;
	private String prtnum;		// PRTNUM
	private String sumprem;		// 总保费
	private String submitlog;		// 上传状态1:成功,0:失败,H:处理中
	private String source;		// 上传来源:1:N3S,2:PAD,3:P3S
	private String agentcode;		// 代理人工号
	private String handler;		// 代理人姓名
	private String devicetype;		// 设备类型w: web, A: android,I :iPhone,Un:未知
	private String makedate;		// 上传日期
	private String maketime;		// 上传时间
	private String salechanne;		// 销售渠道
	private String provBranchNo;		// 省机构号
	private String cityBranchNo;		// 市机构号
	private String townBranchNo;		// 县机构号
	
	public Uploadstaics() {
		super();
	}

	public Uploadstaics(String id){
		super(id);
	}

	@Length(min=0, max=40, message="PRTNUM长度必须介于 0 和 40 之间")
	public String getPrtnum() {
		return prtnum;
	}

	public void setPrtnum(String prtnum) {
		this.prtnum = prtnum;
	}
	
	@Length(min=0, max=20, message="总保费长度必须介于 0 和 20 之间")
	public String getSumprem() {
		return sumprem;
	}

	public void setSumprem(String sumprem) {
		this.sumprem = sumprem;
	}
	
	@Length(min=0, max=40, message="上传状态1:成功,0:失败,H:处理中长度必须介于 0 和 40 之间")
	public String getSubmitlog() {
		return submitlog;
	}

	public void setSubmitlog(String submitlog) {
		this.submitlog = submitlog;
	}
	
	@Length(min=0, max=1, message="上传来源:1:N3S,2:PAD,3:P3S长度必须介于 0 和 1 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=20, message="代理人工号长度必须介于 0 和 20 之间")
	public String getAgentcode() {
		return agentcode;
	}

	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}
	
	@Length(min=0, max=30, message="代理人姓名长度必须介于 0 和 30 之间")
	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}
	
	@Length(min=0, max=10, message="设备类型w: web, A: android,I :iPhone,Un:未知长度必须介于 0 和 10 之间")
	public String getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	
	@Length(min=0, max=10, message="上传日期长度必须介于 0 和 10 之间")
	public String getMakedate() {
		return makedate;
	}

	public void setMakedate(String makedate) {
		this.makedate = makedate;
	}
	
	@Length(min=0, max=8, message="上传时间长度必须介于 0 和 8 之间")
	public String getMaketime() {
		return maketime;
	}

	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}
	
	@Length(min=0, max=40, message="销售渠道长度必须介于 0 和 40 之间")
	public String getSalechanne() {
		return salechanne;
	}

	public void setSalechanne(String salechanne) {
		this.salechanne = salechanne;
	}
	
	@Length(min=0, max=6, message="省机构号长度必须介于 0 和 6 之间")
	public String getProvBranchNo() {
		return provBranchNo;
	}

	public void setProvBranchNo(String provBranchNo) {
		this.provBranchNo = provBranchNo;
	}
	
	@Length(min=0, max=6, message="市机构号长度必须介于 0 和 6 之间")
	public String getCityBranchNo() {
		return cityBranchNo;
	}

	public void setCityBranchNo(String cityBranchNo) {
		this.cityBranchNo = cityBranchNo;
	}
	
	@Length(min=0, max=6, message="县机构号长度必须介于 0 和 6 之间")
	public String getTownBranchNo() {
		return townBranchNo;
	}

	public void setTownBranchNo(String townBranchNo) {
		this.townBranchNo = townBranchNo;
	}
	
}