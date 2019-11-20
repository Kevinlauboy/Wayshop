package com.waybond.wayshop.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceHolder {
	private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
	private static ThreadLocal<String> contextHodler = new ThreadLocal<String>();
	public static final String  DB_MASTER ="master";
	public static final String DB_SLAVE= "slave";
	
	public static String getDbType() {
		String db = contextHodler.get();
		if(db== null) {
			db = DB_MASTER;
		}
		return db;
	}
	public static void setDbType(String str) {
		logger.debug("所使用的数据源为:"+str);
		contextHodler.set(str);
	}
	public static void clearDbType() {
		contextHodler.remove();
	}
	
	
}
