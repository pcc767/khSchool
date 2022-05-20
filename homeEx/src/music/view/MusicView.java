package com.kh.practice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가\n2. 첫 위치에 곡 추가\n3. 전체 곡 목록 출력\n4. 특정 곡 검색\n5. 특정 곡 삭제"
					+"\n6. 특정 곡 정보 수정\n7. 곡명 오름차순 정렬\n8. 가수명 내림차순 정렬\n9. 종료\n\n메뉴 번호 선택 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1 : addList(); continue;
			case 2 : addAtZero(); continue;
			case 3 : printAll(); continue;
			case 4 : searchMusic(); continue;
			case 5 : removeMusic(); continue;
			case 6 : setMusic(); continue;
			case 7 : ascTitle(); continue;
			case 8 : descSinger(); continue;
			case 9 : System.out.println("프로그램 종료"); return;
			default : System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요."); continue;
			}
		}
	}
	
	public void addList() {
		System.out.println("****** 마자막 위치에 곡 추가 ******");
		System.out.println("곡 명 : ");
		String title = sc.nextLine(); 
		System.out.println("가수 명 : ");
		String singer = sc.nextLine(); 
		
		Music music = new Music(title, singer);
		if (mc.addList(music) == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.println("곡 명 : ");
		String title = sc.nextLine(); 
		System.out.println("가수 명 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title, singer);
		if (mc.addAtZero(music) == 1) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		List<Music> list = mc.printAll();
		for(Music music : list) {
			System.out.println(music);
		}
	}
	
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
	
		System.out.println("곡 명 : ");
		String title = sc.nextLine();
		
		if (mc.searchMusic(title) == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println(mc.searchMusic(title).toString());
		}
	}
	
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		
		System.out.println("곡 명 : ");
		String title = sc.nextLine();
		
		Music music = mc.removeMusic(title);
		if (music != null) {
			System.out.println(music.toString() + "을(를) 삭제했습니다.");
		} else {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	
	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		
		System.out.println("검색할 곡 명 : ");
		String searchTitle = sc.nextLine();
		System.out.println("수정할 곡 명 : ");
		String title = sc.nextLine();
		System.out.println("수정할 가수 명 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title,singer);
		Music musicCopy = mc.setMusic(searchTitle, music);
		if (musicCopy != null) {
			System.out.println(musicCopy.toString() + "가 값이 변경 되었습니다.");
		} else {
			System.out.println("수정할 곡이 없습니다.");
		}
		
	}
	
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		
		if (mc.ascTitle() == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
	
	public void descSinger() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
		
		if (mc.descSinger() == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
}
