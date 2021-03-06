import java.util.Arrays;

public class ObjectArray {
	public static void main(String[] args) {
		// 선언 및 초기화 문법
		UserVO[] userArray; // 초기화 안함
		UserVO[] userArray1 = null;
		UserVO[] userArray2 = new UserVO[10]; // 표준적으로 사용하는 방법!
		UserVO[] userArray3 = new UserVO[] {
				new UserVO("홍길동",26,"010-1234-5332"),
				new UserVO("최길동",31,"010-5555-5332"),
				new UserVO("박길동",29,"010-7554-5332"),
		};
		
//		userArray[0].getName();  // 죽는 이유 : 초기화를 하지 않아서 에러 발생
//		userArray1[0].getName(); // 죽는 이유 : null 발생, 초기화를 null로 해서!
//		System.out.println(Arrays.toString(userArray2));
//		userArray2[0].getName(); // 죽는 이유 : 배열은 생성하고, User객체를 생성 안해서 null로 죽음
//		userArray2[0] = new UserVO();
//		userArray2[0].getName().length(); // 죽는 이유 : 객체 생성하고 이름을 초기화 않고 길이를 불러서!
		
		// 처음서부터 생성하면 사는 문장
		userArray3[0].getName();
		System.out.println("userArray3[0] : "+userArray3[0].getName());
		
		
		// 객체배열 올바르게 활용하는 순서
		// 1. 객체 배열을 선언하고 객체 배열을 생성한다.
		// 2. 실제 사용할 객체를 new로 생성하고 배열에 넣어서 사용한다.
		// 3. 객체가 없는 index에 접근하지 않는다!
		userArray2 = new UserVO[10];
		userArray2[0] = new UserVO("홍길동", 24, "010-1214-1212");
		System.out.println(userArray2[0].getName());
		
		
		// 실제 활용하는 방법
		// 1. 반복문 없이 index로 접근하는 방법
		userArray2[0] = new UserVO("홍길동", 24, "010-1214-1212");
		userArray2[1] = new UserVO("김길동", 31, "010-4312-1212");
		
		// 2. 반복문에서 직접 생성하는 방법
		for(int i = 0; i< userArray2.length; i++) {
			userArray2[i] = new UserVO("홍길동"+i, 23+i, "010-1234-567"+i);
		}
		
		// 3. 반복문 내부에서 객체를 생성하고 값별로 초기화하여 사용하는 방법
		for(int i =0; i< userArray2.length; i++) {
			UserVO user = new UserVO();
			user.setName("박길동" + i);
			user.setAge(23+i);
			user.setPhoneNum("010-1234-567"+i);
			userArray2[i] = user;
		}
		
		// 순회하는 방법
		// 1. 일반 반복문 - i를 통해 인덱스 접근하는 방법
		for(int i = 0; i< userArray2.length; i++) {
			System.out.println(userArray2[i].toString());
		}
		System.out.println("--------------------------------------------");

		
		// 2. for each문법 Ver. - i가 필요없이 순회할때
		// for(Type 변수명 : [배열이나 컬렉션]){ ..... }
		for(UserVO user : userArray2) {
			System.out.println(user.toString());
		}
		System.out.println("--------------------------------------------");
		
		
		// 3. Arrays.toString(...) + replace (가로를 세로로 늘리기 위해서)
		System.out.println(Arrays.toString(userArray2));
		System.out.println(Arrays.toString(userArray2).replace("],", "],\n"));
		System.out.println("--------------------------------------------");
	}
}







