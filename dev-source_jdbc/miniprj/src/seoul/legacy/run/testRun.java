package seoul.legacy.run;

import java.util.List;
import java.util.Scanner;

import seoul.legacy.controller.FacilityController;
import seoul.legacy.controller.LegacyController;
import seoul.legacy.controller.PalaceController;
import seoul.legacy.controller.ReviewController;
import seoul.legacy.controller.UserController;
import seoul.legacy.controller.ZzimController;
import seoul.legacy.model.service.FacilityService;
import seoul.legacy.model.service.LegacyService;
import seoul.legacy.model.service.PalaceService;
import seoul.legacy.model.service.ReviewService;
import seoul.legacy.model.service.UserService;
import seoul.legacy.model.service.ZzimService;
import seoul.legacy.model.vo.Facility;
import seoul.legacy.model.vo.Legacy;
import seoul.legacy.model.vo.Palace;
import seoul.legacy.model.vo.Review;
import seoul.legacy.model.vo.User;
import seoul.legacy.model.vo.Zzim;

public class testRun {

	private FacilityService fs = new FacilityService();
	private UserService us = new UserService();
	private ReviewService rs = new ReviewService();
	private ZzimService zs = new ZzimService();
	private PalaceService ps = new PalaceService();
	private LegacyService ls = new LegacyService();
	private static Scanner sc = new Scanner(System.in);
	private static String wrongInput = "잘못된 입력 재입력 부탁 → ";

	private FacilityController fc = new FacilityController();
	private UserController uc = new UserController();
	private ReviewController rc = new ReviewController();
	private ZzimController zc = new ZzimController();
	private PalaceController pc = new PalaceController();
	private LegacyController lc = new LegacyController();

	public void serviceTest() {

		while (true) {

			String menu = "※ 종료 원하면 아무거나 누르세요.\n1. Legacy\n2. User\n3. Review\n4. Zzim\n5. Palace\n6. Facility\n→ ";
			System.out.print(menu);
			int menuNum = scannerInt();

			switch (menuNum) {
			case 1:
				String legacyMenu = "1. category\n2. era\n3. area\n4. name\n5. no\n6. topten\n→ ";
				System.out.print(legacyMenu);
				int mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("Category → ");
					String category = scannerStr();
					List<Legacy> cList = ls.selectByCategory(category);
					for (Legacy l : cList) {
						System.out.println(l.toString());
					}
					break;
				case 2:
					System.out.print("Era → ");
					String era = scannerStr();
					List<Legacy> eList = ls.selectByEra(era);
					for (Legacy l : eList) {
						System.out.println(l.toString());
					}
					break;
				case 3:
					System.out.print("area → ");
					String area = scannerStr();
					List<Legacy> aList = ls.selectByLegacyArea(area);
					for (Legacy l : aList) {
						System.out.println(l.toString());
					}
					break;
				case 4:
					System.out.print("Name → ");
					String name = scannerStr();
					List<Legacy> nList = ls.selectByName(name);
					for (Legacy l : nList) {
						System.out.println(l.toString());
					}
					break;
				case 5:
					System.out.print("no → ");
					int no = scannerInt();
					Legacy nL = ls.selectOneByNo(no);
					System.out.println(nL.toString());
					break;
				case 6:
					List<Legacy> topTen = ls.topTen();
					for (Legacy l : topTen) {
						System.out.println(l.toString());
					}
					break;
				default:
					break;
				}
				continue;
			case 2:
				String userMenu = "id\n→ ";
				System.out.print(userMenu);
				String id = scannerStr();
				User user = us.selectById(id);
				System.out.println(user.toString());
				continue;
			case 3:
				String reviewMenu = "1. lNo\n2. id\n→ ";
				System.out.print(reviewMenu);
				mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("lNo → ");
					int lNo = scannerInt();
					List<Review> lList = rs.selectByLegacyNo(lNo);
					for (Review r : lList) {
						System.out.println(r.legacyToString());
					}
					break;
				case 2:
					System.out.print("id → ");
					id = scannerStr();
					List<Review> iList = rs.selectByUserId(id);
					for (Review r : iList) {
						System.out.println(r.idToString());
					}
					break;
				default:
					break;
				}
				continue;
			case 4:
				String zzimMenu = "1. countZzim\n2. id\n→ ";
				System.out.print(zzimMenu);
				mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("lNo → ");
					int lNo = scannerInt();
					int count = zs.countZzim(lNo);
					System.out.println("문화재번호 : " + lNo + ", 찜 횟수 : " + count);
					break;
				case 2:
					System.out.print("id → ");
					id = scannerStr();
					List<Zzim> zList = zs.selectById(id);
					for (Zzim z : zList) {
						System.out.println(z.toString());
					}
					break;
				default:
					break;
				}
				continue;
			case 5:
				String palaceMenu = "all";
				System.out.println(palaceMenu);
				List<Palace> pList = ps.selectAll();
				for (Palace p : pList) {
					System.out.println(p.toString());
				}
				continue;
			case 6:
				String FacilityMenu = "1. pNo\n2. fNo\n→ ";
				System.out.print(FacilityMenu);
				mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("pNo → ");
					int pNo = scannerInt();
					List<Facility> fList = fs.selectByPalaceNO(pNo);
					for (Facility f : fList) {
						System.out.println(f.toString());
					}
					break;
				case 2:
					System.out.print("fNo → ");
					int fNo = scannerInt();
					Facility facility = fs.selectOneByFacilityNO(fNo);
					System.out.println(facility.toString());
					break;
				default:
					break;
				}
				continue;
			default:
				return;
			}
//			1. legacy

//			ls.selectByCategory(null);
//			ls.selectByEra(null);
//			ls.selectByLegacyArea(null);
//			ls.selectByName(null);
//			ls.selectOneByNo(0);
//			ls.topTen();

//			2. User

//			us.selectById(userMenu);

//			3. Review
//			rs.selectByLegacyNo(menuNum);
//			rs.selectByUserId(userMenu);

//			4. Zzim
//			zs.countZzim(menuNum);
//			zs.selectById(userMenu);

//			5. Palace
//			ps.selectAll();
//			6. Facility
//			fs.selectByPalaceNO(menuNum);
//			fs.selectOneByFacilityNO(menuNum);
		}
	}

	public void controllerTest() {
		while (true) {

			String menu = "※ 종료 원하면 아무거나 누르세요.\n1. Legacy\n2. User\n3. Review\n4. Zzim\n5. Palace\n6. Facility\n→ ";
			System.out.print(menu);
			int menuNum = scannerInt();

			switch (menuNum) {
			case 1:
				String legacyMenu = "1. category\n2. era\n3. area\n4. name\n5. no\n6. topten\n→ ";
				System.out.print(legacyMenu);
				int mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("Category → ");
					String category = scannerStr();
					List<Legacy> cList = lc.searchByCategory(category);
					for (Legacy l : cList) {
						System.out.println(l.toString());
					}
					break;
				case 2:
					System.out.print("Era → ");
					String era = scannerStr();
					List<Legacy> eList = lc.searchByEra(era);
					for (Legacy l : eList) {
						System.out.println(l.toString());
					}
					break;
				case 3:
					System.out.print("area → ");
					String area = scannerStr();
					List<Legacy> aList = lc.selectByLegacyArea(area);
					for (Legacy l : aList) {
						System.out.println(l.toString());
					}
					break;
				case 4:
					System.out.print("Name → ");
					String name = scannerStr();
					List<Legacy> nList = lc.selectByLegacyName(name);
					for (Legacy l : nList) {
						System.out.println(l.toString());
					}
					break;
				case 5:
					System.out.print("no → ");
					int no = scannerInt();
					String detail = lc.printDetail(no);
					System.out.println(detail);
					break;
				case 6:
					List<Legacy> topTen = lc.topTen();
					for (Legacy l : topTen) {
						System.out.println(l.toString());
					}
					break;
				default:
					break;
				}
				continue;
			case 2:
				
				System.out.println(UserController.getLoginUser());
				String userMenu = "id\n→ ";
				System.out.print(userMenu);
				String id = scannerStr();
				System.out.println("pw\n→ ");
				String pw = scannerStr();
				boolean isLogin = uc.login(id, pw);
				System.out.println(isLogin);
				System.out.println(UserController.getLoginUser());
				UserController.logOut();
				System.out.println(isLogin);
				System.out.println(UserController.getLoginUser());
				continue;
			case 3:
				String reviewMenu = "1. lNo\n2. id\n→ ";
				System.out.print(reviewMenu);
				mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("lNo → ");
					int lNo = scannerInt();
					List<Review> lList = rs.selectByLegacyNo(lNo);
					for (Review r : lList) {
						System.out.println(r.legacyToString());
					}
					break;
				case 2:
					System.out.print("id → ");
					id = scannerStr();
					List<Review> iList = rs.selectByUserId(id);
					for (Review r : iList) {
						System.out.println(r.idToString());
					}
					break;
				default:
					break;
				}
				continue;
			case 4:
				String zzimMenu = "1. countZzim\n2. id\n→ ";
				System.out.print(zzimMenu);
				mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("lNo → ");
					int lNo = scannerInt();
					int count = zs.countZzim(lNo);
					System.out.println("문화재번호 : " + lNo + ", 찜 횟수 : " + count);
					break;
				case 2:
					System.out.print("id → ");
					id = scannerStr();
					List<Zzim> zList = zs.selectById(id);
					for (Zzim z : zList) {
						System.out.println(z.toString());
					}
					break;
				default:
					break;
				}
				continue;
			case 5:
				String palaceMenu = "all";
				System.out.println(palaceMenu);
				List<Palace> pList = ps.selectAll();
				for (Palace p : pList) {
					System.out.println(p.toString());
				}
				continue;
			case 6:
				String FacilityMenu = "1. pNo\n2. fNo\n→ ";
				System.out.print(FacilityMenu);
				mNum = scannerInt();
				switch (mNum) {
				case 1:
					System.out.print("pNo → ");
					int pNo = scannerInt();
					List<Facility> fList = fs.selectByPalaceNO(pNo);
					for (Facility f : fList) {
						System.out.println(f.toString());
					}
					break;
				case 2:
					System.out.print("fNo → ");
					int fNo = scannerInt();
					Facility facility = fs.selectOneByFacilityNO(fNo);
					System.out.println(facility.toString());
					break;
				default:
					break;
				}
				continue;
			default:
				return;
			}
		}
	}

	public static int scannerInt() {
		sc.reset();
		int result = 0;
		while (true) {
			String str = sc.nextLine();
			if (str == null || str.length() < 1) {
				System.out.print(wrongInput);
				continue;
			}

			try {
				result = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.print(wrongInput);
				continue;
			}
			break;
		}
		return result;
	}

	public static String scannerStr() {
		sc.reset();
		String result = "";
		while (true) {
			result = sc.nextLine();
			if (result == null || result.length() < 1) {
				System.out.print(wrongInput);
				continue;
			}
			break;
		}
		return result;
	}

	public static void main(String[] args) {

		testRun tr = new testRun();
		while (true) {

			System.out.println("<<< TEST >>>\n");

			System.out.print("1. Service Test\n2. ControllerTest\n3. Exit\n→ ");

			int menuNum = scannerInt();

			switch (menuNum) {
			case 1:
				tr.serviceTest();
				continue;
			case 2:
				tr.controllerTest();
				continue;
			case 3:
				return;
			default:
				System.out.println(wrongInput);
				continue;
			}
		}

	}
}
