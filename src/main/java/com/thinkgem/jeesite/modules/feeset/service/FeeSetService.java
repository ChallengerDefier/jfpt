/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.feeset.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.feeset.entity.FeeSet;
import com.thinkgem.jeesite.modules.feeset.dao.FeeSetDao;

/**
 * 费用设置管理实体Service
 * @author 谢亚涛
 * @version 2016-11-02
 */
@Service
@Transactional(readOnly = true)
public class FeeSetService extends CrudService<FeeSetDao, FeeSet> {

	public FeeSet get(String id) {
		return super.get(id);
	}
	
	public List<FeeSet> findList(FeeSet feeSet) {
		return super.findList(feeSet);
	}
	
	public Page<FeeSet> findPage(Page<FeeSet> page, FeeSet feeSet) {
		return super.findPage(page, feeSet);
	}
	
	@Transactional(readOnly = false)
	public void save(FeeSet feeSet) {
		super.save(feeSet);
	}
	
	@Transactional(readOnly = false)
	public void delete(FeeSet feeSet) {
		super.delete(feeSet);
	}
	
	public FeeSet getOne(FeeSet f){
		return dao.getOne(f);
	}
	
}