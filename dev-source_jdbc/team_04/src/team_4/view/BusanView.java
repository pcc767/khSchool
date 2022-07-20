package view;

import java.util.Comparator;
import java.util.List;

import common.Util;
import controller.ParkCotroller;
import controller.ThemeController;
import controller.ThemeReviewController;
import controller.UserController;
import controller.WalkCotroller;
import controller.WalkReviewController;
import vo.ParkVO;
import vo.ThemeReviewVO;
import vo.ThemeVO;
import vo.UserVO;
import vo.WalkReviewVO;
import vo.WalkVO;

public class BusanView {
	private UserController userController = new UserController();
	private ThemeController themeController = new ThemeController();
	private WalkCotroller walkController = new WalkCotroller();
	private ParkCotroller parkCotroller = new ParkCotroller();
	private ThemeReviewController themeRvwController = new ThemeReviewController();
	private WalkReviewController walkRvwController = new WalkReviewController();
	
//	public BusanView() {
//		super();
//		parkCotroller.initPark();
//		themeController.initTheme();
//		walkController.initWalk();
//	}

	public void mainMenu() {
		boolean isLogin = false;
		String menu = "========== 부산여행 Project Main ===========\n"
				+ "1.테마여행 검색\n"
				+ "2.도보여행 검색\n" 
				+ "3.주차장 검색\n" 
				+ "4.리뷰	\n" 
				+ "5.로그 아웃\n"
				+ "0.프로그램 끝내기\n"
				+ "---------------------------------------------\n"
				+ "선택 : "; 

		while(true) {
			if(isLogin == false) {
				loginMenu();
				isLogin = true;
			}
			System.out.print(menu);
			int choice = Util.readIntForConsol();
			switch(choice) {
			case 1 : themeMenu(); break;
			case 2 : walkMenu(); break;
			case 3 : parkingMenu(); break;
			case 4 : reviewMenu(); break;
			case 5 : 
				isLogin = false;
				UserController.logout();
				System.out.println("로그아웃 되었습니다.\n");
				break;
			case 0 : 
				System.out.print("정말로 끝내시겠습니까?(y/n) : ");
				if(Util.readStrForConsol().charAt(0) == 'y')
				return;
				break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void loginMenu() {
		while(true) {
			System.out.println("================== 로그인 =====================");
			System.out.print("아이디 : ");
			String id = Util.readStrForConsol();
			System.out.print("비밀번호 : ");
			String pw = Util.readStrForConsol();
			boolean result = userController.login(id, pw);
			if(result) {
				System.out.println("로그인에 성공하였습니다!");
				break;
			}else {
				System.out.println("로그인에 실패하였습니다. 다시 입력해주세요.");
			}
		}
	}

	private void themeMenu() {
		String menu = "========== Theme Menu ==========\n"
				+ "1.구 검색\n"
				+ "2.카테고리 검색\n" 
				+ "3.키워드 검색\n" 
				+ "0.이전 메뉴로 돌아가기\n"
				+ "----------------------------------\n"
				+ "선택 : "; 

		while(true) {
			String guKind = "1. 금정구 2. 동래구 3. 북구 4. 연제구 \n5. 수영구 6. 부산진구 7. 남구 8. 동구"
					+ "\n9. 사상구 10. 강서구 11. 서구 12. 사하구 \n13. 중구 14. 영도구 15. 해운대구 16. 기장군";
			List<ThemeVO> list = null;
			System.out.print(menu);
			int choice = Util.readIntForConsol();

			switch(choice) {
			case 1 : 
				System.out.println(guKind);
				System.out.print("검색할 구 입력: ");
				String gu = Util.readStrForConsol();
				list = themeController.searchByGu(gu);
				printTheme(list);
				break;
			case 2 :
				System.out.print("카테고리 검색(일정여행/이색여행) : ");
				String cate = Util.readStrForConsol();
				list = themeController.searchByCategory(cate);
				printTheme(list);			
				break;
			case 3 : 
				System.out.print("키워드 검색 검색 : ");
				String keyW = Util.readStrForConsol();
				list = themeController.searchByKeyW(keyW);
				printTheme(list);
				break;
			case 0 : return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private void printTheme(List<ThemeVO> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for(ThemeVO item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	private void walkMenu() {
		String menu = "========== Walk Menu ==========\n"
				+ "1.카테고리 검색\n"
				+ "2.키워드 검색\n" 
				+ "0.이전 메뉴로 돌아가기\n"
				+ "----------------------------------\n"
				+ "선택 : "; 
		while(true) {
			List<WalkVO> list = null;
			System.out.print(menu);
			int choice = Util.readIntForConsol();
			switch(choice) {
			case 1 : 
				System.out.print("카테고리 검색 검색(해안길/숲길/도심길) : ");
				String cate = Util.readStrForConsol();
				list = walkController.searchByCtegory(cate);
				printWalk(list);		
				break;
			case 2 : 
				System.out.print("키워드 검색 검색 : ");
				String keyW = Util.readStrForConsol();
				list = walkController.searchByKeyW(keyW);
				printWalk(list);
				break;
			case 0 : return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private void printWalk(List<WalkVO> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for(WalkVO item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	private void parkingMenu() {
		String menu = "========== Parking Menu ==========\n"
				+ "1.주소지 검색\n"
				+ "2.주차장명 검색\n" 
				+ "0.이전 메뉴로 돌아가기\n"
				+ "----------------------------------\n"
				+ "선택 : "; 
		while(true) {
			List<ParkVO> list = null;
			System.out.print(menu);
			int choice = Util.readIntForConsol();
			switch(choice) {
			case 1: 
				System.out.print("주소지 검색 : ");
				String addr = Util.readStrForConsol();
				list = parkCotroller.searchByAddr(addr);
				printParking(list);		
				break;
			case 2: 
				System.out.print("주차장명 검색 : ");
				String name = Util.readStrForConsol();
				list = parkCotroller.searchByName(name);
				printParking(list);		
				break;
			case 0: 
				return;
			default: 
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private void printParking(List<ParkVO> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		for(ParkVO item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	private void reviewMenu() {
		String menu = "========== Review Menu ==========\n"
				+ "1.테마여행 리뷰 페이지\n"
				+ "2.도보여행 리뷰 페이지\n" 
				+ "0.이전 메뉴로 돌아가기\n"
				+ "-------------------------------------\n"
				+ "선택 : "; 

		System.out.print(menu);
		int choice = Util.readIntForConsol();
		switch(choice) {
		case 1 : themeReviewPage(); break;
		case 2 : WalkReviewPage();	break;
		case 0 : return;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}

	private void themeReviewPage() {
		String menu = "========== Theme Review Menu ==========\n"
				+ "1.테마여행 리뷰 작성\n"
				+ "2.전체 테마여행 리뷰 조회\n" 
				+ "3.나의 테마여행 리뷰 조회\n"
				+ "4.테마여행 리뷰 검색하기\n"
				+ "5.테마여행 리뷰 삭제하기\n"
				+ "6.테마여행 리뷰 수정하기\n"
				+ "0.이전으로 돌아가기\n"
				+ "-------------------------------------\n"
				+ "선택 : "; 

		while(true) {
			List<ThemeVO> themeList = null;
			List<ThemeReviewVO> themeReviewList = null;
			UserVO user = UserController.getLoginUser();
			int themeNo = 0;
			int userNo = user.getUserNum();
			int rNo = 0;
			boolean result = false;
			ThemeReviewVO themeReview = null;

			System.out.print(menu);
			int choice = Util.readIntForConsol();

			switch(choice) {
			case 1:
				themeList = themeController.getAllThemeList();
				printTheme(themeList);
				System.out.print("테마여행 번호 : "); 
				themeNo = Util.readIntForConsol();
				System.out.print("리뷰 제목을 입력하세요 : ");
				String tTitle = Util.readStrForConsol();
				System.out.print("리뷰 내용을 입력하세요 : ");
				String tContent = Util.readStrForConsol();
				themeReview = new ThemeReviewVO(rNo, userNo, themeNo, tTitle, tContent);
				result = themeRvwController.writeReview(themeReview);
				System.out.println(result ? "성공 하였습니다." : "실패 하였습니다.");
				break;
			case 2 :
				System.out.println("-전체 테마여행 리뷰 목록-");
				themeReviewList = themeRvwController.getReviewAllList();
				printThemeReviewTitle(themeReviewList);
				break;
			case 3 :
				System.out.println("-내가 쓴 테마여행 리뷰 목록-");
				themeReviewList = themeRvwController.getReviewUserList(userNo);
				printThemeReviewTitle(themeReviewList);
				break;
			case 4 :
				while(true) {
				System.out.println("-------- 테마여행 리뷰 검색 --------");
				System.out.println("1. 여행제목 검색 \n2. 키워드 검색 \n0. 이전 메뉴로 돌아가기");
				System.out.print("선택 : ");
				switch(Util.readIntForConsol()) {
				case 1 :
					System.out.print("여행제목 입력 : ");
					String title = Util.readStrForConsol();
					themeReviewList = themeRvwController.getReviewTitle(title);
					printThemeReviewTitle(themeReviewList);
					break;
				case 2 :
					System.out.print("키워드 입력 : ");
					String keyword = Util.readStrForConsol();
					themeReviewList = themeRvwController.getReviewKeyword(keyword);
					printThemeReviewTitle(themeReviewList);
					break;
				case 0 : return;
				default : System.out.println("잘못 입력하셨습니다.");
				break;
				}
			}
				
			case 5 : 
				System.out.println("--------내가 쓴 테마여행 리뷰 목록 --------");
				themeReviewList = themeRvwController.getReviewUserList(userNo);
				printThemeReviewTitle(themeReviewList);
				System.out.print("삭제할 리뷰 번호 : ");
				choice = Util.readIntForConsol();
				if(themeRvwController.deleteThemeReview(choice)) {
					System.out.println("삭제가 완료되었습니다.");
				} else {
					System.out.println("리뷰번호를 확인해주세요.");
				}
				break;
			case 6 : 
				System.out.println("-내가 쓴 테마여행 리뷰 목록-"); 
				themeReviewList = themeRvwController.getReviewUserList(userNo);
				printThemeReviewTitle(themeReviewList);
				
				System.out.print("수정할 리뷰 번호 : ");
				int rtNo = Util.readIntForConsol();
				System.out.print("수정할 리뷰 제목 : ");
				String themeTitle = Util.readStrForConsol();
				System.out.print("수정할 리뷰 내용 : ");
				String themeContent = Util.readStrForConsol();
					
				if (themeRvwController.updateThemeReview(rtNo, new ThemeReviewVO(themeTitle, themeContent))) {
					System.out.println("수정이 완료되었습니다.");
				} else {
					System.out.println("리뷰번호가 다릅니다. 다시 입력해주세요.");
				}
				break;
			case 0 : return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private void WalkReviewPage() {
		String menu = "========== Walk Review Menu ==========\n"
				+ "1.도보여행 리뷰 작성\n"
				+ "2.전체 도보여행 리뷰 조회\n" 
				+ "3.나의 도보여행 리뷰 조회\n"
				+ "4.도보여행 리뷰 검색하기\n"
				+ "5.도보여행 리뷰 삭제하기\n"
				+ "6.도보여행 리뷰 수정하기\n"
				+ "0.이전으로 돌아가기\n"
				+ "-------------------------------------\n"
				+ "선택 : "; 

		while(true) {
			List<WalkVO> walkList = null;
			List<WalkReviewVO> walkReviewList = null;
			UserVO user = UserController.getLoginUser();
			int walkNo = 0;
			int userNo = user.getUserNum();
			int rNo = 0;
			boolean result = false;
			WalkReviewVO walkReview = null;

			System.out.print(menu);
			int choice = Util.readIntForConsol();

			switch(choice) {
			case 1 :
				walkList = walkController.getAllWalkList();
				printWalk(walkList);
				System.out.print("도보여행 번호 : "); 
				walkNo = Util.readIntForConsol();
				System.out.print("리뷰 제목을 입력하세요 : ");
				String wTitle = Util.readStrForConsol();
				System.out.print("리뷰 내용을 입력하세요 : ");
				String wContent = Util.readStrForConsol();
				walkReview = new WalkReviewVO(rNo, userNo, walkNo, wTitle, wContent);
				result = walkRvwController.writeReview(walkReview);
				System.out.println(result ? "성공 하였습니다.": "실패 하였습니다.");
				break;
			case 2 : 
				System.out.println("-전체 도보여행 리뷰 목록-");
				walkReviewList = walkRvwController.getReviewAll();
				printWalkReviewTitle(walkReviewList);
				break;
			case 3 : 
				System.out.println("-내가 쓴 도보여행 리뷰 목록-");
				walkReviewList = walkRvwController.getReviewByUnum(userNo);
				printWalkReviewTitle(walkReviewList);
				break;
			case 4 :
				while(true) {
					System.out.println("-------- 도보여행 리뷰 검색 --------");
					System.out.println("1. 여행제목 검색 \n2. 키워드 검색 \n0. 이전 메뉴로 돌아가기");
					System.out.print("선택 : ");
					
					switch(Util.readIntForConsol()) {
					case 1 :
						System.out.print("여행제목 입력 : ");
						String title = Util.readStrForConsol();
						walkReviewList = walkRvwController.getReviewByTitle(title);
						printWalkReviewTitle(walkReviewList);
						break;
					case 2 :
						System.out.print("키워드 입력 : ");
						String keyword = Util.readStrForConsol();
						walkReviewList = walkRvwController.getReviewByKeyword(keyword);
						printWalkReviewTitle(walkReviewList);
						break;
					case 0 : return;
					default : System.out.println("잘못 입력하셨습니다.");
					}
				}
			case 5 : 
				System.out.println("--------내가 쓴 도보여행 리뷰 목록 --------");
				walkReviewList = walkRvwController.getReviewByUnum(userNo);
				printWalkReviewTitle(walkReviewList);
				System.out.print("삭제할 리뷰 번호 : ");
				choice = Util.readIntForConsol();
				
				if (walkRvwController.deleteReview(choice)) {
					System.out.println("삭제가 완료되었습니다.");
				} else {
					System.out.println("리뷰번호를 확인해주세요.");
				}
				break;
			case 6 :
				System.out.println("-내가 쓴 도보여행 리뷰 목록-");
				walkReviewList = walkRvwController.getReviewByUnum(userNo);
				printWalkReviewTitle(walkReviewList);
				
				System.out.print("수정할 리뷰 번호 : ");
				int rwNo = Util.readIntForConsol();
				System.out.print("수정할 리뷰 제목 : ");
				String walkTitle = Util.readStrForConsol();
				System.out.print("수정할 리뷰 내용 : ");
				String walkContent = Util.readStrForConsol();
					
				if(walkRvwController.updateReview(rwNo, new WalkReviewVO(walkTitle, walkContent))) {
					System.out.println("수정이 완료되었습니다.");
				} else {
					System.out.println("리뷰번호가 다릅니다. 다시 입력해주세요.");
				}
				break;
			case 0 : return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	private void printThemeReviewTitle(List<ThemeReviewVO> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		list.sort(new Comparator<ThemeReviewVO>(){
			public int compare(ThemeReviewVO t1, ThemeReviewVO t2) {
				int check = t1.gettRevNum() - t2.gettRevNum();
				return check;
			}
		});
		
		for(ThemeReviewVO item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	private void printWalkReviewTitle(List<WalkReviewVO> list) {
		System.out.println("================== 조회 건수 총 :" + list.size() + "건 ===================");
		list.sort(new Comparator<WalkReviewVO>(){
			public int compare(WalkReviewVO w1, WalkReviewVO w2) {
				int check = w1.getwRevNum() - w2.getwRevNum();
				return check;
			}
		});
		
		for(WalkReviewVO item : list) {
			System.out.println(item.toStringForConsole());
		}
		System.out.println("=================================================================\n");
	}

	public static void main(String[] args) {
		BusanView bv = new BusanView();
		bv.mainMenu();
	}
}
