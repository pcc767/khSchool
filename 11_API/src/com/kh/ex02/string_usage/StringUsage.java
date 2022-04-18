package com.kh.ex02.string_usage;

import java.util.StringTokenizer;

//문자열 API 사용법
public class StringUsage {
	
	public static void main(String[] args) {
		//1. equals : 문자열을 비교하는 함수
		String a = "aaa";
		String b = "aaabbb";
		
		System.out.println(a.equals("aaa"));
		System.out.println(a.equals(b));
		System.out.println(a == new String("aaa"));		// 쓰지말것
		System.out.println("------------------------------------------");
		
		
		//2. contains : 문자열 포함여부를 알려주는 함수
		System.out.println(a.contains("a"));
		System.out.println(a.contains("c"));
		System.out.println(a.contains(b));
		System.out.println(a.contains(a));		
		System.out.println("------------------------------------------");

		
		
		//3. compareTo : 문자열의 유사도를 확인하는 기능
		// - 숫자가 크면 클수록 유사성이 없는 문자열, 10미만일 경우 유사도가 높다.
		a = "Hello Java";	//2
//		b = "Hello Java!!";	//2
		b = "Hello Java World!!";	//8
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(a));		
		System.out.println("------------------------------------------");
		
		//4. concat : 문자열을 결합하는 함수
		String str = "홍길동";
		String str2 = "의 주소지는 서울입니다.";
		str.concat(str2);
		String str3 = str.concat(str2);
		
		System.out.println(str);		// 주의
		System.out.println(str3);
		System.out.println(str+str2);	// 같은 기능
		System.out.println("------------------------------------------");

		
		// String API 사용시 주의점
		// - this(본인)은 불변하는 원칙(immutable = 불변성)
		// - 다른 객체로 값을 받아줘야한다.

		//5. charAt() : 문자열에서 하나의 문자만 반환하는 기능
		String temp = "abcdef";
		for (int i = 0; i < temp.length(); i++) {
			System.out.print(temp.charAt(i)+" ");
		}
		System.out.println();
		System.out.println("------------------------------------------");
		
		
		//6. indexOf : 문자열 내에서 매개변수와 일치하는 문자의 index를 반환하는 함수.
		String str4 = "안녕하세요";
		System.out.println(str4.indexOf("하"));	//2
		System.out.println("------------------------------------------");

		str4 = "abcabcabc";
		System.out.println(str.indexOf("a"));	//0
		System.out.println(str.indexOf("bc"));	//1,  시작점을 반환
		System.out.println(str.indexOf("a",1));	//3,  index 1번부터 검색 시작
		System.out.println(str.indexOf("a",4));	//6,  index 4번부터 검색 시작
		System.out.println(str.indexOf("f"));	//-1  데이터가 없을시.
//		int result = str4.indexOf("f");	//값을 가져오는 방법
		System.out.println("------------------------------------------");

		// 응용편
		// '안녕'이라고 친 문자열 개수를 찾고 인덱스를 출력하세요!
		String str5 = "안녕하세요? 저는 홍길동이고, 다시 안녕하세요 하는 "
						+ "사람은 제가 아니고 안녕하세요 말하고 있지 않습니다.";
		
		String tokon = "안녕";		
		int count = 0;
		int startIndex = 0;
		
		while(true) {
			int result = str5.indexOf(tokon,startIndex);
			if(result < 0) {
				break;
			}
			count++;
			System.out.println("찾은 인덱스 : "+result);
			startIndex = result+ tokon.length();			
		}
		System.out.println("찾은 개수 : "+ count);
		
		
		System.out.println("------------------------------------------");
		
		// 7. lastIndexOf : 문자열 찾는데, 뒤에서부터 찾는다.
		System.out.println(str5.lastIndexOf("안녕"));	//40 뒤에서부터 찾는다.
		System.out.println(str5.lastIndexOf("안녕",40-2));	//마지막 찾은 위치 - 문자길이
		System.out.println(str5.lastIndexOf("안녕",40-2));
		System.out.println("------------------------------------------");

		// 8.trim 류: white space를 제거하는 함수
		//white space?
		//사람 눈에 보이지 않는 문자열 혹은 공백, newline, tab, 기타 등등
		final String origin 
		= " \r    이름 : #*홍길동, 나이 : #*23, 주소 : #*서울시 강남구   \u2003\n\t";
		System.out.println(origin);
		System.out.println("------------------------------------------");
		
		//문자 쓰레기값을 제외한 white space제거
		System.out.println(origin.trim());	
		// 모든 white space제거+매우 빠름 ★★★★★★★★
		System.out.println(origin.strip()); 	
		// 앞쪽만 제거한다.
		System.out.println(origin.stripLeading()); 	
		// 뒤쪽만 제거한다.
		System.out.println(origin.stripTrailing()); 	
		// white space 중에 \t newline 제외 인텐트를 살릴때
		System.out.println(origin.stripIndent()); 	
		System.out.println("------------------------------------------");
		String text = origin.strip();	//strip 추천
		System.out.println(text);
		//WEB에서 모든 입력을 받을때 필수적으로 활용됨. 특히 게시판글에서 공백 지울떄 사용.
		
		
		// 9 .subString : 문자열을 정한 위치에서 자를 때
		// 주의점 : 문자열 길이를 잘 못 지정하면 죽는다.
		System.out.println("------------------------------------------");
		System.out.println(text.substring(10));	//앞에서 10글자 지우기
		System.out.println(text.substring(4,10));	//앞에서 4~10글자
		System.out.println(text.substring(text.length() -10, text.length()));	//앞에서 4~10글자 지우기
		
		System.out.println("------------------------------------------");
		
		
		// 10. replace : 문자열을 대체(교체)할때 사용
//		System.out.println(text.replace("#*", "")); // 중복된 모든 문자 지우기
		System.out.println(text.replace("홍길동", "구길동")); // 중복된 모든 문자 지우기
		System.out.println("------------------------------------------");

		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; // 특수문자를 제거하는 정규식 표현
		System.out.println(origin.replaceAll(match, "")); // ID, PW에서 특수문자 제거할때 -> 보안상 처리 필수!
		System.out.println("----------------------------");
		text = text.replace("#*", "");
		
		// 11. split : 문자열을 특성 인자(Delimiter)로 잘라서 ToKen으로 반환하는 기능.
		System.out.println("원문) "+text);
		String[] strArrays = text.split(","); // Delimiter = ','
		for (int i = 0; i < strArrays.length; i++) {
			System.out.println(strArrays[i]);
		}
		System.out.println("----------------------------");
		
		String[] outArrays = text.split(",");
		for(String s : outArrays) {
			String[] inArrays = s.split(":");
			for(String s2 : inArrays) {
				System.out.println(s2.strip());
			}		
		}
		System.out.println("----------------------------");

		// 12. join() : 배열을 특정 문자열로 합쳐주는 기능
		String[] strArray2 = text.split(","); //  Delimiter = ,
		System.out.println(strArray2[0]);
		System.out.println(strArray2[1]);
		
		String temp2 = String.join("_", strArray2);
		System.out.println(temp2);
		System.out.println("-----------------------------------");
		
		
		
		// 13. StringTokenizer : Split의 객체버전
		System.out.println(text);
		
		StringTokenizer tokens = new StringTokenizer(text,",");
		while(tokens.hasMoreElements()) { // 다음의 엘리먼트를 갖고 있니?
			System.out.println(tokens.nextElement()); // 다음 엘리먼트야.
		}
		System.out.println("-----------------------------------");
		
		// 14. 대문자 변경하기 - toXXXXXCase
		System.out.println("-------------------------------------");
		String temp5 = "ABC abc AAA bbb";
		System.out.println(temp5.toUpperCase()); // 대문자 변경
		System.out.println(temp5.toLowerCase()); // 소문자 변경
		System.out.println("-------------------------------------");
		
		// 15. valueOf : 다른 자료형으로 변환하기
		int age = 23;
		String strAge1 = "" + age; // 이거 추천!
		String strAge2 = String.valueOf(age);
		System.out.println(strAge1);
		System.out.println(strAge2);
		System.out.println("------------------------------------");
	
		// 16. repeat : 반복하기
		String repeatText = "ABC".repeat(10);
		System.out.println(repeatText);

		
		


		
		

		


		
		
		

		
		
		



		
		
		
		
		
		
		

		
		
	}
	
		
		
	

}
