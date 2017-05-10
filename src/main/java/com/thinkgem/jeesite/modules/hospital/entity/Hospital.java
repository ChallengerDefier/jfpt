/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hospital.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 医院管理模块Entity
 * @author 谢亚涛
 * @version 2016-11-02
 */
public class Hospital extends DataEntity<Hospital> {
	
	private static final long serialVersionUID = 1L;
	private String hospitalName;		// 医院名称
	private String address;		// 地址
	private String hospitalNo;		// 医院编号
	private String level;		// 医院等级
	private String parentId = "0";	//上级节点
	
	public Hospital() {
		super();
	}

	public Hospital(String id){
		super(id);
	}

	@Length(min=1, max=200, message="医院名称长度必须介于 1 和 200 之间")
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	@Length(min=0, max=200, message="地址长度必须介于 0 和 200 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=1, max=6, message="医院编号长度必须介于 1 和 6 之间")
	public String getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	
	@Length(min=1, max=32, message="医院等级长度必须介于 1 和 32 之间")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}