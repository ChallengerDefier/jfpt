/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hospital.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.hospital.entity.Hospital;

/**
 * 医院管理模块DAO接口
 * @author 谢亚涛
 * @version 2016-11-02
 */
@MyBatisDao
public interface HospitalDao extends CrudDao<Hospital> {
	
	public List<Hospital> findAll(Hospital hos);
	
	public Hospital getHospitalByNo(String no);
	
	public Hospital getHospitalByNo(Hospital hos);
	
	public Hospital getHospitalByName(Hospital hos);
}