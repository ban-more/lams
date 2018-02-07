/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.modules.log.entity.Base;
import com.thinkgem.jeesite.modules.log.entity.ProvBase;
import com.thinkgem.jeesite.modules.sys.entity.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.log.entity.Uploadstaics;
import com.thinkgem.jeesite.modules.log.service.UploadstaicsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 保单数据统计Controller
 * @author wangzhenwei
 * @version 2018-01-15
 */
@Controller
@RequestMapping(value = "${adminPath}/log/uploadstaics")
public class UploadstaicsController extends BaseController {

	@Autowired
	private UploadstaicsService uploadstaicsService;
	
	@ModelAttribute
	public Uploadstaics get(@RequestParam(required=false) String id) {
		Uploadstaics entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = uploadstaicsService.get(id);
		}
		if (entity == null){
			entity = new Uploadstaics();
		}
		return entity;
	}

	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"list", ""})
	public String findUploadByAll(Date date1, Date date2, HttpServletRequest request, HttpServletResponse response, Model model) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1);
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
			String time = format.format(c.getTime());
			time = time +"-01";
			int MaxDay=c.getActualMaximum(Calendar.DAY_OF_MONTH);
			c.set( c.get(Calendar.YEAR), c.get(Calendar.MONTH), MaxDay);
			try {
				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
				Date date3 = sdf.parse(time);//上月第一天
				Date date4 = c.getTime();//上月最后一天
				List<Base> mulds = uploadstaicsService.findUploadByMonth(date3, date4);
				model.addAttribute("mulds", mulds);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.MONTH, 0);
		c2.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		Date first = c2.getTime();//本月第一天
		Calendar c3 = Calendar.getInstance();
		c3.add(Calendar.DATE,-1);
		Date ytime=c3.getTime();//昨天
		List<Base> dulds = uploadstaicsService.findUploadByDay(first, ytime);
		model.addAttribute("dulds", dulds);

		List<Base> hulds = uploadstaicsService.findUploadByHour(ytime, ytime);
		model.addAttribute("hulds", hulds);

		return "modules/log/statistics";
	}

	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"list/findUploadByProv", ""})
	public String findUploadByProv(Date date1,Date date2,HttpServletRequest request, HttpServletResponse response, Model model) {
		if(date1!= null&&date2 != null) {
			List<ProvBase> prov = uploadstaicsService.findUploadByProv(date1,date2);
			model.addAttribute("prov", prov);
		}else{
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1);
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
			String time = format.format(c.getTime());
			time = time +"-01";
			int MaxDay=c.getActualMaximum(Calendar.DAY_OF_MONTH);
			c.set( c.get(Calendar.YEAR), c.get(Calendar.MONTH), MaxDay);
			try {
				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
				Date date3 = sdf.parse(time);
				Date date4 = c.getTime();//上月最后一天
				List<ProvBase> prov = uploadstaicsService.findUploadByProv(date3,date4);
				model.addAttribute("prov", prov);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return "modules/log/provstatistics";
	}
//	@RequiresPermissions("log:uploadstaics:view")
//	@RequestMapping(value = {"list/findUploadByMonth", ""})
//	public String findUploadByMonth(Date date1,Date date2,HttpServletRequest request, HttpServletResponse response, Model model) {
//		if(date1!= null&&date2 != null) {
//			List<Base> ulds = uploadstaicsService.findUploadByMonth(date1, date2);
//			model.addAttribute("ulds", ulds);
//		}else{
//			Calendar c = Calendar.getInstance();
//			c.add(Calendar.MONTH, -1);
//			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
//			String time = format.format(c.getTime());
//			time = time +"-01";
//			int MaxDay=c.getActualMaximum(Calendar.DAY_OF_MONTH);
//			c.set( c.get(Calendar.YEAR), c.get(Calendar.MONTH), MaxDay);
//			try {
//				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
//				Date date3 = sdf.parse(time);
//				Date date4 = c.getTime();//上月最后一天
//				List<Base> ulds = uploadstaicsService.findUploadByMonth(date3, date4);
//					model.addAttribute("ulds", ulds);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return "modules/log/provstatistics";
//	}
	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"list/findChartByDay", ""})
	public String findChartByDay(String id, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(id!=null&&!"".equals(id)&&id.indexOf("-")!= -1) {
			String [] date2 = id.split("-");
			System.out.println("ID："+id);
			id = id +"-01";
			Calendar cal = Calendar.getInstance();
			//设置年份
			cal.set(Calendar.YEAR,Integer.valueOf(date2[0]));
			//设置月份
			cal.set(Calendar.MONTH, Integer.valueOf(date2[1])-1);
			//获取某月最大天数
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DAY_OF_MONTH, lastDay);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = null;
			try {
				date1 = sdf.parse(id);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Map<String,List<String>> map = uploadstaicsService.findChartByDay(date1, cal.getTime());
			model.addAttribute("map", map);
		}else{
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1);
			SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM");
			String time = format.format(c.getTime());
			time = time +"-01";
			int MaxDay=c.getActualMaximum(Calendar.DAY_OF_MONTH);
			c.set( c.get(Calendar.YEAR), c.get(Calendar.MONTH), MaxDay);
			try {
				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
				Date date3 = sdf.parse(time);
				Date date4 = c.getTime();//上月最后一天
				Map<String,List<String>> map = uploadstaicsService.findChartByDay(date3, date4);
			model.addAttribute("map", map);
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		return "modules/log/dstatisticsChart";
	}

	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"list/findUploadByDay", ""})
	public String findUploadByDay(String id,Date date1, Date date2, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(id!=null&&!"".equals(id)&&id.indexOf("-")!= -1) {
			String [] dat2 = id.split("-");
			System.out.println("ID："+id);
			id = id +"-01";
			Calendar cal = Calendar.getInstance();
			//设置年份
			cal.set(Calendar.YEAR,Integer.valueOf(dat2[0]));
			//设置月份
			cal.set(Calendar.MONTH, Integer.valueOf(dat2[1])-1);
			//获取某月最大天数
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			cal.set(Calendar.DAY_OF_MONTH, lastDay);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dat1 = null;
			try {
				dat1 = sdf.parse(id);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			List<Base> ulds = uploadstaicsService.findUploadByDay(dat1, cal.getTime());
			model.addAttribute("ulds", ulds);
		}else if(date1!= null&&date2 != null) {
			List<Base> ulds = uploadstaicsService.findUploadByDay(date1, date2);
			model.addAttribute("ulds", ulds);
		}else{
			Calendar c2 = Calendar.getInstance();
			c2.add(Calendar.MONTH, 0);
			c2.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
			Date first = c2.getTime();//本月第一天
			Calendar c3 = Calendar.getInstance();
			c3.add(Calendar.DATE,-1);
			Date time=c3.getTime();//昨天
			List<Base> ulds = uploadstaicsService.findUploadByDay(first, time);
			model.addAttribute("ulds", ulds);
		}

		return "modules/log/dstatistics";
	}
	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"list/findLineChartByHour", ""})
	public String findLineChartByHour(Date date1, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(date1!= null) {
			Map<String,List<String>> map = uploadstaicsService.findChartByHour(date1,date1);
			model.addAttribute("map",map);
		}else{
			Calendar cal=Calendar.getInstance();//获取当前时间
			cal.add(Calendar.DATE,-1);
			Date time=cal.getTime();//昨天
			Map<String,List<String>> map = uploadstaicsService.findChartByHour(time,time);
			model.addAttribute("map",map);
		}
		return "modules/log/hstatisticsChart";
	}
	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"list/findUploadByHour", ""})
	public String findUploadByHour(Date date1, HttpServletRequest request, HttpServletResponse response, Model model) {
		if(date1!= null) {
			List<Base> ulds = uploadstaicsService.findUploadByHour(date1, date1);
			model.addAttribute("ulds", ulds);
		}else{
			Calendar cal=Calendar.getInstance();//获取当前时间
			cal.add(Calendar.DATE,-1);
			Date time=cal.getTime();//昨天
			List<Base> ulds = uploadstaicsService.findUploadByHour(time, time);
			model.addAttribute("ulds", ulds);
		}
		return "modules/log/hstatistics";
	}

	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"index"})
	public String index(User user, Model model) {
		return "modules/log/dateTreeIndex";
	}

	@RequiresPermissions("log:uploadstaics:view")
	@RequestMapping(value = {"chartIndex"})
	public String chartindex(User user, Model model) {
		return "modules/log/dstatisticsTreeIndex";
	}
	@RequiresPermissions("log:uploadstaics:view")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, @RequestParam(required=false) String type,
											  @RequestParam(required=false) Long grade, @RequestParam(required=false) Boolean isAll, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		Date d2 = new Date();//当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String date2 = sdf.format(d2);
		String date1 = String.valueOf(Integer.valueOf(date2) - 1)+"-01-01";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
		Date d1 = null;
		try {
			d1 = sdf1.parse(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar dd = Calendar.getInstance();//定义日期实例
		dd.setTime(d1);//设置日期起始时间
		int i=1;


		Map<String, Object> map0 = Maps.newHashMap();
		map0.put("id","1");
		map0.put("pId", "0");
		map0.put("pIds", "0,");
		map0.put("name", "日期");
		mapList.add(map0);
		String dat1 = String.valueOf(Integer.valueOf(date2) - 1);
		while(dd.getTime().before(d2)){
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM");
			String str = sdf3.format(dd.getTime());
			if(i%12==1){
				if(i!=1) {
					dat1 = String.valueOf(Integer.valueOf(dat1) + 1);
				}
				Map<String, Object> map = Maps.newHashMap();
				map.put("id",dat1);
				map.put("pId", "1");
				map.put("pIds", "1,0,");
				map.put("name", dat1);
				mapList.add(map);
				System.out.println("年份"+dat1);

			}
			Map<String, Object> map = Maps.newHashMap();
			map.put("id",str);
			map.put("pId", dat1);
			map.put("pIds", dat1+"1,0,");
			map.put("name", str);
			mapList.add(map);
			dd.add(Calendar.MONTH, 1);
			i++;
		}
		return mapList;
	}

}