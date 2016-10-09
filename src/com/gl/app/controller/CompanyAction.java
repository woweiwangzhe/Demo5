package com.gl.app.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gi.app.util.Page;
import com.gl.app.entity.Company;
import com.gl.app.mapper.CompanyMapper;

@Controller
@RequestMapping(value = "/company")
public class CompanyAction {
	private CompanyMapper companyMapper = null;
	
	@Autowired
	public void setMapper(CompanyMapper companyMapper) {
		this.companyMapper = companyMapper;
	}
	
	//**********************************企业列表*************************
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String companyname = request.getParameter("companyname");	
		Map map = new HashMap();
		map.put("companyname",companyname);
		String pageNow = request.getParameter("pageNow");
		Page<Company> page = null;
		List<Company> companys = null;
		int totalCount = (int) companyMapper.getAllCompanyCount(map);
		if (pageNow != null) {
			page = new Page<Company>(totalCount, Integer.parseInt(pageNow));
			map.put("pageSize", page.getPageSize());
			map.put("startPos", page.getStartPos());
			companys = companyMapper.getCompanyslike(map);
		} else {
			page = new Page<Company>(totalCount, 1);
			map.put("pageSize", page.getPageSize());
			map.put("startPos", page.getStartPos());
			companys = companyMapper.getCompanyslike(map);
		}
		page.setResult(companys);
		String json = JSONArray.fromObject(page).toString(); 
		System.out.println(json);
		response.getWriter().print(	"var json ="+json);
		return null;
	}

	//**********************************企业新增*************************
	@RequestMapping(value = "/add")
	public void add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String companyname = URLDecoder.decode(request.getParameter("companyname"),"UTF-8");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String dept = request.getParameter("dept");
			String employ = request.getParameter("employ");		
			request.setCharacterEncoding("utf-8");		
			Company company = new Company();
			company.setAddress(address);
			company.setCompanyname(companyname);
			company.setDept(dept);
			company.setEmploy(employ);
			company.setTel(Integer.parseInt(tel));
			companyMapper.addCompany(company);
			String ss ="var msg={msg:'添加成功'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		} catch (Exception e) {
			String ss ="var msg={msg:'添加失败'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		}
		
	}

	//**********************************企业详情（自己测试）*************************
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable int id, ModelMap model, HttpServletRequest request) {
		Company companybyid = companyMapper.getCompanyById(id);
		request.getSession().setAttribute("company",companybyid);
		return "redirect:../../goods/list.do";
	}

	//**********************************企业删除*************************
	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable int id, ModelMap model,HttpServletResponse response) throws IOException {
		companyMapper.deleteById(id);
		try {
			String ss ="var msg={msg:'删除成功'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		} catch (IOException e) {
			String ss ="var msg={msg:'删除失败'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		}
		return null;
	}

	//**********************************企业修改*************************
	@RequestMapping(value = "/toupdate/{id}")
	public String toUpdate(@PathVariable int id, ModelMap model,HttpServletResponse response) throws IOException {
		Company company = companyMapper.getCompanyById(id);
		String json = JSONArray.fromObject(company).toString(); 
		System.out.println(json);
		response.getWriter().print(	"var json ="+json);
		return null;
	}

	//**********************************企业修改确认*************************
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("comid");	
		String companyname = request.getParameter("companyname");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String dept = request.getParameter("dept");
		String employ = request.getParameter("employ");	
		Company company =new Company();
		company.setId(Integer.parseInt(id));
		company.setAddress(address);
		company.setCompanyname(companyname);
		company.setDept(dept);
		company.setEmploy(employ);
		company.setTel(Integer.parseInt(tel));
		companyMapper.update(company);
		try {
			String ss ="var msg={msg:'成功'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		} catch (Exception e) {
			String ss ="var msg={msg:'失败'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		}
	}

}
