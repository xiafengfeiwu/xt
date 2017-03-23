package com.xt.controller.pc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tinify.Options;
import com.tinify.Source;
import com.tinify.Tinify;
import com.xt.entity.generation.Res;
import com.xt.entity.generation.User;
import com.xt.service.ResService;
import com.xt.service.UserService;
import com.xt.util.PublicUtil;

@Controller
@RequestMapping("file")
public class TxFileController {

	@Autowired
	ResService resService;
	@Autowired
	UserService userService;

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("upload-img")
	public Map<String, Object> uploadImg(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@RequestParam("groupId") String groupId) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (file == null) {
			map.put("message", "未上传文件");
			return map;
		}
		if (PublicUtil.isEmpty(groupId)) {
			map.put("message", "请传入GroupId");
			return map;
		}

		if (!file.getContentType().startsWith("image")) {
			map.put("message", "无效的文件类型");
			return map;
		}

		if (file.getSize() > 2 * 1024 * 1024) {
			map.put("message", "文件大小超过2Mb限制");
			return map;
		}

		String Fseparator = File.separator;
		String realPath = request.getSession().getServletContext().getRealPath(Fseparator + "uploads");

		String savePath = realPath + Fseparator + PublicUtil.getCurrentYearMonth();
		File saveFilePath = new File(savePath);
		if (!saveFilePath.exists()) {
			saveFilePath.mkdirs();
		}

		String originalFilename = file.getOriginalFilename();
		String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		String newFileName = "FN" + PublicUtil.initId() + "." + type;

		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(savePath, newFileName));
		} catch (IOException e) {
			map.put("message", "存储失败，请稍后重试");
			return map;
		}

		String filePath = "/" + PublicUtil.getCurrentYearMonth() + "/" + newFileName;

		Res res = new Res();
		res.setResId(PublicUtil.initId());
		res.setGroupId(groupId);
		if (originalFilename.length() > 100) {
			res.setResName(newFileName);
		} else {
			res.setResName(originalFilename);
		}
		res.setResSize(file.getSize());
		res.setResType(type);
		res.setResPath(filePath);
		res.setResCreateTime(new Date());
		try {
			resService.insert(res);
		} catch (Exception e) {
			map.put("message", "保存失败，请稍后重试");
			return map;
		}
		TxFileController.compression(savePath + "/" + newFileName);
		map.put("success", true);
		map.put("message", "上传成功");
		map.put("res", res);
		return map;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("upload-head-img")
	public Map<String, Object> uploadHeadImg(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@RequestParam("userId") String userId) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (file == null) {
			map.put("message", "未上传文件");
			return map;
		}
		if (PublicUtil.isEmpty(userId)) {
			map.put("message", "请传入userId");
			return map;
		}

		if (!file.getContentType().startsWith("image")) {
			map.put("message", "无效的文件类型");
			return map;
		}

		if (file.getSize() > 2 * 1024 * 1024) {
			map.put("message", "文件大小超过500Kb限制");
			return map;
		}

		User user = userService.findById(userId);
		if (user == null) {
			map.put("message", "无效的用户ID");
			return map;
		}

		String Fseparator = File.separator;
		String realPath = request.getSession().getServletContext().getRealPath(Fseparator + "uploads");

		String savePath = realPath + Fseparator + PublicUtil.getCurrentYearMonth();
		File saveFilePath = new File(savePath);
		if (!saveFilePath.exists()) {
			saveFilePath.mkdirs();
		}

		String originalFilename = file.getOriginalFilename();
		String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
		String newFileName = "FN" + PublicUtil.initId() + "." + type;

		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(savePath, newFileName));
		} catch (IOException e) {
			map.put("message", "存储失败，请稍后重试");
			return map;
		}

		String filePath = "uploads" + "/" + PublicUtil.getCurrentYearMonth() + "/" + newFileName;

		user.setUserPortraitPath(filePath);
		try {
			userService.update(user);
		} catch (Exception e) {
			map.put("message", "更新失败，请稍后重试");
			return map;
		}

		TxFileController.compression(savePath + "/" + newFileName);

		map.put("success", true);
		map.put("message", "上传成功");
		map.put("filePath", filePath);
		return map;
	}

	private static void compression(String path) {
		Tinify.setKey("SjdrSTZvZ1Hfw58Wu90aV_Qdr_o4n7go");
		Source source = null;
		try {
			source = Tinify.fromFile(path);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Options options = new Options().with("method", "cover").with("width", 320).with("height", 320);
		Source resized = source.resize(options);
		try {
			resized.toFile(path);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}
