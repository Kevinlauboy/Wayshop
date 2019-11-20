package com.waybond.wayshop.dao;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.waybond.wayshop.BaseTest;
import com.waybond.wayshop.entity.Area;
import static org.junit.Assert.assertEquals;

/**
 * @desc: 区域Dao层测试类
 * @author: Kevin
 * @createTime: 2019年11月14日 上午9:45:38
 * @history:
 * @version: v1.0
 */

public class AreaDaoTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testQueryArea() {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(2, areaList.size());
	}

}
