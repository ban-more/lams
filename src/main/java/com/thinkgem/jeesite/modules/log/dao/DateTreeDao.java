/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.log.entity.DateTree;

/**
 * 日期树DAO接口
 * @author wangzhenwei
 * @version 2018-01-22
 */
@MyBatisDao
public interface DateTreeDao extends CrudDao<DateTree> {
	
}