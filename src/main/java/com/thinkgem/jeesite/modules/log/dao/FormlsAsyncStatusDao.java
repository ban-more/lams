/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDaoTwo;
import com.thinkgem.jeesite.modules.log.entity.FormlsAsyncStatus;
import com.thinkgem.jeesite.modules.log.entity.RatioBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * fdfdfDAO接口
 * @author wangzhenwei
 * @version 2018-01-12
 */
@MyBatisDaoTwo
public interface FormlsAsyncStatusDao extends CrudDao<FormlsAsyncStatus> {

    public String findAllInsuranceFee(@Param("date1") String date1, @Param("date2") String date2);
    public String findSumInsurance(@Param("date1") String date1, @Param("date2") String date2);
    public String findAllInsuranceNop(@Param("date1") String date1, @Param("date2") String date2);
    public List<RatioBase> findPolicyRatio(@Param("date1") String date1, @Param("date2") String date2, @Param("date3") String date3);
}