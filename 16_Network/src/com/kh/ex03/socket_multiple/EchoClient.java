package com.kh.ex03.socket_multiple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) throws Exception {
		String ip = "127.0.0.1";
		int port = 9000;
		
		Socket socket = new Socket(ip, port);
		System.out.println("Client ���� ������ �����߽��ϴ�.");
		
		boolean result = connectServer(socket);
		System.out.println("��� ��� : " + (result ? "����" : "����"));

		socket.close();
		System.out.println("Client ������ �����Ͽ����ϴ�.");
	}
	
	private static boolean connectServer(Socket socket) {
		System.out.println("���� ����!\n\tServer IP : "  
							+socket.getInetAddress().getHostAddress());
		System.out.println("\tPort ��ȣ : " + socket.getPort() );
		
		// ECHO ��� ����
		try (   InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				Scanner sc = new  Scanner(System.in);
				) {
			
			while(true) {
				System.out.println("������ �޼����� �Է��ϼ���.");
				String readText = sc.nextLine();
				System.out.println("read : " + readText);
				bw.append(readText);
				bw.newLine();
				bw.flush();
				String recvMessage = br.readLine();
				System.out.println("���� �޼��� : " + recvMessage);
				
				if(readText.toUpperCase().contains("EXIT")  == true||
					readText.toUpperCase().contains("CLOSE") == true ){
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
