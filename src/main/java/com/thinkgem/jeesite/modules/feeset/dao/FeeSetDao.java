/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.feeset.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.feeset.entity.FeeSet;

/**
 * 费用设置管理实体DAO接口
 * @author 谢亚涛
 * @version 2016-11-02
 */
@MyBatisDao
public interface FeeSetDao extends CrudDao<FeeSet> {
	public FeeSet getOne(FeeSet feeSet);
}