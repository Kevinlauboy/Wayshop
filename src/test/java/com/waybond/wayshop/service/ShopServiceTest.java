package com.waybond.wayshop.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.waybond.wayshop.BaseTest;
import com.waybond.wayshop.dto.ShopExecution;
import com.waybond.wayshop.entity.Area;
import com.waybond.wayshop.entity.PersonInfo;
import com.waybond.wayshop.entity.Shop;
import com.waybond.wayshop.entity.ShopCategory;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(1L);
		shop.setOwner(owner);
		Area area = new Area();
		area.setAreaId(1L);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
		shop.setShopImg("test1");
		shop.setLongitude(1D);
		shop.setLatitude(1D);
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
		File img = new File("F:\\Camera\\IMG_20160204_181046.jpg");
		try {
			InputStream is = new FileInputStream(img);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// ShopExecution se = shopService.addShop(shop,is);
		// assertEquals("mytest1", se.getShop().getShopName());

	}
}
