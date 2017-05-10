/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.records.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.modules.feeset.entity.FeeSet;

/**
 * 阅片记录实体Entity
 * @author 谢亚涛
 * @version 2016-11-03
 */
@SuppressWarnings("serial")
public class Records extends DataEntity<Records> {
	
	private FeeSet feeSet;	//关联费用实体
	private Date applyDate;		// 请求阅片日期
	private Date backDate;		// 阅片回传日期
	private RequestHospital requestHospital;	// 申请阅片医院
	private String requestProfessorName;		// 申请阅片专家
	private ResponseHospital responseHospital;		// 合作中心医院
	private String responseProfessorName;		// 合作阅片专家
	private String treatmentNo;		// 诊疗号
	private String patientNo;		// 患者编号
	private String patientName;		// 患者姓名
	private String sex;		// 性别
	private String patientAge;		// 患者年龄
	private String checkContent;		// 检查部位
	private String advice;		// 阅片诊断意见
	private Date beginBackDate;		// 开始 阅片回传日期
	private Date endBackDate;		// 结束 阅片回传日期
	private String moneyInOut;//收入支出
	
	private String requestHospitalNo;//请求阅片医院编号（下级），用于接收接口推送过来的参数
	private String responseHospitalNo;//合作阅片医院编号（中心），用于接收接口推送过来的参数
	private String feeType;//费用类型编号，用于接收接口推送过来的参数
	
	private Double hospitalFee;//导出使用，医院费用
	private Double platformFee;//导出使用，平台费用
	
	public Records() {
		super();
	}

	public Records(String id){
		super(id);
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="请求阅片日期不能为空")
	@ExcelField(title="请求阅片日期", type=1, align=1, sort=10)
	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="阅片回传日期不能为空")
	@ExcelField(title="阅片回传日期", type=1, align=1, sort=20)
	public Date getBackDate() {
		return backDate;
	}

	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	@ExcelField(title="请求阅片医院",type=1,align=1,sort=30,value="requestHospital.hospitalName")
	public RequestHospital getRequestHospital() {
		return requestHospital;
	}

	public void setRequestHospital(RequestHospital requestHospital) {
		this.requestHospital = requestHospital;
	}
	
	@Length(min=1, max=100, message="申请阅片专家长度必须介于 1 和 100 之间")
	@ExcelField(title="请求阅片专家",type=1,align=1,sort=40)
	public String getRequestProfessorName() {
		return requestProfessorName;
	}

	public void setRequestProfessorName(String requestProfessorName) {
		this.requestProfessorName = requestProfessorName;
	}
	
	@ExcelField(title="合作阅片医院",type=1,align=1,sort=30,value="responseHospital.hospitalName")
	public ResponseHospital getResponseHospital() {
		return responseHospital;
	}

	public void setResponseHospital(ResponseHospital responseHospital) {
		this.responseHospital = responseHospital;
	}
	
	@Length(min=1, max=100, message="合作阅片专家长度必须介于 1 和 100 之间")
	@ExcelField(title="合作阅片专家",type=1,align=1,sort=60)
	public String getResponseProfessorName() {
		return responseProfessorName;
	}

	public void setResponseProfessorName(String responseProfessorName) {
		this.responseProfessorName = responseProfessorName;
	}
	
	@Length(min=1, max=32, message="诊疗号长度必须介于 1 和 32 之间")
	@ExcelField(title="诊疗号",type=1,align=1,sort=70)
	public String getTreatmentNo() {
		return treatmentNo;
	}

	public void setTreatmentNo(String treatmentNo) {
		this.treatmentNo = treatmentNo;
	}
	
	@Length(min=1, max=32, message="患者编号长度必须介于 1 和 32 之间")
	@ExcelField(title="患者编号",type=1,align=1,sort=80)
	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	
	@Length(min=1, max=100, message="患者姓名长度必须介于 1 和 100 之间")
	@ExcelField(title="患者姓名",type=1,align=1,sort=90)
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	@Length(min=1, max=32, message="性别长度必须介于 1 和 32 之间")
	@ExcelField(title="性别",type=1,align=1,sort=100,dictType="sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=11, message="患者年龄长度必须介于 1 和 11 之间")
	@ExcelField(title="年龄",type=1,align=1,sort=110)
	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	
	@Length(min=1, max=1000, message="检查部位长度必须介于 1 和 1000 之间")
	@ExcelField(title="检查部位",type=1,align=1,sort=120)
	public String getCheckContent() {
		return checkContent;
	}

	public void setCheckContent(String checkContent) {
		this.checkContent = checkContent;
	}
	
	@Length(min=1, max=4000, message="阅片诊断意见长度必须介于 1 和 4000 之间")
	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}
	
	public Date getBeginBackDate() {
		return beginBackDate;
	}

	public void setBeginBackDate(Date beginBackDate) {
		this.beginBackDate = beginBackDate;
	}
	
	public Date getEndBackDate() {
		return endBackDate;
	}

	public void setEndBackDate(Date endBackDate) {
		this.endBackDate = endBackDate;
	}
	
	@ExcelField(title="检查类型",type=1,align=1,sort=130,value="feeSet.feeType")
	public FeeSet getFeeSet() {
		return feeSet;
	}

	public void setFeeSet(FeeSet feeSet) {
		this.feeSet = feeSet;
	}

	public String getMoneyInOut() {
		return moneyInOut;
	}

	public void setMoneyInOut(String moneyInOut) {
		this.moneyInOut = moneyInOut;
	}
	@JsonIgnore
	@ExcelField(title="诊疗金",type=1,align=1,sort=140)
	public Double getHospitalFee() {
		Double money = this.feeSet.getHospitalFee();
		Double scale = this.feeSet.getScale();
		return money*(1.00-scale);
	}

	public void setHospitalFee(Double hospitalFee) {
		this.hospitalFee = hospitalFee;
	}
	@JsonIgnore
	@ExcelField(title="平台服务费",type=1,align=1,sort=150)
	public Double getPlatformFee() {
		Double money = this.feeSet.getHospitalFee();
		Double scale = this.feeSet.getScale();
		return money*scale;
	}

	public void setPlatformFee(Double platformFee) {
		this.platformFee = platformFee;
	}

	public String getRequestHospitalNo() {
		return requestHospitalNo;
	}

	public void setRequestHospitalNo(String requestHospitalNo) {
		this.requestHospitalNo = requestHospitalNo;
	}

	public String getResponseHospitalNo() {
		return responseHospitalNo;
	}

	public void setResponseHospitalNo(String responseHospitalNo) {
		this.responseHospitalNo = responseHospitalNo;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
		
}