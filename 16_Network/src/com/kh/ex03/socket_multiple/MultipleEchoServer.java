package com.kh.ex03.socket_multiple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultipleEchoServer {
	
	public static ServerSocket serverSocket = null;
	public static int clientCount = 0;
	
	public static void main(String[] args) throws Exception {
		int port = 9000; 

		serverSocket = new ServerSocket(port); 
		System.out.println("Server ������ �����Ͽ����ϴ�. port : " + port);

		while(true) {
			System.out.println("Client ���� ���");
			Socket socket = serverSocket.accept(); //  ���ο� port ��ȣ�� ���
			// Thread
			new ConnectThread(socket, clientCount++).start();;
		}
	}
	
	public static void exit() {
		try {
			serverSocket.close();
			System.exit(0); // ���α׷� ���̴� ��ɾ�
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("������ �����մϴ�.");
	}
	
	public static class ConnectThread extends Thread{
		private Socket socket;
		private int clientID;
		
		public ConnectThread(Socket socket, int clientID) {
			super();
			this.socket = socket;
			this.clientID = clientID;
		}
		
		@Override
		public void run() {
			System.out.println("���� ����");
			System.out.println("\tClient IP : "+ socket.getInetAddress().getHostAddress());
			System.out.println("\tClient Port : "+ socket.getPort());
			System.out.println("\tClientID : "+ clientID);

			int result = connectClient(socket);
			System.out.println("��� ��� : " + (result != 0 ? "����" : "����"));

			System.out.println("Client ������ �����մϴ�.");
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(result == 2) {
				exit();
			}
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
}
