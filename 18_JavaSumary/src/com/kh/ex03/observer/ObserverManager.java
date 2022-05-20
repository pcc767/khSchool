package com.kh.ex03.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//���� �߿�.!
// observer���� ����� �����ϴ� ��ü��, ����, ����, broad casting = ��ü �޼���
public class ObserverManager {
	// �̱������� �������Ѵ�.
	private ObserverManager() {}
	private static ObserverManager instance = new ObserverManager();
	public static ObserverManager getInstance() {
		return instance;
	}
	
	//synchronizedList ����ȭ�� �ذ��Ҽ� �ִ� List�� ������ִ� ���
	// -> �ش� ����� ������ ���α׷��� ������ �ִ�.
	private List<Observer> oblist = Collections.synchronizedList(new ArrayList<>());
	
	// Observer ������Ű��
	public void subscribe(Observer ob) {
		oblist.add(ob);
	}
	
	//��������
	public void unsubscribe(Observer ob) {
		oblist.remove(ob);
	}
	
	//������ ��� ��ü���� �޼����� ������ ���
	public void notifyAll(String msg) {
		for(Observer ob : oblist) {
			ob.update(msg);
		}
	}

}
