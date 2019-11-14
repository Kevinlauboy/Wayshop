package com.waybond.wayshop.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.waybond.wayshop.BaseTest;
import com.waybond.wayshop.entity.Area;


/**
* @desc: 区域业务层测试类
* @author: Kevin
* @createTime: 2019年11月14日 上午10:32:06
* @history:
* @version: v1.0
*/
	
public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	@Test
	public void TestGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("南院", areaList.get(0).getAreaName());
	}
	
}
