package com.sites.controller;


import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.json.Json;
import com.jfinal.kit.LogKit;
import com.jfinal.upload.UploadFile;
import com.sites.common.StaticContents;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/12
 * Time: 15:23
 *
 * @author duansongjiang
 */
public class UploadController extends Controller {
    public void index() {

    }

    /**
     * @return {
     * success : 0 | 1, //0表示上传失败;1表示上传成功
     * message : "提示的信息",
     * url     : "图片地址" //上传成功时才返回
     * }
     */
    public void editormdImage() {
//		String para = this.getPara();
        UploadFile uploadFile = this.getFile();

        this.renderFile(uploadFile.getFile());

        String filename = uploadFile.getOriginalFileName();
        LogKit.debug("文件上传名称：" + filename);
        JSONObject res = new JSONObject();
        res.put("url", "asd/" + filename);
        res.put("success", StaticContents.OK);
        res.put("message", StaticContents.OKMESSAGE);
        this.renderJson(res);
    }


    public Json editormdImages() {
        List<UploadFile> fileList = this.getFiles();
        for (UploadFile uploadFile : fileList) {
            //一些操作
        }
//		FileRender
        return Json.getJson();
    }
}
