/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDaoTwo;
import com.thinkgem.jeesite.modules.log.entity.Base;
import com.thinkgem.jeesite.modules.log.entity.ProvBase;
import com.thinkgem.jeesite.modules.log.entity.Uploadstaics;
import org.apache.ibatis.annotations.Param;


import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * daDAO接口
 * @author wangzhenwei
 * @version 2018-01-11
 */
@MyBatisDaoTwo
public interface UploadstaicsDao extends CrudDao<Uploadstaics> {

    public List<Base> findUploadByMonth(@Param("date1") String date1, @Param("date2") String date2);
    public List<Base> findUploadByDay(@Param("date1") String date1, @Param("date2") String date2);
    public List<Base> findUploadByHour(@Param("date1") String date1, @Param("date2") String date2);
    public List<ProvBase> findUploadByProv(@Param("date1") String date1, @Param("date2") String date2);
}