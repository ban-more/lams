/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ehome.sourch.logService.LogServiceImpl;
import com.ehome.sourch.pojo.Log;
import com.ehome.sourch.pojo.Node;
import com.ehome.sourch.utils.GetServerMessageUtil;
import com.thinkgem.jeesite.modules.log.util.NodeToNode;
import com.thinkgem.jeesite.modules.node.service.NodeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.web.BaseController;


import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * 搜索日志信息Controller
 * @author 王振伟
 * @version 2017-10-20
 */
@Controller
@RequestMapping(value = "${adminPath}/log/log")
public class ServerLogController extends BaseController {

	@Autowired
	private NodeService nodeService;

	private LogServiceImpl logService;

	@RequiresPermissions("log:log:view")
	@RequestMapping(value = {"list/bynew", ""})
	public String listByNew(String keyword,Date date,String[] nodeids, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, InterruptedException {
		GetServerMessageUtil getServerMessageUtil = new GetServerMessageUtil();
//		List<Node> nodes = getServerMessageUtil.getNodes();
		List<Node> nodes = new ArrayList<Node>();
		NodeToNode n1 = new NodeToNode();
		if(nodeids != null) {
			System.out.print("nodeids不为空？？？？");
			for (int i = 0; i < nodeids.length; i++) {
				nodes.add(n1.nodeToNode(nodeService.get(nodeids[i])));
			}
		}else {

			System.out.print("未选定任何服务器，默认指定所有服务器！！");
			nodes.addAll(n1.nodesToNodes(nodeService.findAllList1()));
		}

		logService = new LogServiceImpl();
		String logString = null;
		if (date != null) {
			System.out.println("*********************************8s");
					logString = logService.findAllLogByDate(date,nodes,keyword);

		}else {
				logString = logService.findLogByNew(nodes, keyword);
		}
		List<Log> logs = JSON.parseArray(logString, Log.class);
		model.addAttribute("logs", logs);
		return "modules/log/logList";
	}
	@RequiresPermissions("log:log:view")
	@RequestMapping(value = {"list", ""})
	public String list(){

		return "modules/log/logList";
	}
	@RequiresPermissions("log:log:view")
	@RequestMapping(value = {"list/detalis", ""})
	public String listAll(Log log,Long line, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		System.out.println(log.getNodename());
		logService = new LogServiceImpl();
		String logString =  logService.findLogByLine(log.getNode(),log.getNodename(),log.getKeyword(),log.getFilename(),line);
		Log log1 = JSON.parseObject(logString, Log.class);
		model.addAttribute("log1", log1);
		return "modules/log/logDetalis";
	}


}