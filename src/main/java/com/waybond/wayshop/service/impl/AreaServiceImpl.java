package com.waybond.wayshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waybond.wayshop.dao.AreaDao;
import com.waybond.wayshop.entity.Area;
import com.waybond.wayshop.service.AreaService;

/**
* @desc: 区域业务层实现
* @author: Kevin
* @createTime: 2019年11月14日 上午10:05:31
* @history:
* @version: v1.0
*/
@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;
	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}

}
