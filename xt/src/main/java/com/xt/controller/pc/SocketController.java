package com.xt.controller.pc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xt.util.CollectDataUtil;

@Controller
@RequestMapping("socket")
public class SocketController {

	@ResponseBody
	@RequestMapping("all-data")
	public Map<String, Object> allData() {
		Map<String, Object> data = new HashMap<>();
		System.out.println(CollectDataUtil.getPool());
		for (String key : CollectDataUtil.getPool().keySet()) {
			System.out.println(CollectDataUtil.getPool().get(key));
		}
		for (String key : CollectDataUtil.getPoolA().keySet()) {
			data.put(key, CollectDataUtil.getPoolA().get(key).getInetAddress().getHostName());
		}
		data.put("size", CollectDataUtil.size());
		data.put("Asize", CollectDataUtil.sizeA());
		return data;
	}

	@ResponseBody
	@RequestMapping("send-data")
	public Map<String, Object> sendData(String key, String dat) {
		Map<String, Object> data = new HashMap<>();
		for (String k : CollectDataUtil.getPool().keySet()) {
			if (k.trim().equalsIgnoreCase(key)) {
				Socket socket = CollectDataUtil.getPool().get(k);
				OutputStream os = null;
				PrintWriter pw = null;
				try {
					os = socket.getOutputStream();
					pw = new PrintWriter(os);
					pw.write(String2Byte(dat));
					pw.flush();
				} catch (IOException e) {
					e.printStackTrace();
					data.put("message", e.getMessage());
					return data;
				} finally {
				}
			}
		}
		data.put("size", CollectDataUtil.size());
		return data;
	}

	private String String2Byte(String str) {
		String s = "";
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				s += " ";
			}
			s += str.charAt(i);
		}
		return s;
	}

}
