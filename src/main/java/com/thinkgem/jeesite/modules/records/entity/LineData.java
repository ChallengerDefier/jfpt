package com.thinkgem.jeesite.modules.records.entity;


/**
 * @author ZCD
 * 生成折线图的数据实体
 */
public class LineData{
	
	private String date;
	private String feeType;
	private String count;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
}
