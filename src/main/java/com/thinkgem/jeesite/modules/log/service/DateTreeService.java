/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.log.entity.DateTree;
import com.thinkgem.jeesite.modules.log.dao.DateTreeDao;

/**
 * 日期树Service
 * @author wangzhenwei
 * @version 2018-01-22
 */
@Service
@Transactional(readOnly = true)
public class DateTreeService extends CrudService<DateTreeDao, DateTree> {

	public DateTree get(String id) {
		return super.get(id);
	}
	
	public List<DateTree> findList(DateTree dateTree) {
		return super.findList(dateTree);
	}
	
	public Page<DateTree> findPage(Page<DateTree> page, DateTree dateTree) {
		return super.findPage(page, dateTree);
	}
	
	@Transactional(readOnly = false)
	public void save(DateTree dateTree) {
		super.save(dateTree);
	}
	
	@Transactional(readOnly = false)
	public void delete(DateTree dateTree) {
		super.delete(dateTree);
	}
	
}