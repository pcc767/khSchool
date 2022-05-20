package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList<>();
	
	public MusicController() {
		list.add(new Music("그래서 그대는", "얀"));
		list.add(new Music("삐삐", "아이유"));
		list.add(new Music("거짓말", "빅뱅"));
		list.add(new Music("행운을 빌어줘", "원필"));
		list.add(new Music("신호등", "이무진"));
		list.add(new Music("텐미닛", "이효리"));
		list.add(new Music("텐미닛", "원슈타인"));
		list.add(new Music("텐미닛", "리효리"));
		list.add(new Music("이등병의 편지", "김광석"));
		list.add(new Music("소녀시대", "소대시대"));
		list.add(new Music("소녀시대", "이승철"));
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
		// 곡 명으로 객체 검색, 객체가 있으면 객체 정보 삭제, 없으면 null 리턴
		for(Music music : list) {
			if(music.getTitle().equals(title) == true) {
				list.remove(music);
				return music;
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		//곡 명으로 객체 검색, 객체가 있으면 객체 정보 수정, 없으면 null 리턴
		// 1. 객체를 통해 수정하는 방법
//		for(Music m : list) {
//			if(m.getTitle().equals(title) == true) {
//				m.setTitle(music.getTitle());
//				m.setSinger(music.getSinger());
//				return m;
//			}
//		}
//		return null;
		
		// 2. list를 통해 수정하는 방법
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title) == true) {
				list.set(i, music);
				return music;
			}
		}
		return null;
	}

	public int ascTitle() {
		// 리스트 곡 명 오름차순 정렬, 제목이 같으면 가수 명으로 오름차순 정렬, 1 리턴
		list.sort(new Comparator<Music>() {
			@Override
			public int compare(Music o1, Music o2) {
				int result = o1.getTitle().compareTo(o2.getTitle());
				if(result == 0) {
					result = o1.getSinger().compareTo(o2.getSinger());
				}
//				if(result == 0) { // 만일 3순위가 있을때..
//					result = o1.getSinger().compareTo(o2.getSinger());
//				}
				return result;
			}
		});
		
		return 1;
	}

	public int descSinger() {
		// 리스트 가수 명 내림차순 정렬, 1 리턴
		Collections.sort(list);
		return 1;
	}
}
