/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.feeset.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.hospital.entity.Hospital;

/**
 * 费用设置管理实体Entity
 * @author 谢亚涛
 * @version 2016-11-02
 */
public class FeeSet extends DataEntity<FeeSet> {
	
	private static final long serialVersionUID = 1L;
	private String hospitalId;		// 医院ID
	private String feeType;		// 费用类型
	private Double hospitalFee;		// 医院收费
	private Double scale;		// 平台提成比例
	private Hospital hospital;//关联的医院实体对象
	
	public FeeSet() {
		super();
	}

	public FeeSet(String id){
		super(id);
	}

	
	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	@Length(min=1, max=2, message="费用类型长度必须介于 1 和 2 之间")
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	
	public Double getHospitalFee() {
		return hospitalFee;
	}

	public void setHospitalFee(Double hospitalFee) {
		this.hospitalFee = hospitalFee;
	}
	
	public Double getScale() {
		return scale;
	}

	public void setScale(Double scale) {
		this.scale = scale;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
}