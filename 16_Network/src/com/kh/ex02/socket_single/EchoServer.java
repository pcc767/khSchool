package com.kh.ex02.socket_single;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws Exception {
		int port = 9000; 
		
		ServerSocket serverSocket = new ServerSocket(port); 
		System.out.println("Server ������ �����Ͽ����ϴ�. port : " + port);
		
		while(true) {
			System.out.println("Client ���� ���");
			Socket socket = serverSocket.accept(); //  ���ο� port ��ȣ�� ���
			
			System.out.println("���� ����");
			System.out.println("\t Client IP : "+ socket.getInetAddress().getHostAddress());
			System.out.println("\t Client Port : "+ socket.getPort());
			
			int result = connectClient(socket);
			System.out.println("��� ��� : " + (result != 0 ? "����" : "����"));
			if(result == 2) {
				break;
			}
			
			System.out.println("Client ������ �����մϴ�.");
			socket.close();
		}
		
		serverSocket.close();
		System.out.println("������ �����մϴ�.");
	}

	private static int connectClient(Socket socket) {
		try (   InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				) {
			while(true) {
				String readStr = br.readLine();
				System.out.println("���ŵ� �޼��� : " + readStr);
				bw.append(readStr);
				bw.newLine();
				bw.flush();
				
				if(readStr.toUpperCase().contains("EXIT") == true) {
					return 1;
				} else if(readStr.toUpperCase().contains("CLOSE") == true) {
					return 2;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
