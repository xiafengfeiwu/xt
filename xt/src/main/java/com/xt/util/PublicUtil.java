package com.xt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.xt.entity.custom.MAreaPump;
import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.WeatherAlarm;
import com.xt.entity.generation.WeatherData;
import com.xt.service.CityWeatherService;

import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class PublicUtil {
	final static _Sequence sequence = new _Sequence(1);
	// 系统管理员角色ID
	public final static String ROLE_SYSTEM_MANAGE_ID = "3295920218899451";
	// 区域管理员角色ID
	public final static String ROLE_AREA_MANAGE_ID = "3295920218899452";
	// 运维角色ID
	public final static String ROLE_OPERATOR_ID = "3295920218899453";
	// 普通用户角色ID
	public final static String ROLE_USER_ID = "3295920218899454";

	// 初始化ID
	public static String initId() {
		return sequence.nextId() + "";
	}

	// 初始化MAP
	public static Map<String, Object> initMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		return map;
	}

	// 获取Session用户ID
	public static String sessionUid() {
		Subject subject = SecurityUtils.getSubject();
		Object userId = subject.getSession().getAttribute("userId");
		if (userId == null) {
			return null;
		}
		return userId.toString();
	}

	// 获取Session用户角色名称
	public static Role sessionUserRole() {
		Subject subject = SecurityUtils.getSubject();
		Object userRole = subject.getSession().getAttribute("userRole");
		if (userRole == null) {
			return null;
		}
		return (Role) userRole;
	}

	// 判断对象是否为空
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			if ("".equals(((String) obj).trim())) {
				return true;
			}
		}
		if (obj instanceof Collection<?>) {
			return ((Collection<?>) obj).isEmpty();
		}
		return false;
	}

	// 判断对象是否不为空
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	// 获取访问者IP地址
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PRoxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// 判断是否是登录名称
	public static boolean isLoginName(String loginName) {
		if (isEmpty(loginName)) {
			return false;
		}
		Pattern regex = Pattern.compile("^\\w{2,20}$");
		Matcher matcher = regex.matcher(loginName);
		return matcher.matches();
	}

	// 判断是否是手机号
	public static boolean isPhoneNo(String phoneNo) {
		if (isEmpty(phoneNo)) {
			return false;
		}
		Pattern regex = Pattern.compile("^1\\d{10}$");
		Matcher matcher = regex.matcher(phoneNo);
		return matcher.matches();
	}

	// 判断是否是密码
	public static boolean isPassword(String password) {
		if (isEmpty(password)) {
			return false;
		}
		Pattern regex = Pattern.compile("^\\w{6,20}$");
		Matcher matcher = regex.matcher(password);
		return matcher.matches();
	}

	// SHA1加密
	public static String sha1(String decript) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		digest.update(decript.getBytes());
		byte messageDigest[] = digest.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < messageDigest.length; i++) {
			String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
			if (shaHex.length() < 2)
				hexString.append(0);
			hexString.append(shaHex);
		}
		return hexString.toString();
	}

	public static String getStringPy(String str) {
		if (isEmpty(str)) {
			return "";
		}
		try {
			String all = PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE);
			String jp = PinyinHelper.getShortPinyin(str);
			return jp + ";" + all;
		} catch (PinyinException e) {
			return "";
		}
	}

	public static String getCurrentYearMonth() {
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}

	public static String getNextCode(String lastCode) {
		String no = lastCode.substring(13, 17);
		Integer psNo = new Integer(no);
		psNo++;
		String n = null;
		if (psNo < 10) {
			n = "000" + psNo;
		} else if (psNo < 100) {
			n = "00" + psNo;
		} else if (psNo < 1000) {
			n = "0" + psNo;
		} else {
			n = "" + psNo;
		}
		return lastCode.substring(0, 13) + n;
	}

	public static String getNextPumpCode(String lastCode) {
		String no = lastCode.substring(lastCode.length() - 4, lastCode.length());
		Integer psNo = new Integer(no);
		psNo++;
		String n = null;
		if (psNo < 10) {
			n = "000" + psNo;
		} else if (psNo < 100) {
			n = "00" + psNo;
		} else if (psNo < 1000) {
			n = "0" + psNo;
		} else {
			n = "" + psNo;
		}
		return lastCode.substring(0, lastCode.length() - 4) + n;
	}

	public static boolean isNumber(String str) {
		if (isEmpty(str)) {
			return false;
		}
		Pattern regex = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
		Matcher matcher = regex.matcher(str);
		return matcher.matches();
	}

	public static String delZero(String src) {
		if (src.endsWith("0"))
			return delZero(src.substring(0, src.length() - 1));
		else
			return src;
	}

	public static WeatherData analysisWeatherDataJson(String json, CityWeatherService cityWeatherService) {
		try {
			JSONObject object = JSONObject.fromObject(json);
			JSONObject root = object.getJSONArray("HeWeather5").getJSONObject(0);
			String status = root.getString("status");
			if (!"ok".equals(status)) {
				return null;
			}
			JSONObject basic = root.getJSONObject("basic");
			WeatherData data = new WeatherData();
			data.setWeatherCityCode(basic.getString("id"));
			JSONObject update = basic.getJSONObject("update");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			data.setCollectDate(df.parse(update.getString("loc")));
			JSONObject now = root.getJSONObject("now");
			JSONObject cond = now.getJSONObject("cond");
			data.setCondCode(cond.getString("code"));
			data.setCondCodeUrl(cityWeatherService.findWeatherIconByCode(data.getCondCode()).getIcon());
			data.setCondTxt(cond.getString("txt"));
			data.setFl(now.getString("fl"));
			data.setHum(now.getString("hum"));
			data.setPcpn(now.getString("pcpn"));
			data.setPres(now.getString("pres"));
			data.setTmp(now.getString("tmp"));
			data.setVis(now.getString("vis"));
			JSONObject wind = now.getJSONObject("wind");
			data.setWindDeg(wind.getString("deg"));
			data.setWindDir(wind.getString("dir"));
			data.setWindSc(wind.getString("sc"));
			data.setWindSpd(wind.getString("spd"));
			data.setLastUpdateTime(new Date());
			return data;
		} catch (Exception e) {
			return null;
		}
	}

	public static WeatherAlarm analysisAlarmDataJson(String json) {
		try {
			JSONObject object = JSONObject.fromObject(json);
			JSONObject root = object.getJSONArray("HeWeather5").getJSONObject(0);
			String status = root.getString("status");
			if (!"ok".equals(status)) {
				return null;
			}
			JSONObject basic = root.getJSONObject("basic");
			WeatherAlarm data = new WeatherAlarm();
			data.setWeatherCityCode(basic.getString("id"));
			Object alarms = root.get("alarms");
			if (alarms == null) {
				return data;
			}
			JSONObject alarm = root.getJSONArray("alarms").getJSONObject(0);
			data.setEarlyWarnLevel(alarm.getString("level"));
			data.setEarlyWarnStat(alarm.getString("stat"));
			data.setEarlyWarnTitle(alarm.getString("title"));
			data.setEarlyWarnTxt(alarm.getString("txt"));
			data.setEarlyWarnType(alarm.getString("type"));
			data.setEarlyWarnTime(new Date());
			return data;
		} catch (Exception e) {
			return null;
		}
	}

	public static void transforAreaObj(List<Map<String, Object>> data, List<ProjectArea> projectAreas) {
		if (projectAreas != null && !projectAreas.isEmpty()) {
			Map<String, Object> map = null;
			for (ProjectArea projectArea : projectAreas) {
				map = new HashMap<>();
				map.put("id", projectArea.getProjectAreaId());
				map.put("name", projectArea.getAreaName());
				map.put("isParent", true);
				data.add(map);
			}
		}
	}

	public static void transforPumpObj(List<Map<String, Object>> data, List<MAreaPump> mAreaPumps, boolean isParent) {
		if (mAreaPumps != null && !mAreaPumps.isEmpty()) {
			Map<String, Object> map = null;
			for (MAreaPump mAreaPump : mAreaPumps) {
				map = new HashMap<>();
				map.put("id", mAreaPump.getId());
				map.put("name", mAreaPump.getName());
				map.put("isParent", isParent);
				data.add(map);
			}
		}
	}

	public static void main(String[] args) {
		// // while (true) {
		// System.out.println(initId());
		// // }
		// // System.out.println(isNumber("太行山hang"));
		// // System.out.println(isNumber("11.23"));
		// // System.out.println(isNumber("-120.23"));
		// // System.out.println(isNumber("0"));
		// // System.out.println(getNextCode("P1100002017039998"));
		// // System.out.println(getNextCode("P1100002017039993"));
		// // System.out.println(getNextCode("M1100002017039991"));
		// String areaCode = "1102002017030002";
		// // areaCode = areaCode.substring(1, 13);
		// System.out.println(getNextPumpCode(areaCode));
		// System.out.println(initId());
		// System.out.println(initId());
		// System.out.println(initId());
		// System.out.println(initId());
		Jedis jedis = RedisConfig.getJedis();
		System.out.println(RedisUtil.getString("version"));

		JedisPubSub jedisPubSub = new JedisPubSub() {
			@Override
			public void onMessage(String channel, String message) {
				System.out.println("channel:" + channel + ", message:" + message);
			}
		};
		jedis.subscribe(jedisPubSub, "redisChat");
		

		jedis.publish("redisChat", "123");
	}
}