package com.xt.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

public final class SmsUtil {
	protected final static Logger logger = Logger.getLogger(SmsUtil.class);

	/** 【热泵在线】当前短信验证码为#code#，有效期30分钟。 */
	public static boolean sendVerificationCode(String mobile, String code) {
		StringBuffer tpl_value = new StringBuffer("#code#=");
		tpl_value.append(code);
		return sendSMS(mobile, "31221", tpl_value.toString());
	}
	
	/** 【热泵在线】热泵 #pumpName# 产生了一条#type#信息，请登录平台及时处理。 */
	public static boolean sendPumpWarn(String mobile, String pumpName, String type) {
		StringBuffer tpl_value = new StringBuffer("#pumpName#=");
		tpl_value.append(pumpName);
		tpl_value.append("&#type#=");
		tpl_value.append(type);
		return sendSMS(mobile, "31223", tpl_value.toString());
	}

	/***
	 * 调用接口发送短信
	 * 
	 * @param mobile
	 * @param tplId
	 * @param tplValue
	 * @return
	 */
	private static boolean sendSMS(String mobile, String tplId, String tplValue) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobile", mobile);
		params.put("tpl_id", tplId);
		params.put("tpl_value", tplValue);
		params.put("key", "6128971b2a6600d78f4be91ce7df58d7");
		params.put("dtype", "json");
		try {
			String result = HttpUtil.request("http://v.juhe.cn/sms/send", params, "GET");
			JSONObject object = JSONObject.fromObject(result);
			if (object.getInt("error_code") == 0) {
				return true;
			} else {
				logger.error(object.get("error_code") + ":" + object.get("reason"));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	
	public static void main(String[] args) {
		sendVerificationCode("18518435862", "2133");
		sendPumpWarn("18518436862", "测试热泵", "告警");
	}
}
