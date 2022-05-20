package com.kh.ex03.observer;

public abstract class Observer implements Cloneable {

	public Observer() {
		ObserverManager manager = ObserverManager.getInstance();
		manager.subscribe(this);
	}
	
	abstract public void update(String msg);
	
	public void close() {
		ObserverManager manager = ObserverManager.getInstance();
		manager.unsubscribe(this);
	}

}
