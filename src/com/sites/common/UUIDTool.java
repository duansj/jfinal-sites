package com.sites.common;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA
 * Created By duansongjiang
 * Date: 2018/1/12
 * Time: 14:58
 */
public class UUIDTool {
	public UUIDTool() {
	}
	/**
	 * 自动生成32位的UUid，对应数据库的主键id进行插入用。
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
}
