package com.xt.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.xt.entity.generation.WeatherAlarm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeatherHttpUtil {
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 60000;
	public static final int DEF_READ_TIMEOUT = 60000;
	public static final String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	public static String getRequest(String urlPath) {
		try {
			URL url = new URL(urlPath);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Upgrade-Insecure-Requests", "1");

			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
			connection.setRequestProperty("Host", "product.weather.com.cn");
			connection.setRequestProperty("Referer",
					"http://www.weather.com.cn/alarm/newalarmlist.shtml?areaId=101010100");
			connection.setRequestProperty("Cookie",
					"vjuids=-3274f028d.15a75d58b0b.0.3fe0cf2c16464; __asc=96a9ee2015b413a4b6965d6126f; __auc=96a9ee2015b413a4b6965d6126f; f_city=%E5%8C%97%E4%BA%AC%7C101010100%7C; Hm_lvt_080dabacb001ad3dc8b9b9049b36d43b=1490367992,1491136766,1491270383,1491446033; Hm_lpvt_080dabacb001ad3dc8b9b9049b36d43b=1491448896; vjlast=1488035613.1491446033.11");

			connection.connect();
			InputStream inputStream = connection.getInputStream();
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				sb.append(str);
			}
			reader.close();
			connection.disconnect();
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

	public static String postRequest(String url) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			// 初始化请求路径
			URL realUrl = new URL(url);
			// 打开链接
			URLConnection conn = realUrl.openConnection();
			// 设置请求头参数
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Upgrade-Insecure-Requests", "1");

			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
			conn.setRequestProperty("Host", "product.weather.com.cn");
			conn.setRequestProperty("Referer", "http://www.weather.com.cn/alarm/newalarmlist.shtml?areaId=101010100");
			conn.setRequestProperty("Cookie",
					"vjuids=-3274f028d.15a75d58b0b.0.3fe0cf2c16464; __asc=96a9ee2015b413a4b6965d6126f; __auc=96a9ee2015b413a4b6965d6126f; f_city=%E5%8C%97%E4%BA%AC%7C101010100%7C; Hm_lvt_080dabacb001ad3dc8b9b9049b36d43b=1490367992,1491136766,1491270383,1491446033; Hm_lpvt_080dabacb001ad3dc8b9b9049b36d43b=1491448896; vjlast=1488035613.1491446033.11");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// 获取接收数据
			out = new PrintWriter(conn.getOutputStream());
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			// 获取/拼装数据
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			// 请求失败
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static String getAlarmData(String file) {
		String url = "http://product.weather.com.cn/alarm/webdata/" + file;
		return getRequest(url);
	}

	public static WeatherAlarm getWeatherAlarm() {
		String res = WeatherHttpUtil.postRequest("http://product.weather.com.cn/alarm/grepalarm_cn.php?_=" + new Date().getTime());
		res = res.substring(14);
		res = res.substring(0, res.length() - 1);
		JSONObject obj = JSONObject.fromObject(res);
		JSONArray data = obj.getJSONArray("data");
		if (data == null || data.size() == 0) {
			return null;
		}
		int size = data.size();
		for (int i = 0; i < size; i++) {
			JSONArray t = JSONArray.fromObject(data.get(i));
			if (t.get(0).toString().indexOf("北京") > -1) {
				String warn = getAlarmData((String) t.get(1));
				warn = warn.substring(14);
				JSONObject warnObj = JSONObject.fromObject(warn);
				WeatherAlarm alarm = new WeatherAlarm();
				alarm.setEarlyWarnLevel((String) warnObj.get("SIGNALLEVEL"));
				alarm.setEarlyWarnStat("预警中");
				if (warnObj.get("ISSUETIME") == null
						|| PublicUtil.getStringDateTime((String) warnObj.get("ISSUETIME")) == null) {
					alarm.setEarlyWarnTime(new Date());
				} else {
					alarm.setEarlyWarnTime(PublicUtil.getStringDateTime((String) warnObj.get("ISSUETIME")));
				}
				alarm.setEarlyWarnTitle((String) warnObj.get("ALERTID"));
				alarm.setEarlyWarnTxt((String) warnObj.get("ISSUECONTENT"));
				alarm.setEarlyWarnType((String) warnObj.get("SIGNALTYPE"));
				return alarm;
			}
		}
		return null;
	}
}
