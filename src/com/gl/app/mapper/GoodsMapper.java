package com.gl.app.mapper;

import java.util.List;
import java.util.Map;

import com.gi.app.util.Page;
import com.gl.app.entity.Goods;

public interface GoodsMapper {

	//带分页商品列表
	public List<Goods> getGoodss(Page page);

	//商品数量
	public long getAllGoodsCount();

	//增加商品
	public void addGoods(Goods goods);

	//根据id查找商品
	public Goods getGoodsById(int id);

	//删除商品
	public void deleteById(int id);

	//商品列表
	public List<Goods> getAllGoods();

	//修改商品
	public void update(Goods goods);

	//public int getAllGoodsCountByid(int companyid);

	//public List<Goods> getGoodssByid(Page page,int companyid);

	//带分页模糊匹配商品列表
	public List<Goods> getallGoodsByid(Map map);

	//模糊匹配商品数量
	public int getAllGoodsCountlike(Map map);

}
