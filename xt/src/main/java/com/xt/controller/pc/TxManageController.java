package com.xt.controller.pc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.custom.MDeviceProduct;
import com.xt.entity.custom.MProjectArea;
import com.xt.entity.custom.MPumpLatLng;
import com.xt.entity.generation.DeviceProduct;
import com.xt.entity.generation.DeviceVender;
import com.xt.entity.generation.Project;
import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.Pump;
import com.xt.service.DeviceProductService;
import com.xt.service.DeviceVenderService;
import com.xt.service.ProjectAreaService;
import com.xt.service.ProjectService;
import com.xt.service.PumpService;
import com.xt.util.PublicUtil;

@Controller
@RequiresAuthentication
@RequestMapping("manage")
public class TxManageController {
	// 基础路径
	final String BASEPATH = "manage/";

	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectAreaService projectAreaService;
	@Autowired
	DeviceVenderService deviceVenderService;
	@Autowired
	DeviceProductService deviceProductService;
	@Autowired
	PumpService pumpService;

	@RequiresAuthentication
	@RequestMapping("project")
	public ModelAndView project() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "project");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("project-data")
	public Map<String, Object> projectData() {
		Map<String, Object> data = new HashMap<>();
		List<Project> projects = projectService.getProjectData();
		data.put("data", projects);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("add-project")
	public Map<String, Object> addProject(@RequestBody(required = true) Project project) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (project == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (project.getProjectAreaId() == null) {
			data.put("message", "无效的区域信息");
			return data;
		}
		if (PublicUtil.isEmpty(project.getProjectName())) {
			data.put("message", "请输入项目名称");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerId())) {
			data.put("message", "请选择业主信息");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerPhoneNo())) {
			data.put("message", "请输入业主联系方式");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerType())) {
			data.put("message", "请选择业主类别");
			return data;
		}

		ProjectArea projectArea = projectAreaService.getByAreaId(project.getProjectAreaId());
		if (projectArea == null) {
			data.put("message", "无效的区域信息");
			return data;
		}

		project.setProjectId(PublicUtil.initId());

		String areaCode = projectArea.getAreaCode();
		if (areaCode.length() > 6) {
			areaCode = areaCode.substring(0, 6);
		}
		String tempCode = "P" + areaCode + PublicUtil.getCurrentYearMonth();

		project.setProjectCode(projectService.getLastProjectCode(tempCode));
		project.setCreateTime(new Date());
		project.setModifyTime(new Date());
		try {
			projectService.create(project);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "创建成功");
		data.put("project", project);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("change-project")
	public Map<String, Object> changeProject(@RequestBody(required = true) Project project) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (project == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (project.getProjectId() == null) {
			data.put("message", "无效的项目信息");
			return data;
		}
		if (PublicUtil.isEmpty(project.getProjectName())) {
			data.put("message", "请输入项目名称");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerName())) {
			data.put("message", "请输入业主名称");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerPhoneNo())) {
			data.put("message", "请输入业主联系方式");
			return data;
		}
		if (PublicUtil.isEmpty(project.getOwnerType())) {
			data.put("message", "请选择业主类别");
			return data;
		}

		Project _project = projectService.getProjectById(project.getProjectId());
		if (_project == null) {
			data.put("message", "无效的区域信息");
			return data;
		}

		_project.setProjectName(project.getProjectName());
		_project.setOwnerName(project.getOwnerName());
		_project.setOwnerPhoneNo(project.getOwnerPhoneNo());
		_project.setOwnerType(project.getOwnerType());
		_project.setHeatingArea(project.getHeatingArea());
		_project.setHeatingTemp(project.getHeatingTemp());
		_project.setProjectAddress(project.getProjectAddress());
		_project.setModifyTime(new Date());

		try {
			projectService.update(_project);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作失败，请稍候重试");
			return data;
		}

		data.put("success", true);
		data.put("message", "修改成功");
		data.put("project", _project);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-project")
	public Map<String, Object> deleteProject(String projectId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (projectId == null) {
			data.put("message", "无效的数据");
			return data;
		}

		try {
			projectService.delete(projectId);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作失败，可能存在关联数据。");
			return data;
		}

		data.put("success", true);
		data.put("message", "删除成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("project-manage")
	public Map<String, Object> projectManage(String projectId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		Project project = projectService.getProjectById(projectId);
		if (project == null) {
			data.put("message", "无效的项目ID");
		}
		data.put("projectArea", projectAreaService.getByAreaId(project.getProjectAreaId()));
		data.put("pumps", pumpService.getProjectAll(projectId));
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("create-pump")
	public Map<String, Object> createPump(@RequestBody(required = true) Pump pump) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (pump == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (pump.getProjectId() == null) {
			data.put("message", "无效的项目ID");
			return data;
		}
		if (PublicUtil.isEmpty(pump.getPumpName())) {
			data.put("message", "请输入热泵名称");
			return data;
		}
		if (PublicUtil.isEmpty(pump.getPumpSn())) {
			data.put("message", "请输入热泵设备序列号");
			return data;
		}
		if (pump.getInstallDate() == null) {
			data.put("message", "请选择热泵安装日期");
			return data;
		}
		if (pump.getProductId() == null) {
			data.put("message", "请选择热泵产品");
			return data;
		}

		Project project = projectService.getProjectById(pump.getProjectId());
		if (project == null) {
			data.put("message", "无效的项目ID");
			return data;
		}

		if (null != pumpService.getBySn(pump.getPumpSn())) {
			data.put("message", "热泵设备序列号已存在");
			return data;
		}

		String projectAreaId = project.getProjectAreaId();
		ProjectArea projectArea = projectAreaService.getByAreaId(projectAreaId);
		if(projectArea == null) {
			data.put("message", "无效的项目区域ID");
			return data;
		}
		String tempCode = projectArea.getAreaCode() + PublicUtil.getCurrentYearMonth();
		pump.setPumpCode(pumpService.getLastPumpCode(tempCode));
		
		pump.setPumpId(PublicUtil.initId());
		pump.setOwnerId(project.getOwnerId());
		pump.setCreateTime(new Date());
		pump.setModifyTime(new Date());
		pump.setAreaLatitude("");
		pump.setAreaLongitude("");

		try {
			pumpService.create(pump);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("pump", pump);
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-pump")
	public Map<String, Object> updatePump(@RequestBody(required = true) Pump pump) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (pump == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (pump.getPumpId() == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}
		if (PublicUtil.isEmpty(pump.getPumpName())) {
			data.put("message", "请输入热泵名称");
			return data;
		}
		if (PublicUtil.isEmpty(pump.getPumpSn())) {
			data.put("message", "请输入热泵设备序列号");
			return data;
		}
		if (pump.getInstallDate() == null) {
			data.put("message", "请选择热泵安装日期");
			return data;
		}
		if (pump.getProductId() == null) {
			data.put("message", "请选择热泵产品");
			return data;
		}

		Pump upump = pumpService.getById(pump.getPumpId());
		if (upump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}

		Pump opump = pumpService.getBySn(pump.getPumpSn());
		if (null != opump && !opump.getPumpId().equals(upump.getPumpId())) {
			data.put("message", "热泵设备序列号已存在");
			return data;
		}

		upump.setPumpName(pump.getPumpName());
		upump.setPumpSn(pump.getPumpSn());
		upump.setInstallDate(pump.getInstallDate());
		upump.setProductId(pump.getProductId());
		upump.setModifyTime(new Date());

		try {
			pumpService.update(upump);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("pump", upump);
		data.put("success", true);
		return data;
	}
	
	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-pump-lat-lng")
	public Map<String, Object> updatePumpLatLng(@RequestBody(required = true) MPumpLatLng mPumpLatLng) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (mPumpLatLng == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (mPumpLatLng.getPumpId() == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}
		if (!PublicUtil.isNumber(mPumpLatLng.getLng())) {
			data.put("message", "无效的经度");
			return data;
		}
		if (!PublicUtil.isNumber(mPumpLatLng.getLat())) {
			data.put("message", "无效的纬度");
			return data;
		}

		Pump upump = pumpService.getById(mPumpLatLng.getPumpId());
		if (upump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}

		upump.setAreaLatitude(mPumpLatLng.getLat());
		upump.setAreaLongitude(mPumpLatLng.getLng());
		upump.setModifyTime(new Date());

		try {
			pumpService.update(upump);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("pump", upump);
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-pump")
	public Map<String, Object> deletePump(String pumpId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (pumpId == null) {
			data.put("message", "无效的数据");
			return data;
		}
		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			data.put("message", "无效的参数");
			return data;
		}
		try {
			pumpService.delete(pumpId);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作出错，可能存在关联数据");
			return data;
		}
		data.put("success", true);
		data.put("message", "删除成功");
		return data;
	}

	@RequiresAuthentication
	@RequestMapping("project-area")
	public ModelAndView projectArea() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "project-area");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("project-area-info")
	public Map<String, Object> projectAreaInfo(String projectAreaId) {
		Map<String, Object> data = new HashMap<>();
		data.put("data", projectAreaService.getByAreaId(projectAreaId));
		return data;
	}

	@ResponseBody
	@RequestMapping("project-area-data")
	public Map<String, Object> projectAreaData() {
		Map<String, Object> data = new HashMap<>();
		List<ProjectArea> projectAreas = projectAreaService.getProjectAreaData();
		List<MProjectArea> mProjectAreas = new ArrayList<>();
		if (projectAreas != null && !projectAreas.isEmpty()) {
			for (ProjectArea projectArea : projectAreas) {
				MProjectArea mProjectArea = new MProjectArea();
				BeanUtils.copyProperties(projectArea, mProjectArea);
				mProjectArea.setChildren(new ArrayList<MProjectArea>());
				mProjectAreas.add(mProjectArea);
			}
		}
		data.put("data", buildListToTree(mProjectAreas));
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("child-area-data")
	public Map<String, Object> childAreaData(String parentCode) {
		Map<String, Object> data = new HashMap<>();
		data.put("data", projectAreaService.getChildArea(parentCode));
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("add-child-area")
	public Map<String, Object> addChildArea(@RequestBody(required = true) ProjectArea area) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (area == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(area.getAreaCode())) {
			data.put("message", "无效的区域编码");
			return data;
		}
		if (PublicUtil.isEmpty(area.getParentAreaCode())) {
			data.put("message", "无效的父级区域编码");
			return data;
		}
		if (PublicUtil.isEmpty(area.getWeatherCode())) {
			data.put("message", "无效的区域天气编码");
			return data;
		}
		ProjectArea projectArea = projectAreaService.getByAreaCode(area.getAreaCode());
		if (projectArea != null) {
			data.put("message", "当前区域已被创建");
			return data;
		}

		area.setProjectAreaId(PublicUtil.initId());
		area.setCreateTime(new Date());
		area.setModifyTime(new Date());

		try {
			projectAreaService.create(area);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作失败，请稍候重试");
			return data;
		}

		MProjectArea mProjectArea = new MProjectArea();
		BeanUtils.copyProperties(area, mProjectArea);
		mProjectArea.setChildren(new ArrayList<>());
		data.put("area", mProjectArea);
		data.put("success", true);

		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-area")
	public Map<String, Object> deleteArea(String areaCode) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(areaCode)) {
			data.put("message", "请传入区域编码");
			return data;
		}
		if ("110000".equals(areaCode)) {
			data.put("message", "不可删除顶级节点");
			return data;
		}
		ProjectArea projectArea = projectAreaService.getByAreaCode(areaCode);
		if (projectArea == null) {
			data.put("message", "无效的区域编码");
			return data;
		}
		List<ProjectArea> childs = projectAreaService.getByParentAreaCode(areaCode);
		if (childs != null && !childs.isEmpty()) {
			data.put("message", "存在子级区域，不可删除");
			return data;
		}
		List<Project> project = projectService.getProjectByAreaCode(projectArea.getProjectAreaId());
		if (project != null && !project.isEmpty()) {
			data.put("message", "存在关联项目，不可删除");
			return data;
		}
		try {
			projectAreaService.delete(projectArea.getProjectAreaId());
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "删除成功");
		return data;
	}

	private List<MProjectArea> buildListToTree(List<MProjectArea> mProjectAreas) {
		if (mProjectAreas == null || mProjectAreas.isEmpty()) {
			return mProjectAreas;
		}
		List<MProjectArea> roots = findListRoots(mProjectAreas);
		List<MProjectArea> childs = (List<MProjectArea>) CollectionUtils.subtract(mProjectAreas, roots);
		for (MProjectArea root : roots) {
			root.setChildren(findChildren(root, childs));
		}
		return roots;
	}

	private List<MProjectArea> findListRoots(List<MProjectArea> mProjectAreas) {
		List<MProjectArea> roots = new ArrayList<MProjectArea>();
		for (MProjectArea mProjectArea : mProjectAreas) {
			if (PublicUtil.isEmpty(mProjectArea.getParentAreaCode())) {
				roots.add(mProjectArea);
			}
		}
		return roots;
	}

	private List<MProjectArea> findChildren(MProjectArea root, List<MProjectArea> allNodes) {
		List<MProjectArea> children = new ArrayList<MProjectArea>();
		for (MProjectArea comparedOne : allNodes) {
			if (comparedOne.getParentAreaCode().equals(root.getAreaCode())) {
				children.add(comparedOne);
			}
		}
		if (children.size() > 0) {
			List<MProjectArea> notChildren = (List<MProjectArea>) CollectionUtils.subtract(allNodes, children);
			for (MProjectArea child : children) {
				child.setChildren(findChildren(child, notChildren));
			}
		}
		return children;
	}

	@RequiresAuthentication
	@RequestMapping("device-product")
	public ModelAndView deviceProduct() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "device-product");
		return modelAndView;
	}

	@RequiresAuthentication
	@RequestMapping("device-vender")
	public ModelAndView deviceVender() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "device-vender");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("device-vender-data")
	public Map<String, Object> deviceVenderData() {
		Map<String, Object> data = new HashMap<>();
		List<DeviceVender> deviceVenders = deviceVenderService.findAll();
		data.put("data", deviceVenders);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("create-device-vender")
	public Map<String, Object> createDeviceVender(@RequestBody(required = true) DeviceVender deviceVender) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (deviceVender == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(deviceVender.getVenderName())) {
			data.put("message", "请输入厂家名称");
			return data;
		}
		if (PublicUtil.isEmpty(deviceVender.getVenderContacts())) {
			data.put("message", "请输入厂家联系人");
			return data;
		}
		if (PublicUtil.isEmpty(deviceVender.getVenderContactsTel())) {
			data.put("message", "请输入厂家联系方式");
			return data;
		}
		deviceVender.setVenderId(PublicUtil.initId());
		deviceVender.setCreateTime(new Date());
		deviceVender.setModifyTime(new Date());

		try {
			deviceVenderService.create(deviceVender);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作出错，请稍候重试");
			return data;
		}

		data.put("success", true);
		data.put("deviceVender", deviceVender);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-device-vender")
	public Map<String, Object> updateDeviceVender(@RequestBody(required = true) DeviceVender deviceVender) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (deviceVender == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (deviceVender.getVenderId() == null) {
			data.put("message", "请输入厂家ID");
			return data;
		}
		if (PublicUtil.isEmpty(deviceVender.getVenderName())) {
			data.put("message", "请输入厂家名称");
			return data;
		}
		if (PublicUtil.isEmpty(deviceVender.getVenderContacts())) {
			data.put("message", "请输入厂家联系人");
			return data;
		}
		if (PublicUtil.isEmpty(deviceVender.getVenderContactsTel())) {
			data.put("message", "请输入厂家联系方式");
			return data;
		}
		DeviceVender vender = deviceVenderService.findById(deviceVender.getVenderId());
		if (vender == null) {
			data.put("message", "无效的厂家ID");
			return data;
		}
		vender.setVenderName(deviceVender.getVenderName());
		vender.setVenderContacts(deviceVender.getVenderContacts());
		vender.setVenderContactsTel(deviceVender.getVenderContactsTel());
		vender.setVenderAddress(deviceVender.getVenderAddress());
		vender.setVenderRemark(deviceVender.getVenderRemark());
		vender.setModifyTime(new Date());
		try {
			deviceVenderService.update(vender);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作出错，请稍候重试");
			return data;
		}

		data.put("success", true);
		data.put("deviceVender", vender);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-device-vender")
	public Map<String, Object> deleteDeviceVender(String venderId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (venderId == null) {
			data.put("message", "无效的数据");
			return data;
		}
		DeviceVender vender = deviceVenderService.findById(venderId);
		if (vender == null) {
			data.put("message", "无效的参数");
			return data;
		}
		try {
			deviceVenderService.delete(venderId);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作出错，可能存在关联数据");
			return data;
		}
		data.put("success", true);
		data.put("message", "删除成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("device-product-data")
	public Map<String, Object> deviceProductData() {
		Map<String, Object> data = new HashMap<>();
		List<MDeviceProduct> deviceProducts = deviceProductService.findAll();
		List<MDeviceProduct> Rs = new ArrayList<>();
		List<MDeviceProduct> Cs = new ArrayList<>();
		if (deviceProducts != null && deviceProducts.size() > 0) {
			for (MDeviceProduct m : deviceProducts) {
				if (m.getProductType().equals("R"))
					Rs.add(m);
				else
					Cs.add(m);
			}
		}
		data.put("Rs", Rs);
		data.put("Cs", Cs);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("create-device-product")
	public Map<String, Object> createDeviceProduct(@RequestBody(required = true) DeviceProduct deviceProduct) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (deviceProduct == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(deviceProduct.getProductType())) {
			data.put("message", "请选择设备的类别");
			return data;
		}
		if (PublicUtil.isEmpty(deviceProduct.getProductName())) {
			data.put("message", "请输入产品名称");
			return data;
		}
		if (deviceProduct.getProductVenderId() == null) {
			data.put("message", "请选择一个厂家");
			return data;
		}

		DeviceVender vender = deviceVenderService.findById(deviceProduct.getProductVenderId());
		if (vender == null) {
			data.put("message", "无效的厂家ID");
			return data;
		}

		deviceProduct.setProductId(PublicUtil.initId());
		deviceProduct.setCreateTime(new Date());
		deviceProduct.setModifyTime(new Date());

		try {
			deviceProductService.create(deviceProduct);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作出错，请稍候重试");
			return data;
		}

		MDeviceProduct mDeviceProduct = new MDeviceProduct();
		BeanUtils.copyProperties(deviceProduct, mDeviceProduct);
		mDeviceProduct.setProductVenderName(vender.getVenderName());
		data.put("success", true);
		data.put("deviceProduct", mDeviceProduct);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-device-product")
	public Map<String, Object> updateDeviceProduct(@RequestBody(required = true) DeviceProduct deviceProduct) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (deviceProduct == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (deviceProduct.getProductId() == null) {
			data.put("message", "请输入产品ID");
			return data;
		}
		if (PublicUtil.isEmpty(deviceProduct.getProductName())) {
			data.put("message", "请输入产品名称");
			return data;
		}
		if (PublicUtil.isEmpty(deviceProduct.getProductVenderId())) {
			data.put("message", "请选择产品厂家");
			return data;
		}

		DeviceVender vender = deviceVenderService.findById(deviceProduct.getProductVenderId());
		if (vender == null) {
			data.put("message", "无效的厂家ID");
			return data;
		}

		DeviceProduct product = deviceProductService.findById(deviceProduct.getProductId());
		if (product == null) {
			data.put("message", "无效的产品ID");
			return data;
		}
		product.setProductName(deviceProduct.getProductName());
		product.setProductVenderId(deviceProduct.getProductVenderId());
		product.setProductSpec(deviceProduct.getProductSpec());
		product.setProductPowerSpec(deviceProduct.getProductPowerSpec());
		product.setProductPi(deviceProduct.getProductPi());
		product.setProductDescript(deviceProduct.getProductDescript());
		product.setModifyTime(new Date());
		try {
			deviceProductService.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作出错，请稍候重试");
			return data;
		}

		MDeviceProduct mDeviceProduct = new MDeviceProduct();
		BeanUtils.copyProperties(product, mDeviceProduct);
		mDeviceProduct.setProductVenderName(vender.getVenderName());

		data.put("success", true);
		data.put("deviceProduct", mDeviceProduct);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-device-product")
	public Map<String, Object> deleteDeviceProduct(String productId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (productId == null) {
			data.put("message", "无效的数据");
			return data;
		}
		DeviceProduct product = deviceProductService.findById(productId);
		if (product == null) {
			data.put("message", "无效的参数");
			return data;
		}
		try {
			deviceProductService.delete(productId);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("message", "操作出错，可能存在关联数据。");
			return data;
		}
		data.put("success", true);
		data.put("message", "删除成功");
		return data;
	}

}
