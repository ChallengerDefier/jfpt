package com.thinkgem.jeesite.modules.records.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.feeset.entity.FeeSet;
import com.thinkgem.jeesite.modules.feeset.service.FeeSetService;
import com.thinkgem.jeesite.modules.hospital.entity.Hospital;
import com.thinkgem.jeesite.modules.hospital.service.HospitalService;
import com.thinkgem.jeesite.modules.records.entity.Records;
import com.thinkgem.jeesite.modules.records.service.RecordsService;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

@Controller
@RequestMapping(value = "/servlet/records")
public class APIController extends BaseController {

	@Autowired
	public HospitalService hosService;

	@Autowired
	public FeeSetService feeSetService;

	@Autowired
	public RecordsService rService;

	@RequestMapping(value = "insert")
	@ResponseBody
	public Map<String, Object> insertRecords(@RequestBody Records record) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		if (record == null) {
			resultMap.put("errcode", 400);
			resultMap.put("errmessage", "请求参数错误！");
			return resultMap;
		}
		if (StringUtils.isBlank(record.getRequestHospitalNo())
				|| hosService.getHospitalByNo(record.getRequestHospitalNo()) == null) {
			resultMap.put("errcode", 1);
			resultMap.put("errmessage", "请求阅片医院的编号不存在！");
			return resultMap;
		}
		if (StringUtils.isBlank(record.getResponseHospitalNo())
				|| hosService.getHospitalByNo(record.getResponseHospitalNo()) == null) {
			resultMap.put("errcode", 2);
			resultMap.put("errmessage", "合作阅片医院的编号不存在！");
			return resultMap;
		}
		if (StringUtils.isBlank(record.getFeeType())
				|| !DictUtils.checkDictType("feeType", record.getFeeType())) {
			resultMap.put("errcode", 3);
			resultMap.put("errmessage", "阅片检查类型的编号不存在！");
			return resultMap;
		}
		if (Integer.parseInt(resultMap.get("errcode").toString()) == 0) {
			Hospital hos = hosService.getHospitalByNo(record
					.getResponseHospitalNo());
			FeeSet fee = new FeeSet();
			fee.setFeeType(record.getFeeType());
			fee.setHospitalId(hos.getId());
			FeeSet f = feeSetService.getOne(fee);
			record.setFeeSet(f);
			rService.save(record);
			resultMap.put("errcode", 0);
			resultMap.put("errmessage", "ok");
		}
		System.out.println("外部接口成功访问！***************************");
		System.out.println(JsonMapper.toJsonString(record));
		return resultMap;
	}
}
