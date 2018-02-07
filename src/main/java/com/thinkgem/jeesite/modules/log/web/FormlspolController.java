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
import com.thinkgem.jeesite.modules.log.entity.Formlspol;
import com.thinkgem.jeesite.modules.log.service.FormlspolService;

/**
 * asdController
 * @author wangzhenwei
 * @version 2018-01-15
 */
@Controller
@RequestMapping(value = "${adminPath}/log/formlspol")
public class FormlspolController extends BaseController {

	@Autowired
	private FormlspolService formlspolService;
	
	@ModelAttribute
	public Formlspol get(@RequestParam(required=false) String id) {
		Formlspol entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = formlspolService.get(id);
		}
		if (entity == null){
			entity = new Formlspol();
		}
		return entity;
	}
	
	@RequiresPermissions("log:formlspol:view")
	@RequestMapping(value = {"list", ""})
	public String list(Formlspol formlspol, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Formlspol> page = formlspolService.findPage(new Page<Formlspol>(request, response), formlspol); 
		model.addAttribute("page", page);
		return "modules/log/formlspolList";
	}

	@RequiresPermissions("log:formlspol:view")
	@RequestMapping(value = "form")
	public String form(Formlspol formlspol, Model model) {
		model.addAttribute("formlspol", formlspol);
		return "modules/log/formlspolForm";
	}

	@RequiresPermissions("log:formlspol:edit")
	@RequestMapping(value = "save")
	public String save(Formlspol formlspol, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, formlspol)){
			return form(formlspol, model);
		}
		formlspolService.save(formlspol);
		addMessage(redirectAttributes, "保存fff成功");
		return "redirect:"+Global.getAdminPath()+"/log/formlspol/?repage";
	}
	
	@RequiresPermissions("log:formlspol:edit")
	@RequestMapping(value = "delete")
	public String delete(Formlspol formlspol, RedirectAttributes redirectAttributes) {
		formlspolService.delete(formlspol);
		addMessage(redirectAttributes, "删除fff成功");
		return "redirect:"+Global.getAdminPath()+"/log/formlspol/?repage";
	}

}