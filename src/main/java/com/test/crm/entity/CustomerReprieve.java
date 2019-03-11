package com.test.crm.entity;

/*
 * 暂缓客户流失管理
 */
public class CustomerReprieve {

	private Integer id;
	private Integer lossId;
	private String measure;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLossId() {
		return lossId;
	}

	public void setLossId(Integer lossId) {
		this.lossId = lossId;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

}
