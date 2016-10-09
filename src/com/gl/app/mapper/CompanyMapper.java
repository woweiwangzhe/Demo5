package com.gl.app.mapper;

import java.util.List;
import java.util.Map;

import com.gi.app.util.Page;
import com.gl.app.entity.Company;

public interface CompanyMapper {

	//带分页企业列表
	public List<Company> getCompanys(Page page);

	//企业数量
	public long getAllCompanyCount();

	//增加企业
	public void addCompany(Company company);

	//根据id查找企业
	public Company getCompanyById(int id);

	//删除企业
	public void deleteById(int id);

	//企业列表
	public List<Company> getAllCompany();

	//修改企业
	public void update(Company company);

	//带分页模糊匹配企业列表
	public List<Company> getCompanyslike(Map map);

	//模糊匹配企业数量
	public int getAllCompanyCount(Map map);


}
