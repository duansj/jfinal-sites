package com.sites.config.rotes;

import com.jfinal.config.Routes;
import com.sites.controller.AdminController;
import com.sites.controller.UploadController;
import com.sites.controller.UserController;

/**
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/11
 * Time: 13:10
 */
public class AdminRoutes extends Routes {
	@Override
	public void config() {
		add("/admin", AdminController.class);
		add("/admin/user", UserController.class);
		add("/upload", UploadController.class);
	}
}
