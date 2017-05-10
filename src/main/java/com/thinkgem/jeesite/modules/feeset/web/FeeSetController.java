/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.feeset.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.feeset.entity.FeeSet;
import com.thinkgem.jeesite.modules.feeset.service.FeeSetService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 费用设置管理实体Controller
 * @author 谢亚涛
 * @version 2016-11-02
 */
@Controller
@RequestMapping(value = "${adminPath}/feeset/feeSet")
public class FeeSetController extends BaseController {

	@Autowired
	private FeeSetService feeSetService;
	
	@ModelAttribute
	public FeeSet get(@RequestParam(required=false) String id) {
		FeeSet entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = feeSetService.get(id);
		}
		if (entity == null){
			entity = new FeeSet();
		}
		return entity;
	}
	
	@RequiresPermissions("feeset:feeSet:view")
	@RequestMapping(value = {"list", ""})
	public String list(FeeSet feeSet, HttpServletRequest request, HttpServletResponse response, Model model) {
		feeSet.getSqlMap().put("dsf", BaseService.dataScopeFilter(UserUtils.getUser(), "h", ""));
		Page<FeeSet> page = feeSetService.findPage(new Page<FeeSet>(request, response), feeSet); 
		model.addAttribute("page", page);
		return "modules/feeset/feeSetList";
	}

	@RequiresPermissions("feeset:feeSet:view")
	@RequestMapping(value = "form")
	public String form(FeeSet feeSet, Model model) {
		model.addAttribute("feeSet", feeSet);
		return "modules/feeset/feeSetForm";
	}

	@RequiresPermissions("feeset:feeSet:edit")
	@RequestMapping(value = "save")
	public String save(FeeSet feeSet, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, feeSet)){
			return form(feeSet, model);
		}
		if(feeSetService.getOne(feeSet)==null){
			feeSetService.save(feeSet);
			addMessage(redirectAttributes, "保存数据成功！");
		}else{
			addMessage(redirectAttributes, "所选医院该类型记录已经存在，请确认！");
		}	
		return "redirect:"+Global.getAdminPath()+"/feeset/feeSet/?repage";
	}
	
	@RequiresPermissions("feeset:feeSet:edit")
	@RequestMapping(value = "delete")
	public String delete(FeeSet feeSet, RedirectAttributes redirectAttributes) {
		feeSetService.delete(feeSet);
		addMessage(redirectAttributes, "删除数据成功");
		return "redirect:"+Global.getAdminPath()+"/feeset/feeSet/?repage";
	}
	
	/*@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "checkFeeSet")
	public String checkFeeSet(@RequestParam(value="hospitalId",required=true)String hospitalId,
			@RequestParam(value="feeType",required=true)String feeType) {
		FeeSet f = new FeeSet();
		f.setHospitalId(hospitalId);
		f.setFeeType(feeType);
		if(feeSetService.getOne(f)==null){
			return "true";
		}
		return "false";
	}*/

}