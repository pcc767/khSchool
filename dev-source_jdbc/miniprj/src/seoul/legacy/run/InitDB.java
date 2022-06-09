package seoul.legacy.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import seoul.legacy.api.LegacyApiManager;
import seoul.legacy.api.PalaceApiManager;
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

public class InitDB {

	private FacilityService fs = new FacilityService();
	private UserService us = new UserService();
	private ReviewService rs = new ReviewService();
	private ZzimService zs = new ZzimService();
	private PalaceService ps = new PalaceService();
	private LegacyService ls = new LegacyService();

	public List<Palace> palaceData() {
		List<Palace> temp = new ArrayList<>();

		temp.add(new Palace(1, 2886));
		temp.add(new Palace(2, 2888));
		temp.add(new Palace(3, 2889));
		temp.add(new Palace(4, 2890));
		temp.add(new Palace(5, 2891));

		return temp;
	}

	public List<User> userData() {
		List<User> temp = new ArrayList<>();

		for (int i = 1; i <= 50; i++) {
			StringBuffer sb = new StringBuffer();

			for (int j = 0; j < 8; j++) {
				int ranNum = new Random().nextInt(10);
				sb.append(ranNum);
			}

			String id = "test" + i;
			String pw = "1234";
			String name = "홍길동" + i;
			String email = id + "@test.test";
			String phone = "010" + sb.toString();

			System.out.println(new User(id, pw, name, email, phone).toString());
			temp.add(new User(id, pw, name, email, phone));
		}

		return temp;
	}

	public List<Review> reviewTest() {
		List<Review> temp = new ArrayList<>();
		// no = 17 id test1 content = 웅장한 맛이 좋습니다.
		int lNo = 17;
		String userId = "test1";
		String content = "웅장한 맛이 좋습니다.";

		temp.add(new Review(content, userId, lNo));

		return temp;
	}

	public List<Zzim> zzimTest() {
		List<Zzim> temp = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			int lNo = i;
			for (int j = i; j < 30; j++) {
				String userId = "test" + j;
				temp.add(new Zzim(userId, lNo));
			}
		}

		return temp;
	}

	public void initDB() {

		List<Legacy> lParseData = LegacyApiManager.callLegacyByXML();
		for (Legacy legacy : lParseData) {
			ls.insert(legacy);
		}
		List<Palace> palaceList = palaceData();
		for (Palace palace : palaceList) {
			ps.insert(palace);
		}
		List<Facility> fParseData = PalaceApiManager.callPalaceByXML();

		for (Facility facility : fParseData) {
			fs.insert(facility);
		}

		List<User> userList = userData();
		for (User user : userList) {
			us.insert(user);
		}

		List<Review> reviewList = reviewTest();
		for (Review review : reviewList) {
			rs.insert(review);
		}

		List<Zzim> zzimList = zzimTest();
		for (Zzim zzim : zzimList) {
			System.out.println(zzim.getUserId() + " : " + zzim.getLegacyNo());
			zs.insert(zzim);
		}
	}

	public static void main(String[] args) {

		// DB 초기화 순서
		// 1. Legacy
		// 2. User
		// 3. Palace, Review, Zzim
		// 4. Facility

		InitDB id = new InitDB();

		id.initDB(); // DB data 입력

		// 1. legacy service test

//		List<Legacy> test = id.ls.selectByCategory("보");
//		for (Legacy l : test) {
//			System.out.println(l.toString());
//		}

//		List<Legacy> test2 = id.ls.selectByLegacyArea("구");
//		for (Legacy l : test2) {
//			System.out.println(l.toString());
//		}

//		List<Legacy> test11 = id.ls.topTen();
//		for (Legacy l : test11) {
//			System.out.println(l.toString());
//		}

//		List<Legacy> test12 = id.ls.selectByEra("신라");
//		for (Legacy l : test12) {
//			System.out.println(l.toString());
//		}

//		List<Legacy> test13 = id.ls.selectByName("숭");
//		for (Legacy l : test13) {
//			System.out.println(l.toString());
//		}

//		Legacy test14 = id.ls.selectOneByNo(2);
//		System.out.println(test14.toString());
//		 2. palace

//		List<Palace> test3 = id.ps.selectAll();
//		for (Palace p : test3) {
//			System.out.println(p);
//		}

		// 3. facility

//		List<Facility> test4 = id.fs.selectByPalaceNO(1);
//		for (Facility f : test4) {
//			System.out.println(f.toString());
//		}

//		Facility test5 = id.fs.selectOneByFacilityNO(12);
//		System.out.println(test5.toString());
//		System.out.println(test5.detailToString());
//		
		// 4. user

//		User test6 = id.us.selectById("test1");
//		System.out.println(test6.toString());
//		
		// 5. review

//		List<Review> test7 = id.rs.selectByLegacyNo(17);
//		for (Review r : test7) {
//			System.out.println(r.legacyToString());
//		}
//		
//		List<Review> test8 = id.rs.selectByUserId("test1");
//		for (Review r : test8) {
//			System.out.println(r.idToString());
//		}
//		
		// 6. zzim
//		List<Zzim> test9 = id.zs.selectById("test9");
//		for (Zzim zzim : test9) {
//			System.out.println(zzim.toString());
//		}

//		int test10 = id.zs.countZzim(12);
//		System.out.println(test10);

	}
}
