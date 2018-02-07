/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.modules.log.entity.RatioBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.log.entity.FormlsAsyncStatus;
import com.thinkgem.jeesite.modules.log.dao.FormlsAsyncStatusDao;

/**
 * fdfdfService
 * @author wangzhenwei
 * @version 2018-01-12
 */
@Service
@Transactional(readOnly = true)
public class FormlsAsyncStatusService extends CrudService<FormlsAsyncStatusDao, FormlsAsyncStatus> {

	public FormlsAsyncStatus get(String id) {
		return super.get(id);
	}
	
	public List<FormlsAsyncStatus> findList(FormlsAsyncStatus formlsAsyncStatus) {
		return super.findList(formlsAsyncStatus);
	}
	
	public Page<FormlsAsyncStatus> findPage(Page<FormlsAsyncStatus> page, FormlsAsyncStatus formlsAsyncStatus) {
		return super.findPage(page, formlsAsyncStatus);
	}

	/**
	 * 查询无纸化出单保费，出单量，出单人次
	 * @param date1
	 * @param date2
	 * @return
	 */
	public Map<String,String> findPaperless(String date1,String date2){
		Map<String,String> paperless = new HashMap<String, String>();
		String[] dat2 = date2.split("-");
		String d2 = dat2[0]+"-"+dat2[1]+"-"+String.valueOf(Integer.valueOf(dat2[2])+1);
		String insuranceFee = dao.findAllInsuranceFee(date1,d2);
		String sumInsurance = dao.findSumInsurance(date1,d2);
		String insuranceNop = dao.findAllInsuranceNop(date1,d2);

		paperless.put("insuranceFee",insuranceFee);
		paperless.put("sumInsurance",sumInsurance);
		paperless.put("insuranceNop",insuranceNop);

		return paperless;
	}

	/**
	 * 查询无纸化总保费
	 * @param date1
	 * @param date2
	 * @return
	 */
	public String findInsuranceFee(String date1,String date2){
		String insuranceFee = dao.findAllInsuranceFee(date1,date2);
		if(insuranceFee==null||!"".equals(insuranceFee)){
			insuranceFee = "0";
		}
		return dao.findAllInsuranceFee(date1,date2);
}

	/**
	 * 查询无纸化总保单
	 * @param date1
	 * @param date2
	 * @return
	 */
	public String findSumInsurance(String date1,String date2){

		return dao.findSumInsurance(date1,date2);
	}

	/**
	 * 查询无纸化出单人次
	 * @param date1
	 * @param date2
	 * @return
	 */
	public String findAllInsuranceNop(String date1,String date2){
		return dao.findAllInsuranceNop(date1,date2);
	}

	public List<RatioBase> findPolicyRatio(String date1, String date2, String date3){
		return dao.findPolicyRatio(date1,date2,date3);
	}
	@Transactional(readOnly = false)
	public void save(FormlsAsyncStatus formlsAsyncStatus) {
		super.save(formlsAsyncStatus);
	}
	
	@Transactional(readOnly = false)
	public void delete(FormlsAsyncStatus formlsAsyncStatus) {
		super.delete(formlsAsyncStatus);
	}
	
}