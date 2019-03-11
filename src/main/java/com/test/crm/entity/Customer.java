package com.test.crm.entity;

/*
 * 客户信息管理
 */

public class Customer {

	private Integer id;// id
	private String khno;// 客户编号
	private String name;// 客户姓名
	private String area;// 客户地区
	private String cusManager;// 客户管理
	private String level;// 等级
	private String myd;// 客户满意度
	private String xyd;// 客户信用度
	private String address;// 客户地址
	private String postCode;// 邮政编码
	private String phone;// 客户电话
	private String fax;// 传真
	private String webSite;// 网址
	private String yyzzzch;// 营业执照注册号
	private String fr;// 法人
	private String zczj;// 注册资金(万元)
	private String nyye;// 年营业额(万元)
	private String khyh;// 开户银行
	private String khzh;// 开户帐号
	private String gsdjh;// 国税登记号
	private String dsdjh;// 地税登记号
	private Integer state;// 状态
	
	private String customerLevel;//客户等级
	private Integer customerNum;//客户数量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKhno() {
		return khno;
	}

	public void setKhno(String khno) {
		this.khno = khno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCusManager() {
		return cusManager;
	}

	public void setCusManager(String cusManager) {
		this.cusManager = cusManager;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMyd() {
		return myd;
	}

	public void setMyd(String myd) {
		this.myd = myd;
	}

	public String getXyd() {
		return xyd;
	}

	public void setXyd(String xyd) {
		this.xyd = xyd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getYyzzzch() {
		return yyzzzch;
	}

	public void setYyzzzch(String yyzzzch) {
		this.yyzzzch = yyzzzch;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getZczj() {
		return zczj;
	}

	public void setZczj(String zczj) {
		this.zczj = zczj;
	}

	public String getNyye() {
		return nyye;
	}

	public void setNyye(String nyye) {
		this.nyye = nyye;
	}

	public String getKhyh() {
		return khyh;
	}

	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}

	public String getKhzh() {
		return khzh;
	}

	public void setKhzh(String khzh) {
		this.khzh = khzh;
	}

	public String getGsdjh() {
		return gsdjh;
	}

	public void setGsdjh(String gsdjh) {
		this.gsdjh = gsdjh;
	}

	public String getDsdjh() {
		return dsdjh;
	}

	public void setDsdjh(String dsdjh) {
		this.dsdjh = dsdjh;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}

	public Integer getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

}
