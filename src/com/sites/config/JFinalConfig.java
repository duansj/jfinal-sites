package com.sites.config;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Log4jLog;
import com.jfinal.log.Log4jLogFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.sites.config.rotes.AdminRoutes;
import com.sites.config.rotes.FrontRoutes;
import com.sites.controller.AdminController;
import com.sites.controller.IndexController;
import com.sites.controller.UploadController;
import com.sites.controller.UserController;
import com.sites.model._MappingKit;
import lombok.extern.log4j.Log4j;

/**
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/10
 * Time: 17:28
 *
 * @author duansongjiang
 */
public class JFinalConfig extends com.jfinal.config.JFinalConfig {


    @Override
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("props/config.properties");
        me.setDevMode(Boolean.valueOf(PropKit.get("devModel", "false")));
        me.setEncoding("utf-8");
        me.setViewType(ViewType.JSP);

        me.setBaseUploadPath(PropKit.get("upload.path").trim());

//		PropKit.use("/props/log4j.properties");
//		me.setLogFactory(new Log4jLogFactory(new Log4jLog()));

    }

    /**
     * 配置路由
     *
     * @param me
     */
    @Override
    public void configRoute(Routes me) {
//		me.add(new FrontRoutes());
//		me.add(new AdminRoutes());
        me.add("/", IndexController.class);
        me.add("/admin", AdminController.class);
        me.add("/admin/user", UserController.class);
        me.add("/upload", UploadController.class);
    }

    @Override
    public void configEngine(Engine me) {

    }

    /**
     * 配置插件
     *
     * @param me
     */
    @Override
    public void configPlugin(Plugins me) {

//		C3p0Plugin cp = new C3p0Plugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.userName"), PropKit.get("jdbc.password"));
//		me.add(cp);
//		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
//		me.add(arp);
//		arp.setDialect(new MysqlDialect());
//		arp.addMapping("user", .class);
//		//默认主键为id，如果为content_id则需要单独指定
//		arp.addMapping("content", .class);

        // 配置 druid 数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.userName"), PropKit.get("jdbc.password").trim());
        ;
        me.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // 所有映射在 MappingKit 中自动化搞定
        _MappingKit.mapping(arp);
        me.add(arp);
    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    /**
     * 配置处理器
     */
    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("basePath"));
    }

    public static DruidPlugin createDruidPlugin() {
        PropKit.use("props/config.properties");
        return new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.userName"), PropKit.get("jdbc.password").trim());
    }
}
