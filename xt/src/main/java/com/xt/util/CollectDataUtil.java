package com.xt.util;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CollectDataUtil {
	private final static Map<String, Socket> sockets;
	private final static Map<String, Socket> allSockets;

	static {
		sockets = new HashMap<>();
		allSockets = new HashMap<>();
	}

	public static Socket get(String key) {
		return sockets.get(key);
	}

	public static Socket del(String key) {
		return sockets.remove(key);
	}

	public static Socket set(String key, Socket socket) {
		return sockets.put(key, socket);
	}

	public static int size() {
		return sockets.size();
	}

	public static Map<String, Socket> getPool() {
		return sockets;
	}

	public static Socket getA(String key) {
		return allSockets.get(key);
	}

	public static Socket delA(String key) {
		return allSockets.remove(key);
	}

	public static Socket setA(String key, Socket socket) {
		return allSockets.put(key, socket);
	}

	public static int sizeA() {
		return allSockets.size();
	}

	public static Map<String, Socket> getPoolA() {
		return allSockets;
	}
}
