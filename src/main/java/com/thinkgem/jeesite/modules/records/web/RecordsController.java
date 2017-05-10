/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.records.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.modules.records.entity.Records;
import com.thinkgem.jeesite.modules.records.service.RecordsService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 阅片记录实体Controller
 * @author 谢亚涛
 * @version 2016-11-03
 */
@Controller
@RequestMapping(value = "${adminPath}/records/records")
public class RecordsController extends BaseController {

	@Autowired
	private RecordsService recordsService;
	
	@ModelAttribute
	public Records get(@RequestParam(required=false) String id) {
		Records entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = recordsService.get(id);
		}
		if (entity == null){
			entity = new Records();
		}
		return entity;
	}
	
	@RequiresPermissions("records:records:view") 
	@RequestMapping(value = {"list", ""})
	public String list(Records records, HttpServletRequest request, HttpServletResponse response, Model model) {
		records.getSqlMap().put("dsf", BaseService.recordsDataScopeFilter(UserUtils.getUser()));
		if(StringUtils.isBlank(records.getMoneyInOut())){
			records.setMoneyInOut("0");
		}
		Page<Records> page = recordsService.findPage(new Page<Records>(request, response), records); 
		model.addAttribute("page", page);
		model.addAttribute("totalRecords",recordsService.getTotal(records));
		model.addAttribute("lineDatas", recordsService.getLineData(records));
		return "modules/records/recordsList";
	}

	@RequiresPermissions("records:records:view")
	@RequestMapping(value = "form")
	public String form(Records records, Model model) {
		model.addAttribute("records", records);
		return "modules/records/recordsForm";
	}

	@RequiresPermissions("records:records:edit")
	@RequestMapping(value = "save")
	public String save(Records records, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, records)){
			return form(records, model);
		}
		recordsService.save(records);
		addMessage(redirectAttributes, "保存阅片记录成功");
		return "redirect:"+Global.getAdminPath()+"/records/records/?repage";
	}
	
	@RequiresPermissions("records:records:edit")
	@RequestMapping(value = "delete")
	public String delete(Records records, RedirectAttributes redirectAttributes) {
		recordsService.delete(records);
		addMessage(redirectAttributes, "删除阅片记录成功");
		return "redirect:"+Global.getAdminPath()+"/records/records/?repage";
	}
	
	/**
	 * 导出阅片记录明细数据
	 * @param records
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("records:records:view")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(Records records, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "报表明细数据"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<Records> page = recordsService.findPage(new Page<Records>(request, response,-1), records);
    		new ExportExcel("合作阅片明细数据", Records.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出报表数据失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/records/records/list?repage";
    }

}