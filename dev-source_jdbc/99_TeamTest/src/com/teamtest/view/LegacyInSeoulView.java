package com.teamtest.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.teamtest.controller.LegacyController;
import com.teamtest.model.vo.Legacy;

public class LegacyInSeoulView {

	// review, zzim, palace, facility, user, legacy controller 호출
//		private UserController uc = new UserController();
		private LegacyController lc = new LegacyController();

		private static Scanner sc = new Scanner(System.in);
		private String wrongInput = "잘 못 입력하셨습니다. 다시 입력해 주세요.";

		public void mainMenu() {
			while (true) {

				String standardMenu = "\n---=== 서울시 문화재 탐방 ===---\n" + "\n1. 문화재 검색" + "\n2. 궁궐 검색" + "\n3. 서울시 문화재 Top-10";
				String logInMenu = "\n4. 개인정보" + "\n8. 로그아웃";
				String logOutMenu = "\n7. 로그인";
				String exitMenu = "\n9. 종료" + "\n입력 : ";
				StringBuffer sb = new StringBuffer();

				sb.append(standardMenu);
				if (uc.getLoginUser() == null) {
					sb.append(logOutMenu);
				} else {
					sb.append(logInMenu);
				}
				sb.append(exitMenu);

				System.out.print(sb.toString());
				int menuNum = Integer.parseInt(sc.nextLine());

				switch (menuNum) {
				case 1:
					searchLegacy();
					break;// 문화재 검색 첫단
				case 2:
					palaceList();
					break;// 궁궐 검색 첫단
				case 3:
					topTen();
					break;// Top-10
				case 4:
					userData();
					break;// 개인 정보 조회
				case 7:
					login();
					break;// 로그인
				case 8: // uc.logout();break;// 로그아웃
				case 9:
					System.out.println("\n안녕히 가세요!");
					System.exit(0);// 종료
				default:
					System.out.println(wrongInput);
					break;
				}
			}
		}

		public void login() {

		}

		public void userData() {

		}

		public void searchLegacy() {
			while (true) {
				String menu = "\n<<< 문화재 검색 >>>\n" + "\n1. 이름 검색" + "\n2. 간편 검색" + "\n3. 뒤로 가기" + "\n입력 : ";
				System.out.print(menu);
				int menuNum = Integer.parseInt(sc.nextLine());

				switch (menuNum) {
				case 1:
					searchLegacyByName();
					return;// 이름 검색 탭
				case 2:
					typeSearch();
					return;// 간편 검색 (종목, 시대, 지역)
				case 3:
					return; // 뒤로 가기
				default:
					System.out.println(wrongInput);
					break;
				}
			}
		}

		public void searchLegacyByName() {
			System.out.println("<<< 이름 검색 >>>");
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();

			List<Legacy> list = lc.selectByLegacyName(name);
			for(Legacy legacy : list)
				System.out.println(legacy.toString());

//			String menu = "\n<<< 이름 검색 >>>\n" + "\n이름 입력 : ";
//			String name = sc.nextLine();
////			List<String> result = null; // legacyController method searchByName() 아마 list<legacy>로 반환
//			// list 출력 메소드 in legacycontroller
//			List<Legacy> result = lc.selectByLegacyName(name);
//			// 메소드 짜주세요
//			for (int i = 0; i < result.size(); i++) {
//				System.out.println(i + " : " + result.get(i));
//			}
			int menuNum = Integer.parseInt(sc.nextLine());
			String str = result.get(menuNum); // Legacy temp = result.get(menuNum);
			// System.out.println(lc.detailPrint(temp));
//				lc.printDetail((result.get(menuNum).getLegacyNo));

			if (uc.getLoginUser() != null) {
				while (true) {
					String menu = "1. 찜\n2. 토막 후기\n3. 처음으로\n입력 : ";
					System.out.println(menu);
					menuNum = Integer.parseInt(sc.nextLine());
					switch (menuNum) {
					case 1:
//					zc.insertZzim(); zzimcontroller insert 메소드
						return;
					case 2:
						int getLegacyNo = 0;
						insertReview(getLegacyNo); // 실제로 temp.getLegacyNo
						return;
					case 3:
						return;
					default:
						System.out.println(wrongInput);
						break;
					}
				}
			}
		}

		public void typeSearch() {
			while (true) {
				String menu = "\n<<< 간편 검색 >>>\n" + "\n1. 종목 검색" + "\n2. 지역 검색" + "\n3. 시대 검색" + "\n4. 뒤로가기\n입력 : ";
				System.out.println(menu);

				int menuNum = Integer.parseInt(sc.nextLine());

				switch (menuNum) {
				case 1:
					searchByCategory();
					return;// 종목 검색
				case 2:
					searchByArea();
					return;// 지역 검색
				case 3:
					searchByEra();
					return;// 시대 검색
				case 4:
					return;
				default:
					System.out.println(wrongInput);
					break;
				}
			}
		}

		public void searchByCategory() {
			System.out.println("종목을 입력해 주세요");
			System.out.println("1 : 국보, 2 : 보물, 3 : 사적, 4 : 사적및명승, 5 : 명승, 6 : 천연기념물, 7 : 국가무형문화재, 8 : 국가민속문화재,\n" +
					" 9 : 시도유형문화재, 10 : 시도무형문화재, 11 : 시도기념물, 12 : 시도민속문화재, 13 : 시도등록문화재, 14 : 문화재자료,\n" +
					" 15 : 국가등록문화재, 16 : 이북5도 무형문화재");
			System.out.print("번호 입력 : ");
			String category = sc.nextLine();

			List<Legacy> temp = lc.selectByCategoryName(category);
//			temp = lc.selectByCategoryName(category);
//			for (int i = 0; i < temp.size(); i++) {
//				System.out.println(i + " : " + temp); // temp.get(i)
//			}
			for(Legacy legacy : temp){
				System.out.println(legacy.toString());
			}

			int menuNum = Integer.parseInt(sc.nextLine());
//			lc.detailPrint(temp.get(menuNum));

		}

		public void searchByEra() {
			System.out.print("시대를 입력해 주세요");
			System.out.println("1. 고구려, 2. 백제, 3. 신라, 4. 고려, 6. 조선");
			System.out.print("번호 입력 : ");
			String era = sc.nextLine();

			 List<Legacy> temp = lc.selectByEra(era);
//			List<String> temp = new ArrayList<>();
//			for (int i = 0; i < temp.size(); i++) {
//				System.out.println(i + " : " + temp); // temp.get(i)
//			}
			for(Legacy legacy : temp){
				System.out.println(legacy.toString());
			}

			int menuNum = Integer.parseInt(sc.nextLine());
//			lc.detailPrint(temp.get(menuNum));
		}

		public void searchByArea() {
			System.out.println("지역을 입력해 주세요(서울시에 한함.(관악구, 동작구 등등)");
			System.out.print("지역 입력 : ");
			String area = sc.nextLine();

			List<Legacy> temp = lc.selectByArea(area);
//			List<String> temp = new ArrayList<>();
//			for (int i = 0; i < temp.size(); i++) {
//				System.out.println(i + " : " + temp); // temp.get(i)
//			}
			for(Legacy legacy : temp){
				System.out.println(legacy.toString());
			}

			int menuNum = Integer.parseInt(sc.nextLine());
//			lc.detailPrint(temp.get(menuNum));
		}

		public void topTen() {
//			List<Legacy> temp = lc.topTen();
			List<String> temp = new ArrayList<>();
			for (int i = 0; i < temp.size(); i++) {
				System.out.println(i + " : " + temp.get(i));
			}
			int menuNum = Integer.parseInt(sc.nextLine());

			// lc.detailPrint(temp.get(menuNum));

		}

		public void insertReview(int lNo) {
			System.out.print("토막 후기를 입력해 주세요!\n→ ");
			String content = sc.nextLine();
			String userId = uc.getLoginUser().getUserId();
			Review review = new Review(content, userId, lNo);

			// rc.insertReview(review);

		}

		public void palaceList() {
			// palace controller 메소드 짜주세여...
			System.out.println("return type : List<Palace> or HashMap<Integer, Palace> 모두 리턴하는 메소드 짜주세여");
			// List<Legacy> temp = pc.searchAll;
			List<String> temp = new ArrayList<>();
			String menu = "<<< 궁궐 >>>" + "번호 선택 : ";
			int menuNum = Integer.parseInt(sc.nextLine());
			// List<Legacy> temp2 = fc.searchByPNo(menuNum);
			List<String> temp2 = new ArrayList<String>();
			for (int i = 0; i < temp2.size(); i++) {
				System.out.println(i + " : " + temp2.get(i));
			}
			menuNum = Integer.parseInt(sc.nextLine());

//			fc.detailPrint(temp2.get(menuNum)); 시설 디테일 출력 매소드
		}

		public static void main(String[] args) {
			LegacyInSeoulView lisv = new LegacyInSeoulView();

			lisv.mainMenu();
		}

}
