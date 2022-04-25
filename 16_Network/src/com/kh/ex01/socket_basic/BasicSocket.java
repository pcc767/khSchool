package com.kh.ex01.socket_basic;

import java.net.InetAddress;
import java.util.Arrays;

public class BasicSocket {
	public static void main(String[] args) throws Exception {
		// PC�� IP �޾ƿ���
		// InetAddress : IPv4, IPv6�� �ּ������� ������ �ִ� Class
		
//		 InetAddress myIP = new InetAddress(); 
		// The constructor InetAddress() is not visible
		// �����ڸ� private -> Singleton ����
		//  - ����ڰ� ���Ƿ� �����ϴ� ���� ������ ���
		
		InetAddress myIP = InetAddress.getLocalHost();
		System.out.println(myIP.getHostAddress());
		
		byte[] address = myIP.getAddress();
		System.out.println(Arrays.toString(address));
		// [-64, -88, 120, 4]
		
		for(int i = 0; i < address.length; i++) {
			System.out.print(Byte.toUnsignedInt(address[i]));
			if(i < 3) {
				System.out.print(".");
			}else {
				System.out.println();
			}
		}

		String str = "";
		for(int i = 0; i < address.length; i++) {
			str += Byte.toUnsignedInt(address[i]) + ".";
		}
		str = new StringBuffer(new StringBuffer(str).reverse().toString().replaceFirst(".", "\n")).reverse().toString();
		System.out.println(str);
		
		// host name �˾ƿ���
		System.out.println(myIP.getHostName());
		
		// domain name -> IP ��ȯ
		InetAddress naverAddress = InetAddress.getByName("www.naver.com");
		System.out.println(naverAddress.getHostAddress());
		
		// domain name -> IP ��ȯ
		InetAddress googleAddress = InetAddress.getByName("www.google.com");
		System.out.println(googleAddress.getHostAddress());
		
	}
}
