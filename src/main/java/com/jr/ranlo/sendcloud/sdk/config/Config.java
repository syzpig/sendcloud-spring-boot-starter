package com.jr.ranlo.sendcloud.sdk.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static final String CHARSET = "utf-8";
	public static String server = "http://www.sendcloud.net";
	// 普通邮件发送
	public static String send_api = "http://api.sendcloud.net/apiv2/demo/send";
	// 地址列表发送
	public static String send_template_api = "http://api.sendcloud.net/apiv2/demo/sendtemplate";
	// 短信发送
	public static String send_sms_api = "http://www.sendcloud.net/smsapi/send";
	// 语音发送
	public static String send_voice_api = "http://www.sendcloud.net/smsapi/sendVoice";
	public Config() {
	}
	static {
		try {
			InputStream f = Config.class.getClassLoader().getResourceAsStream("config.properties");
			Properties pros = new Properties();
			pros.load(f);
			send_api = pros.getProperty("send_api");
			send_template_api = pros.getProperty("send_template_api");
			send_sms_api = pros.getProperty("send_sms_api");
			send_voice_api = pros.getProperty("send_voice_api");
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}