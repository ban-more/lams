/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.web;

import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.log.entity.Base;
import com.thinkgem.jeesite.modules.log.entity.Uploadstaics;
import com.thinkgem.jeesite.modules.log.service.PaperlessRelatedService;
import com.thinkgem.jeesite.modules.log.service.UploadstaicsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 保单数据统计Controller
 * @author wangzhenwei
 * @version 2018-01-15
 */
@Controller
@RequestMapping(value = "${adminPath}/log/paperlessRelated")
public class PaperlessRelatedController extends BaseController {

	@Autowired
	private PaperlessRelatedService paperlessRelatedService;

	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"list/findUploadByHour", ""})
	public String findUploadByHour( HttpServletRequest request, HttpServletResponse response, Model model) {

		return "modules/log/hstatistics";
	}

}