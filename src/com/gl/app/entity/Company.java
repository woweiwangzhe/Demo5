package com.gl.app.entity;

import java.util.List;

public class Company implements java.io.Serializable{

	
	private Integer id;			//企业id
	private String companyname;	//企业名称
	private String address;		//企业地址
	private Integer tel;		//电话
	private String dept;		//部门
	private String employ;		//员工
	private List<Company> CompanyList;
	public Company(){
		
	}
	public Company(Integer id, String companyname, String address, Integer tel,
			String dept, String employ) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.address = address;
		this.tel = tel;
		this.dept = dept;
		this.employ = employ;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmploy() {
		return employ;
	}
	public void setEmploy(String employ) {
		this.employ = employ;
	}
	public List<Company> getCompanyList() {
		return CompanyList;
	}
	public void setCompanyList(List<Company> companyList) {
		CompanyList = companyList;
	}
	
}
