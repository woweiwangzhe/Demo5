package com.gl.app.entity;

import java.util.Date;
import java.util.List;

public class Goods implements java.io.Serializable{

	private Integer id;			//商品id
	private String shopname;	//商品名称
	private String size;		//规格
	private Integer price;		//价格
	private Integer number;		//数量
	private String type;		//类型
	private Date createtime;	//进货时间
	private Integer companyid;  //关联企业id
	private List<Goods> GoodsList;
	
	public Goods(){
		
	}
	public Goods(Integer id, String shopname, String size, Integer price,
			Integer number, String type, Date createtime,Integer companyid) {
		super();
		this.id = id;
		this.shopname = shopname;
		this.size = size;
		this.price = price;
		this.number = number;
		this.type = type;
		this.createtime = createtime;
		this.companyid = companyid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public List<Goods> getGoodsList() {
		return GoodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		GoodsList = goodsList;
	}
	public Integer getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	
	
}
