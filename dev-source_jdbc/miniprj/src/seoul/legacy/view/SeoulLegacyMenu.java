package seoul.legacy.view;

import java.util.List;

import seoul.legacy.common.Utility;
import seoul.legacy.controller.FacilityController;
import seoul.legacy.controller.LegacyController;
import seoul.legacy.controller.PalaceController;
import seoul.legacy.controller.ReviewController;
import seoul.legacy.controller.UserController;
import seoul.legacy.controller.ZzimController;
import seoul.legacy.model.vo.Facility;
import seoul.legacy.model.vo.Legacy;
import seoul.legacy.model.vo.Palace;
import seoul.legacy.model.vo.Review;
import seoul.legacy.model.vo.User;
import seoul.legacy.model.vo.Zzim;

public class SeoulLegacyMenu {

	private LegacyController lc = new LegacyController();
	private PalaceController pc = new PalaceController();
	private FacilityController fc = new FacilityController();
	private UserController uc = new UserController();
	private ReviewController rc = new ReviewController();
	private ZzimController zc = new ZzimController();

	private Legacy legacy = null; // 상세 검색 후 해당 legacy 객체 넣어주세요
	private boolean isLogin = false;

	private String wrongInput = "잘못 입력하셨습니다. 다시 입력해주세요. → ";

	public void mainMenu() {
		while (true) {

			String standardMenu = "\n---=== 서울시 문화재 탐방 ===---\n" + "\n1. 문화재 검색" + "\n2. 궁궐 검색" + "\n3. 서울시 문화재 Top-10";
			String logInMenu = "\n4. 개인정보" + "\n8. 로그아웃";
			String logOutMenu = "\n6. 회원가입\n7. 로그인";
			String exitMenu = "\n9. 종료" + "\n입력 : ";
			StringBuffer sb = new StringBuffer();

			sb.append(standardMenu);
			if (isLogin == true) {
				sb.append(logInMenu);
			} else {
				sb.append(logOutMenu);
			}
			sb.append(exitMenu);

			System.out.print(sb.toString());
			int menuNum = Utility.scannerInt();
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
			case 6: // 회원가입
				inputMember();
				break;
			case 7:
				login();
				break;// 로그인
			case 8:
				UserController.logOut();
				isLogin = false;
				break;// 로그아웃
			case 9:
				System.out.println("\n안녕히 가세요!");
				System.exit(0);// 종료
			default:
				System.out.println(wrongInput);
				break;
			}
		}
	}
	
	/**
	 * 1. searchLegacy - 문화재 검색
	 * 	1-1. searchName
	 * 	1-2. typeSearch
	 * 	 1-2-1. searchCategory
	 * 	 1-2-2. searchArea
	 * 	 1-2-3. searchEra
	 */
	
	public void searchLegacy() { // 문화재 검색 메뉴
		while (true) {
			String menu = "\n<<< 문화재 검색 >>>\n" + "\n1. 이름 검색" + "\n2. 간편 검색" + "\n3. 뒤로 가기" + "\n입력 : ";
			System.out.print(menu);
			int menuNum = Utility.scannerInt();

			switch (menuNum) {
			case 1:
				searchName();
				break;// 이름 검색 탭
			case 2:
				typeSearch();
				break;// 간편 검색 (종목, 시대, 지역)
			case 3:
				return; // 뒤로 가기
			default:
				System.out.println(wrongInput);
				break;
			}
		}
	}
	
	public void searchName() { // 이름 검색
		while (true) {
			System.out.println("\n<<< 이름 검색 >>>");
			System.out.print("이름 입력 : ");
			String name = Utility.scannerString();

			List<Legacy> list = lc.selectByLegacyName(name);
			if (list.size() < 1) {
				System.out.println("조회된 자료가 없습니다.\n");
				continue;
			}

			legacySearch(list, name);
			break;
		}
	}
	
	public void typeSearch() {
		while (true) {
				String menu = "\n<<< 간편 검색 >>>\n" + "\n1. 종목 검색" + "\n2. 지역 검색" + "\n3. 시대 검색" + "\n4. 뒤로가기"
						+ "\n입력 : ";
				System.out.print(menu);

				int menuNum = Utility.scannerInt();

				switch (menuNum) {
				case 1:
					searchCategory();
					break;// 종목 검색
				case 2:
					searchArea();
					break;// 지역 검색
				case 3:
					searchEra();
					break;// 시대 검색
				case 4:
					return;
				default:
					System.out.println(wrongInput);
					break;
				}
		}
	}
	
	public void searchCategory() {
		System.out.println("\n<<< 종목 검색 >>>");

		String[] categoryCode = { "국보", "보물", "사적", "사적 및 명승", "명승", "천연기념물", "국가무형문화재", "국가민속문화재", "시도유형문화재",
				"시도무형문화재", "시도기념물", "시도민속문화재", "시도등록문화재", "문화재자료", "국가등록문화재", "이북5도 무형문화재" };
		System.out.println("---------------------------------------------------------------");
		for (int i = 0; i < categoryCode.length; i++) {
			System.out.print((i + 1) + " - " + categoryCode[i]);
			if (i % 2 == 0) {
				if (i > 5) {
					System.out.print("\t\t");
					continue;
				}
				System.out.print("\t\t\t");
			} else {
				System.out.print("\n");
			}
		}
		System.out.println("---------------------------------------------------------------");
		while (true) {
			System.out.print("종목 번호를 입력해 주세요 : ");
			int num = Utility.scannerInt();
			if (num > categoryCode.length || num < 1) {
				System.out.println(wrongInput);
				continue;
			}

			String codeNo = categoryCode[num - 1];

			List<Legacy> lList = lc.searchByCategory(codeNo);

			if (lList.size() < 1) {
				System.out.println("조회 결과가 존재하지 않습니다.");
				continue;
			}

			legacySearch(lList, codeNo);
			break;
		}
	}

	public void searchArea() {
		while (true) {
			System.out.println("\n<<< 지역 검색 >>>");
			System.out.print("지역을 입력해 주세요(광진구, 관악 등) : ");
			String area = Utility.scannerString();

			List<Legacy> temp = lc.selectByLegacyArea(area);

			if (temp.size() < 1) {
				System.out.println("조회 결과가 존재하지 않습니다.");
				continue;
			}

			legacySearch(temp, area);
			break;
		}
	}

	public void searchEra() { // 이것도 카테고리 처럼 하는게 어떤지?
		
		System.out.println("\n<<< 시대 검색 >>>");
		String[] era = { "고구려", "백제", "신라", "고려", "조선" };

		while (true) {

			System.out.print("시대를 입력해 주세요 ");
			System.out.println("1. 고구려, 2. 백제, 3. 신라, 4. 고려, 5. 조선");
			System.out.print("번호 입력 : ");

			int eraCode = Utility.scannerInt() - 1;
			if (eraCode >= era.length || eraCode < 0) {
				System.out.println("범위를 벗어났습니다.\n");
				continue;
			}

			List<Legacy> lList = lc.searchByEra(era[eraCode]);

			if (lList.size() < 1) {
				System.out.println("조회 결과가 존재하지 않습니다.\n");
				continue;
			}

			legacySearch(lList, era[eraCode]);
			break;
		}
	}
	
	/**
	 * 2. palaceList - 궁궐 검색
	 */

	public void palaceList() {
		System.out.println("\n<<< 궁궐 >>>\n");
		List<Palace> pList = pc.printAll();
		for (int i = 0; i < pList.size(); i++) {
			System.out.println((i + 1) + " ▷ " + pList.get(i).toString());
			System.out.println();
		}
		int menuNum = 0;
		while (true) {
			System.out.print("보고 싶은 궁궐 선택 ▷ ");
			menuNum = Utility.scannerInt() - 1;
			if (menuNum < pList.size() && menuNum > -1) {
				break;
			}
			System.out.println(wrongInput);
		}
		Palace palace = pList.get(menuNum);

		int pNo = palace.getPalaceNo();

		List<Facility> fList = fc.searchByPNo(pNo);

		for (int i = 0; i < fList.size(); i++) {
			System.out.println((i + 1) + " - " + fList.get(i).toString());
		}
		System.out.println();
		System.out.print("번호를 선택하세요 ▷ ");
		int chooseNum = 0;
		while (true) {
			chooseNum = Utility.scannerInt() - 1;
			if (chooseNum < fList.size() && chooseNum > -1) {
				break;
			}
			System.out.print(wrongInput);
		}
		System.out.println(fList.get(chooseNum).detailToString());
	}
	
	/**
	 * 3. topTen - 서울시 문화재 Top-10
	 */
	
	public void topTen() {
		System.out.println("<<< TOP - 10 >>>");
		List<Legacy> temp = lc.topTen();

		for (int i = 0; i < temp.size(); i++) {
			System.out.println((i + 1) + " : " + temp.get(i));
			System.out.println();
		}
		int menuNum = 0;
		while (true) {
			System.out.print("상세 조회 → ");
			menuNum = Utility.scannerInt() - 1;
			if (menuNum < temp.size() && menuNum > -1) {
				break;
			}
			System.out.println(wrongInput);
		}
		System.out.println(lc.printDetail(temp.get(menuNum).getLegacy_no()));

		legacy = temp.get(menuNum);

		if (isLogin == true) {
			addCommunity();
		}
	}
	
	/**
	 * 4. userData - 개인정보
	 */
	
	public void userData() { // 유저 정보
		while (true) {
			String userMenu = "\n<<< " + UserController.getLoginUser().getUserName()
					+ " >>>\n1. 개인 정보\n2. 찜 목록\n3. 리뷰 목록\n4. 뒤로 가기\n→ ";
			System.out.print(userMenu);
			int menuNum = Utility.scannerInt();

			switch (menuNum) {
			case 1:
				System.out.println(UserController.getLoginUser().toString());
				break;
			case 2:
				userZzim();
				break;
			case 3:
				userReview();
				break;
			case 4:
				return;
			default:
				System.out.println(wrongInput);
				break;
			}

		}
	}
	
	/**
	 * 5. inputMember - 회원가입.
	 */

	public void inputMember() {
		while (true) {
			System.out.println("\n<<< 회원 가입 >>>");
			System.out.print("ID : ");
			String id = Utility.scannerString();
			if (uc.checkId(id) == false) {
				System.out.println("중복된 아이디 입니다.\n다시 입력해 주세요.");
				continue;
			}
			System.out.print("Password : ");
			String pw = Utility.scannerString();
			System.out.print("Name : ");
			String name = Utility.scannerString();
			System.out.print("Email : ");
			String email = Utility.scannerString();
			System.out.print("Phone : ");
			String phone = Utility.scannerString();

			boolean isJoin = uc.addUser(new User(id, pw, name, email, phone));
			if (isJoin) {
				System.out.println("회원 가입에 성공 하셨습니다.");
				break;
			} else {
				System.out.println("회원 가입에 실패 하셨습니다.");
			}
		}
	}
	
	/**
	 * 6. login - 회원가입.
	 */

	public void login() {
		while (true) {
			System.out.println("\n<<< 로그인 >>>");
			System.out.print("ID : ");
			String id = Utility.scannerString();
			System.out.print("Password : ");
			String pw = Utility.scannerString();
			isLogin = uc.login(id, pw);
			if (isLogin == true) {
				System.out.println(UserController.getLoginUser().getUserName() + " 님 환영합니다.");
				break;
			} else {
				System.out.print("등록되지 않은 회원입니다.\n다시 입력하시곘습니까?(Y/N) : ");
				String yn = Utility.scannerString();

				if (yn.toUpperCase().equals("Y")) {// ??????? 머선 129
					continue;
				} else {
					break;
				}
			}
		}
	}

	

	public void userZzim() { // 유저 정보 - 찜 목록
		while (true) {
			List<Zzim> zList = zc.searchPrivZzim(UserController.getLoginUser().getUserId());

			if (zList.size() < 1) {
				System.out.println("조회된 결과가 없습니다.");
				break;
			}
			System.out.println();
			for (int i = 0; i < zList.size(); i++) {
				System.out.println((i + 1) + " ▷ " + zList.get(i).toString());
			}
			System.out.println();
			System.out.print("번호 선택 → ");
			int index = Utility.scannerInt() - 1;

			if (index < 0 || index >= zList.size()) {
				System.out.println(wrongInput);
				continue;
			}

			System.out.println(lc.printDetail(zList.get(index).getLegacyNo()));
			System.out.println();
			System.out.print("토막 후기를 추가 하시겠습니까? (Y/N) → ");
			String yN = Utility.scannerString();
			if (yN.toUpperCase().equals("Y")) {
				legacy = lc.searchByNo(index);
				addReview();
				legacy = null;
			}
			break;
		}
	}

	public void userReview() { // 유저정보 - 리뷰 목록
		while (true) {
			List<Review> rList = rc.privReviewList(UserController.getLoginUser().getUserId());
			if (rList.size() < 1) {
				System.out.println("조회된 결과가 없습니다.\n");
				break;
			}
			for (int i = 0; i < rList.size(); i++) {
				System.out.println((i + 1) + " ▷ " + rList.get(i).idToString());
			}

			System.out.print("번호 선택 → ");
			int index = Utility.scannerInt() - 1;
			if (index < 0 || index >= rList.size()) {
				System.out.println(wrongInput);
				continue;
			}
			int lNo = rList.get(index).getLegacyNo();

			System.out.println(lc.printDetail(lNo));

			System.out.print("찜을 추가 하시겠습니까? (Y/N) → ");
			String yN = Utility.scannerString();

			if (yN.toUpperCase().equals("Y")) {
				boolean result = zc.addZzim(UserController.getLoginUser().getUserId(), lNo);
				if (result == true) {
					System.out.println("찜 추가에 성공하였습니다.\n");
					System.out.println(lc.printDetail(lNo));
				} else {
					System.out.println("찜은 중복해서 추가할 수 없습니다.\n");
				}
			} else {
				break;
			}
		}
	}

	


	private void legacySearch(List<Legacy> list, String keyword) {

		System.out.println("\n[ " + keyword + " 검색 결과 ]\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " - " + list.get(i).toString() + "\n");
		}
		System.out.println("[ " + keyword + " 검색완료 ] 자료 수 : " + list.size() + " 개\n");

		while (true) {
			System.out.print("상세 정보 보기(뒤로가기 : 0) ▷ ");
			int chooseNum = Utility.scannerInt() - 1;
			if (chooseNum == -1) {
				return;
			}
			if (chooseNum >= list.size()) {
				System.out.println("범위를 벗어났습니다.\n");
				continue;
			}

			legacy = list.get(chooseNum);
			System.out.println(legacy.getLegacy_no() + " " + legacy.getLegacy_name_kor());
			System.out.println("\n" + lc.printDetail(legacy.getLegacy_no()) + "\n");

			if (isLogin == true) {
				addCommunity();
				break;
			} else {
				return;
			}
		}
	}

	public void addCommunity() {
		String menu = "<<< "+ legacy.getLegacy_name_kor() +" 커뮤니티 메뉴 >>>" + "\n1. 토막 후기 보기\n2. 찜 추가\n3. 토막 후기 작성\n4. 뒤로가기\n→ ";
		while (true) {
			System.out.print(menu);
			int menuNum = Utility.scannerInt();
			switch (menuNum) {
			case 1:
				List<Review> lList = rc.legacyReviewList(legacy.getLegacy_no());
				if (lList.size() < 1) {
					System.out.println("\n토막 후기가 없어요! 입력해 주세요!\n");
				}
				for (Review r : lList) {
					System.out.println("\n"+r.legacyToString() + "\n");
				}
				break;
			case 2:
				boolean addZzim = zc.addZzim(UserController.getLoginUser().getUserId(), legacy.getLegacy_no());
				if (addZzim) {
					System.out.println(legacy.getLegacy_name_kor() + "에 찜을 추가하셨습니다.\n");
				} else {
					System.out.println("찜은 중복 추가 하실 수 없습니다.\n");
				}
				break;
			case 3:
				addReview();
				break;
			case 4:
				legacy = null;
				return; // 처음으로 돌아감
			default:
				System.out.println(wrongInput);
				break;
			}

		}

	}

	public void addReview() {
		
		System.out.print("<<< 리뷰 작성 >>>\n→ ");

		String reviewContent = Utility.scannerString();

		rc.addReview(new Review(reviewContent, UserController.getLoginUser().getUserId(), legacy.getLegacy_no()));

	}

	

	

	// 메인 메뉴 1. 문화재 검색 2. 궁궐 검색 3. Top-10 4. 개인정보(로그인 시) 5. 로그인 6. 로그아웃. 9. 종료
	// --------------------------------------------------------------------------------
	// 문화재 검색 1. 이름 검색 2. 간편 검색 3. 뒤로가기

	// 이름 검색 이름 입력 : 입력받은 이름으로 List출력 List 중 택 1하여 상세 정보

	// 간편 검색 1. 종목 검색 2. 지역 검색 3. 시대 검색 4. 뒤로 가기

	// 종목 검색 종목 입력 : 입력받은 종목으로 List 출력 List 중 택 1 하여 상세 정보

	// 지역 검색 지역 입력 : 입력받은 지역으로 List 출력 List 중 택 1 하여 상세 정보

	// 시대 검색 시대 입력 : 입력받은 시대로 List 출력 List 중 택 1 하여 상세 정보

	// 상세 정보 1. 찜 추가 2. 리뷰 3. 돌아가기

	// 리뷰 1. 리뷰 보기 2. 리뷰 작성 3. 돌아가기
	// --------------------------------------------------------------------------------
	// 궁궐 검색 궁궐 List 출력 후 궁궐 선택하여 시설 List 출력하고 List 중 택 1하여 상세 정보
	// --------------------------------------------------------------------------------
	// Top-10 찜 횟수 1~10 위 List 출력하고 List 중 택 1하여 상세 정보 출력하고 문화재와 동일하게 후기, 찜 등 추가 메소드
	// 실행
	// --------------------------------------------------------------------------------
	// 개인정보(로그인시) 1. 개인 정보 조회 2. 찜 목록 3. 리뷰 목록 4. 돌아가기 (리뷰, 찜 삭제 기능 추가?)

	// 개인 정보 조회 로그인된 User Data를 User.toString으로 조회

	// 찜 목록 로그인된 User Data로 찜목록 조회 하고 List 중 택 1하여 상세 정보 출력

	// 리뷰 목록 로그인된 User Data로 리뷰 목록 조회 하고 List 중 택 1하여 상세 정보 출력
	// --------------------------------------------------------------------------------
	// 로그인 ID, PW 입력받아 User Data 입력
	// --------------------------------------------------------------------------------
	// 로그아웃 User Data = null;
	// --------------------------------------------------------------------------------
	// 종료 System.exit(0);
	public static void main(String[] args) {
		new SeoulLegacyMenu().mainMenu();
	}
}
