package com.xt.controller.wx;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.generation.User;
import com.xt.entity.generation.UserAuth;
import com.xt.service.PumpService;
import com.xt.service.UserAuthService;
import com.xt.service.UserService;
import com.xt.util.PublicUtil;

@Controller
@RequestMapping("wx")
public class WxPageController {

	private String APPID = "wxa26318af384fa0cc";
	// private String APPSECRET = "a5d05e9b2ece36324ae0540b24de938b";
	/** 基础路径 */
	private String BAERURL = "http://www.guangfuhome.com/collect/wx/";

	@Autowired
	UserAuthService userAuthService;
	@Autowired
	UserService userService;
	@Autowired
	PumpService pumpService;

	// 基础路径
	final String BASEPATH = "wx/";

	@RequestMapping("skipToIndex")
	public void bindSkip(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String redirectUri = BAERURL + "index";
		redirectUri = URLEncoder.encode(redirectUri, "UTF-8");
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APPID + "&redirect_uri="
				+ redirectUri + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		response.sendRedirect(url);
	}

	@RequestMapping("index")
	public ModelAndView bind(HttpServletRequest request, HttpServletResponse response, String code, String state)
			throws Exception {
		// String url =
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID +
		// "&secret=" + APPSECRET + "&code=" + code +
		// "&grant_type=authorization_code";
		ModelAndView mav = new ModelAndView();
		// JSONObject object = null;
		// String openId = null;
		// try {
		// String reqStr = HttpUtil.getJsonString(url);
		// object = JSONObject.fromObject(reqStr);
		// } catch (Exception e) {
		// mav.setViewName(BASEPATH + "invalid");
		// return mav;
		// }
		// String errCode = object.getString("errcode");
		// if (null != errCode) {
		// // errCode
		// mav.setViewName(BASEPATH + "invalid");
		// return mav;
		// } else {
		// openId = object.getString("openid");
		// mav.addObject("openId", openId);
		// }
		mav.addObject("userId", "3296101450843130");
		mav.setViewName(BASEPATH + "index");
		return mav;
	}

	@ResponseBody
	@RequestMapping("my-pump-data")
	public Map<String, Object> myPumpData(String userId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (userId == null) {
			data.put("message", "请传入用户ID");
			return data;
		}
		User user = userService.findById(userId);
		if (user == null) {
			data.put("message", "无效的用户ID");
			return data;
		}
		if(PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(user.getRoleId())) {
		}

		List<UserAuth> uas = userAuthService.findUserAll(userId);
		if (uas == null || uas.isEmpty()) {
			data.put("message", "当前用户未被授权访问任何热泵数据");
			return data;
		}
		List<String> pumpCodes = new ArrayList<>();
		for (UserAuth ua : uas) {
			pumpCodes.add(ua.getAuthCode());
		}
		List<MAreaPump> aps = pumpService.selectPumpsByCodes(pumpCodes);
		if (aps == null || aps.isEmpty()) {
			data.put("message", "无效的授权访问");
			return data;
		}
		data.put("success", true);
		data.put("data", aps);
		return data;
	}

	@RequestMapping("/{path}")
	public ModelAndView path(@PathVariable("path") String path) {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + path);
		return modelAndView;
	}
}