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
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ������ ��ġ�� �� �߰�\n2. ù ��ġ�� �� �߰�\n3. ��ü �� ��� ���\n4. Ư�� �� �˻�\n5. Ư�� �� ����"
					+"\n6. Ư�� �� ���� ����\n7. ��� �������� ����\n8. ������ �������� ����\n9. ����\n\n�޴� ��ȣ ���� : ");
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
			case 9 : System.out.println("���α׷� ����"); return;
			default : System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���."); continue;
			}
		}
	}
	
	public void addList() {
		System.out.println("****** ���ڸ� ��ġ�� �� �߰� ******");
		System.out.println("�� �� : ");
		String title = sc.nextLine(); 
		System.out.println("���� �� : ");
		String singer = sc.nextLine(); 
		
		Music music = new Music(title, singer);
		if (mc.addList(music) == 1) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
	}
	
	public void addAtZero() {
		System.out.println("****** ù ��ġ�� �� �߰� ******");
		System.out.println("�� �� : ");
		String title = sc.nextLine(); 
		System.out.println("���� �� : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title, singer);
		if (mc.addAtZero(music) == 1) {
			System.out.println("�߰� ����");
		} else {
			System.out.println("�߰� ����");
		}
	}
	
	public void printAll() {
		System.out.println("****** ��ü �� ��� ��� ******");
		List<Music> list = mc.printAll();
		for(Music music : list) {
			System.out.println(music);
		}
	}
	
	public void searchMusic() {
		System.out.println("****** Ư�� �� �˻� ******");
	
		System.out.println("�� �� : ");
		String title = sc.nextLine();
		
		if (mc.searchMusic(title) == null) {
			System.out.println("�˻��� ���� �����ϴ�.");
		} else {
			System.out.println(mc.searchMusic(title).toString());
		}
	}
	
	public void removeMusic() {
		System.out.println("****** Ư�� �� ���� ******");
		
		System.out.println("�� �� : ");
		String title = sc.nextLine();
		
		Music music = mc.removeMusic(title);
		if (music != null) {
			System.out.println(music.toString() + "��(��) �����߽��ϴ�.");
		} else {
			System.out.println("������ ���� �����ϴ�.");
		}
	}
	
	public void setMusic() {
		System.out.println("****** Ư�� �� ���� ���� ******");
		
		System.out.println("�˻��� �� �� : ");
		String searchTitle = sc.nextLine();
		System.out.println("������ �� �� : ");
		String title = sc.nextLine();
		System.out.println("������ ���� �� : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title,singer);
		Music musicCopy = mc.setMusic(searchTitle, music);
		if (musicCopy != null) {
			System.out.println(musicCopy.toString() + "�� ���� ���� �Ǿ����ϴ�.");
		} else {
			System.out.println("������ ���� �����ϴ�.");
		}
		
	}
	
	public void ascTitle() {
		System.out.println("****** �� �� �������� ���� ******");
		
		if (mc.ascTitle() == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}
	
	public void descSinger() {
		System.out.println("****** ���� �� �������� ���� ******");
		
		if (mc.descSinger() == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}
}
