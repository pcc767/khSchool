package com.kh.pratice.set.view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.kh.pratice.set.controller.LotteryController;
import com.kh.pratice.set.model.vo.Lottery;

public class LotteryMenu {
	
	
	LotteryController lc = new LotteryController();
    public static Scanner sc = new Scanner(System.in);

    public void mainMenu(){
        while (true) {
            System.out.println("========== KH 추첨 프로그램 ==========");
            System.out.println("***** 메인 메뉴 *****");
            System.out.println("1. 추첨 대상 추가");
            System.out.println("2. 추첨 대상 삭제");
            System.out.println("3. 당첨 대상 확인");
            System.out.println("4. 정렬된 당첨 대상 확인");
            System.out.println("5. 당첨 대상 검색");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 선택 : ");
            int inputNum = Integer.parseInt(sc.nextLine());

            switch (inputNum) {
                case 1:
                    insertObject();
                    break;
                case 2:
                    deleteObject();
                    break;
                case 3:
                    winObject();
                    break;
                case 4:
                    sortedWinObject();
                    break;
                case 5:
                    searchWinner();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘 못 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }

    public void insertObject() {
        System.out.println("추가할 추첨 대상 수 : ");
        int addNum = Integer.parseInt(sc.nextLine());
        for(int i=0; i<addNum; i++){
            System.out.println("이름 : ");
            String name = sc.nextLine();
            System.out.println("핸드폰 번호('-'제외) : ");
            String phone = sc.nextLine();

            boolean addUser = lc.insertObject(new Lottery(name, phone));
            if(!addUser){
                System.out.println("중복된 대상입니다. 다시 입력하세요.");
            }
        }
        System.out.println(addNum+"명 추가 완료 되었습니다.");
    }

    public void deleteObject() {
        System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
        System.out.println("이름 : ");
        String name = sc.nextLine();
        System.out.println("핸드폰 번호('-'제외) : ");
        String phone = sc.nextLine();

        boolean delUser = lc.deleteObject(new Lottery(name, phone));
        if(delUser){
            System.out.println("삭제 완료 되었습니다.");
        }
        if(!delUser){
            System.out.println("존재하지 않는 대상입니다.");
        }
    }

    public void winObject() {
        HashSet<Lottery> win = lc.winObject();
        Iterator<Lottery> iterator = win.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public void sortedWinObject() {
        TreeSet<Lottery> sort = lc.sortedWinObject();
        Iterator<Lottery> iterator = sort.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void searchWinner() {
        System.out.println("검색할 대상의 이름과 핸드폼 번호를 입력하세요");
        System.out.println("이름 : ");
        String name = sc.nextLine();
        System.out.println("핸드폰 번호('-'제외) : ");
        String phone = sc.nextLine();

        boolean winner = lc.searchWinner(new Lottery(name, phone));
        if (!winner){
            System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
        } else {
            System.out.println("축하합니다. 당첨 목록에 존재합니다.");
        }

    }

}
