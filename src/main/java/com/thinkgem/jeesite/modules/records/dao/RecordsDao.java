/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.records.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.records.entity.Records;
import com.thinkgem.jeesite.modules.records.entity.TotalRecords;

/**
 * 阅片记录实体DAO接口
 * @author 谢亚涛
 * @version 2016-11-03
 */
@MyBatisDao
public interface RecordsDao extends CrudDao<Records> {
	
	public List<TotalRecords> findListForLine(Records records); 
}