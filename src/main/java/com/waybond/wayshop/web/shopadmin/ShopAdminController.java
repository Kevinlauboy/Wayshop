
package com.waybond.wayshop.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin",method= {RequestMethod.GET})
public class ShopAdminController {
	@RequestMapping(value="shopoperation",method= {RequestMethod.GET})
	public String shopOperation() {
		return "shop/shopoperation";
	}
}


