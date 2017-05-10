/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hospital.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.hospital.entity.Hospital;
import com.thinkgem.jeesite.modules.hospital.service.HospitalService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 医院管理模块Controller
 * @author 谢亚涛
 * @version 2016-11-02
 */
@Controller
@RequestMapping(value = "${adminPath}/hospital/hospital")
public class HospitalController extends BaseController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@ModelAttribute
	public Hospital get(@RequestParam(required=false) String id) {
		Hospital entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = hospitalService.get(id);
		}
		if (entity == null){
			entity = new Hospital();
		}
		return entity;
	}
	
	@RequiresPermissions("hospital:hospital:view")
	@RequestMapping(value = {"list", ""})
	public String list(Hospital hospital, HttpServletRequest request, HttpServletResponse response, Model model) {
		
		hospital.getSqlMap().put("dsf", BaseService.dataScopeFilter(UserUtils.getUser(), "a", ""));
		Page<Hospital> page = hospitalService.findPage(new Page<Hospital>(request, response), hospital); 
		model.addAttribute("page", page);
		return "modules/hospital/hospitalList";
	}

	@RequiresPermissions("hospital:hospital:view")
	@RequestMapping(value = "form")
	public String form(Hospital hospital, Model model) {
		model.addAttribute("hospital", hospital);
		return "modules/hospital/hospitalForm";
	}

	@RequiresPermissions("hospital:hospital:edit")
	@RequestMapping(value = "save")
	public String save(Hospital hospital, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, hospital)){
			return form(hospital, model);
		}
		hospitalService.save(hospital);
		addMessage(redirectAttributes, "保存医院成功");
		return "redirect:"+Global.getAdminPath()+"/hospital/hospital/?repage";
	}
	
	@RequiresPermissions("hospital:hospital:edit")
	@RequestMapping(value = "delete")
	public String delete(Hospital hospital, RedirectAttributes redirectAttributes) {
		hospitalService.delete(hospital);
		addMessage(redirectAttributes, "删除医院成功");
		return "redirect:"+Global.getAdminPath()+"/hospital/hospital/?repage";
	}
	
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "checkName")
	public String checkName(@RequestParam(value="hospitalName",required=false)String hospitalName) {
		if (StringUtils.isNotBlank(hospitalName)){
			Hospital hos = new Hospital();
			hos.setHospitalName(hospitalName);
			if(hospitalService.getHospitalByName(hos) == null){
				return "true";
			}
		}
		return "false";
	}
	
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "checkNo")
	public String checkNo(@RequestParam(value="hospitalNo",required=false)String hospitalNo) {
		if (StringUtils.isNotBlank(hospitalNo)){
			Hospital hos = new Hospital();
			hos.setHospitalNo(hospitalNo);
			if(hospitalService.getHospitalByNo(hos) == null)
			{
				return "true";
			}
		}
		return "false";
	}
}