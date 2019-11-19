package com.waybond.wayshop.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.waybond.wayshop.dto.ShopExecution;
import com.waybond.wayshop.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
