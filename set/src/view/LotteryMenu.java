package view;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import controller.LotteryController;
import model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		System.out.println("========== KH 추첨 프로그램 ==========");
		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 전체 출력\n2. 추첨 대상 추가\n3. 추첨 대상 삭제\n4. 당첨 대상 확인\n5. 정렬된 당첨 대상 확인\n6. 당첨 대상 검색\n9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {
			case 1 :
				printAll();
				break;
			case 2:
				insertObject();
				break;
			case 3:
				deleteObject();
				break;
			case 4:
				winObject();
				break;
			case 5:
				sortedWinObject();
				break;
			case 6:
				searchWinner();
				break;
			case 9:
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				break;
			}
			System.out.println();
		}
	}

	public void printAll() {
		lc.printAll();
	}

	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int inputNum = Integer.parseInt(sc.nextLine());
		int count = 0; // 실제 들어간 대상 수
		while (inputNum > 0) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("핸드폰 번호('-'빼고) : ");
			String phone = sc.nextLine();
			Lottery l = new Lottery(name, phone);
			System.out.println();			
			boolean yn = lc.insertObject(l);
			if (yn == true) {
				count++;
			} else {
				System.out.println("중복된 대상입니다. 다시 입력하세요.");
				continue;
			}
			inputNum--;
		}
		System.out.println(count + "명 추가 완료되었습니다.");
	}

	public void deleteObject() {
		System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		Lottery l = new Lottery(name, phone);
		boolean yn = lc.deleteObject(l);
		if (yn == true) {
			System.out.println("삭제 완료되었습니다.");
		} else {
			System.out.println("존재하지 않는 대상입니다.");
		}
	}

	public void winObject() {
		HashSet<Lottery> winners = lc.winObject();
		for(Lottery lottery : winners)
			System.out.println(lottery);
	}

	public void sortedWinObject() {
		TreeSet<Lottery> treeWinners = lc.sortedWinObject();
		Iterator<Lottery> iter = treeWinners.iterator();
		while (iter.hasNext()) {
			Lottery lot = iter.next();
			System.out.println(lot); //??? 왜 출력이 안되지?
		}
	}

	public void searchWinner() {
		System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		Lottery l = new Lottery(name, phone);
		boolean yn = lc.searchWinner(l);
		if (yn == true) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		} else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		}
	}
}
