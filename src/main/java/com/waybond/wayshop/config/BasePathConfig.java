
package com.waybond.wayshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:config.properties")  
public class BasePathConfig {
	@Value("${basepathwin}")
	public String basePathWin;
	@Value("${basepathlinux}")
	public String basePathLinux;
}
