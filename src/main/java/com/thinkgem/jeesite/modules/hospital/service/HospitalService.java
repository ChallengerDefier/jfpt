/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hospital.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.hospital.entity.Hospital;
import com.thinkgem.jeesite.modules.hospital.dao.HospitalDao;

/**
 * 医院管理模块Service
 * @author 谢亚涛
 * @version 2016-11-02
 */
@Service
@Transactional(readOnly = true)
public class HospitalService extends CrudService<HospitalDao, Hospital> {

	
	public Hospital get(String id) {
		return super.get(id);
	}
	
	public List<Hospital> findList(Hospital hospital) {
		return super.findList(hospital);
	}
	
	public Page<Hospital> findPage(Page<Hospital> page, Hospital hospital) {
		return super.findPage(page, hospital);
	}
	
	@Transactional(readOnly = false)
	public void save(Hospital hospital) {
		super.save(hospital);
	}
	
	@Transactional(readOnly = false)
	public void delete(Hospital hospital) {
		super.delete(hospital);
	}
	
	public List<Hospital> findAll(Hospital hospital){
		return dao.findAll(hospital);
	}
	
	/**验证传入的医院编号是否存在
	 * @param hospital
	 * @return 
	 */
	public Hospital getHospitalByNo(String no){
		
		return dao.getHospitalByNo(no);
		
	}
	
	public Hospital getHospitalByNo(Hospital hos){
		return dao.getHospitalByNo(hos);
	}
	
	/**根据传入的医院名字查询医院信息
	 * @param hospitalName
	 * @return
	 */
	public Hospital getHospitalByName(Hospital hospital){
		return dao.getHospitalByName(hospital);
	}
}