package com.kh.pratice.list.music.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.kh.pratice.list.music.model.vo.Music;

public class MusicController2 {

	List<Music> list = new ArrayList<>();

    public int addList(Music music){
        list.add(music);
        return 1;
    }

    public int addAtZero(Music music){
        list.add(0, music);
        return 1;
    }

    public List printAll(){
        return list;
    }

    public Optional<Music> searchMusic(String title){
        Optional<Music> optSearch = Optional.empty();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getTitle().contains(title)){
//                return list.get(i);
                optSearch = Optional.of(list.get(i));
            }
        }
        return optSearch;
    }



    public Optional<Music> removeMusic(String title){
        Optional optRemove = Optional.empty();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getTitle().contains(title)){
                optRemove = Optional.of(list.remove(i));
            }
        }
        return optRemove;
    }

    public Optional<Music> setMusic(String title, Music music){
        Optional<Music> optSet = Optional.empty();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getTitle().contains(title)){
                list.get(i).setTitle(music.getTitle());
                list.get(i).setTitle(music.getSinger());

                optSet = Optional.of(list.get(i));
            }
        }
        return optSet;
    }

    public int ascTitle(){
        list.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                int result = o1.getTitle().compareTo(o2.getTitle());
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
