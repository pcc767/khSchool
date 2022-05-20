package com.kh.ex03.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//제일 중요.!
// observer들의 목록을 관리하는 객체로, 구독, 해지, broad casting = 전체 메세지
public class ObserverManager {
	// 싱글톤으로 만들어야한다.
	private ObserverManager() {}
	private static ObserverManager instance = new ObserverManager();
	public static ObserverManager getInstance() {
		return instance;
	}
	
	//synchronizedList 동기화를 해결할수 있는 List로 만들어주는 기능
	// -> 해당 기능이 없으면 프로그램이 죽을수 있다.
	private List<Observer> oblist = Collections.synchronizedList(new ArrayList<>());
	
	// Observer 구독시키기
	public void subscribe(Observer ob) {
		oblist.add(ob);
	}
	
	//구독해지
	public void unsubscribe(Observer ob) {
		oblist.remove(ob);
	}
	
	//구독된 모든 객체에게 메세지를 보내는 방법
	public void notifyAll(String msg) {
		for(Observer ob : oblist) {
			ob.update(msg);
		}
	}

}
