package com.waybond.wayshop.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.waybond.wayshop.dao.ShopDao;
import com.waybond.wayshop.dto.ShopExecution;
import com.waybond.wayshop.entity.Shop;
import com.waybond.wayshop.enums.ShopStateEnum;
import com.waybond.wayshop.exceptions.ShopOperationExeception;
import com.waybond.wayshop.service.ShopService;
import com.waybond.wayshop.util.ImageUtil;
import com.waybond.wayshop.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}

		try {
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int effectedNum = shopDao.insertShop(shop);
			if(effectedNum <=0) {
				throw new ShopOperationExeception("店铺创建失败");
			}else {
				if(shopImg!= null) {
					try {
						//存储图片
						addShopImg(shop,shopImg);
					} catch (Exception e) {
						throw new ShopOperationExeception("addShopImg errror:"+ e.getMessage());
					}
					effectedNum  = shopDao.updateShop(shop);
					if(effectedNum<=0) {
						throw new ShopOperationExeception("updateShop errror:");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationExeception("addShop error:"+e.getMessage());
		}

		return new ShopExecution(ShopStateEnum.CHECK,shop);
	}
	private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImageAddr =  ImageUtil.generateThumbnail(shopImg,dest);
		shop.setShopImg(shopImageAddr);
	}

}
