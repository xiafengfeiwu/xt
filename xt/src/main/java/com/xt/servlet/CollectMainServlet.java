package com.xt.servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("collectMainServlet")
public class CollectMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(CollectMainServlet.class);

	public CollectMainServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		int port = Integer.valueOf(config.getInitParameter("port"));
		logger.info("Listener Port：" + port);
		try {
			logger.info("Try Start Server");
			startService(port);
			logger.info("Start Server Success");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Start Server Error");
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	void startService(int port) {
		new Thread(new Runnable() {
			@SuppressWarnings("resource")
			@Override
			public void run() {
				logger.info("Open A Thread");
				ServerSocket serverSocket = null;
				try {
					logger.info("Try To Listener " + port);
					serverSocket = new ServerSocket(port);
					logger.info("Create Listener Success");
				} catch (IOException e1) {
					e1.printStackTrace();
					logger.error("Create Listener Error");
				}
				Socket socket = null;
				while (true) {
					logger.info("InTo Loop");
					if (serverSocket == null) {
						logger.info("Service Close");
						return;
					}
					try {
						logger.info("Wait Collect");
						socket = serverSocket.accept(); // 主线程获取客户端连接
						logger.info("Create Connect");
						new Thread(new HandlerLongLink(socket)).start(); // 创建线程并启动线程
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private String Byte2String(byte[] ba, int l) {
		String s = "";
		for (int i = 0; i < l; ++i) {
			s += String.format("%02x", ba[i]);
		}
		return s;
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

	class HandlerLongLink implements Runnable {
		private Socket socket;

		public HandlerLongLink(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			OutputStream os = null;
			BufferedInputStream bis = null;
			PrintWriter pw = null;
			try {
				logger.info("New Connect:  " + socket.getInetAddress() + ":" + socket.getPort());
				byte[] readBuf = new byte[4096];
				socket.setSoTimeout(60 * 1000 * 30);

				bis = new BufferedInputStream(socket.getInputStream());
				os = socket.getOutputStream();
				pw = new PrintWriter(os);

				while (true) {
					int length = -1;
					logger.info("Wait read");
					length = bis.read(readBuf);
					if (length < 0) {
						logger.info("Connect Disconnect");
						break;
					}
					logger.info("Read Data");
					String readString = Byte2String(readBuf, length);
					logger.info(String2Byte(readString));

					// pw.write(String2Byte(readString));
					// pw.flush();

					logger.info("Server Write Data");
					Thread.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("Connect Exception");
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (bis != null) {
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (pw != null) {
					pw.close();
				}
			}
		}
	}

	class HandlerOneLink implements Runnable {
		private Socket socket;

		public HandlerOneLink(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			OutputStream os = null;
			BufferedInputStream bis = null;
			PrintWriter pw = null;
			try {
				logger.info("New Connent: " + socket.getInetAddress() + ":" + socket.getPort());
				byte[] readBuf = new byte[4096];
				socket.setSoTimeout(60 * 1000 * 5);
				bis = new BufferedInputStream(socket.getInputStream());
				os = socket.getOutputStream();
				pw = new PrintWriter(os);
				int length = -1;
				try {
					length = bis.read(readBuf);
					if (length < 0) {
						logger.info("No Data, Connent Disconnect");
						return;
					}
				} catch (SocketTimeoutException e2) {
					logger.info("Read Error; Connect Disconnect");
					return;
				}
				String readString = Byte2String(readBuf, length);
				pw.write(String2Byte(readString));
				pw.flush();
				pw.close();
				logger.info("Server Write Data");
				logger.info("Sleeping...");
				Thread.sleep(1000);
			} catch (Exception e) {
				logger.info("Connect Exception");
			} finally {
				try {
					if (os != null)
						os.close();
					if (bis != null)
						bis.close();
					if (socket != null)
						socket.close();
				} catch (IOException e) {
					logger.info("Connect Close Exception");
				}
			}
		}
	}

}
