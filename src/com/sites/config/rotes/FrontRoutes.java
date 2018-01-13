package com.sites.config.rotes;

import com.jfinal.config.Routes;
import com.sites.controller.IndexController;

/**
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/11
 * Time: 13:06
 * 前端路由配置
 */
public class FrontRoutes extends Routes{
	@Override
	public void config() {
		add("/", IndexController.class);
	}
}
