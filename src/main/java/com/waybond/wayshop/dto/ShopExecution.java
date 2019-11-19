package com.waybond.wayshop.dto;

import java.util.List;

import com.waybond.wayshop.entity.Shop;
import com.waybond.wayshop.enums.ShopStateEnum;

public class ShopExecution {
	/**
	 * 结果状态
	 */
	private int state;
	/**
	 * 状态标识
	 */
	private String stateInfo;
	/**
	 * 店铺数量
	 */
	private int count;
	/**
	 * 操作的shop
	 */
	private Shop shop;
	/**
	 * shop列表
	 */
	private List<Shop> shopList;

	public int getState() {

		return state;
	}

	public void setState(int state) {

		this.state = state;
	}

	public String getStateInfo() {

		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {

		this.stateInfo = stateInfo;
	}

	public int getCount() {

		return count;
	}

	public void setCount(int count) {

		this.count = count;
	}

	public Shop getShop() {

		return shop;
	}

	public void setShop(Shop shop) {

		this.shop = shop;
	}

	public List<Shop> getShopList() {

		return shopList;
	}

	public void setShopList(List<Shop> shopList) {

		this.shopList = shopList;
	}

	public ShopExecution() {

	}

	/**
	 * 失败的构造器
	 * 
	 * @param stateEnum
	 */
	public ShopExecution(ShopStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	/**
	 * 成功的构造器
	 * 
	 * @param stateEnum
	 * @param shop
	 */

	public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

	/**
	 * 成功的构造器
	 * 
	 * @param shopList
	 * @param shop
	 */
	public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
	}

}
