package com.thinkgem.jeesite.modules.records.entity;

import java.io.Serializable;

/**
 * @author ZCD
 * 合计实体类
 */
@SuppressWarnings("serial")
public class TotalRecords implements Serializable{
	
	private Integer recordsCount;	
	private Integer crCount;
	private Integer ctCount;
	private Integer mrCount;
	private Integer bcCount;
	private Integer mgCount;
	private Integer njCount;
	private Integer xdCount;
	private Double hospitalIn;
	private Double hospitalOut;
	private Double platformFee;
	
	private String date;
	
	public Integer getRecordsCount() {
		return recordsCount;
	}
	public void setRecordsCount(Integer recordsCount) {
		this.recordsCount = recordsCount;
	}
	public Integer getCrCount() {
		return crCount;
	}
	public void setCrCount(Integer crCount) {
		this.crCount = crCount;
	}
	public Integer getCtCount() {
		return ctCount;
	}
	public void setCtCount(Integer ctCount) {
		this.ctCount = ctCount;
	}
	public Integer getMrCount() {
		return mrCount;
	}
	public void setMrCount(Integer mrCount) {
		this.mrCount = mrCount;
	}
	public Integer getBcCount() {
		return bcCount;
	}
	public void setBcCount(Integer bcCount) {
		this.bcCount = bcCount;
	}
	public Integer getMgCount() {
		return mgCount;
	}
	public void setMgCount(Integer mgCount) {
		this.mgCount = mgCount;
	}
	public Integer getNjCount() {
		return njCount;
	}
	public void setNjCount(Integer njCount) {
		this.njCount = njCount;
	}
	public Integer getXdCount() {
		return xdCount;
	}
	public void setXdCount(Integer xdCount) {
		this.xdCount = xdCount;
	}
	public Double getHospitalIn() {
		return hospitalIn;
	}
	public void setHospitalIn(Double hospitalIn) {
		this.hospitalIn = hospitalIn;
	}
	public Double getHospitalOut() {
		return hospitalOut;
	}
	public void setHospitalOut(Double hospitalOut) {
		this.hospitalOut = hospitalOut;
	}
	public Double getPlatformFee() {
		return platformFee;
	}
	public void setPlatformFee(Double platformFee) {
		this.platformFee = platformFee;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
