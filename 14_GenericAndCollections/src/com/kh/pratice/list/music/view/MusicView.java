package com.kh.pratice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.pratice.list.music.controller.MusicController4;
import com.kh.pratice.list.music.model.vo.Music;

public class MusicView {
	
	public static Scanner sc = new Scanner(System.in);
    MusicController4 mc = new MusicController4();

    public void mainMenu(){
        while(true) {
            System.out.println("===== ���� �޴� =====");
            System.out.println("1. ������ ��ġ�� �� �߰�");
            System.out.println("2. ù ��ġ�� �� �߰�");
            System.out.println("3. ��ü �� ��� ���");
            System.out.println("4. Ư�� �� �˻�");
            System.out.println("5. Ư�� �� ����");
            System.out.println("6. Ư�� �� ���� ����");
            System.out.println("7. ��� �������� ����");
            System.out.println("8. ������ �������� ����");
            System.out.println("9. ����");
            System.out.print("�޴� ��ȣ ���� : ");
            int inputNum = Integer.parseInt(sc.nextLine());

            switch (inputNum) {
                case 1:
                    addList();
                    break;
                case 2:
                    addAtZero();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    searchMusic();
                    break;
                case 5:
                    removeMusic();
                    break;
                case 6:
                    setMusic();
                    break;
                case 7:
                    ascTitle();
                    break;
                case 8:
                    descSinger();
                    break;
                case 9:
                    System.out.println("�����մϴ�.");
                    return;
                default:
                    System.out.println("�� �� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���");
            }
        }
    }

    public void addList() {
        System.out.println("***** ������ ��ġ�� �� �߰� *****");
        System.out.print("�� �� : ");
        String title = sc.nextLine();
        System.out.print("���� �� : ");
        String singer = sc.nextLine();
        int addSuc = mc.addList(new Music(title, singer));
        if(addSuc==1){
            System.out.println("�߰� ����");
        }else {
            System.out.println("�߰� ����");
        }

    }

    public void addAtZero() {
        System.out.println("***** ù ��ġ�� �� �߰� *****");
        System.out.print("�� �� : ");
        String title = sc.nextLine();
        System.out.print("���� �� : ");
        String singer = sc.nextLine();
        int addSuc = mc.addAtZero(new Music(title, singer));
        if(addSuc==1){
            System.out.println("�߰� ����");
        }else {
            System.out.println("�߰� ����");
        }
    }

    public void printAll() {
        System.out.println("***** ��ü �� ��� ��� *****");
        List<Music> list = mc.printAll();
        if(list.isEmpty()) {
            System.out.println("����ֽ��ϴ�.");
            return;
        }
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public void searchMusic() {
        System.out.println("***** Ư�� �� �˻� *****");
        System.out.print("�� �� : ");
        String title = sc.nextLine();

        List<Music> music = mc.searchMusic(title);
        if(music.isEmpty()){
            System.out.println("�˻��� ���� �����ϴ�.");
        }else{
            System.out.println("�˻��� ����"+" "+music+"�Դϴ�.");
        }
    }

    public void removeMusic() {
        System.out.println("***** Ư�� �� �˻� *****");
        System.out.print("�� �� : ");
        String title = sc.nextLine();

       List<Music> music = mc.searchMusic(title);
        if(music.isEmpty()){
            System.out.println("������ ���� �����ϴ�.");
        }else {
            System.out.println(title+" "+music+"�� �����Ͽ����ϴ�.");
        }
    }

    public void setMusic() {
        System.out.println("***** Ư�� �� ���� ���� *****");
        System.out.print("������ �� : ");
        String setTitle = sc.nextLine();
        System.out.print("�� �� : ");
        String title = sc.nextLine();
        System.out.print("���� �� : ");
        String singer = sc.nextLine();

        Music music = mc.setMusic(setTitle, new Music(title,singer));
        if(music==null){
            System.out.println("������ ���� �����ϴ�.");
        }else {
            System.out.println(music+"�� �����Ͽ����ϴ�.");
        }
    }

    public void ascTitle() {
        int asc = mc.ascTitle();
        if(asc==1){
            System.out.println("���� ����");
        }else {
            System.out.println("���� ����");
        }
    }

    public void descSinger() {
        int des = mc.descSinger();
        if(des==1){
            System.out.println("���� ����");
        }else {
            System.out.println("���� ����");
        }

    }

}
