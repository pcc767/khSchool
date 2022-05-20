package com.kh.ex03.observer;

public class ChatClient extends Observer{

	private StringBuffer chatMsg = new StringBuffer();
	
	@Override
	public void update(String msg) {
		chatMsg.append(msg+"\n");
		System.out.println(chatMsg);
	}
	
	public void sendMsg(String msg) {
		ObserverManager.getInstance().notifyAll(msg);
	}

}
