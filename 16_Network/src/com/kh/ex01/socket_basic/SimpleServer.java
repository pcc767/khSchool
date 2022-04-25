package com.kh.ex01.socket_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws Exception {
		// 1. port ���� : int�� ���ڷ� ���ϰ�, ���� ��Ģ�� ���� 1023 �̻� ����
		int port = 9000; // ��ǻ�� ������ ���α׷��� �ּ�
		
		// 2. ServerSocket ��ü �����ϱ�
		//  - OS�κ��� ��Ʈ��ũ ��Ʈ �ڿ��� ��û�� -> Bind ����
		//  - �����ϸ� ��ü ��ȯ, �����ϸ� ���� �߻�
		ServerSocket serverSocket = new ServerSocket(port); // IOException // ��ǥ ��ȣ
		System.out.println("Server ������ �����Ͽ����ϴ�. port : " + port);
		
		// 3. Accept Ŭ���̾�Ʈ�� ��û�� ��ٸ�
		//   -> Accept�� Blocking �Լ��� ��û�� ���������� ����� (��, Time out ����)
		Socket socket = serverSocket.accept(); //  ���ο� port ��ȣ�� ��� -> �������� ����
		
		// 4. Client ��û ���� ����
		System.out.println("���� ����");
		System.out.println("\t Client IP : "+ socket.getInetAddress().getHostAddress());
		System.out.println("\t Client Port : "+ socket.getPort());
		
		// 5. Client ����� �ް� ���� Socket�� ���� ��ŷ��� ����
		boolean result = connectClient(socket);
		System.out.println("��� ��� : " + (result ? "����" : "����"));
		
		// 6. ��� �Ϸ� ���� Socket Close
		socket.close();
		
		// 7. ���� ������ ����
		serverSocket.close();
		System.out.println("������ �����մϴ�.");
	}

	private static boolean connectClient(Socket socket) {
		// ECHO ��� ����
		try (   InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				) {
			String readStr = br.readLine(); // Blocking �Լ� -> ������. Client���� �޼��� ������ ���� ���
			System.out.println("���ŵ� �޼��� : " + readStr);
			// �ؼ���
			bw.append(readStr);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
