package com.sites.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/12
 * Time: 14:58
 */
public class Utils {
	public Utils() {
	}

	/**
	 * 自动生成32位的UUid，对应数据库的主键id进行插入用。
	 *
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("ss[" + i + "]=====" + getUUID());
		}
	}

	/**
	 * 获取系统当前时间
	 */
	public static String getNowTime() {
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间
		return df.format(new Date());
	}

	public static Timestamp getTimestampTime() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

//		Date date = new Date();
//		Timestamp nousedate = new Timestamp(date.getTime());
		return timestamp;
	}
}
