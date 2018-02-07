/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.node.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.node.entity.Node;
import com.thinkgem.jeesite.modules.node.dao.NodeDao;

/**
 * 节点Service
 * @author 王振伟
 * @version 2017-10-26
 */
@Service
@Transactional(readOnly = true)
public class NodeService extends CrudService<NodeDao, Node> {

	@Autowired
	protected NodeDao dao;


	public Node get(String id) {
		return super.get(id);
	}
	
	public List<Node> findList(Node node) {
		return super.findList(node);
	}
	
	public Page<Node> findPage(Page<Node> page, Node node) {
		return super.findPage(page, node);
	}
	public List<Node> findAllList1(){return dao.findAllList1();}
	@Transactional(readOnly = false)
	public void save(Node node) {
		super.save(node);
	}
	
	@Transactional(readOnly = false)
	public void delete(Node node) {
		super.delete(node);
	}
	
}