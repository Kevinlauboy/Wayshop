package com.waybond.wayshop.dao;

import com.waybond.wayshop.entity.Shop;

public interface ShopDao {
	
	/**
	* 新增店铺
	* @param Shop
	* @return int
	*/
	int insertShop(Shop shop);
	
	
	/**
	* 更新店铺信息
	* @param shop
	* @return int
	*/
		
	int updateShop(Shop shop);
}
