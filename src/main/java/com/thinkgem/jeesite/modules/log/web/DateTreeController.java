/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.thinkgem.jeesite.modules.log.entity.DateTree;
import com.thinkgem.jeesite.modules.log.service.DateTreeService;

/**
 * 日期树Controller
 * @author wangzhenwei
 * @version 2018-01-22
 */
@Controller
@RequestMapping(value = "${adminPath}/log/dateTree")
public class DateTreeController extends BaseController {

	@Autowired
	private DateTreeService dateTreeService;
	
	@ModelAttribute
	public DateTree get(@RequestParam(required=false) String id) {
		DateTree entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dateTreeService.get(id);
		}
		if (entity == null){
			entity = new DateTree();
		}
		return entity;
	}
	
	@RequiresPermissions("log:dateTree:view")
	@RequestMapping(value = {"list", ""})
	public String list(DateTree dateTree, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DateTree> page = dateTreeService.findPage(new Page<DateTree>(request, response), dateTree); 
		model.addAttribute("page", page);
		return "modules/log/provstatistics";
	}

	@RequiresPermissions("log:dateTree:view")
	@RequestMapping(value = "form")
	public String form(DateTree dateTree, Model model) {
		model.addAttribute("dateTree", dateTree);
		return "modules/log/dateTreeForm";
	}

	@RequiresPermissions("log:dateTree:edit")
	@RequestMapping(value = "save")
	public String save(DateTree dateTree, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dateTree)){
			return form(dateTree, model);
		}
		dateTreeService.save(dateTree);
		addMessage(redirectAttributes, "保存日期树成功");
		return "redirect:"+Global.getAdminPath()+"/log/dateTree/?repage";
	}
	
	@RequiresPermissions("log:dateTree:edit")
	@RequestMapping(value = "delete")
	public String delete(DateTree dateTree, RedirectAttributes redirectAttributes) {
		dateTreeService.delete(dateTree);
		addMessage(redirectAttributes, "删除日期树成功");
		return "redirect:"+Global.getAdminPath()+"/log/dateTree/?repage";
	}

}