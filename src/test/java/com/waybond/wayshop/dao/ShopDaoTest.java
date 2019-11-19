
package com.waybond.wayshop.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.waybond.wayshop.BaseTest;
import com.waybond.wayshop.entity.Area;
import com.waybond.wayshop.entity.PersonInfo;
import com.waybond.wayshop.entity.Shop;
import com.waybond.wayshop.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AreaDao areaDao;
	@Test
	@Ignore
	public void TestInsertShop(){
		
		Shop shop = new Shop();
		PersonInfo owner  = new PersonInfo();
		owner.setUserId(1L);
		Area area = new Area();
		ShopCategory shopCategory= new  ShopCategory();
		
		owner.setUserId(1L);
		area.setAreaId(1L);
		shopCategory.setShopCategoryId(1L);
		
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int ffectedNum = shopDao.insertShop(shop);
		assertEquals(1,ffectedNum);
	}
	
	@Test
	public void TestUpdateShop(){
		Shop shop = new Shop();
		
		List<Area> areaList = areaDao.queryArea();
		Area area = areaList.get(0);
		shop.setArea(area);
		shop.setShopId(3L);
		shop.setShopName("测试店铺1");
		shop.setShopDesc("测试1");
		shop.setShopAddr("测试1");
		shop.setPhone("测试1");
		shop.setShopImg("测试1");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int ffectedNum = shopDao.updateShop(shop);
		assertEquals(1,ffectedNum);
	}
}
