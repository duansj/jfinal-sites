package com.sites.controller;

import com.jfinal.core.Controller;

/**
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/11
 * Time: 13:08
 *
 * @author duansongjiang
 */
public class IndexController extends Controller {
	public void index() {
		this.render("index.jsp");
	}

	public void editor() {
		this.renderJsp("admin/editarticle.html");


	}

	public void article() {
		this.renderJsp("admin/article.html");
	}

	public void sayHello() {
		String userName = this.getPara("userName");
		String sayHello = "hello" + userName + ",welcome to jfinal demo";
		this.setAttr("sayHello", sayHello);
		this.render("/hello.jsp");
	}
}
