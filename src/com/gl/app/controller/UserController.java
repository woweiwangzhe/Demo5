package com.gl.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gi.app.util.Page;
import com.gl.app.entity.User;
import com.gl.app.mapper.UserMapper;

@Controller
@RequestMapping(value = "/gl")
public class UserController {

	private UserMapper userMapper = null;

	@Autowired
	public void setMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;
		List<User> users = null;
		int totalCount = (int) userMapper.getAllUserCount();
		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
			users = userMapper.getUsers(page);
		} else {
			page = new Page(totalCount, 1);
			users = userMapper.getUsers(page);
			// users = userMapper.getAllUser();
		}
		model.addAttribute("page", page);
		model.addAttribute("users", users);
		return "list";
	}

	@RequestMapping(value = "/add")
	public String add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		User user = new User();
		user.setUserName(userName);
		user.setAge(Integer.parseInt(age));
		user.setSex(Integer.parseInt(sex));
		user.setAddress(address);
		userMapper.addUser(user);

		List<User> list = null;
		Page page = null;
		int totalCount = (int) userMapper.getAllUserCount();
		page = new Page(totalCount, 1);
		list = userMapper.getUsers(page);
		model.addAttribute("page", page);
		model.addAttribute("users", list);
		return "list";
	}

	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable int id, ModelMap model) {
		User user = userMapper.getUserById(id);
		model.addAttribute("user", user);
		return "detail";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, ModelMap model) {
		userMapper.deleteById(id);
		List<User> list = userMapper.getAllUser();
		model.addAttribute("users", list);
		return "list";
	}

	@RequestMapping(value = "/toupdate/{id}")
	public String toUpdate(@PathVariable int id, ModelMap model) {
		User user = userMapper.getUserById(id);
		model.addAttribute("user", user);
		return "update";
	}

	@RequestMapping(value = "/update")
	public String update(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("sid");
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUserName(userName);
		user.setAge(Integer.parseInt(age));
		user.setSex(Integer.parseInt(sex));
		user.setAddress(address);
		userMapper.update(user);
		List<User> list = userMapper.getAllUser();
		model.addAttribute("users", list);
		return "list";
	}
}
