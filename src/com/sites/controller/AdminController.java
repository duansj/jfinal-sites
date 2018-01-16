package com.sites.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.LogKit;
import com.jfinal.log.Log;
import com.sites.common.Utils;
import com.sites.model.Content;
import com.sites.model.Rticle;
import com.sites.model.User;
import com.sun.tools.javac.util.RichDiagnosticFormatter;

import java.sql.Timestamp;
import java.util.List;

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
		LogKit.debug("this is adminController.index method");
		login();
	}


	public void editarticle() {
		Rticle rticle = getModel(Rticle.class);
		String title = rticle.getTitle();
		String context = rticle.getContext();
		String classification = rticle.getClassification();
		String category = rticle.getCategory();
		String type = rticle.getType();
		Timestamp time = Utils.getTimestampTime();
		new Rticle()._setAttrs(rticle.setId(Utils.getUUID()).setCreateTime(Utils.getTimestampTime())).save();
	}

	public void uploadImages() {
		Log.getLog(AdminController.class).info(this.getPara());
	}

	public void login() {
		LogKit.debug("this is adminController.login method");
		User user = getModel(User.class);
		List<User> users = User.dao.find("select * from t_user where name = ? ", user.getName());
		if (users.isEmpty()) {
			this.renderJsp("/admin/login.html");
		} else {
			this.renderJsp("/admin/index.html");
		}
	}
}
