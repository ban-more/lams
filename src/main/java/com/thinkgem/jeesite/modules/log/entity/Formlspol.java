/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * asdEntity
 * @author wangzhenwei
 * @version 2018-01-12
 */
public class Formlspol extends DataEntity<Formlspol> {
	
	private static final long serialVersionUID = 1L;
	private String grpcontno;		// grpcontno
	private String grppolno;		// grppolno
	private String contno;		// contno
	private String polno;		// polno
	private String proposalno;		// proposalno
	private String prtno;		// prtno
	private String conttype;		// conttype
	private String poltypeflag;		// poltypeflag
	private String mainpolno;		// mainpolno
	private String masterpolno;		// masterpolno
	private String kindcode;		// kindcode
	private String riskcode;		// riskcode
	private String riskversion;		// riskversion
	private String managecom;		// managecom
	private String agentcom;		// agentcom
	private String agenttype;		// agenttype
	private String agentcode;		// agentcode
	private String agentgroup;		// agentgroup
	private String agentcode1;		// agentcode1
	private String salechnl;		// salechnl
	private String handler;		// handler
	private String insuredno;		// insuredno
	private String insuredname;		// insuredname
	private String insuredsex;		// insuredsex
	private Date insuredbirthday;		// insuredbirthday
	private String insuredappage;		// insuredappage
	private String insuredpeoples;		// insuredpeoples
	private String occupationtype;		// occupationtype
	private String appntno;		// appntno
	private String appntname;		// appntname
	private Date cvalidate;		// cvalidate
	private String signcom;		// signcom
	private Date signdate;		// signdate
	private String signtime;		// signtime
	private Date firstpaydate;		// firstpaydate
	private Date payenddate;		// payenddate
	private Date paytodate;		// paytodate
	private Date getstartdate;		// getstartdate
	private Date enddate;		// enddate
	private Date accienddate;		// accienddate
	private String getyearflag;		// getyearflag
	private String getyear;		// getyear
	private String payendyearflag;		// payendyearflag
	private String payendyear;		// payendyear
	private String insuyearflag;		// insuyearflag
	private String insuyear;		// insuyear
	private String acciyearflag;		// acciyearflag
	private String acciyear;		// acciyear
	private String getstarttype;		// getstarttype
	private String specifyvalidate;		// specifyvalidate
	private String paymode;		// paymode
	private String paylocation;		// paylocation
	private String payintv;		// payintv
	private String payyears;		// payyears
	private String years;		// years
	private Double managefeerate;		// managefeerate
	private Double floatrate;		// floatrate
	private Double premrate;		// premrate
	private String premtoamnt;		// premtoamnt
	private Double mult;		// mult
	private Double standprem;		// standprem
	private Double prem;		// prem
	private Double sumprem;		// sumprem
	private Double amnt;		// amnt
	private Double riskamnt;		// riskamnt
	private Double leavingmoney;		// leavingmoney
	private String endorsetimes;		// endorsetimes
	private String claimtimes;		// claimtimes
	private String livetimes;		// livetimes
	private String renewcount;		// renewcount
	private Date lastgetdate;		// lastgetdate
	private Date lastloandate;		// lastloandate
	private Date lastregetdate;		// lastregetdate
	private Date lastedordate;		// lastedordate
	private Date lastrevdate;		// lastrevdate
	private String rnewflag;		// rnewflag
	private String stopflag;		// stopflag
	private String expiryflag;		// expiryflag
	private String autopayflag;		// autopayflag
	private String interestdifflag;		// interestdifflag
	private String subflag;		// subflag
	private String bnfflag;		// bnfflag
	private String healthcheckflag;		// healthcheckflag
	private String impartflag;		// impartflag
	private String reinsureflag;		// reinsureflag
	private String agentpayflag;		// agentpayflag
	private String agentgetflag;		// agentgetflag
	private String livegetmode;		// livegetmode
	private String deadgetmode;		// deadgetmode
	private String bonusgetmode;		// bonusgetmode
	private String bonusman;		// bonusman
	private String deadflag;		// deadflag
	private String smokeflag;		// smokeflag
	private String remark;		// remark
	private String approveflag;		// approveflag
	private String approvecode;		// approvecode
	private Date approvedate;		// approvedate
	private String approvetime;		// approvetime
	private String uwflag;		// uwflag
	private String uwcode;		// uwcode
	private Date uwdate;		// uwdate
	private String uwtime;		// uwtime
	private Date polapplydate;		// polapplydate
	private String appflag;		// appflag
	private String polstate;		// polstate
	private String standbyflag1;		// standbyflag1
	private String standbyflag2;		// standbyflag2
	private String standbyflag3;		// standbyflag3
	private String operator;		// operator
	private Date makedate;		// makedate
	private String maketime;		// maketime
	private Date modifydate;		// modifydate
	private String modifytime;		// modifytime
	
	public Formlspol() {
		super();
	}

	public Formlspol(String id){
		super(id);
	}

	@Length(min=1, max=40, message="grpcontno长度必须介于 1 和 40 之间")
	public String getGrpcontno() {
		return grpcontno;
	}

	public void setGrpcontno(String grpcontno) {
		this.grpcontno = grpcontno;
	}
	
	@Length(min=1, max=40, message="grppolno长度必须介于 1 和 40 之间")
	public String getGrppolno() {
		return grppolno;
	}

	public void setGrppolno(String grppolno) {
		this.grppolno = grppolno;
	}
	
	@Length(min=1, max=40, message="contno长度必须介于 1 和 40 之间")
	public String getContno() {
		return contno;
	}

	public void setContno(String contno) {
		this.contno = contno;
	}
	
	@Length(min=1, max=40, message="polno长度必须介于 1 和 40 之间")
	public String getPolno() {
		return polno;
	}

	public void setPolno(String polno) {
		this.polno = polno;
	}
	
	@Length(min=0, max=40, message="proposalno长度必须介于 0 和 40 之间")
	public String getProposalno() {
		return proposalno;
	}

	public void setProposalno(String proposalno) {
		this.proposalno = proposalno;
	}
	
	@Length(min=0, max=40, message="prtno长度必须介于 0 和 40 之间")
	public String getPrtno() {
		return prtno;
	}

	public void setPrtno(String prtno) {
		this.prtno = prtno;
	}
	
	@Length(min=0, max=1, message="conttype长度必须介于 0 和 1 之间")
	public String getConttype() {
		return conttype;
	}

	public void setConttype(String conttype) {
		this.conttype = conttype;
	}
	
	@Length(min=0, max=1, message="poltypeflag长度必须介于 0 和 1 之间")
	public String getPoltypeflag() {
		return poltypeflag;
	}

	public void setPoltypeflag(String poltypeflag) {
		this.poltypeflag = poltypeflag;
	}
	
	@Length(min=1, max=40, message="mainpolno长度必须介于 1 和 40 之间")
	public String getMainpolno() {
		return mainpolno;
	}

	public void setMainpolno(String mainpolno) {
		this.mainpolno = mainpolno;
	}
	
	@Length(min=0, max=40, message="masterpolno长度必须介于 0 和 40 之间")
	public String getMasterpolno() {
		return masterpolno;
	}

	public void setMasterpolno(String masterpolno) {
		this.masterpolno = masterpolno;
	}
	
	@Length(min=0, max=3, message="kindcode长度必须介于 0 和 3 之间")
	public String getKindcode() {
		return kindcode;
	}

	public void setKindcode(String kindcode) {
		this.kindcode = kindcode;
	}
	
	@Length(min=0, max=10, message="riskcode长度必须介于 0 和 10 之间")
	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}
	
	@Length(min=0, max=10, message="riskversion长度必须介于 0 和 10 之间")
	public String getRiskversion() {
		return riskversion;
	}

	public void setRiskversion(String riskversion) {
		this.riskversion = riskversion;
	}
	
	@Length(min=0, max=10, message="managecom长度必须介于 0 和 10 之间")
	public String getManagecom() {
		return managecom;
	}

	public void setManagecom(String managecom) {
		this.managecom = managecom;
	}
	
	@Length(min=0, max=20, message="agentcom长度必须介于 0 和 20 之间")
	public String getAgentcom() {
		return agentcom;
	}

	public void setAgentcom(String agentcom) {
		this.agentcom = agentcom;
	}
	
	@Length(min=0, max=20, message="agenttype长度必须介于 0 和 20 之间")
	public String getAgenttype() {
		return agenttype;
	}

	public void setAgenttype(String agenttype) {
		this.agenttype = agenttype;
	}
	
	@Length(min=0, max=20, message="agentcode长度必须介于 0 和 20 之间")
	public String getAgentcode() {
		return agentcode;
	}

	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}
	
	@Length(min=0, max=20, message="agentgroup长度必须介于 0 和 20 之间")
	public String getAgentgroup() {
		return agentgroup;
	}

	public void setAgentgroup(String agentgroup) {
		this.agentgroup = agentgroup;
	}
	
	@Length(min=0, max=20, message="agentcode1长度必须介于 0 和 20 之间")
	public String getAgentcode1() {
		return agentcode1;
	}

	public void setAgentcode1(String agentcode1) {
		this.agentcode1 = agentcode1;
	}
	
	@Length(min=0, max=2, message="salechnl长度必须介于 0 和 2 之间")
	public String getSalechnl() {
		return salechnl;
	}

	public void setSalechnl(String salechnl) {
		this.salechnl = salechnl;
	}
	
	@Length(min=0, max=10, message="handler长度必须介于 0 和 10 之间")
	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}
	
	@Length(min=0, max=40, message="insuredno长度必须介于 0 和 40 之间")
	public String getInsuredno() {
		return insuredno;
	}

	public void setInsuredno(String insuredno) {
		this.insuredno = insuredno;
	}
	
	@Length(min=0, max=200, message="insuredname长度必须介于 0 和 200 之间")
	public String getInsuredname() {
		return insuredname;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	
	@Length(min=0, max=1, message="insuredsex长度必须介于 0 和 1 之间")
	public String getInsuredsex() {
		return insuredsex;
	}

	public void setInsuredsex(String insuredsex) {
		this.insuredsex = insuredsex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInsuredbirthday() {
		return insuredbirthday;
	}

	public void setInsuredbirthday(Date insuredbirthday) {
		this.insuredbirthday = insuredbirthday;
	}
	
	public String getInsuredappage() {
		return insuredappage;
	}

	public void setInsuredappage(String insuredappage) {
		this.insuredappage = insuredappage;
	}
	
	public String getInsuredpeoples() {
		return insuredpeoples;
	}

	public void setInsuredpeoples(String insuredpeoples) {
		this.insuredpeoples = insuredpeoples;
	}
	
	@Length(min=0, max=10, message="occupationtype长度必须介于 0 和 10 之间")
	public String getOccupationtype() {
		return occupationtype;
	}

	public void setOccupationtype(String occupationtype) {
		this.occupationtype = occupationtype;
	}
	
	@Length(min=0, max=40, message="appntno长度必须介于 0 和 40 之间")
	public String getAppntno() {
		return appntno;
	}

	public void setAppntno(String appntno) {
		this.appntno = appntno;
	}
	
	@Length(min=0, max=60, message="appntname长度必须介于 0 和 60 之间")
	public String getAppntname() {
		return appntname;
	}

	public void setAppntname(String appntname) {
		this.appntname = appntname;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCvalidate() {
		return cvalidate;
	}

	public void setCvalidate(Date cvalidate) {
		this.cvalidate = cvalidate;
	}
	
	@Length(min=0, max=10, message="signcom长度必须介于 0 和 10 之间")
	public String getSigncom() {
		return signcom;
	}

	public void setSigncom(String signcom) {
		this.signcom = signcom;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSigndate() {
		return signdate;
	}

	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	
	@Length(min=0, max=8, message="signtime长度必须介于 0 和 8 之间")
	public String getSigntime() {
		return signtime;
	}

	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getFirstpaydate() {
		return firstpaydate;
	}

	public void setFirstpaydate(Date firstpaydate) {
		this.firstpaydate = firstpaydate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPayenddate() {
		return payenddate;
	}

	public void setPayenddate(Date payenddate) {
		this.payenddate = payenddate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPaytodate() {
		return paytodate;
	}

	public void setPaytodate(Date paytodate) {
		this.paytodate = paytodate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGetstartdate() {
		return getstartdate;
	}

	public void setGetstartdate(Date getstartdate) {
		this.getstartdate = getstartdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAccienddate() {
		return accienddate;
	}

	public void setAccienddate(Date accienddate) {
		this.accienddate = accienddate;
	}
	
	@Length(min=0, max=1, message="getyearflag长度必须介于 0 和 1 之间")
	public String getGetyearflag() {
		return getyearflag;
	}

	public void setGetyearflag(String getyearflag) {
		this.getyearflag = getyearflag;
	}
	
	public String getGetyear() {
		return getyear;
	}

	public void setGetyear(String getyear) {
		this.getyear = getyear;
	}
	
	@Length(min=0, max=1, message="payendyearflag长度必须介于 0 和 1 之间")
	public String getPayendyearflag() {
		return payendyearflag;
	}

	public void setPayendyearflag(String payendyearflag) {
		this.payendyearflag = payendyearflag;
	}
	
	public String getPayendyear() {
		return payendyear;
	}

	public void setPayendyear(String payendyear) {
		this.payendyear = payendyear;
	}
	
	@Length(min=0, max=1, message="insuyearflag长度必须介于 0 和 1 之间")
	public String getInsuyearflag() {
		return insuyearflag;
	}

	public void setInsuyearflag(String insuyearflag) {
		this.insuyearflag = insuyearflag;
	}
	
	public String getInsuyear() {
		return insuyear;
	}

	public void setInsuyear(String insuyear) {
		this.insuyear = insuyear;
	}
	
	@Length(min=0, max=1, message="acciyearflag长度必须介于 0 和 1 之间")
	public String getAcciyearflag() {
		return acciyearflag;
	}

	public void setAcciyearflag(String acciyearflag) {
		this.acciyearflag = acciyearflag;
	}
	
	public String getAcciyear() {
		return acciyear;
	}

	public void setAcciyear(String acciyear) {
		this.acciyear = acciyear;
	}
	
	@Length(min=0, max=1, message="getstarttype长度必须介于 0 和 1 之间")
	public String getGetstarttype() {
		return getstarttype;
	}

	public void setGetstarttype(String getstarttype) {
		this.getstarttype = getstarttype;
	}
	
	@Length(min=0, max=1, message="specifyvalidate长度必须介于 0 和 1 之间")
	public String getSpecifyvalidate() {
		return specifyvalidate;
	}

	public void setSpecifyvalidate(String specifyvalidate) {
		this.specifyvalidate = specifyvalidate;
	}
	
	@Length(min=0, max=1, message="paymode长度必须介于 0 和 1 之间")
	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	
	@Length(min=0, max=1, message="paylocation长度必须介于 0 和 1 之间")
	public String getPaylocation() {
		return paylocation;
	}

	public void setPaylocation(String paylocation) {
		this.paylocation = paylocation;
	}
	
	public String getPayintv() {
		return payintv;
	}

	public void setPayintv(String payintv) {
		this.payintv = payintv;
	}
	
	public String getPayyears() {
		return payyears;
	}

	public void setPayyears(String payyears) {
		this.payyears = payyears;
	}
	
	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}
	
	public Double getManagefeerate() {
		return managefeerate;
	}

	public void setManagefeerate(Double managefeerate) {
		this.managefeerate = managefeerate;
	}
	
	public Double getFloatrate() {
		return floatrate;
	}

	public void setFloatrate(Double floatrate) {
		this.floatrate = floatrate;
	}
	
	public Double getPremrate() {
		return premrate;
	}

	public void setPremrate(Double premrate) {
		this.premrate = premrate;
	}
	
	@Length(min=0, max=1, message="premtoamnt长度必须介于 0 和 1 之间")
	public String getPremtoamnt() {
		return premtoamnt;
	}

	public void setPremtoamnt(String premtoamnt) {
		this.premtoamnt = premtoamnt;
	}
	
	public Double getMult() {
		return mult;
	}

	public void setMult(Double mult) {
		this.mult = mult;
	}
	
	public Double getStandprem() {
		return standprem;
	}

	public void setStandprem(Double standprem) {
		this.standprem = standprem;
	}
	
	public Double getPrem() {
		return prem;
	}

	public void setPrem(Double prem) {
		this.prem = prem;
	}
	
	public Double getSumprem() {
		return sumprem;
	}

	public void setSumprem(Double sumprem) {
		this.sumprem = sumprem;
	}
	
	public Double getAmnt() {
		return amnt;
	}

	public void setAmnt(Double amnt) {
		this.amnt = amnt;
	}
	
	public Double getRiskamnt() {
		return riskamnt;
	}

	public void setRiskamnt(Double riskamnt) {
		this.riskamnt = riskamnt;
	}
	
	public Double getLeavingmoney() {
		return leavingmoney;
	}

	public void setLeavingmoney(Double leavingmoney) {
		this.leavingmoney = leavingmoney;
	}
	
	public String getEndorsetimes() {
		return endorsetimes;
	}

	public void setEndorsetimes(String endorsetimes) {
		this.endorsetimes = endorsetimes;
	}
	
	public String getClaimtimes() {
		return claimtimes;
	}

	public void setClaimtimes(String claimtimes) {
		this.claimtimes = claimtimes;
	}
	
	public String getLivetimes() {
		return livetimes;
	}

	public void setLivetimes(String livetimes) {
		this.livetimes = livetimes;
	}
	
	public String getRenewcount() {
		return renewcount;
	}

	public void setRenewcount(String renewcount) {
		this.renewcount = renewcount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastgetdate() {
		return lastgetdate;
	}

	public void setLastgetdate(Date lastgetdate) {
		this.lastgetdate = lastgetdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastloandate() {
		return lastloandate;
	}

	public void setLastloandate(Date lastloandate) {
		this.lastloandate = lastloandate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastregetdate() {
		return lastregetdate;
	}

	public void setLastregetdate(Date lastregetdate) {
		this.lastregetdate = lastregetdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastedordate() {
		return lastedordate;
	}

	public void setLastedordate(Date lastedordate) {
		this.lastedordate = lastedordate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastrevdate() {
		return lastrevdate;
	}

	public void setLastrevdate(Date lastrevdate) {
		this.lastrevdate = lastrevdate;
	}
	
	public String getRnewflag() {
		return rnewflag;
	}

	public void setRnewflag(String rnewflag) {
		this.rnewflag = rnewflag;
	}
	
	@Length(min=0, max=2, message="stopflag长度必须介于 0 和 2 之间")
	public String getStopflag() {
		return stopflag;
	}

	public void setStopflag(String stopflag) {
		this.stopflag = stopflag;
	}
	
	@Length(min=0, max=1, message="expiryflag长度必须介于 0 和 1 之间")
	public String getExpiryflag() {
		return expiryflag;
	}

	public void setExpiryflag(String expiryflag) {
		this.expiryflag = expiryflag;
	}
	
	@Length(min=0, max=1, message="autopayflag长度必须介于 0 和 1 之间")
	public String getAutopayflag() {
		return autopayflag;
	}

	public void setAutopayflag(String autopayflag) {
		this.autopayflag = autopayflag;
	}
	
	@Length(min=0, max=1, message="interestdifflag长度必须介于 0 和 1 之间")
	public String getInterestdifflag() {
		return interestdifflag;
	}

	public void setInterestdifflag(String interestdifflag) {
		this.interestdifflag = interestdifflag;
	}
	
	@Length(min=0, max=1, message="subflag长度必须介于 0 和 1 之间")
	public String getSubflag() {
		return subflag;
	}

	public void setSubflag(String subflag) {
		this.subflag = subflag;
	}
	
	@Length(min=0, max=1, message="bnfflag长度必须介于 0 和 1 之间")
	public String getBnfflag() {
		return bnfflag;
	}

	public void setBnfflag(String bnfflag) {
		this.bnfflag = bnfflag;
	}
	
	@Length(min=0, max=1, message="healthcheckflag长度必须介于 0 和 1 之间")
	public String getHealthcheckflag() {
		return healthcheckflag;
	}

	public void setHealthcheckflag(String healthcheckflag) {
		this.healthcheckflag = healthcheckflag;
	}
	
	@Length(min=0, max=1, message="impartflag长度必须介于 0 和 1 之间")
	public String getImpartflag() {
		return impartflag;
	}

	public void setImpartflag(String impartflag) {
		this.impartflag = impartflag;
	}
	
	@Length(min=0, max=1, message="reinsureflag长度必须介于 0 和 1 之间")
	public String getReinsureflag() {
		return reinsureflag;
	}

	public void setReinsureflag(String reinsureflag) {
		this.reinsureflag = reinsureflag;
	}
	
	@Length(min=0, max=1, message="agentpayflag长度必须介于 0 和 1 之间")
	public String getAgentpayflag() {
		return agentpayflag;
	}

	public void setAgentpayflag(String agentpayflag) {
		this.agentpayflag = agentpayflag;
	}
	
	@Length(min=0, max=1, message="agentgetflag长度必须介于 0 和 1 之间")
	public String getAgentgetflag() {
		return agentgetflag;
	}

	public void setAgentgetflag(String agentgetflag) {
		this.agentgetflag = agentgetflag;
	}
	
	@Length(min=0, max=1, message="livegetmode长度必须介于 0 和 1 之间")
	public String getLivegetmode() {
		return livegetmode;
	}

	public void setLivegetmode(String livegetmode) {
		this.livegetmode = livegetmode;
	}
	
	@Length(min=0, max=1, message="deadgetmode长度必须介于 0 和 1 之间")
	public String getDeadgetmode() {
		return deadgetmode;
	}

	public void setDeadgetmode(String deadgetmode) {
		this.deadgetmode = deadgetmode;
	}
	
	@Length(min=0, max=1, message="bonusgetmode长度必须介于 0 和 1 之间")
	public String getBonusgetmode() {
		return bonusgetmode;
	}

	public void setBonusgetmode(String bonusgetmode) {
		this.bonusgetmode = bonusgetmode;
	}
	
	@Length(min=0, max=1, message="bonusman长度必须介于 0 和 1 之间")
	public String getBonusman() {
		return bonusman;
	}

	public void setBonusman(String bonusman) {
		this.bonusman = bonusman;
	}
	
	@Length(min=0, max=1, message="deadflag长度必须介于 0 和 1 之间")
	public String getDeadflag() {
		return deadflag;
	}

	public void setDeadflag(String deadflag) {
		this.deadflag = deadflag;
	}
	
	@Length(min=0, max=1, message="smokeflag长度必须介于 0 和 1 之间")
	public String getSmokeflag() {
		return smokeflag;
	}

	public void setSmokeflag(String smokeflag) {
		this.smokeflag = smokeflag;
	}
	
	@Length(min=0, max=255, message="remark长度必须介于 0 和 255 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Length(min=0, max=1, message="approveflag长度必须介于 0 和 1 之间")
	public String getApproveflag() {
		return approveflag;
	}

	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}
	
	@Length(min=0, max=10, message="approvecode长度必须介于 0 和 10 之间")
	public String getApprovecode() {
		return approvecode;
	}

	public void setApprovecode(String approvecode) {
		this.approvecode = approvecode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getApprovedate() {
		return approvedate;
	}

	public void setApprovedate(Date approvedate) {
		this.approvedate = approvedate;
	}
	
	@Length(min=0, max=8, message="approvetime长度必须介于 0 和 8 之间")
	public String getApprovetime() {
		return approvetime;
	}

	public void setApprovetime(String approvetime) {
		this.approvetime = approvetime;
	}
	
	@Length(min=0, max=10, message="uwflag长度必须介于 0 和 10 之间")
	public String getUwflag() {
		return uwflag;
	}

	public void setUwflag(String uwflag) {
		this.uwflag = uwflag;
	}
	
	@Length(min=0, max=10, message="uwcode长度必须介于 0 和 10 之间")
	public String getUwcode() {
		return uwcode;
	}

	public void setUwcode(String uwcode) {
		this.uwcode = uwcode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUwdate() {
		return uwdate;
	}

	public void setUwdate(Date uwdate) {
		this.uwdate = uwdate;
	}
	
	@Length(min=0, max=8, message="uwtime长度必须介于 0 和 8 之间")
	public String getUwtime() {
		return uwtime;
	}

	public void setUwtime(String uwtime) {
		this.uwtime = uwtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPolapplydate() {
		return polapplydate;
	}

	public void setPolapplydate(Date polapplydate) {
		this.polapplydate = polapplydate;
	}
	
	@Length(min=0, max=1, message="appflag长度必须介于 0 和 1 之间")
	public String getAppflag() {
		return appflag;
	}

	public void setAppflag(String appflag) {
		this.appflag = appflag;
	}
	
	@Length(min=0, max=10, message="polstate长度必须介于 0 和 10 之间")
	public String getPolstate() {
		return polstate;
	}

	public void setPolstate(String polstate) {
		this.polstate = polstate;
	}
	
	@Length(min=0, max=40, message="standbyflag1长度必须介于 0 和 40 之间")
	public String getStandbyflag1() {
		return standbyflag1;
	}

	public void setStandbyflag1(String standbyflag1) {
		this.standbyflag1 = standbyflag1;
	}
	
	@Length(min=0, max=40, message="standbyflag2长度必须介于 0 和 40 之间")
	public String getStandbyflag2() {
		return standbyflag2;
	}

	public void setStandbyflag2(String standbyflag2) {
		this.standbyflag2 = standbyflag2;
	}
	
	@Length(min=0, max=40, message="standbyflag3长度必须介于 0 和 40 之间")
	public String getStandbyflag3() {
		return standbyflag3;
	}

	public void setStandbyflag3(String standbyflag3) {
		this.standbyflag3 = standbyflag3;
	}
	
	@Length(min=0, max=20, message="operator长度必须介于 0 和 20 之间")
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="makedate不能为空")
	public Date getMakedate() {
		return makedate;
	}

	public void setMakedate(Date makedate) {
		this.makedate = makedate;
	}
	
	@Length(min=0, max=8, message="maketime长度必须介于 0 和 8 之间")
	public String getMaketime() {
		return maketime;
	}

	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="modifydate不能为空")
	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	
	@Length(min=0, max=8, message="modifytime长度必须介于 0 和 8 之间")
	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	
}