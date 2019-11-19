package com.waybond.wayshop.enums;

public enum ShopStateEnum {
	CHECK(0, "审核中"), OFFLINE(-1, "非法商铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(-1001, "操作失败"),
	NULL_SHOPID(-1002, "ShopId为空"), NULL_SHOP(-1003, "商铺信息为空");

	private int state;

	private String stateInfo;

	public int getState() {

		return state;
	}

	public String getStateInfo() {

		return stateInfo;
	}

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public static ShopStateEnum stateOf(int index) {
		for(ShopStateEnum stateEnum:values()) {
			if (stateEnum.getState() == index) {
				return stateEnum;
			}
		}
		return null;
	}

}
