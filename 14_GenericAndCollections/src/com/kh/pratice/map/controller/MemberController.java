package com.kh.pratice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.kh.pratice.map.model.vo.Member;

public class MemberController {
	// alt + shifr+ r ���� ��ü
	HashMap<String, Member> idToMemberMap = new HashMap<>();
	
	public MemberController() {
		
		idToMemberMap.put("test1", new Member("test1_1","1234","ȫ�浿"));
		idToMemberMap.put("test2", new Member("test2_1","1234","��浿"));
		idToMemberMap.put("test3", new Member("test3_1","1234","�ڱ浿"));
		idToMemberMap.put("test4", new Member("test4_1","1234","�ֱ浿"));
		idToMemberMap.put("test5", new Member("test5_1","1234","��浿"));
	}
	
	

    public boolean joinMembership(String id, Member m){

    	if(idToMemberMap.containsKey(id)) {
    		return false;
    	}
    	
    	idToMemberMap.put(id, m);
    	return true;

    }

    public String login(String id, String password){    	
    	if(!idToMemberMap.containsKey(id)) {
    		return null;
    	}
    	Member member = idToMemberMap.get(id);
    	if(!member.getPassword().equals(password)) {
    		return null;
    	}
    	
    	return member.getName();
    }

    public boolean changePassword(String id, String oldPw, String newPw){
    	if(!idToMemberMap.containsKey(id)) {
    		return false;
    	}
    	
    	Member member = idToMemberMap.get(id);
    	
    	if(!member.getPassword().equals(oldPw)) {
    		return false;
    	}
    	
    	member.setPassword(newPw);
    	return true;
 
    }

    public void changeName(String id, String newName){
    	if(!idToMemberMap.containsKey(id)) {
    		return;
    	}
    	Member member = idToMemberMap.get(id);
    	
    	member.setName(newName);
    	
    }

    public TreeMap<String, Member> sameName(String name){

		TreeMap<String, Member> map = new TreeMap<String, Member>();

		Iterator<String> iter = idToMemberMap.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Member member = idToMemberMap.get(key);
			if (member.getName().equals(name)) {
				map.put(key, member);
			}
		}
		return map;
    
//        while(iterator.hasNext()) {
//        	String key = iterator.next();
//        	Member member = idToMemberMap.get(key);
//        	if(member.getName().equals(name)) {
//        		treeMap.put(key, member);
//        	}
//        }
//
//        return treeMap;

    }

}
