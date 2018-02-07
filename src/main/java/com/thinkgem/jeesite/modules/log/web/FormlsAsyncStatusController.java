/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.log.entity.RatioBase;
import com.thinkgem.jeesite.modules.log.service.PaperlessRelatedService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.log.entity.FormlsAsyncStatus;
import com.thinkgem.jeesite.modules.log.service.FormlsAsyncStatusService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * fdfdfController
 * @author wangzhenwei
 * @version 2018-01-15
 */
@Controller
@RequestMapping(value = "${adminPath}/log/formlsAsyncStatus")
public class FormlsAsyncStatusController extends BaseController {

	@Autowired
	private PaperlessRelatedService paperlessRelatedService;
	@Autowired
	private FormlsAsyncStatusService formlsAsyncStatusService;
	
	@ModelAttribute
	public FormlsAsyncStatus get(@RequestParam(required=false) String id) {
		FormlsAsyncStatus entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = formlsAsyncStatusService.get(id);
		}
		if (entity == null){
			entity = new FormlsAsyncStatus();
		}
		return entity;
	}

	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findPaperless", ""})
	public String findPaperless(Date date1, Date date2, Model model) {

		String paperlessProvinces = paperlessRelatedService.findPaperlessProvinces();
		String paperlessUsers = paperlessRelatedService.findPaperlessUsers();
		String paperlessBranches = paperlessRelatedService.findPaperlessBranches();

		Map<String,String> paperlessContent = new HashMap<String, String>();
		paperlessContent.put("paperlessProvinces",paperlessProvinces);
		paperlessContent.put("paperlessBranches",paperlessBranches);
		paperlessContent.put("paperlessUsers",paperlessUsers);
		model.addAttribute("paperlessContent", paperlessContent);
			Map<String, String> paperless = new HashMap<String, String>();
		if(date1!=null&&date2!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(date1);
			String dat2 = sdf.format(date2);
			paperless = formlsAsyncStatusService.findPaperless(dat1, dat2);
			model.addAttribute("paperless", paperless);
			String date = dat1+"至"+dat2;
			model.addAttribute("date", date);
		}else{
			Calendar c3 = Calendar.getInstance();
			c3.add(Calendar.DATE,-1);
			Date ytime=c3.getTime();//昨天
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(ytime);
			paperless = formlsAsyncStatusService.findPaperless(dat1, dat1);
			model.addAttribute("paperless", paperless);
			model.addAttribute("date", dat1);
		}
		return "modules/log/paperless";
	}

	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findInsuranceFee", ""})
	public String findInsuranceFee(Date date1,Date date2, Model model) {
		if(date1!=null&&date2!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(date1);
			String dat2 = sdf.format(date2);
			String insuranceFee = formlsAsyncStatusService.findInsuranceFee(dat1, dat2);
			model.addAttribute("insuranceFee", insuranceFee);
		}else{
			Calendar c3 = Calendar.getInstance();
			c3.add(Calendar.DATE,-1);
			Date ytime=c3.getTime();//昨天
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(ytime);
			String insuranceFee = formlsAsyncStatusService.findInsuranceFee(dat1, dat1);
			model.addAttribute("insuranceFee", insuranceFee);
		}
		return "modules/log/insurancefee";
	}
	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findSumInsurance", ""})
	public String findSumInsurance(Date date1,Date date2, Model model) {
		if(date1 !=null&&date2 !=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(date1);
			String dat2 = sdf.format(date2);
			String sumInsurance = formlsAsyncStatusService.findSumInsurance(dat1, dat2);
			model.addAttribute("sumIncurance", sumInsurance);
		}else{
			Calendar c3 = Calendar.getInstance();
			c3.add(Calendar.DATE,-1);
			Date ytime=c3.getTime();//昨天
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(ytime);
			String sumInsurance = formlsAsyncStatusService.findSumInsurance(dat1, dat1);
			model.addAttribute("sumIncurance", sumInsurance);
		}
		return "modules/log/sumInsurance";
	}
	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findInsuranceNop", ""})
	public String findInsuranceNop(Date date1,Date date2, Model model) {
		if(date1 !=null&&date2 !=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(date1);
			String dat2 = sdf.format(date2);
			String insuranceNop = formlsAsyncStatusService.findAllInsuranceNop(dat1, dat2);
			model.addAttribute("insuranceNop", insuranceNop);
		}else{
			Calendar c3 = Calendar.getInstance();
			c3.add(Calendar.DATE,-1);
			Date ytime=c3.getTime();//昨天
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(ytime);
			String insuranceNop = formlsAsyncStatusService.findAllInsuranceNop(dat1, dat1);
			model.addAttribute("insuranceNop", insuranceNop);
		}
		return "modules/log/insuranceNop";
	}
	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/paperlessContent", ""})
	public String findpaperlessContent(Model model) {
		String paperlessProvinces = paperlessRelatedService.findPaperlessProvinces();
		String paperlessUsers = paperlessRelatedService.findPaperlessUsers();
		String paperlessBranches = paperlessRelatedService.findPaperlessBranches();

		Map<String,String> paperlessContent = new HashMap<String, String>();
		paperlessContent.put("paperlessProvinces",paperlessProvinces);
		paperlessContent.put("paperlessBranches",paperlessBranches);
		paperlessContent.put("paperlessUsers",paperlessUsers);
		model.addAttribute("paperlessContent", paperlessContent);
		return "modules/log/paperlessContent";
	}

	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findPaperlessProvinces", ""})
	public String findPaperlessProvinces(Model model) {
		String paperlessProvinces = paperlessRelatedService.findPaperlessProvinces();
			model.addAttribute("paperlessProvinces", paperlessProvinces);

		return "modules/log/paperlessProvinces";
	}
	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findPaperlessBranches", ""})
	public String findPaperlessBranches(Model model) {
		String paperlessUsers = paperlessRelatedService.findPaperlessUsers();
		model.addAttribute("paperlessUsers", paperlessUsers);

		return "modules/log/paperlessUsers";
	}
	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findPaperlessUsers", ""})
	public String findPaperlessUsers(Model model) {
		String paperlessBranches = paperlessRelatedService.findPaperlessBranches();
		model.addAttribute("paperlessBranches", paperlessBranches);

		return "modules/log/paperlessBranches";
	}

	@RequiresPermissions("log:formlsAsyncStatus:view")
	@RequestMapping(value = {"list/findPolicyRatio", ""})
	public String findPolicyRatio(Date date1,Date date2, Model model) {
		if(date1!=null&&date2!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dat1 = sdf.format(date1);
			String dat2 = sdf.format(date2);
			Calendar c3 = Calendar.getInstance();
			c3.setTime(date2);
			c3.add(Calendar.DATE,1);
			String dat3 = sdf.format(c3.getTime());
			List<RatioBase> ratioBases = formlsAsyncStatusService.findPolicyRatio(dat1,dat3,dat2);
			model.addAttribute("ratioBases", ratioBases);
		}
		return "modules/log/paperlessRatio";
	}

}