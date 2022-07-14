package com.kh.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.kh.util.AES256Cipher;
import com.kh.util.EncryptUtil;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		
		if(name.equals("password")) {
			value = EncryptUtil.oneWayEnc(value);
		} else if(name.equals("day")) {
			try {
				value = AES256Cipher.AES_Encode(value);
			} catch (Exception e) {}
		}
		
		return value;
	}
}
