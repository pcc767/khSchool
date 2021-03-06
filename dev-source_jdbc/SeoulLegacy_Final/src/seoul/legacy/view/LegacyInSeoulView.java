package seoul.legacy.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import seoul.legacy.controller.LegacyController;
import seoul.legacy.controller.UserController;
import seoul.legacy.controller.ZzimController;
import seoul.legacy.model.service.ReviewService;
import seoul.legacy.model.service.ZzimService;
import seoul.legacy.model.vo.Legacy;
import seoul.legacy.model.vo.Zzim;
import seoul.legacy.model.vo.Review;
import seoul.legacy.model.vo.User;

public class LegacyInSeoulView {
	// review, zzim, palace, facility, user, legacy controller 호출
//	private UserController uc = new UserController();

	private LegacyController lc = new LegacyController();
	private ZzimController zc = new ZzimController();
	private ZzimService zs = new ZzimService();
	private ReviewService rvs = new ReviewService();
	private UserController uc = new UserController();

	private Scanner sc = new Scanner(System.in);
	private String wrongInput = "잘 못 입력하셨습니다. 다시 입력해 주세요.";
	Legacy legacy = null;

	public void mainMenu() {
		uc.logout();
		
		while (true) {
			String standardMenu = "\n---=== 서울시 문화재 탐방 ===---\n" + "\n1. 문화재 검색" + "\n2. 궁궐 검색" + "\n3. 서울시 문화재 Top-10";
			String logInMenu = "\n4. 개인정보" + "\n5. 로그아웃";
			String logOutMenu = "\n6. 로그인" + "\n7. 회원가입";
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
			
//			System.out.println("====== 서울시 문화재 탐방 ======");
//	        System.out.println("1. 문화재 검색");
//	        System.out.println("2. 궁궐 검색");
//	        System.out.println("3. 서울시 문화재 Top-10");
//
//	        if (UserController.getLoginUser() == null) {
//	        	System.out.println("4. 로그인");
//	            System.out.println("5. 회원가입");
//	        } else {
//	            System.out.println("4. 개인정보");
//	            System.out.println("5. 로그아웃");
//	        }
//	        System.out.println("8. 종료");
//	        System.out.println("번호 입력 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			

			User user = null;
			int result = 0;
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
				case 5:
					uc.logout();
					break;
				case 6:
					login();
					break;// 로그인
				case 7:
					user = inputMember();
					System.out.println("신규 가입 확인 : " + user);
					result = uc.insertUser(user);
					System.out.println(result > 0 ? "회원가입 성공" : "회원가입 실패");
					break;
				case 9:
					System.out.println("\n안녕히 가세요!");
					System.exit(0);// 종료
				default:
					System.out.println(wrongInput);
					break;
			}
		}
	}

	private User inputMember() {
		System.out.println("<<< 회원 가입을 환영합니다. >>>");
		System.out.println("가입할 ID : ");
		String userId = sc.nextLine();
		System.out.println("가입할 PW : ");
		String userPw = sc.nextLine();
		System.out.println("가입할 이름 : ");
		String userName = sc.nextLine();
		System.out.println("가입할 Email : ");
		String userEmail = sc.nextLine();
		System.out.println("가입할 Phone : ");
		String userPhone = sc.nextLine();

		User user = new User(userId, userPw, userName, userEmail, userPhone);
		return user;

	}

	public void login() {
		while (true) {
			System.out.println("================== 로그인 =====================");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pw = sc.nextLine();
			boolean result = uc.login(id, pw);
			if (result) {
				System.out.println("로그인에 성공하였습니다!");
				break;
			} else {
				System.out.println("로그인에 실패하였습니다. 다시 입력해주세요.");
			}
		}

	}

	public void userData() {
		System.out.println("<<< 개인 정보 >>>");
		System.out.println("1. 내가 찜한 문화재 보기");
		System.out.println("2. 내가 쓴 리뷰 보기");
		System.out.print("번호 입력 : ");
		int choNum = Integer.parseInt(sc.nextLine());

		User user = uc.getLoginUser();
		String userId = user.getUserId();
		switch (choNum) {
		case 1:
			List<Zzim> list = zs.selectById(userId);
			PrintZzim(list);
			break;
		case 2:
			List<Review> reviewList = rvs.selectByUserId(userId);
			printReview(reviewList);

		}

	}

	private void PrintZzim(List<Zzim> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for (Zzim zzim : list) {
			System.out.println(zzim.toString());
		}
		System.out.println("=================================================================\n");
	}

	private void printReview(List<Review> reviewList) {
		System.out.println("================== 조회 건수 총 :" + reviewList.size() + "건 ===================");
		for (Review review : reviewList) {
			System.out.println(review.toString());
		}
		System.out.println("=================================================================\n");
	}

	public void searchLegacy() {
		while (true) {
			String menu = "\n<<< 문화재 검색 >>>\n" + "\n1. 이름 검색" + "\n2. 간편 검색" + "\n3. 뒤로 가기" + "\n입력 : ";
			System.out.print(menu);
			int menuNum = Integer.parseInt(sc.nextLine());

			switch (menuNum) {
			case 1:
				searchLegacyByName();
				continue;// 이름 검색 탭
			case 2:
				typeSearch();
				continue;// 간편 검색 (종목, 시대, 지역)
			case 3:
				return;
			default:
				System.out.println(wrongInput);
				continue;
			}
		}
	}

	public void searchLegacyByName() {
		System.out.println("\n<<< 이름 검색 >>>");
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();

		List<Legacy> list = lc.selectByLegacyName(name);

		LegacySearch(list);

	}

	public void typeSearch() {
		while (true) {
			System.out.println("\n<<< 간편 검색 >>>");
			System.out.println("1. 종목 검색");
			System.out.println("2. 지역 검색");
			System.out.println("3. 시대 검색");
			System.out.println("4. 뒤로가기");
			System.out.print("입력 : ");

			int menuNum = Integer.parseInt(sc.nextLine());

			switch (menuNum) {
			case 1:
				searchCategory();
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

	public void searchCategory() {
		String[] categoryCode = { "국보", "보물", "사적", "사적및명승", "명승", "천연기념물", "국가무형문화재", "국가민속문화재", "시도유형문화재", "시도무형문화재",
				"시도기념물", "시도민속문화재", "시도등록문화재", "문화재자료", "국가등록문화재", "이북5도 무형문화재" };

		System.out.println();
		System.out.println("<<< 종목 검색 >>>");
		System.out.println("--------------------------------------------");

		for (int i = 0; i < categoryCode.length; i++) {
			System.out.print((i + 1) + " : " + categoryCode[i]);
			if (i == 0 || i == 2 || i == 4) {
				System.out.print("\t\t\t");
			} else if (i % 2 == 0) {
				System.out.print("\t\t");
			} else {
				System.out.print("\n");
			}
		}
		System.out.println("--------------------------------------------");
		while (true) {
			try {
				System.out.print("종목 번호를 입력해 주세요 : ");
				int num = Integer.parseInt(sc.nextLine());
				if (num > categoryCode.length || num < 1) {
					System.out.println(wrongInput);
					continue;
				}

				String codeName = categoryCode[num - 1];
				List<Legacy> list = lc.searchByCategory(codeName);

				if (list.isEmpty()) {
					System.out.println("조회 결과가 존재하지 않습니다.");
					continue;
				}

				System.out.println();
				int count = 0;
				System.out.println("[ " + codeName + " ]");
				for (Legacy legacy : list) {
					System.out.println(legacy.toString());
					count++;
				}
				System.out.println();
				System.out.println("[ " + codeName + " 검색완료 ] 자료 수 : " + count + "개");

				searchNameInside(); // <<<<
				break;
			} catch (Exception e) {
				System.out.println(wrongInput);
			}
		}
	}

	public void searchByArea() {
		System.out.print("지역을 입력해 주세요(광진구, 관악 등) : ");
		String area = sc.nextLine();

		List<Legacy> list = lc.selectByLegacyArea(area);

		LegacySearch(list);

	}

	public void searchByEra() {
		System.out.print("시대를 입력해 주세요 ");
		System.out.println("1. 고구려, 2. 백제, 3. 신라, 4. 고려, 5. 조선");
		System.out.print("번호 입력 : ");
		int eraName = Integer.parseInt(sc.nextLine());

		String era = "";
		switch (eraName) {
		case 1:
			era = "고구려";
			break;
		case 2:
			era = "백제";
			break;
		case 3:
			era = "신라";
			break;
		case 4:
			era = "고려";
			break;
		case 5:
			era = "조선";
			break;
		}

		List<Legacy> list = lc.selectByEra(era);

		LegacySearch(list);

	}

//	출력 메소드---------------------------------------------------------------

	public void searchNameInside() {
		while (true) {
			System.out.println();
			System.out.print("이름을 입력하여 상세검색을 하시겠습니까? (y/n) : ");
			String result = sc.nextLine();

			if (result.equals("y")) {
				searchLegacyByName();
				break;
			} else if (result.equals("n")) {
				return;
			} else {
				System.out.println(wrongInput);
				continue;
			}
		}
	}

	public void LegacySearch(List<Legacy> list) {

		if (list.isEmpty()) {
			System.out.println("검색된 문화재가 없습니다. 간편검색으로 돌아갑니다.");
			searchLegacy();
			return;
		}

		int count = 1;
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			System.out.println((i+1)+ " : " + list.get(i).toString());
			count++;
			
			if (list.size() == 1) {
				System.out.println(list.get(i).detailToString());
				System.out.println("총 출력된 문화재 [ 1개 ]와 상세 문화재 정보입니다." );
				return;
			}
		}
		System.out.println("총 출력된 문화재는 [ " + (count-1) + " 개] 입니다." );
		
		while (true) {
			System.out.println();
			System.out.print("상세검색을 하시겠습니까? (y/n) : ");
			String result = sc.nextLine();
			
			if(result.toUpperCase().equals("Y")) {
				break;
			} else if (result.toUpperCase().equals("N")) {
				return;
			} else {
				System.out.println(wrongInput);
				continue;
			}
		}

		System.out.println("\n<<< 문화재 상세 정보 >>>");
		int choNum = 0;
		while (true) {
			System.out.print("결과내에서 번호를 선택하세요 : ");
			choNum = Integer.parseInt(sc.nextLine()) - 1;
			if (choNum >= list.size()) {
				System.out.println("1 부터 " + (list.size()) +" 까지의 범위내에서 선택해 주세요");
				continue;
			}
			break;
		}

		legacy = list.get(choNum);
		System.out.println();
		System.out.println(legacy.detailToString() + "\n찜 횟수 : " + zc.zzimcount(legacy.getLegacy_no()));
		


		int legacy = list.get(choNum).getLegacy_no();
		if (uc.getLoginUser() != null) {
			Zzim(legacy);
		}

		return;

	}

//	/---------------------------------------------------------------------

//	찜 출력------------------------------------------------------------------

	public void Zzim(int legacyNo) {
		if (uc.getLoginUser() != null) {
			User user = uc.getLoginUser();
			String userId = user.getUserId();
			while (true) {
				System.out.println("\n1. 찜 하기~!");
				System.out.println("2. 토막 후기");
				System.out.println("3. 처음으로");
				System.out.print("번호입력 : ");

				int menuNum = Integer.parseInt(sc.nextLine());
				switch (menuNum) {
				case 1:
					zc.insert(userId, legacyNo);
					return;
				case 2:
					insertReview(legacyNo); // 실제로 temp.getLegacyNo
					return;
				case 3:
					break;
				default:
					System.out.println(wrongInput);
				}
			}
		}
	}

//	------------------------------------------------------------------------------

	public void topTen() {
//		List<Legacy> temp = lc.topTen();
//		List<String> temp = new ArrayList<>();
//		for (int i = 0; i < temp.size(); i++) {
//			System.out.println(i + " : " + temp.get(i));
//		}
//		int menuNum = Integer.parseInt(sc.nextLine());
//
//		// lc.detailPrint(temp.get(menuNum));

		List<Legacy> list = new ArrayList<Legacy>();
		list = lc.topTen();
		for (int i = 0; i < list.size(); i++) {
			int num = i + 1;
			System.out.println(num + " : " + list.get(i));
		}

	}

	public void insertReview(int legacyNo) {
		System.out.print("토막 후기를 입력해 주세요!\n→ ");
		String content = sc.nextLine();
		String userId = uc.getLoginUser().getUserId();
		Review review = new Review(content, userId, legacyNo);
		System.out.print("후기를 입력하시겠습니까? (Y/N) : ");
		// yn 입력
//		if ( u~ wls)
		rvs.insert(review);
	}

	public void palaceList() {
//		// palace controller 메소드 짜주세여...
//		System.out.println("return type : List<Palace> or HashMap<Integer, Palace> 모두 리턴하는 메소드 짜주세여");
//		// List<Legacy> temp = pc.searchAll;
//		List<String> temp = new ArrayList<>();
//		String menu = "<<< 궁궐 >>>" + "번호 선택 : ";
//		int menuNum = Integer.parseInt(sc.nextLine());
//		// List<Legacy> temp2 = fc.searchByPNo(menuNum);
//		List<String> temp2 = new ArrayList<String>();
//		for (int i = 0; i < temp2.size(); i++) {
//			System.out.println(i + " : " + temp2.get(i));
//		}
//		menuNum = Integer.parseInt(sc.nextLine());
//
////		fc.detailPrint(temp2.get(menuNum)); 시설 디테일 출력 매소드
	}

	public static void main(String[] args) {
		LegacyInSeoulView lisv = new LegacyInSeoulView();

		lisv.mainMenu();
	}

}
