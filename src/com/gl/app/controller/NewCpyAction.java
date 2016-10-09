package com.gl.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gl.app.entity.Company;
import com.gl.app.mapper.CompanyMapper;

@Controller
@RequestMapping(value = "/newcpy")
public class NewCpyAction {
	private CompanyMapper companyMapper = null;
	
	@Autowired
	public void setMapper(CompanyMapper companyMapper) {
		this.companyMapper = companyMapper;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	
			List<Company> companys = companyMapper.getAllCompany();
		String json = JSONArray.fromObject(companys).toString(); 	
		System.out.println(json);
		response.getWriter().print(	"var json ="+json);		
		return null;
	}

	
}
