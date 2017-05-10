/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.records.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.records.entity.Records;
import com.thinkgem.jeesite.modules.records.entity.TotalRecords;
import com.thinkgem.jeesite.modules.records.dao.RecordsDao;

/**
 * 阅片记录实体Service
 * 
 * @author 谢亚涛
 * @version 2016-11-03
 */
@Service
@Transactional(readOnly = true)
public class RecordsService extends CrudService<RecordsDao, Records> {

	public Records get(String id) {
		return super.get(id);
	}

	public List<Records> findList(Records records) {
		return super.findList(records);
	}

	public Page<Records> findPage(Page<Records> page, Records records) {
		// 设置默认时间范围，默认当前月
		if (records.getBeginBackDate() == null) {
			records.setBeginBackDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd")+" 00:00:00"), 1));
		}
		if (records.getEndBackDate() == null) {
			records.setEndBackDate(DateUtils.addMonths(records.getBeginBackDate(), 1));
		}
		return super.findPage(page, records);
	}

	@Transactional(readOnly = false)
	public void save(Records records) {
		super.save(records);
	}

	@Transactional(readOnly = false)
	public void delete(Records records) {
		super.delete(records);
	}
	
	public String getTotal(Records records){
		
		if (records.getBeginBackDate() == null) {
			records.setBeginBackDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd")+" 00:00:00"), 1));
		}
		if (records.getEndBackDate() == null) {
			records.setEndBackDate(DateUtils.addMonths(records.getBeginBackDate(), 1));
		}
		String hospitalId  = records.getRequestHospital()==null?"":records.getRequestHospital().getId();
		
		List<Records> list = dao.findList(records);
		
		TotalRecords tr = new TotalRecords();
		Double hospitalIn = 0d,hospitalOut = 0d,platformFee = 0d;
		Integer count = 0, cr = 0, ct = 0, nj = 0, mr = 0, mg = 0, bc =0, xd = 0;
		
		if(list.size()>0){			
			count =list.size();
			for(Records r : list){
				Double d = r.getFeeSet().getHospitalFee();
				Double scale = r.getFeeSet().getScale();
				platformFee += d*scale;
				if(StringUtils.isNotBlank(hospitalId)){
					if(r.getRequestHospital().getId().equals(hospitalId)){
						hospitalOut+=d*(1-scale);
					}else if(r.getResponseHospital().getId().equals(hospitalId)){
						hospitalIn+=d*(1-scale);
					}
				}
				switch (r.getFeeSet().getFeeType()) {
				case "1":	//CR/DR
					cr++;
					break;
				case "2":	//CT
					ct++;
					break;
				case "3":	//NJ
					nj++;
					break;
				case "4":	//MR
					mr++;
					break;	
				case "5":	//MG
					mg++;
					break;
				case "6":	//BC
					bc++;
					break;
				case "7":	//心电
					xd++;
					break;
				default:
					break;
				}
			}			
		}
		tr.setRecordsCount(count);
		tr.setCrCount(cr);
		tr.setCtCount(ct);
		tr.setNjCount(nj);
		tr.setMrCount(mr);
		tr.setMgCount(mg);
		tr.setBcCount(bc);
		tr.setXdCount(xd);
		tr.setHospitalIn(hospitalIn);
		tr.setHospitalOut(hospitalOut);
		tr.setPlatformFee(platformFee);
		return JsonMapper.getInstance().toJson(tr);
	}
	
	public String getLineData(Records records){
		
		if (records.getBeginBackDate() == null) {
			records.setBeginBackDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate("yyyy-MM-dd")+" 00:00:00"), 1));
		}
		if (records.getEndBackDate() == null) {
			records.setEndBackDate(DateUtils.addMonths(records.getBeginBackDate(), 1));
		}
				
		List<TotalRecords> list = dao.findListForLine(records);

		return JsonMapper.getInstance().toJson(list);
	}
}