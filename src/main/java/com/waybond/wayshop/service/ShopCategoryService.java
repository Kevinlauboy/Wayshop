package com.waybond.wayshop.service;

import java.util.List;

import com.waybond.wayshop.entity.ShopCategory;

public interface ShopCategoryService {
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
