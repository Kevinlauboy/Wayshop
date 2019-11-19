package com.waybond.wayshop.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.waybond.wayshop.BaseTest;
import com.waybond.wayshop.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	@Ignore
	public void testInsertShopCategory() {
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryName("店铺类别1");
		shopCategory.setShopCategoryDesc("测试商品类别");
		shopCategory.setPriority(1);
		shopCategory.setCreateTime(new Date());
		shopCategory.setLastEditTime(new Date());
		int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
		assertEquals(1, effectedNum);
	}
	
	@Test
	public void testQueryShopCategory() {
		ShopCategory shopCategoryCondition = new ShopCategory();
		List<ShopCategory> shopCategoryList = shopCategoryDao
				.queryShopCategory(shopCategoryCondition);
		assertEquals(2, shopCategoryList.size());
		
		ShopCategory parent = new ShopCategory();
		parent.setShopCategoryId(1L);
		shopCategoryCondition.setParent(parent);
		shopCategoryList = shopCategoryDao
				.queryShopCategory(shopCategoryCondition);
		assertEquals(1, shopCategoryList.size());
		
	}
}
