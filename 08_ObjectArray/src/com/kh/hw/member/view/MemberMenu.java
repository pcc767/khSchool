package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {
	// Responsibility Scope : 객체의 역할과 기능으로써 책임져야 하는 범위
	
	// View의 책임 범위 (Responsibility Scope)
	// - 사용자로부터 (G,C)UI를 제공하고 입력과 이벤트를 Controller에서 전달하고,
	//   처리 결과를 사용자에게 전달하는 역할
	// - View가 할수 있을 일 : UI제공, 사용자의 입력이 올바른지 확인하는 것 ex) ID가 영문인지, PW 자리수..
	// - View가 하면 안되는 일 : ID의 중복확인, ID/PW로 로그인이 가능한지 확인하는 일
	//                        -> Controller와 Model에서 확인해야하는 일
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public MemberMenu() {}

	public void mainMenu() {

		while (true) {
			System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명입니다.");
			System.out.print("1. 새 회원 등록\n2. 회원 검색\n3. 회원 정보 수정\n4. 회원 삭제\n5. 모두 출력\n9. 끝내기\n메뉴 번호 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
				case 1 :
					insertMember();
					break;
				case 2 :
					searchMember();
					break;
				case 3 :
					updateMember();
					break;
				case 4 : 
					deleteMember();
					break;
				case 5 :
					printAll();
					break;
				case 9 :
					System.out.println("프로그램을 종료합니다.");
					return;
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
			}
		}
	}

	public void insertMember() {
		System.out.println("새 회원을 등록합니다.");
		
		String inputId = null;
		while (true) {
			System.out.print("아이디 : ");
			inputId = sc.nextLine();

			if (mc.checkId(inputId) == false) {
				break;
			} else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		}

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		System.out.print("비밀번호 : ");
		String inputPassword = sc.nextLine();

		System.out.print("이메일 : ");
		String inputEmail = sc.nextLine();

		char inputGender;
		
		while (true) {
			System.out.print("성별(M/F) : ");
			inputGender = sc.nextLine().charAt(0);

			if (inputGender == 'm' || inputGender == 'M' || inputGender == 'f' || inputGender == 'F') {
				break;
			} else {
				System.out.println("성별을 다시 입력하세요.");
			}
		}

		System.out.print("나이 : ");
		int inputAge = Integer.parseInt(sc.nextLine());
		mc.insertMember(new Member(inputId, inputName, inputPassword, inputEmail, inputGender, inputAge));
	}

	public void searchMember() {

		System.out.print("1. 아이디로 검색하기\n2. 이름으로 검색하기\n3. 이메일로 검색하기\n9. 메인으로 돌아가기\n메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		switch(menuNum) {
			case 1 :
				searchId();
				break;
			case 2 :
				searchName();
				break;
			case 3:
				searchEmail();
				break;
			case 9 : 
				mainMenu();
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
		}

	}

	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String inputId = sc.nextLine();

		Member member = mc.searchId(inputId);
		
		if (member == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(member.toString());
		}
	}

	public void searchName() {
		System.out.print("검색할 이름 : ");
		String inputName = sc.nextLine();
		Member[] array = mc.searchName(inputName);

		if (array.length == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		} 
		
		System.out.println("찾으신 회원 조회 결과입니다.");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].inform()); 
		}
	}

	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		String inputEmail = sc.nextLine();

		Member[] array = mc.searchEmail(inputEmail);

		if (array.length == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		} 
		
		System.out.println("찾으신 회원 조회 결과입니다.");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].inform()); 
		}
	}

	public void updateMember() {
		System.out.print("1. 비밀번호 수정하기\n2. 이름 수정하기\n3. 이메일 수정하기\n9. 메인으로 돌아가기\n메뉴 선택 : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		if (menuNum == 1) {
			updatePassword();
		} else if (menuNum == 2) {
			updateName();
		} else if (menuNum == 3) {
			updateEmail();
		} else if (menuNum == 9) {
			System.out.println("메인으로 돌아갑니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

	}

	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("수정할 회원의 비밀번호 : ");
		String inputPassword = sc.nextLine();

		if (mc.updatePassword(inputId, inputPassword)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("수정할 회원의 이름 : ");
		String inputName = sc.nextLine();

		if (mc.updateName(inputId, inputName)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("수정할 회원의 이메일 : ");
		String inputEmail = sc.nextLine();

		if (mc.updateEmail(inputId, inputEmail)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public void deleteMember() {

		System.out.print("1. 특정 회원 삭제하기\n2. 모든 회원 삭제하기\n9. 메인으로 돌아가기\n메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		if (menuNum == 1) {
			deleteOne();
		} else if (menuNum == 2) {
			deleteAll();
		} else if (menuNum == 9) {
			System.out.println("메인으로 돌아갑니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

	}

	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		char ch = sc.nextLine().charAt(0);

		if (ch == 'y' || ch == 'Y') {
			if (mc.delete(inputId)) {
				System.out.println("성공적으로 삭제되었습니다.");
			} else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}

	public void deleteAll() {
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		char ch = sc.nextLine().charAt(0);

		if (ch == 'y' || ch == 'Y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}

	public void printAll() {
		if (mc.existMemberNum() == 0) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		} 
		
		Member[] array = mc.printAll();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].inform());
		}
	}
}
