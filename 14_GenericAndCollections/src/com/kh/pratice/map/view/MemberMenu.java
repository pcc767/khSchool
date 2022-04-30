package com.kh.pratice.map.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


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
		while (true) {
			System.out.println("===== 회원 메뉴 =====");
			System.out.println("1. 비밀번호 바꾸기.");
			System.out.println("2. 이름 바꾸기.");
			System.out.println("3. 로그아웃.");
			System.out.print("메뉴 번호 선택 : ");
			int inputNum = Integer.parseInt(sc.nextLine());

			switch (inputNum) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				System.out.println("로그아웃 되었습니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다. 다시 입력해주세요.");
			}	
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

            isSuccess = mc.joinMembership(id, new Member(password, id,name));

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

            if (user == null) {
                System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
                continue;
            }
            
            System.out.println(user+"님 환영합니다.");
            return;
            
        }
    }

    public void sameName() {
		System.out.print("이름 : ");
		String name = sc.nextLine();

//		Set<Entry<String, Member>> tempSet = mc.sameName(name).entrySet();		
//		for (Entry<String, Member> entry : tempSet) {
//			System.out.println("같은 이름 : "+ entry.getValue()+" 입니다.");
//		}
		
		Iterator<Entry<String,Member>> iterator = mc.sameName(name).entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Member> entry = iterator.next();
			System.out.println("같은 이름 : "+ entry.getValue()+" 입니다.");
		}
		
		
	}
    
    
    private void changeName() {
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String password = sc.nextLine();

            String changeName = mc.login(id, password);
            if(changeName == null) {
            	System.out.println("이름 변경에 실패하였습니다. 다시 입력해 주세요.");
            	continue;
            }
            System.out.print("현재 이름 : "+changeName+"입니다.\n");

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
