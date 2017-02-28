package com.xt.servlet;

import java.net.InetSocketAddress;
import java.util.Collection;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class MinaHandler extends IoHandlerAdapter {

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		super.exceptionCaught(session, cause);
		System.out.println("exceptionCaught" + session.getId());
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		super.inputClosed(session);
		System.out.println("inputClosed" + session.getId());
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		super.messageReceived(session, message);
		System.out.println("messageReceived" + session.getId());
		System.out.println("received message: " + message.toString());
		IoBuffer bbuf = (IoBuffer) message;
		byte[] byten = new byte[bbuf.limit()];
		bbuf.get(byten, bbuf.position(), bbuf.limit());

		StringBuffer content = new StringBuffer("");
		int length = byten.length;
		for (int i = 0; i < length; ++i) {
			content.append(String.format("%02x", byten[i]));
		}

		session.setAttribute("sn", content.toString());

		System.out.println("received message: " + content.toString());

		IoBuffer buffer = IoBuffer.allocate(10);
		buffer.put(content.toString().getBytes());
		buffer.flip();

		if (!content.toString().equalsIgnoreCase("CC")) {
			session.write(buffer);
		}

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
		System.out.println("messageSent" + session.getId());
		System.out.println("sent message: " + message.toString());
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
		System.out.println("sessionClosed" + session.getId());
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
		System.out.println("sessionCreated" + session.getId());
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		super.sessionIdle(session, status);
		System.out.println("sessionIdle" + session.getId());
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		super.sessionOpened(session);
		System.out.println("sessionOpened:" + session.getId());
		Collection<IoSession> sessions = session.getService().getManagedSessions().values();
		for (IoSession s : sessions) {
			InetSocketAddress addr = (InetSocketAddress) s.getRemoteAddress();
			String clientIP = addr.getAddress().getHostAddress();
			int clientPort = addr.getPort();
			System.out.println(clientIP + ":" + clientPort + " >>>> " + s.getAttribute("sn"));
		}
	}

}
