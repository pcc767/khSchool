package com.kh.pratice.list.music.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.kh.pratice.list.music.model.vo.Music;

public class MusicController4 {

	List<Music> list = new ArrayList<>();
	
	public MusicController4() {
		list.add(new Music("그래서 그대는", "얀"));
		list.add(new Music("삐삐", "아이유"));
		list.add(new Music("거짓말", "빅뱅"));
		list.add(new Music("신호등", "이무진"));
	}

    public int addList(Music music){
        list.add(music);
        return 1;
    }

    public int addAtZero(Music music){
        list.add(0, music);
        return 1;
    }

    public List<Music> printAll(){
        return list;
    }

    public List<Music> searchMusic(String title){
    	List<Music> templist = new ArrayList<Music>();
    	for(Music music : list) {
    		if(music.getTitle().contains(title)) {
    			templist.add(music);
    		}
    	}
    	return templist;
    }




    public Music removeMusic(String title){
    	
    	for(Music music : list) {
    		if(music.getTitle().equals(title)) {
    			list.remove(music);
    			return music;
    		}
    	}
    	return null;
    }

    public Music setMusic(String title, Music music){    
    	//1. 객체를 통해 수정하는 방법
    	for(Music m : list) {
    		if(m.getTitle().equals(title)) {
    			m.setSinger(music.getSinger());
    			m.setTitle(music.getTitle());
    			return m;
    		}
    	}
    	return null;

    	//2. list를 통해 수정하는 방법
//    	for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getTitle().equals(title)) {				
//				list.set(i, music);
//				return music;
//			}
//		}
//    	return null;
    }

    public int ascTitle(){
        list.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                int result = o1.getTitle().compareTo(o2.getTitle());
                if(result == 0) {
                	o1.getSinger().compareTo(o2.getSinger());
                }
                return result;
            }
        });
        return 1;
    }

    public int descSinger(){
        list.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                int result = o2.getSinger().compareTo(o1.getSinger());
                return result;
            }
        });
        return 1;
    }
	
}
