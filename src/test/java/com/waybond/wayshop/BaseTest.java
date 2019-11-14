package com.waybond.wayshop;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @desc: 创建测试模块的基类，主要配置spring和junit整合,junit启动时加载spirngIOC容器
* @author: Kevin
* @createTime: 2019年11月14日 上午9:49:13
* @history:
* @version: v1.0
*/	

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
	
}

	