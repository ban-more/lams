/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.service;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.thinkgem.jeesite.modules.log.entity.Base;
import com.thinkgem.jeesite.modules.log.entity.ProvBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.log.entity.Uploadstaics;
import com.thinkgem.jeesite.modules.log.dao.UploadstaicsDao;

/**
 * daService
 * @author wangzhenwei
 * @version 2018-01-11
 */
@Service
@Transactional(readOnly = true)
public class UploadstaicsService extends CrudService<UploadstaicsDao, Uploadstaics> {

	public Uploadstaics get(String id) {
		return super.get(id);
	}
	
	public List<Uploadstaics> findList(Uploadstaics uploadstaics) {
		return super.findList(uploadstaics);
	}
	
	public Page<Uploadstaics> findPage(Page<Uploadstaics> page, Uploadstaics uploadstaics) {
		return super.findPage(page, uploadstaics);
	}

	public List<Base> findUploadByMonth(Date date1, Date date2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
		String dat1=sdf.format(date1);
		String dat2=sdf.format(date2);

		String[] da2= dat2.split("-");
		String month = da2[0] + "年" + da2[1] +"月";
		List<Base> ulds= dao.findUploadByMonth(dat1,dat2);
		return ulds;
	}

	public List<Base> findUploadByDay(Date date1, Date date2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
		String dat1=sdf.format(date1);
		String dat2=sdf.format(date2);
		return dao.findUploadByDay(dat1,dat2);
	}

	public Map<String,List<String>> findChartByDay(Date date1,Date date2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
		String dat1=sdf.format(date1);
		String dat2=sdf.format(date2);
		List<Base> list = dao.findUploadByDay(dat1,dat2);
		List<String> dat = new ArrayList<String>();
		List<String> policys = new ArrayList<String>();
		List<String> insurance = new ArrayList<String>();
		for(Base base : list){
			String[] da = base.getDat().split("-");
			dat.add(da[2]);
			policys.add(base.getPolicys());
			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			insurance.add(decimalFormat.format(Float.parseFloat(base.getInsurance())/10000));
		}
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		map.put("dat",dat);
		map.put("policys",policys);
		map.put("insurance",insurance);

		return map;
	}

	public List<Base> findUploadByHour(Date date1, Date date2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
		String dat1=sdf.format(date1);
		String dat2=sdf.format(date2);
		return dao.findUploadByHour(dat1,dat2);
	}

	public Map<String,List<String>> findChartByHour(Date date1,Date date2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
		String dat1=sdf.format(date1);
		String dat2=sdf.format(date2);
		List<Base> list = dao.findUploadByHour(dat1,dat2);
		List<String> dat = new ArrayList<String>();
		List<String> policys = new ArrayList<String>();
		List<String> insurance = new ArrayList<String>();
		int i =1;
		for(Base base : list) {
			if (i % 24 != 0){
				dat.add(String.valueOf(i % 24));
		}else{
				dat.add(String.valueOf(24));
			}
			policys.add(base.getPolicys());
			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			insurance.add(decimalFormat.format(Float.parseFloat(base.getInsurance())/10000));
			i++;
		}

		Map<String,List<String>> map = new HashMap<String, List<String>>();
		map.put("dat",dat);
		map.put("policys",policys);
		map.put("insurance",insurance);

		return map;
	}
	public List<ProvBase> findUploadByProv(Date date1,Date date2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
		String dat1=sdf.format(date1);
		String dat2=sdf.format(date2);
		List<ProvBase> list = dao.findUploadByProv(dat1,dat2);
		int p = 0;
		float i = 0;
		for(ProvBase provBase : list){
			p = p+Integer.valueOf(provBase.getPolicys());
			i = i+Float.parseFloat(provBase.getInsurance());
		}
		ProvBase pBase = new ProvBase();
		pBase.setProv("总计");
		pBase.setPolicys(String.valueOf(p));
		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.

		pBase.setInsurance(decimalFormat.format(i/10000)+" 万元");

		list.add(pBase);
		return list;
	}
	@Transactional(readOnly = false)
	public void save(Uploadstaics uploadstaics) {
		super.save(uploadstaics);
	}
	
	@Transactional(readOnly = false)
	public void delete(Uploadstaics uploadstaics) {
		super.delete(uploadstaics);
	}
	
}