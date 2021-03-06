package com.kh.pratice.set.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import com.kh.pratice.set.model.vo.Lottery;

public class LotteryController {
	
	private HashSet<Lottery> lottery = new HashSet<>();
    private HashSet<Lottery> win = new HashSet<>();
    
    
    public LotteryController() {
		lottery.add(new Lottery("홍길동","010-2222-3333"));
		lottery.add(new Lottery("최길동","010-3333-3333"));
		lottery.add(new Lottery("유길동","010-4444-3333"));
		lottery.add(new Lottery("박길동","010-5555-3333"));
		lottery.add(new Lottery("김길동","010-6666-3333"));
		lottery.add(new Lottery("정길동","010-7777-3333"));
	}
    

    public boolean insertObject(Lottery l){
        return lottery.add(l);
    }

    public boolean deleteObject(Lottery l){    	
        boolean isRemove = lottery.remove(l);
        if(isRemove && !win.isEmpty()){
            win.remove(l);
        }
        return isRemove;
    }

    public HashSet<Lottery> winObject(){
      
        
        if(lottery.size() < 4) {
        	return null;
        }
        ArrayList<Lottery> list = new ArrayList<>(lottery);
        Random r = new Random();
        
        while(true) {
        	if(win.size() >= 4) {
        		break;
        	}
        	win.add(list.get(r.nextInt(list.size())));        	
        }
        return win;
    }

    public TreeSet<Lottery> sortedWinObject(){
    	TreeSet<Lottery> set = new TreeSet<Lottery>(new Comparator<Lottery>() {

			@Override
			public int compare(Lottery o1, Lottery o2) {
				int result = o1.getName().compareTo(o2.getName());		//오름차순
                if(result == 0){
                    result = o1.getPhone().compareTo(o2.getPhone());
                }
                return result;
			}
		});
    	
    	winObject();
    	set.addAll(win);
    	return set;
    	
    }
    

    public Boolean searchWinner(Lottery l){
        return win.contains(l);
    }

}
