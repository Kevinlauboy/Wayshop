package com.waybond.wayshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.waybond.wayshop.entity.ShopCategory;

public interface ShopCategoryDao {

	
	/**
	* 插入新的商铺类型
	* @param shopCategory
	* @return int
	*/
	int insertShopCategory(ShopCategory shopCategory);
	
	
	/**
	* 查询商铺类型
	* @param
	* @return List<ShopCategory>
	*/
		
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory shopCategoryCondition);
}
