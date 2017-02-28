package com.xt.servlet;

import java.net.InetSocketAddress;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {

	public static void start(int port) throws Exception {
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 60 * 2);
		acceptor.setHandler(new MinaHandler());
		acceptor.bind(new InetSocketAddress(port));
	}

	public static void main(String[] args) {
		try {
			MinaServer.start(21010);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
