package com.xt.controller.pc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.xt.entity.generation.Pump;
import com.xt.entity.generation.Res;
import com.xt.entity.generation.User;
import com.xt.service.PumpService;
import com.xt.service.ResService;
import com.xt.service.UserService;
import com.xt.util.ImgCompress;
import com.xt.util.PublicUtil;

@Controller
@RequestMapping("file")
public class TxFileController {

	@Autowired
	ResService resService;
	@Autowired
	UserService userService;
	@Autowired
	PumpService pumpService;

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("upload-pump-img")
	public Map<String, Object> uploadPumpImg(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@RequestParam("pumpId") String pumpId) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (file == null) {
			map.put("message", "未上传文件");
			return map;
		}
		if (PublicUtil.isEmpty(pumpId)) {
			map.put("message", "请传入pumpId");
			return map;
		}

		if (!file.getContentType().startsWith("image")) {
			map.put("message", "无效的文件类型");
			return map;
		}

		if (file.getSize() > 4 * 1024 * 1024) {
			map.put("message", "文件大小超过4Mb限制");
			return map;
		}

		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			map.put("message", "无效的pumpId");
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

		String filePath = "uploads/" + PublicUtil.getCurrentYearMonth() + "/" + newFileName;

		Res res = new Res();
		res.setResId(PublicUtil.initId());
		res.setGroupId(pump.getGroupId());
		if (originalFilename.length() > 60) {
			originalFilename = originalFilename.substring(0, 15) + "..."
					+ originalFilename.substring(originalFilename.length() - 10, originalFilename.length());
		}
		res.setResName(originalFilename);
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
		String originalPicture = pump.getPumpPicture();
		if (PublicUtil.isEmpty(originalPicture) || "assets/img/default.png".equals(originalPicture)) {
			pump.setPumpPicture(filePath);
			try {
				pumpService.update(pump);
			} catch (Exception e) {
				map.put("message", "更新失败，请稍后重试");
				return map;
			}
			map.put("pump", pump);
		}
		TxFileController.compression(savePath + "/" + newFileName);
		map.put("success", true);
		map.put("message", "上传成功");
		map.put("res", res);
		return map;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("upload-file")
	public Map<String, Object> uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			@RequestParam("groupId") String groupId) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (file == null) {
			map.put("message", "未上传文件");
			return map;
		}
		if (PublicUtil.isEmpty(groupId)) {
			map.put("message", "请传入groupId");
			return map;
		}

		if (file.getSize() > 4 * 1024 * 1024) {
			map.put("message", "文件大小超过4Mb限制");
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

		String filePath = "uploads/" + PublicUtil.getCurrentYearMonth() + "/" + newFileName;

		Res res = new Res();
		res.setResId(PublicUtil.initId());
		res.setGroupId(groupId);
		if (originalFilename.length() > 60) {
			originalFilename = originalFilename.substring(0, 15) + "..."
					+ originalFilename.substring(originalFilename.length() - 10, originalFilename.length());
		}
		res.setResName(originalFilename);
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

		if (file.getSize() > 4 * 1024 * 1024) {
			map.put("message", "文件大小超过4Mb限制");
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

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-pump-img")
	public Map<String, Object> deletePumpImg(String pumpId, String resId) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (PublicUtil.isEmpty(pumpId)) {
			map.put("message", "请传入pumpId");
			return map;
		}
		if (PublicUtil.isEmpty(resId)) {
			map.put("message", "请传入resId");
			return map;
		}

		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			map.put("message", "无效的pumpId");
			return map;
		}
		Res res = resService.getById(resId);
		if (res == null) {
			map.put("message", "无效的resId");
			return map;
		}

		if (res.getResPath().equals(pump.getPumpPicture())) {
			List<Res> reses = resService.findResByGroupId(pump.getGroupId());
			if (reses != null && reses.size() > 1) {
				for (Res r : reses) {
					if (!r.getResId().equals(resId)) {
						pump.setPumpPicture(r.getResPath());
						break;
					}
				}
			} else {
				pump.setPumpPicture("assets/img/default.png");
			}
			try {
				pumpService.update(pump);
			} catch (Exception e) {
				map.put("message", "更新数据失败，请稍后重试");
				return map;
			}
			map.put("pump", pump);
		}

		try {
			resService.delete(resId);
		} catch (Exception e) {
			map.put("message", "删除资源失败，请稍后重试");
			return map;
		}

		map.put("success", true);
		map.put("message", "操作成功");
		return map;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-file")
	public Map<String, Object> deleteFile(String resId) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (PublicUtil.isEmpty(resId)) {
			map.put("message", "请传入resId");
			return map;
		}
		Res res = resService.getById(resId);
		if (res == null) {
			map.put("message", "无效的resId");
			return map;
		}
		try {
			resService.delete(resId);
		} catch (Exception e) {
			map.put("message", "删除资源失败，请稍后重试");
			return map;
		}
		map.put("success", true);
		map.put("message", "操作成功");
		return map;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("set-pump-default-img")
	public Map<String, Object> setPumpDefaultImg(String pumpId, String resId) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", false);
		if (PublicUtil.isEmpty(pumpId)) {
			map.put("message", "请传入pumpId");
			return map;
		}
		if (PublicUtil.isEmpty(resId)) {
			map.put("message", "请传入resId");
			return map;
		}

		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			map.put("message", "无效的pumpId");
			return map;
		}
		Res res = resService.getById(resId);
		if (res == null) {
			map.put("message", "无效的resId");
			return map;
		}

		if (!res.getResPath().equals(pump.getPumpPicture())) {
			pump.setPumpPicture(res.getResPath());
			try {
				pumpService.update(pump);
			} catch (Exception e) {
				map.put("message", "更新失败，请稍后重试");
				return map;
			}
			map.put("pump", pump);
		}

		map.put("success", true);
		map.put("message", "操作成功");
		return map;
	}

	private static void compression(String path) {
		ImgCompress.todo(path);
	}
}
