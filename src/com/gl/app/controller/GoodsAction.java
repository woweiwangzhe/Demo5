package com.gl.app.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.gl.app.entity.Goods;
import com.gl.app.mapper.GoodsMapper;

@Controller
@RequestMapping(value = "/goods")
public class GoodsAction {
	private GoodsMapper goodsMapper = null;
	@Autowired
	public void setMapper(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	/**
	 * 
		商品列表查询带模糊匹配
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String pageNow = request.getParameter("pageNow");		
		Page<Goods> page = null;
		List<Goods> goodss = null;		
		String companyId = request.getParameter("companyId");
		Map map = new HashMap();
		String shopname = request.getParameter("shopname");	
		map.put("shopname", shopname);
		int cpyid = Integer.parseInt(companyId);
		map.put("companyid", cpyid);
		int totalCount = (int) goodsMapper.getAllGoodsCountlike(map);			
		if (pageNow != null) {
			page = new Page<Goods>(totalCount, Integer.parseInt(pageNow));	
			map.put("pageSize", page.getPageSize());
			map.put("startPos", page.getStartPos());
			goodss = goodsMapper.getallGoodsByid(map);
		} else {
			page = new Page<Goods>(totalCount, 1);
			map.put("pageSize", page.getPageSize());
			map.put("startPos", page.getStartPos());
			goodss = goodsMapper.getallGoodsByid(map);	
		}
		page.setResult (goodss);		
		String json = JSONArray.fromObject(page).toString(); 
		System.out.println(json);
		response.getWriter().print(	"var json ="+json);
		return null;
	}

	/**
	 * 
	 *增加商品
	 */
	@RequestMapping(value = "/add")
	public void add(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String shopname = request.getParameter("shopname");
			String size = request.getParameter("size");
			String price = request.getParameter("price");
			String number = request.getParameter("number");
			String type = request.getParameter("type");
			String createtime = request.getParameter("createtime");
			String companyId = request.getParameter("companyId");
			Goods goods = new Goods();
			int cpyid = Integer.parseInt(companyId);
			goods.setCompanyid(cpyid);
			goods.setShopname(shopname);
			goods.setSize(size);
			goods.setPrice(Integer.parseInt(price));
			goods.setNumber(Integer.parseInt(number));
			goods.setType(type);			
			Date createtimes = (new SimpleDateFormat("yyyy-MM-dd")).parse(createtime);
			goods.setCreatetime(createtimes);
			goodsMapper.addGoods(goods);
			String ss ="var msg={msg:'添加成功'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		} catch (Exception e) {
			e.printStackTrace();
			String ss ="var msg={msg:'添加失败'}";
			System.out.println(ss);
			response.getWriter().write(ss);
		}
	
	}

	/**
	 * 
	 *商品详情（自己测试）
	 */
	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable int id, ModelMap model) {
		Goods goods = goodsMapper.getGoodsById(id);
		model.addAttribute("goods", goods);
		return "goodsdetail";
	}

	/**
	 * 
	 *删除商品
	 */
	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable int id, ModelMap model,HttpServletResponse response) throws IOException {
		goodsMapper.deleteById(id);
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

	/**
	 * 
	 *修改商品带值
	 */
	@RequestMapping(value = "/toupdate/{id}")
	public String toUpdate(@PathVariable int id, ModelMap model,HttpServletResponse response) throws IOException {
		Goods goods = goodsMapper.getGoodsById(id);
		String json = JSONArray.fromObject(goods).toString(); 
		System.out.println(json);
		response.getWriter().print(	"var json ="+json);
		return null;
	}
	/**
	 * 修改商品
	 * 
	 */
	@RequestMapping(value = "/update")
	public void update(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");	
		String shopname = request.getParameter("shopname");
		String size = request.getParameter("size");
		String price = request.getParameter("price");
		String number = request.getParameter("number");
		String type = request.getParameter("type");		
		Goods goods = new Goods();
		goods.setId(Integer.parseInt(id));
		goods.setShopname(shopname);
		goods.setSize(size);
		goods.setPrice(Integer.parseInt(price));
		goods.setNumber(Integer.parseInt(number));
		goods.setType(type);
		goodsMapper.update(goods);
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
