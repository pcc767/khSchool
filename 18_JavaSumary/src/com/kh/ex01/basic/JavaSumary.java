package com.kh.ex01.basic;

//Java가 발명된 이유

//1. C언어 계열의 컴파일(러)의 해방.
//- 프로그램을 실행시키기 위해선 실행파일이 필요한데, 이를 만드는 작업이 매우 어려웠다.
//- 소스코드 -> 컴파일 -> exe(윈도우 실행 파일), 'test'(리눅스 계열 실행파일 = 확장자 없음)
//- 인텔 계열 CPU / AMD 계열 CPU / CPU 세대 별 -> 프로그램을 만들때는 따로 컴파일이 필요.
// 소스 코드를 최소 5번 이상 컴파일을 해서 실행파일의 배포 필요하다.
// 서버 프로그램인 경우 -> 각자 컴파일 및 호환성 테스트 까지 필요했다.
//- 과거 컴파일 파편화가 굉장히 심했다.

//- JVM = 사용자의 컴파일 작업을 없애줌.
//-> 오라클에서 JVM을 OS 또는 CPU 계열마다 컴파일하여 배포만하면, 사용자(개발자)는 더이상 컴파일 하지 않아도 됨.
//   ★★★★★ 개발자한데는 로또 1등 맞고 집에 가는 것보다 컴파일 안하는게 좋았다...(?)
//.class라는 파일을 만들고 -> JVM에게 실행을 위임시켜. -> 프로그램이 실행됨.
//-> 크로스 플랫폼 시대가 개막됬다.

//Java 언어란? (강사 버전)
//- 코드를 블록 처럼 만들어서 조립하는 언어.

//2. 레고 블록처럼 코드를 조립하는 개념(패러다임)으로의 전환이 가능해짐!
//- 기존 언어(C언어 계열)은 불가능함. 
//-> 이유 : 모든 프로그램이 main으로부터 구현되어야했다. -> exe

//- 자바에서 Class란? main이 포함되어 있지 않고, 다른 프로그램(JVM)에서 즉시 호출할수 있는
//네이밍=(class 이름)과 접근방법(접근제한자, 생성자)을 표준화한 개념.

//- 다른 프로그램은 JVM과 다양한 프레임워크 또는 도구가 된다.
//- 앞으로 프로그래밍할 때 main을 보지 못함 -> 다른 프레임워크에서 대신 실행해서 우리의 클래스를 호출
//
//3. 스크립트언어 + 인터프리터 언어의 개념이 필요
//- 컴파일을 하지 않고 한줄 씩 읽어 즉시 실행하는 개념
//-> 소스 코드 변경을 실시간으로 서버 로직에 반영시킬수 있음.

//class 네임 : 외부에서 호출될 우리 클래스의 이름
//접근 제한자 : 외부로 부터 우리의 프로그램을 보호거나 접근가능게끔 허용해주는 키워드
//       ex) public=누구나접근 private=나만쓸꺼
//메소드 : 외부에서 우리의 로직을 호출하는 명령어.
//    www.naver.com/test.do -> 호출되면 응답할 내용을 회신해서 만들어야함

//■ 이제 부터 중요한 문법
//1. 상속에 관련된 문법 -> 완벽히 마스터 필요 -> Servlet 모든 클래스에서 상속받음
//2. 컬랙션 
//3. IO Stream
//4. 예외처리 문법

// Class의 이름은? - 외부에서 불러들일 사용자의 Class의 이름
public class JavaSumary {
	// 외부 영역
	// 앞으로는 우리가 main 볼일이 없을 것
	// 외부 프레임워크(서블릿, 스프링)에서 우리가 정의한 특정 Class를 호출한다는 전제로 프로그램 예시
	//  -> 우리가 만들어야하는 Class는 이름, 나이를 정의하고 출력할수 있는 Class를 만들 예정
	public static void main(String[] args) {
		UserInputInterface userClass = new UserClass();
		// 이미 프레임워크에서 정의된 코드
		userClass.setName("홍길동");
		userClass.setAge(31);
		System.out.println(userClass.print());
		
		UserInputAbstractClass userClass2 = new UserClassV2();
		// 이미 프레임워크에서 정의된 코드
		userClass2.setName("최길동");
		userClass2.setAge(23);
		System.out.println(userClass2.print());
	}
}

// 사용자에게 프레임워크를 제공할때 제한된 설계를 강요하여 표준적인 인터페이스를 만들게 도와주는 문법
interface UserInputInterface {
	void setName(String name);
	void setAge(int age);
	String print();
}


//사용자에게 표준적인 설계 뿐만 아니고 일부 코드를 대신 작성하여 편리성/재사용성을 높여줄때 사용
abstract class UserInputAbstractClass implements UserInputInterface{
	protected String name;
	protected String age;
	
	public void setAge(int age) {
		this.age = ""+age;
	}
	public void setName(String name) {
		this.name = name;
	}
	abstract public String print();
}


// 사용자 = 우리가 만들 클래스
class UserClass implements UserInputInterface{
	String name;
	String age;
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setAge(int age) {
		this.age = ""+age;
	}
	
	@Override
	public String print() {
		return "이름 : " + name +", 나이 : " + age;
	}
}


class UserClassV2 extends UserInputAbstractClass{

	@Override
	public String print() {
		return "이름은 " + name +" 나이는" + age+"로다.";
	}
}


