package com.sites.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.druid.util.Utils;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.mysql.jdbc.Util;
import com.sites.common.UUIDTool;
import com.sites.model.Content;
import com.sites.model.User;
import sun.security.util.KeyUtil;

import java.util.List;
import java.util.UUID;

/**
 * 查询id值为25的User将其name属性改为James并更新到数据库
 * User.dao.findByIdLoadColumns (25).set("name", "James").update();
 * 查询id值为25的user, 且仅仅取name与age两个字段的值
 * User user = User.dao.findByIdLoadColumns (25, "name, age");
 * 获取user的name属性
 * String userName = user.getStr("name");
 * 获取user的age属性
 * Integer userAge = user.getInt("age");
 * 查询所有年龄大于18岁的user
 * List<User> users = User.dao.find("select * from user where age>18");
 * 分页查询年龄大于18的user,当前页号为1,每页10个user
 * Page<User> userPage = User.dao.paginate(1, 10, "select *", "from user where age > ?", 18);
 * 特别注意：User 中定义的 public static final User dao 对象是全局共享的，只能用于数据库查询， 不能用于数据承载对象。数据承载需要使用 new User().set(…)来实现。
 * <p>
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/11
 * Time: 13:08
 *
 * @author duansongjiang
 */
public class AdminController extends Controller {

	public void index() {
		this.renderJsp("/admin/login.html");
	}


	public void editarticle() {
		Content content = getModel(Content.class);
		new Content().setContext(content.getContext()).setId(UUIDTool.getUUID()).save();
	}

	public void uploadImages() {
		Log.getLog(AdminController.class).info(this.getPara());
	}

	public void login() {
		User user = getModel(User.class);
		List<User> users = User.dao.find("select * from user where name = ? ", user.getName());
		if (users.isEmpty()) {
			index();
		} else {
			this.renderJsp("/admin/index.html");
		}
	}
}
