package com.kh.ex03.observer;

public class Run {
	public static void main(String[] args) {
		ChatClient client1 = new ChatClient();
		ChatClient client2 = new ChatClient();
		ChatClient client3 = new ChatClient();
		ChatClient client4 = new ChatClient();
		ChatClient client5 = new ChatClient();
		
		client1.sendMsg("�ȳ��ϼ���");
		client2.sendMsg("��,�ȳ��ϼ���!");
		client3.sendMsg("���� ȫ�浿�Դϴ�.");
		client1.close();
		client2.close();
		client3.close();
		client4.sendMsg("�Ƴ�~");
		client5.sendMsg("����...");
		
		client4.close();
		client5.close();
		
	}

}
