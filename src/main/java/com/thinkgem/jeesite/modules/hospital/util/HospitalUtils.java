package com.thinkgem.jeesite.modules.hospital.util;

import java.util.List;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.hospital.dao.HospitalDao;
import com.thinkgem.jeesite.modules.hospital.entity.Hospital;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

public class HospitalUtils extends BaseService {
	private static HospitalDao dao = SpringContextHolder.getBean(HospitalDao.class);
	
	public static List<Hospital> getHospitalList(){
		
		Hospital hospital = new Hospital();
		hospital.getSqlMap().put("dsf", dataScopeFilter(UserUtils.getUser(),"a",""));
		List<Hospital> hospitalList = dao.findAll(hospital);
		if(hospitalList==null){
			hospitalList = Lists.newArrayList();
		}				
		return hospitalList;
	}
}
