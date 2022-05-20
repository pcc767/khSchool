package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<>();
	
	public MusicController() {
		list.add(new Music("�׷��� �״��", "��"));
		list.add(new Music("�߻�", "������"));
		list.add(new Music("������", "���"));
		list.add(new Music("����� ������", "����"));
		list.add(new Music("��ȣ��", "�̹���"));
		list.add(new Music("�ٹ̴�", "��ȿ��"));
		list.add(new Music("�ٹ̴�", "����Ÿ��"));
		list.add(new Music("�ٹ̴�", "��ȿ��"));
		list.add(new Music("�̵�� ����", "�豤��"));
		list.add(new Music("�ҳ�ô�", "�Ҵ�ô�"));
		list.add(new Music("�ҳ�ô�", "�̽�ö"));
	}

	public int addList(Music music) {
		return list.add(music) == true ? 1:0;
	}

	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}

	public List<Music> printAll() {
		return list;
	}

	public List<Music> searchMusic(String title) {
		List<Music> tempList = new ArrayList<Music>();
		for(Music music : list) {
			if(music.getTitle().contains(title) == true) {
				tempList.add(music);
			}
		}
		return tempList;
	}

	public Music removeMusic(String title) {
		// �� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
		for(Music music : list) {
			if(music.getTitle().equals(title) == true) {
				list.remove(music);
				return music;
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		//�� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
		// 1. ��ü�� ���� �����ϴ� ���
//		for(Music m : list) {
//			if(m.getTitle().equals(title) == true) {
//				m.setTitle(music.getTitle());
//				m.setSinger(music.getSinger());
//				return m;
//			}
//		}
//		return null;
		
		// 2. list�� ���� �����ϴ� ���
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title) == true) {
				list.set(i, music);
				return music;
			}
		}
		return null;
	}

	public int ascTitle() {
		// ����Ʈ �� �� �������� ����, ������ ������ ���� ������ �������� ����, 1 ����
		list.sort(new Comparator<Music>() {
			@Override
			public int compare(Music o1, Music o2) {
				int result = o1.getTitle().compareTo(o2.getTitle());
				if(result == 0) {
					result = o1.getSinger().compareTo(o2.getSinger());
				}
//				if(result == 0) { // ���� 3������ ������..
//					result = o1.getSinger().compareTo(o2.getSinger());
//				}
				return result;
			}
		});
		
		return 1;
	}

	public int descSinger() {
		// ����Ʈ ���� �� �������� ����, 1 ����
		Collections.sort(list);
		return 1;
	}
}
