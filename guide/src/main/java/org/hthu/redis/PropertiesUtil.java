package org.hthu.redis;

import org.apache.commons.lang3.StringUtils;

import java.util.ResourceBundle;

/**
 * 读取classpath下配置文件
 * @author hht
 *
 */
public class PropertiesUtil {

	public static String getProperty(String str, String defaultValue) {
		// 这里不需要写*.properties后缀，如果文件定义在包中，前面需要加上包名称，如redis.jedis
		ResourceBundle rb = ResourceBundle.getBundle("jedis");
		String value = rb.getString(str);
		if(StringUtils.isEmpty(value)) {
			return defaultValue;
		}
		return value;
	}
	
	public static String getProperty(String str) {
		// 这里不需要写*.properies后缀，如果文件定义在包中，前面需要加上包名称，如redis.jedis
		ResourceBundle rb = ResourceBundle.getBundle("jedis");
		return rb.getString(str);
	}
	
	public static void main(String[] args) {
		System.out.println(getProperty("redis.port"));
	}
}
