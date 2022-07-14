package com.kh.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		String remoteAddr = sre.getServletRequest().getRemoteAddr();
		System.out.println(remoteAddr + "로 부터 요청이 전송됨!!");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		String remoteAddr = sre.getServletRequest().getRemoteAddr();

		System.out.println(remoteAddr + "로 부터 요청이 소멸됨!!");
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("attributeAdded() : " + srae.getName() + ", " + srae.getValue() + " 추가됨!!");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("attributeRemoved() : " + srae.getName() + ", " + srae.getValue() + " 삭제됨!!");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("attributeReplaced() : " + srae.getName() + ", " + srae.getValue() + " 수정됨!!");
	}

}
