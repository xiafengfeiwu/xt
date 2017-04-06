package com.xt.controller.pc;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xt.entity.custom.MAreaPump;
import com.xt.entity.custom.MPumpEleStatistics;
import com.xt.entity.custom.MPumpMonitor;
import com.xt.entity.custom.MPumpWarnGroup;
import com.xt.entity.custom.MPumpWarnGroupParam;
import com.xt.entity.generation.Device;
import com.xt.entity.generation.DeviceProduct;
import com.xt.entity.generation.DeviceVender;
import com.xt.entity.generation.Project;
import com.xt.entity.generation.ProjectArea;
import com.xt.entity.generation.Pump;
import com.xt.entity.generation.PumpEleConstantly;
import com.xt.entity.generation.PumpHistoryData;
import com.xt.entity.generation.PumpWarn;
import com.xt.entity.generation.PumpWarnGroup;
import com.xt.entity.generation.PumpWarnGroupKey;
import com.xt.entity.generation.Res;
import com.xt.entity.generation.Role;
import com.xt.entity.generation.UserAuth;
import com.xt.entity.generation.WarnGroup;
import com.xt.entity.generation.WarnGroupItem;
import com.xt.entity.generation.WeatherAlarm;
import com.xt.entity.generation.WeatherData;
import com.xt.service.CityWeatherService;
import com.xt.service.DeviceProductService;
import com.xt.service.DeviceService;
import com.xt.service.DeviceVenderService;
import com.xt.service.ProjectAreaService;
import com.xt.service.ProjectService;
import com.xt.service.PumpCollectService;
import com.xt.service.PumpService;
import com.xt.service.PumpWarnService;
import com.xt.service.ResService;
import com.xt.service.UserAuthService;
import com.xt.service.WarnGroupService;
import com.xt.util.PublicUtil;

@Controller
@RequiresAuthentication
@RequestMapping("monitor")
public class TxMonitorController {

	// 基础路径
	final String BASEPATH = "monitor/";

	@Autowired
	PumpService pumpService;
	@Autowired
	ProjectService projectService;
	@Autowired
	ProjectAreaService projectAreaService;
	@Autowired
	CityWeatherService cityWeatherService;
	@Autowired
	WarnGroupService warnGroupService;
	@Autowired
	DeviceProductService deviceProductService;
	@Autowired
	DeviceVenderService deviceVenderService;
	@Autowired
	ResService resService;
	@Autowired
	PumpWarnService pumpWarnService;
	@Autowired
	DeviceService deviceService;
	@Autowired
	PumpCollectService pumpCollectService;
	@Autowired
	UserAuthService userAuthService;

	@RequiresAuthentication
	@RequestMapping("pump")
	public ModelAndView pump() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "pump");
		return modelAndView;
	}

	@RequiresAuthentication
	@RequestMapping("report")
	public ModelAndView report() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "report");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-info")
	public Map<String, Object> pumpInfo(String pumpId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(pumpId)) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}

		Project project = projectService.getProjectById(pump.getProjectId());
		if (project == null) {
			data.put("message", "无效的项目ID");
			return data;
		}

		ProjectArea projectArea = projectAreaService.getByAreaId(project.getProjectAreaId());
		if (projectArea == null) {
			data.put("message", "无效的项目区域ID");
			return data;
		}

		DeviceProduct deviceProduct = deviceProductService.findById(pump.getProductId());
		if (deviceProduct == null) {
			data.put("message", "无效的产品信息");
			return data;
		}

		DeviceVender deviceVender = deviceVenderService.findById(deviceProduct.getProductVenderId());
		if (deviceVender == null) {
			data.put("message", "无效的供应商信息");
			return data;
		}

		List<MPumpWarnGroup> warnGroups = pumpService.selectPumpWarnGroups(pumpId);
		WeatherData weather = cityWeatherService.findCityWeatherByCode(projectArea.getWeatherCode());
		WeatherAlarm weatherAlarm = cityWeatherService.findWeatherAlarmByCode(projectArea.getWeatherCode());
		List<PumpWarn> pumpWarns = pumpWarnService.getByPumpId(pumpId);
		List<Device> devices = deviceService.getDevicesByPumpId(pumpId);

		data.put("success", true);
		data.put("pump", pump);
		data.put("project", project);
		data.put("projectArea", projectArea);
		data.put("warnGroups", warnGroups);
		data.put("deviceProduct", deviceProduct);
		data.put("deviceVender", deviceVender);
		data.put("weather", weather);
		data.put("weatherAlarm", weatherAlarm);
		data.put("pumpWarns", pumpWarns);
		data.put("devices", devices);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-history-data")
	public Map<String, Object> pumpHistoryData(String pumpId, String date) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);

		if (PublicUtil.isEmpty(pumpId)) {
			data.put("message", "请输入的热泵ID");
			return data;
		}
		if (PublicUtil.isEmpty(date)) {
			date = PublicUtil.getCurrentStrDate();
		}

		Date d = PublicUtil.getStringDate(date);

		if (d == null) {
			data.put("message", "无效的历史查询时间");
			return data;
		}

		List<PumpHistoryData> historyDatas = pumpCollectService.getPumpDayCollectData(pumpId, d);
		List<Object[]> setUpTemps = new ArrayList<>();
		List<Object[]> backWaterTemps = new ArrayList<>();
		List<Object[]> outWaterTemps = new ArrayList<>();
		List<Object[]> environmentTemps = new ArrayList<>();
		List<Object[]> compressorCurrents = new ArrayList<>();
		List<Object[]> waterTankTemps = new ArrayList<>();
		List<Object[]> backAirTemps = new ArrayList<>();
		List<Object[]> outAirTemps = new ArrayList<>();
		List<Object[]> indoorTemps = new ArrayList<>();

		if (historyDatas != null && !historyDatas.isEmpty()) {
			for (PumpHistoryData hd : historyDatas) {
				Date dt = hd.getCollectTime();
				setUpTemps.add(new Object[] { dt, hd.getSetUpTemp() });
				backWaterTemps.add(new Object[] { dt, hd.getBackWaterTemp() });
				outWaterTemps.add(new Object[] { dt, hd.getOutWaterTemp() });
				environmentTemps.add(new Object[] { dt, hd.getEnvironmentTemp() });
				compressorCurrents.add(new Object[] { dt, hd.getCompressorCurrent() });
				waterTankTemps.add(new Object[] { dt, hd.getWaterTankTemp() });
				backAirTemps.add(new Object[] { dt, hd.getBackAirTemp() });
				outAirTemps.add(new Object[] { dt, hd.getOutAirTemp() });
				indoorTemps.add(new Object[] { dt, hd.getIndoorTemp() });
			}
		}

		data.put("success", true);

		data.put("setUpTemps", setUpTemps);
		data.put("backWaterTemps", backWaterTemps);
		data.put("outWaterTemps", outWaterTemps);
		data.put("environmentTemps", environmentTemps);
		data.put("compressorCurrents", compressorCurrents);
		data.put("waterTankTemps", waterTankTemps);
		data.put("backAirTemps", backAirTemps);
		data.put("outAirTemps", outAirTemps);
		data.put("indoorTemps", indoorTemps);

		data.put("minTime", PublicUtil.getTodayMinTime(d));
		data.put("maxTime", PublicUtil.getTodayMaxTime(d));

		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-ele-data")
	public Map<String, Object> pumpEleDayData(String date) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		Short year = new Short(PublicUtil.getCurrentYear());
		Short month = new Short(PublicUtil.getCurrentMonth());
		Short day = new Short(PublicUtil.getCurrentDay());
		if (PublicUtil.isNotEmpty(date)) {
			Date d = PublicUtil.getStringDate(date);
			if (d == null) {
				data.put("message", "无效的查询时间");
				return data;
			}
			year = new Short(PublicUtil.getCurrentYear(d));
			month = new Short(PublicUtil.getCurrentMonth(d));
			day = new Short(PublicUtil.getCurrentDay(d));
		}

		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			data.put("message", "无效的授权信息");
			return data;
		}
		String roleId = role.getRoleId();

		List<String> pumpIds = new ArrayList<>();

		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(roleId)) {
			// 系统管理员
			List<MPumpMonitor> pms = pumpService.selectAllPumpMonitors();
			if (PublicUtil.isNotEmpty(pms)) {
				for (MPumpMonitor pm : pms) {
					pumpIds.add(pm.getPumpId());
				}
			}
		} else {
			List<UserAuth> uas = userAuthService.findUserAll(PublicUtil.sessionUid());
			if (PublicUtil.isNotEmpty(uas)) {
				List<String> pumpCodes = new ArrayList<>();
				for (UserAuth ua : uas) {
					pumpCodes.add(ua.getAuthCode());
				}
				List<MAreaPump> aps = pumpService.selectPumpsByCodes(pumpCodes);
				if (PublicUtil.isNotEmpty(aps)) {
					for (MAreaPump pm : aps) {
						pumpIds.add(pm.getId());
					}
				}
			}
		}

		BigDecimal[] days = new BigDecimal[24];
		for (int i = 0; i < 24; i++) {
			days[i] = new BigDecimal("0.00");
		}
		BigDecimal dt = new BigDecimal("0");
		BigDecimal dh = new BigDecimal("0");
		List<MPumpEleStatistics> eleDays = null;
		if (!pumpIds.isEmpty()) {
			eleDays = pumpCollectService.getPumpEleData(pumpIds, year, month, day);
		}
		if (PublicUtil.isNotEmpty(eleDays)) {
			for (MPumpEleStatistics mpe : eleDays) {
				days[mpe.getIntervalTime()] = mpe.getEleInterval();
				dt = dt.add(mpe.getEleInterval());
			}
		}
		dh = dt.multiply(new BigDecimal("1"));
		data.put("days", days);
		data.put("dayT", dt);
		data.put("dayH", dh);

		BigDecimal mt = new BigDecimal("0");
		BigDecimal mh = new BigDecimal("0");
		int monthDays = PublicUtil.monthLastDay(year, month);
		String[] dayAxis = new String[monthDays];
		for (int i = 0; i < monthDays; i++) {
			dayAxis[i] = (i + 1) + "日";
		}
		data.put("dayAxis", dayAxis);
		BigDecimal[] months = new BigDecimal[monthDays];
		for (int i = 0; i < monthDays; i++) {
			months[i] = new BigDecimal("0.00");
		}
		List<MPumpEleStatistics> eleMonths = null;
		if (!pumpIds.isEmpty()) {
			eleMonths = pumpCollectService.getPumpEleData(pumpIds, year, month, null);
		}
		if (PublicUtil.isNotEmpty(eleMonths)) {
			for (MPumpEleStatistics mpe : eleMonths) {
				months[mpe.getIntervalTime() - 1] = mpe.getEleInterval();
				mt = mt.add(mpe.getEleInterval());
			}
		}
		mh = mt.multiply(new BigDecimal("1"));
		data.put("months", months);
		data.put("monthT", mt);
		data.put("monthH", mh);

		BigDecimal yt = new BigDecimal("0");
		BigDecimal yh = new BigDecimal("0");
		BigDecimal[] years = new BigDecimal[12];
		for (int i = 0; i < 12; i++) {
			years[i] = new BigDecimal("0.00");
		}

		List<MPumpEleStatistics> eleYears = null;
		if (!pumpIds.isEmpty()) {
			eleYears = pumpCollectService.getPumpEleData(pumpIds, year, null, null);
		}

		if (PublicUtil.isNotEmpty(eleYears)) {
			for (MPumpEleStatistics mpe : eleYears) {
				years[mpe.getIntervalTime() - 1] = mpe.getEleInterval();
				yt = yt.add(mpe.getEleInterval());
			}
		}
		yh = yt.multiply(new BigDecimal("1"));
		data.put("years", years);
		data.put("yearT", yt);
		data.put("yearH", yh);

		BigDecimal at = new BigDecimal("0");
		BigDecimal ah = new BigDecimal("0");
		int yearSize = new Integer(PublicUtil.getCurrentYear()) - 2015 + 1;
		String[] yearAxis = new String[yearSize];
		for (int i = 0; i < yearSize; i++) {
			yearAxis[i] = (i + 2015) + "年";
		}
		data.put("yearAxis", yearAxis);
		BigDecimal[] alls = new BigDecimal[yearSize];
		for (int i = 0; i < yearSize; i++) {
			alls[i] = new BigDecimal("0.00");
		}

		List<MPumpEleStatistics> eleAlls = null;
		if (!pumpIds.isEmpty()) {
			eleAlls = pumpCollectService.getPumpEleData(pumpIds, null, null, null);
		}

		if (PublicUtil.isNotEmpty(eleAlls)) {
			for (MPumpEleStatistics mpe : eleAlls) {
				alls[mpe.getIntervalTime() - 2015] = mpe.getEleInterval();
				at = at.add(mpe.getEleInterval());
			}
		}
		ah = at.multiply(new BigDecimal("1"));
		data.put("alls", alls);
		data.put("allT", at);
		data.put("allH", ah);
		data.put("success", true);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-ele-constantly-data")
	public Map<String, Object> pumpEleConstantlyData() {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			data.put("message", "无效的授权信息");
			return data;
		}
		String roleId = role.getRoleId();
		List<String> pumpIds = new ArrayList<>();
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(roleId)) {
			// 系统管理员
			List<MPumpMonitor> pms = pumpService.selectAllPumpMonitors();
			if (PublicUtil.isNotEmpty(pms)) {
				for (MPumpMonitor pm : pms) {
					pumpIds.add(pm.getPumpId());
				}
			}
		} else {
			List<UserAuth> uas = userAuthService.findUserAll(PublicUtil.sessionUid());
			if (PublicUtil.isNotEmpty(uas)) {
				List<String> pumpCodes = new ArrayList<>();
				for (UserAuth ua : uas) {
					pumpCodes.add(ua.getAuthCode());
				}
				List<MAreaPump> aps = pumpService.selectPumpsByCodes(pumpCodes);
				if (PublicUtil.isNotEmpty(aps)) {
					for (MAreaPump pm : aps) {
						pumpIds.add(pm.getId());
					}
				}
			}
		}
		BigDecimal bd = new BigDecimal("0.00");
		List<PumpEleConstantly> eles = null;
		if (!pumpIds.isEmpty()) {
			eles = pumpCollectService.getPumpsEleConstantlyData(pumpIds);
		}
		if (!PublicUtil.isEmpty(eles)) {
			for (PumpEleConstantly ele : eles) {
				bd = bd.add(ele.getElectricity());
			}
		}
		data.put("success", true);
		DecimalFormat myformat = new DecimalFormat("0.00");
		String dat = myformat.format(bd.multiply(new BigDecimal("0.4")));
		data.put("bzm", dat.split("[.]"));
		dat = myformat.format(bd.multiply(new BigDecimal("0.272")));
		data.put("fc", dat.split("[.]"));
		dat = myformat.format(bd.multiply(new BigDecimal("0.997")));
		data.put("co2", dat.split("[.]"));
		dat = myformat.format(bd.multiply(new BigDecimal("0.03")));
		data.put("so2", dat.split("[.]"));
		dat = myformat.format(bd.multiply(new BigDecimal("0.015")));
		data.put("nox", dat.split("[.]"));
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-pictures")
	public Map<String, Object> pumpPictures(String pumpId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(pumpId)) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}
		List<Res> res = resService.findResByGroupId(pump.getGroupId());
		data.put("success", true);
		data.put("data", res);
		return data;
	}

	@RequiresAuthentication
	@RequestMapping("warn-group")
	public ModelAndView warnGroup() {
		ModelAndView modelAndView = new ModelAndView(BASEPATH + "warn-group");
		return modelAndView;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("warn-group-data")
	public Map<String, Object> warnGroupData() {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			data.put("message", "无效的角色");
			return data;
		}
		List<WarnGroup> warnGroups = null;
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(role.getRoleId())) {
			// 是系统管理员
			warnGroups = warnGroupService.getAll();
		} else {
			warnGroups = warnGroupService.getOwnerAll(PublicUtil.sessionUid());
		}
		data.put("success", true);
		data.put("data", warnGroups);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-warn-group-data")
	public Map<String, Object> pumpWarnGroupData(String pumpId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(pumpId)) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		Pump pump = pumpService.getById(pumpId);
		if (pump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}
		data.put("success", true);
		data.put("data", warnGroupService.getPumpNoSelects(pump.getOwnerId(), pumpId));
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("save-collect-device")
	public Map<String, Object> saveCollectDevice(@RequestBody(required = true) Device device) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (device == null) {
			data.put("message", "请传入参数");
			return data;
		}
		if (PublicUtil.isEmpty(device.getPumpId())) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		if (PublicUtil.isEmpty(device.getDeviceName())) {
			data.put("message", "请传入设备名称");
			return data;
		}
		if (PublicUtil.isEmpty(device.getDeviceSn())) {
			data.put("message", "请传入设备SN");
			return data;
		}

		Device _device = deviceService.findBySn(device.getDeviceSn());
		if (_device != null) {
			data.put("message", "当前设备序列号已存在");
			return data;
		}

		Pump pump = pumpService.getById(device.getPumpId());
		if (pump == null) {
			data.put("message", "无效的热泵ID");
			return data;
		}
		if (PublicUtil.isNotEmpty(device.getDeviceProductId())) {
			DeviceProduct deviceProduct = deviceProductService.findById(device.getDeviceProductId());
			if (deviceProduct == null) {
				data.put("message", "无效的产品ID");
				return data;
			}
		}

		device.setDeviceId(PublicUtil.initId());
		device.setCreateTime(new Date());
		device.setCreatorId(PublicUtil.sessionUid());

		try {
			deviceService.save(device);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}

		data.put("success", true);
		data.put("device", device);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-collect-device")
	public Map<String, Object> updateCollectDevice(@RequestBody(required = true) Device device) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (device == null) {
			data.put("message", "请传入参数");
			return data;
		}
		if (PublicUtil.isEmpty(device.getDeviceId())) {
			data.put("message", "请传入设备ID");
			return data;
		}
		if (PublicUtil.isEmpty(device.getDeviceName())) {
			data.put("message", "请传入设备名称");
			return data;
		}
		if (PublicUtil.isEmpty(device.getDeviceSn())) {
			data.put("message", "请传入设备SN");
			return data;
		}

		Device _device = deviceService.findBySn(device.getDeviceSn());
		if (_device != null && !_device.getDeviceId().equals(device.getDeviceId())) {
			data.put("message", "当前设备序列号已存在");
			return data;
		}

		_device = deviceService.findById(device.getDeviceId());
		if (_device == null) {
			data.put("message", "无效的设备ID");
			return data;
		}

		if (PublicUtil.isNotEmpty(device.getDeviceProductId())) {
			DeviceProduct deviceProduct = deviceProductService.findById(device.getDeviceProductId());
			if (deviceProduct == null) {
				data.put("message", "无效的产品ID");
				return data;
			}
			_device.setDeviceProductId(device.getDeviceProductId());
		}

		_device.setDeviceName(device.getDeviceName());
		_device.setDeviceSn(device.getDeviceSn());
		_device.setModifyTime(new Date());

		try {
			deviceService.update(_device);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}

		data.put("success", true);
		data.put("device", _device);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("remove-collect-device")
	public Map<String, Object> deleteCollectDevice(@RequestBody(required = true) Device device) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (device == null) {
			data.put("message", "请传入参数");
			return data;
		}
		if (PublicUtil.isEmpty(device.getDeviceId())) {
			data.put("message", "请传入设备ID");
			return data;
		}

		Device _device = deviceService.findById(device.getDeviceId());
		if (_device == null) {
			data.put("message", "无效的设备ID");
			return data;
		}

		try {
			deviceService.delete(_device.getDeviceId());
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}

		data.put("success", true);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("add-pump-warn-group")
	public Map<String, Object> addPumpWarnGroup(@RequestBody(required = true) MPumpWarnGroupParam groupParam) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (groupParam == null) {
			data.put("message", "请传入参数");
			return data;
		}
		if (PublicUtil.isEmpty(groupParam.getPumpId())) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		if (PublicUtil.isEmpty(groupParam.getGroupId())) {
			data.put("message", "请传入告警组ID");
			return data;
		}

		WarnGroup wg = warnGroupService.getById(groupParam.getGroupId());
		if (wg == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		PumpWarnGroup warnGroup = new PumpWarnGroup();
		warnGroup.setPumpId(groupParam.getPumpId());
		warnGroup.setWarnGroupId(groupParam.getGroupId());
		warnGroup.setCreateTime(new Date());
		try {
			pumpService.addPumpWarnGroup(warnGroup);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍后重试");
			return data;
		}

		MPumpWarnGroup mPumpWarnGroup = new MPumpWarnGroup();
		mPumpWarnGroup.setGroupId(wg.getGroupId());
		mPumpWarnGroup.setGroupName(wg.getGroupName());
		mPumpWarnGroup.setGroupDescript(wg.getGroupDescript());

		data.put("success", true);
		data.put("warnGroup", mPumpWarnGroup);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("remove-pump-warn-group")
	public Map<String, Object> removePumpWarnGroup(@RequestBody(required = true) MPumpWarnGroupParam groupParam) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (groupParam == null) {
			data.put("message", "请传入参数");
			return data;
		}
		if (PublicUtil.isEmpty(groupParam.getPumpId())) {
			data.put("message", "请传入热泵ID");
			return data;
		}
		if (PublicUtil.isEmpty(groupParam.getGroupId())) {
			data.put("message", "请传入告警组ID");
			return data;
		}
		WarnGroup wg = warnGroupService.getById(groupParam.getGroupId());
		if (wg == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		PumpWarnGroupKey groupKey = new PumpWarnGroupKey();
		groupKey.setPumpId(groupParam.getPumpId());
		groupKey.setWarnGroupId(groupParam.getGroupId());
		try {
			pumpService.removePumpWarnGroup(groupKey);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在关联数据");
			return data;
		}
		MPumpWarnGroup mPumpWarnGroup = new MPumpWarnGroup();
		mPumpWarnGroup.setGroupId(wg.getGroupId());
		mPumpWarnGroup.setGroupName(wg.getGroupName());
		mPumpWarnGroup.setGroupDescript(wg.getGroupDescript());

		data.put("success", true);
		data.put("warnGroup", mPumpWarnGroup);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("save-warn-group")
	public Map<String, Object> saveWarnGroup(@RequestBody(required = true) WarnGroup warnGroup) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroup == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupName())) {
			data.put("message", "请输入告警组名称");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupDescript())) {
			data.put("message", "请输入告警组描述");
			return data;
		}
		Role role = PublicUtil.sessionUserRole();
		if (role == null) {
			data.put("message", "无效的角色");
			return data;
		}
		if (PublicUtil.ROLE_SYSTEM_MANAGE_ID.equals(role.getRoleId())) {
			warnGroup.setSystemGroup(Boolean.TRUE);
			warnGroup.setOwnerId(null);
		} else {
			warnGroup.setSystemGroup(Boolean.FALSE);
			warnGroup.setOwnerId(PublicUtil.sessionUid());
		}
		warnGroup.setGroupId(PublicUtil.initId());
		warnGroup.setCreateTime(new Date());
		try {
			warnGroupService.create(warnGroup);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroup", warnGroup);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-warn-group")
	public Map<String, Object> updateWarnGroup(@RequestBody(required = true) WarnGroup warnGroup) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroup == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupName())) {
			data.put("message", "请输入告警组名称");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroup.getGroupDescript())) {
			data.put("message", "请输入告警组描述");
			return data;
		}
		WarnGroup uWarnGroup = warnGroupService.getById(warnGroup.getGroupId());
		if (uWarnGroup == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		uWarnGroup.setGroupName(warnGroup.getGroupName());
		uWarnGroup.setGroupDescript(warnGroup.getGroupDescript());
		try {
			warnGroupService.update(uWarnGroup);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroup", uWarnGroup);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-warn-group")
	public Map<String, Object> deleteWarnGroup(String warnGroupId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(warnGroupId)) {
			data.put("message", "请传入告警组ID");
			return data;
		}
		WarnGroup dWarnGroup = warnGroupService.getById(warnGroupId);
		if (dWarnGroup == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		try {
			warnGroupService.delete(warnGroupId);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在关联数据");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("warn-group-items")
	public Map<String, Object> warnGroupItems(String warnGroupId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(warnGroupId)) {
			data.put("message", "请传入告警组ID");
			return data;
		}
		WarnGroup warnGroup = warnGroupService.getById(warnGroupId);
		if (warnGroup == null) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		data.put("success", true);
		data.put("data", warnGroupService.getWarnGroupItems(warnGroupId));
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("save-warn-group-item")
	public Map<String, Object> saveWarnGroupItem(@RequestBody(required = true) WarnGroupItem warnGroupItem) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupItem == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnGroupId())) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemName())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemCode())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemOperators())) {
			data.put("message", "请选择一个操作符");
			return data;
		}
		if (!PublicUtil.isNumber(warnGroupItem.getItemThreshold())) {
			data.put("message", "无效的阈值");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnCode())) {
			data.put("message", "请输入告警编码");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnLevel())) {
			data.put("message", "请输入告警级别");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnDescript())) {
			data.put("message", "请输入告警描述");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnScheme())) {
			data.put("message", "请输入处理建议");
			return data;
		}

		WarnGroupItem item = warnGroupService.getWarnGroupItemByCode(warnGroupItem.getWarnCode());
		if (item != null) {
			data.put("message", "告警编码已存在");
			return data;
		}

		warnGroupItem.setItemId(PublicUtil.initId());
		warnGroupItem.setCreateTime(new Date());
		try {
			warnGroupService.addItem(warnGroupItem);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroupItem", warnGroupItem);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("delete-warn-group-item")
	public Map<String, Object> deleteWarnGroupItem(String warnGroupItemId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(warnGroupItemId)) {
			data.put("message", "请传入告警项ID");
			return data;
		}
		WarnGroupItem dWarnGroupItem = warnGroupService.getItemById(warnGroupItemId);
		if (dWarnGroupItem == null) {
			data.put("message", "无效的告警项ID");
			return data;
		}
		try {
			warnGroupService.deleteItem(warnGroupItemId);
		} catch (Exception e) {
			data.put("message", "操作失败，可能存在关联数据");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("update-warn-group-item")
	public Map<String, Object> updateWarnGroupItem(@RequestBody(required = true) WarnGroupItem warnGroupItem) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (warnGroupItem == null) {
			data.put("message", "无效的数据");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemId())) {
			data.put("message", "无效的告警项ID");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemName())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemCode())) {
			data.put("message", "请选择告警项");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getItemOperators())) {
			data.put("message", "请选择一个操作符");
			return data;
		}
		if (!PublicUtil.isNumber(warnGroupItem.getItemThreshold())) {
			data.put("message", "无效的阈值");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnCode())) {
			data.put("message", "请输入告警编码");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnLevel())) {
			data.put("message", "请输入告警级别");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnDescript())) {
			data.put("message", "请输入告警描述");
			return data;
		}
		if (PublicUtil.isEmpty(warnGroupItem.getWarnScheme())) {
			data.put("message", "请输入处理建议");
			return data;
		}

		WarnGroupItem item = warnGroupService.getWarnGroupItemByCode(warnGroupItem.getWarnCode());
		if (item != null && !item.getItemId().equals(warnGroupItem.getItemId())) {
			data.put("message", "告警编码已存在");
			return data;
		}
		if (item == null) {
			item = warnGroupService.getItemById(warnGroupItem.getItemId());
		}
		item.setItemCode(warnGroupItem.getItemCode());
		item.setItemName(warnGroupItem.getItemName());
		item.setItemThreshold(warnGroupItem.getItemThreshold());
		item.setItemOperators(warnGroupItem.getItemOperators());
		item.setWarnCode(warnGroupItem.getWarnCode());
		item.setWarnLevel(warnGroupItem.getWarnLevel());
		item.setWarnDescript(warnGroupItem.getWarnDescript());
		item.setWarnScheme(warnGroupItem.getWarnScheme());
		try {
			warnGroupService.updateItem(item);
		} catch (Exception e) {
			data.put("message", "操作失败，请稍候重试");
			return data;
		}
		data.put("success", true);
		data.put("message", "操作成功");
		data.put("warnGroupItem", item);
		return data;
	}

	@ResponseBody
	@RequiresAuthentication
	@RequestMapping("pump-warn-group-detail")
	public Map<String, Object> pumpWarnGroupDetail(String warnGroupId) {
		Map<String, Object> data = new HashMap<>();
		data.put("success", false);
		if (PublicUtil.isEmpty(warnGroupId)) {
			data.put("message", "无效的告警组ID");
			return data;
		}
		data.put("success", true);
		data.put("warnGroupItems", warnGroupService.getWarnGroupItems(warnGroupId));
		return data;
	}

}
