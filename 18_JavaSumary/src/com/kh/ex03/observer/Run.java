package com.kh.ex03.observer;

public class Run {
	public static void main(String[] args) {
		ChatClient client1 = new ChatClient();
		ChatClient client2 = new ChatClient();
		ChatClient client3 = new ChatClient();
		ChatClient client4 = new ChatClient();
		ChatClient client5 = new ChatClient();
		
		client1.sendMsg("안녕하세요");
		client2.sendMsg("네,안녕하세요!");
		client3.sendMsg("저는 홍길동입니다.");
		client1.close();
		client2.close();
		client3.close();
		client4.sendMsg("아넹~");
		client5.sendMsg("ㅅㄱ...");
		
		client4.close();
		client5.close();
		
	}

}
