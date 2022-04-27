package com.kh.pratice.map.view;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

import com.kh.pratice.map.controller.MemberController;
import com.kh.pratice.map.model.vo.Member;

public class MemberMenu {
	
	MemberController mc = new MemberController();
    public static Scanner sc = new Scanner(System.in);

    public void mainMenu(){
        while (true) {
            System.out.println("========== KH 사이드 ==========");
            System.out.println("===== 메인 메뉴 =====");
            System.out.println("1. 회원가입.");
            System.out.println("2. 로그인.");
            System.out.println("3. 같은 이름 회원 찾기.");
            System.out.println("9. 종료.");
            System.out.print("메뉴 번호 선택 : ");
            int inputNum = Integer.parseInt(sc.nextLine());

            switch (inputNum) {
                case 1:
                    joinMembership();
                    break;
                case 2:
                    login();
                    memberMenu();
                    break;
                case 3:
                    sameName();
                    break;
                case 9:
                    System.out.println("종료 합니다.");
                    return;
                default:
                    System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    private void memberMenu() {
        System.out.println("===== 회원 메뉴 =====");
        System.out.println("1. 비밀번호 바꾸기.");
        System.out.println("2. 이름 바꾸기.");
        System.out.println("3. 로그아웃.");
        System.out.print("메뉴 번호 선택 : ");
        int inputNum = Integer.parseInt(sc.nextLine());

        switch (inputNum) {
            case 1 :
                changePassword();
                break;
            case 2 :
                changeName();
                break;
            case 3 :
                System.out.println("로그아웃 되었습니다.");
                return;
            default :
                System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
        }


    }

    private void joinMembership() {
        boolean isSuccess = false;
        while (true) {
            System.out.print("1. 아이디 : ");
            String id = sc.nextLine();
            System.out.print("2. 비밀번호 : ");
            String password = sc.nextLine();
            System.out.print("3. 이름 : ");
            String name = sc.nextLine();

            isSuccess = mc.joinMembership(id, new Member(password, name));

            if (!isSuccess) {
                System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
                continue;
            }else {
                System.out.println("성공적으로 회원가입 완료하셨습니다.");
                return;
            }
        }
    }

    private void login() {
        while (true) {
            System.out.print("1. 아이디 : ");
            String id = sc.nextLine();
            System.out.print("2. 비밀번호 : ");
            String password = sc.nextLine();

            String user = mc.login(id, password);

            if (user.equals("")) {
                System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
                continue;
            }else {
                System.out.println(user+"님 환영합니다.");
                return;
            }
        }
    }

    private void sameName() {
        System.out.print("검색할 이름 : ");
        String name = sc.nextLine();
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap = mc.sameName(name);
        for(Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println("[이름] : "+entry.getKey()+", [아이디] : "+entry.getValue());
        }

    }

    private void changeName() {
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String password = sc.nextLine();

            String changeName = mc.login(id, password);
            if (Objects.equals(changeName, "")) {
                System.out.println("이름 변경에 실패하였습니다. 다시 입력해 주세요.");
                continue;
            }
            System.out.println("현재 이름 : "+changeName);

            System.out.print("변경할 이름 : ");
            String newName = sc.nextLine();
            mc.changeName(id, newName);
            System.out.println("이름 변경에 성공하였습니다.");
            return;
        }
    }

    private void changePassword() {
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String oldPw = sc.nextLine();
        System.out.print("변경할 비밀번호 : ");
        String newPw = sc.nextLine();

        boolean changePw = mc.changePassword(id,oldPw,newPw);

        if(!changePw){
            System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해 주세요.");
        }else{
            System.out.println("비밀번호 변경에 성공하였습니다.");
        }
    }

}
