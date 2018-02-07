/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.node.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.node.entity.Node;

import java.util.List;

/**
 * 节点DAO接口
 * @author 王振伟
 * @version 2017-10-26
 */
@MyBatisDao
public interface NodeDao extends CrudDao<Node> {
	public List<Node> findAllList1();
}