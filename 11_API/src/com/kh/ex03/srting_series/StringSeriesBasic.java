package com.kh.ex03.srting_series;

public class StringSeriesBasic {
	
	// String 시리즈간 장단점 비교.
	
		// 1. String : 가장 기본적인 문자열 Class, 가장 많은 API 보유, immutable(불변성) -> 한번 정해지면 바뀌지 않음
		//     - 장점 : 많은 API 제공하고 전용 연산자도 제공, 활용하기 좋음
		//     - 단점 : 불변성의 원칙으로 인해 메모리 관리가 필요하고, 문자열 합칠때 연산속도가 엄청 느리다.
		//				-> 메모리 많이 먹고, 느리다.
	
		// 2. StringBuffer : 문자열에 더하기 연산과 텍스트 교체, 삭제를 위해 개발된 API
		//    - 특징 : 가변성 배열통해 문자열을 삽입,삭제가 자율적임, Thread safe함
		//	  - 장점 : 빠르고, 메모리 낭비가 없다. 
		//    - 단점 : API 지원이 적다. -> String 사용해야함 , Thread safe하여 StringBulider보다 아주조금 느림
		
		// 3. StringBuilder : StringBuffer와 기능 동일,  Thread safe하지 않음 -> 좀 더 빠르다.
	
	// String의 덧샘 연산의 예시 -> 느리고 메모리 낭비 심함
		// "a" + "b" + "c" + "d"    // 메모리 크기 : 4
	 	//	1) "a" + "b" = "ab"     // 메모리 크기 : 6
		//	2) "ab" + "c" = "abc"   // 메모리 크기 : 9
		//	3) "abc" + "d" = "abcd" // 메모리 크기 : 14
		
		//  String Buffer의 덧샘 연산의 예시 -> 빠르고 메모리 낭비 적음
		// append("a") append("b")  append("c") append("d")
		//	1) "ab"     // 메모리 크기 : 2
		//	2) "abc"    // 메모리 크기 : 3
		//	3) "abcd"   // 메모리 크기 : 4

	public static void main(String[] args) {
		// 0.선언 및 출력하기
		StringBuffer sb = new StringBuffer("안녕하세요?"); // Buffer = 양동이/공간, 버퍼링, 예비공간
		System.out.println(sb);	// toString 생략하는 문법.
		System.out.println(sb.toString());
		
		// 1. append(추가하다) ★★★★★★★★
		// String str3 = str.concat(str2); String과 사용하는 방법이 다르다.
		sb.append(" 저는 홍길동입니다.");
		sb.append(" 만나서 반갑습니다.");
		System.out.println(sb);
		
		// 2. 중간 삽입도 가능하다(위치 지정)
//		offset = 떨어진 거리, 위치
		sb.insert(0, "하이!!!");
		sb.insert(10,"@@@@@@");
		System.out.println(sb);
		
		// 3. indexof = 탐색
		int index = sb.indexOf("홍길동");
		System.out.println(index);	// 0이상은 있음.
		
		int index2 = sb.indexOf("김길동");
		System.out.println(index2);  // -1 = 찾지 못함.
		
		// 4. 삭제하기
		int index3 = sb.indexOf("홍길동");
//		sb.delete(index3, index3+3);	// start, end = hard cording 버전..
		sb.delete(index3, index3+ "홍길동".length());	// start, end
		System.out.println("삭제하기 : "+sb);
		
		// 4-1 삭제한 곳에 추가하기
		sb.insert(index3, "김길동");
		System.out.println(sb);
		
		// 4-2 교체(replace) 함수 존재하나 삭제하기 + 삽입하기 기능임을 명시
		sb.replace(index3, index3+3, "최길동");
		System.out.println(sb);
		
		// 5. 비교연산자, 주의!) 가능하면 String으로 비교할 것.
		StringBuffer sb2 = new StringBuffer("abc");
//		System.out.println(sb2.equals("abc"));	// false, 안되는 문법
//		System.out.println(new StringBuffer("abc"));	// false, 안되는 문법
		System.out.println(sb2.compareTo(new StringBuffer("abd")));	//되는 문법
		// compareTo : 0이면 같음. -1 앞이 크고, +1 뒤가 작음.
		System.out.println(sb2.toString().equals("abc"));
		
		// 6. reverse : 반전시키기
		StringBuilder sb3 = new StringBuilder("가나다라마바사");
		System.out.println(sb3.reverse());
		
		// 7. setCharAt -> 한 글자만 바꾸기
		sb.setCharAt(0, 'A');
		System.out.println(sb);
		
		// 8. 
		CharSequence sb5 = sb.subSequence(10, 20);
		System.out.println(sb5);
		
		
		
		
		
		
		
		
	}
	

}
