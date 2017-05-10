/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class BaseService {
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 数据范围过滤
	 * @param user 当前用户对象，通过“entity.getCurrentUser()”获取
	 * @param hospitalAlias 医院表别名，多个用“,”逗号隔开。
	 * @param userAlias 用户表别名，多个用“,”逗号隔开，传递空，忽略此参数
	 * @return 标准连接条件对象
	 */
	public static String dataScopeFilter(User user, String hospitalAlias, String userAlias) {

		StringBuilder sqlString = new StringBuilder();
		
		// 进行权限过滤，多个角色权限范围之间为或者关系。
		List<String> dataScope = Lists.newArrayList();
		
		// 超级管理员，跳过权限过滤
		if (!user.isAdmin()){
			boolean isDataScopeAll = false;
			for (Role r : user.getRoleList()){
				for (String ha : StringUtils.split(hospitalAlias, ",")){
					if (!dataScope.contains(r.getDataScope()) && StringUtils.isNotBlank(ha)){
						if (Role.DATA_SCOPE_ALL.equals(r.getDataScope())){
							isDataScopeAll = true;
						}
						else if (Role.DATA_SCOPE_HOSPITAL.equals(r.getDataScope())){
							sqlString.append(" AND " + ha + ".id = '" + user.getHospital().getId() + "'");
						}
						else if (Role.DATA_SCOPE_CUSTOM.equals(r.getDataScope())){
							String hospitalIds =  StringUtils.join(r.getHospitalIdList(), "','");
							if (StringUtils.isNotEmpty(hospitalIds)){
								sqlString.append(" AND " + ha + ".id IN ('" + hospitalIds + "')");
							}
						}
						dataScope.add(r.getDataScope());
					}
				}
			}
			// 如果没有全部数据权限，并设置了用户别名，则当前权限为本人；如果未设置别名，当前无权限为已植入权限
			if (!isDataScopeAll){
				if (StringUtils.isNotBlank(userAlias)){
					for (String ua : StringUtils.split(userAlias, ",")){
						sqlString.append(" AND " + ua + ".id = '" + user.getId() + "'");
					}
				}else {
					for (String oa : StringUtils.split(hospitalAlias, ",")){
						sqlString.append(" AND " + oa + ".id  = '"+user.getHospital().getId()+"'");
						sqlString.append(" OR " + oa + ".id IS NULL");
					}
				}
			}else{
				// 如果包含全部权限，则去掉之前添加的所有条件，并跳出循环。
				sqlString = new StringBuilder();
			}
		}
		if (StringUtils.isNotBlank(sqlString.toString())){
			return " AND (" + sqlString.substring(4) + ")";
		}
		return "";
	}
	
	/**
	 * 数据范围过滤
	 * @param user 当前用户对象，通过“entity.getCurrentUser()”获取
	 * @param hospitalAlias 医院表别名，多个用“,”逗号隔开。
	 * @param userAlias 用户表别名，多个用“,”逗号隔开，传递空，忽略此参数
	 * @return 标准连接条件对象
	 */
	public static String recordsDataScopeFilter(User user) {

		StringBuilder sqlString = new StringBuilder();
		
		// 进行权限过滤，多个角色权限范围之间为或者关系。
		List<String> dataScope = Lists.newArrayList();
		
		// 超级管理员，跳过权限过滤
		if (!user.isAdmin()){
			boolean isDataScopeAll = false;
			for (Role r : user.getRoleList()){				
					if (!dataScope.contains(r.getDataScope())){
						if (Role.DATA_SCOPE_ALL.equals(r.getDataScope())){
							isDataScopeAll = true;
						}
						else if (Role.DATA_SCOPE_HOSPITAL.equals(r.getDataScope())){
							sqlString.append(" AND reqh.id = '" + user.getHospital().getId() + "' OR resph.id = '"+user.getHospital().getId()+"'");
						}
						else if (Role.DATA_SCOPE_CUSTOM.equals(r.getDataScope())){
							String hospitalIds =  StringUtils.join(r.getHospitalIdList(), "','");
							if (StringUtils.isNotEmpty(hospitalIds)){
								sqlString.append(" AND reqh.id IN ('" + hospitalIds + "') OR resph.id IN ('"+hospitalIds+"')");
							}
						}
						dataScope.add(r.getDataScope());
					}				
			}
			if (isDataScopeAll){
				sqlString = new StringBuilder();
			}
		}
		if (StringUtils.isNotBlank(sqlString.toString())){
			return " AND (" + sqlString.substring(4) + ")";
		}
		return "";
	}

}
