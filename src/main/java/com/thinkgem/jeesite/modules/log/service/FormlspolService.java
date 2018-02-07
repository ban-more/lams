/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.log.entity.Formlspol;
import com.thinkgem.jeesite.modules.log.dao.FormlspolDao;

/**
 * asdService
 * @author wangzhenwei
 * @version 2018-01-12
 */
@Service
@Transactional(readOnly = true)
public class FormlspolService extends CrudService<FormlspolDao, Formlspol> {

	public Formlspol get(String id) {
		return super.get(id);
	}
	
	public List<Formlspol> findList(Formlspol formlspol) {
		return super.findList(formlspol);
	}
	
	public Page<Formlspol> findPage(Page<Formlspol> page, Formlspol formlspol) {
		return super.findPage(page, formlspol);
	}
	
	@Transactional(readOnly = false)
	public void save(Formlspol formlspol) {
		super.save(formlspol);
	}
	
	@Transactional(readOnly = false)
	public void delete(Formlspol formlspol) {
		super.delete(formlspol);
	}
	
}