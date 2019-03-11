package com.test.crm.entity;

import java.util.Date;

/*
 * 客户流失管理
 */

public class CustomerLoss {

	private Integer id;
	private String cusNo;
	private String cusName;
	private String cusManager;
	private Date lastOrderTime;
	private String lTime;
	private Date confirmLossTime;
	private String cTime;
	private Integer state;
	private String lossReason;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCusNo() {
		return cusNo;
	}

	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusManager() {
		return cusManager;
	}

	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}

	public Date getLastOrderTime() {
		return lastOrderTime;
	}

	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}

	public String getlTime() {
		return lTime;
	}

	public void setlTime(String lTime) {
		this.lTime = lTime;
	}

	public Date getConfirmLossTime() {
		return confirmLossTime;
	}

	public void setConfirmLossTime(Date confirmLossTime) {
		this.confirmLossTime = confirmLossTime;
	}
	
	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getLossReason() {
		return lossReason;
	}

	public void setLossReason(String lossReason) {
		this.lossReason = lossReason;
	}

}
