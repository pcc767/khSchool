// 패키지명 : 폴더 구분 또는 소스 코드 그룹핑하기 위해서
package com.kh;

// 외부에 있는 패키지를 가져올때 사용하는 문법 
// F3을 누르면 안에 코드를 볼수 있다.
import java.util.Date;

// 실행법 2가지
// 1. 재생버튼 누른다.
// 2. Ctrl + F11 (실행) / F11 (디버깅) 

// ctrl + s : 코드 저장하기. -> 프로그래머라면 한줄 치면 저장...
//  -> 하지 않은 경우 프로젝파일 이름 왼쪽에 '*'이 보인다.

// 주석 다는법 
// 1. '//' 통해서 주석을 단다. -> 한줄만
// 2. /* */을 통해서 주석을 다는데, ** 안에는 모든 내용이 주석
// 3. 이클립스 주석 다는 법 : Ctrl + / -> shift로 선택된 범위가 모두 주석처리 됨
// 주석이란? 
// - 실제 프로그램에 영향을 주지 않는 코드

// Class라 부르는데, public class의 경우 파일이름과 클래스이름이 일치해야한다.
// -> 일치하지 않으면 에러 발생
public class MyFirstClass {
	// 이름을 바꾸기 위해선 -> alt + shift + r

	// main : 프로그램의 시작 경로
	// ※ 주의사항 : main은 반드시 'public static void main(String[] args)'여야 한다.
	// 2개 있어도 안된다.
	// 'main'을 입력하고 Ctrl + space 자동완성이 가능하다.
	public static void main(String[] args) {
		// print 함수 : 문자열을 화면(콘솔)으로 출력하는 함수
		// 'sysout'을 통해 자동완성이 가능한다.
		System.out.println("Hello Java!"); // println -> 문장열을 출력하고 line을 띈다.
		System.out.print("Hello Java!"); // print -> 문자열만 출력한다.
		System.out.println("Hello Java!");

		
//		오류 고치는 방법
//		1. 마우스를 에러(빨간줄) 위에 놓고 이클립스의 도움을 받는다.
// 		2. 자동 임포트 기능 활용 : ctrl + shift + o
		System.out.println(new Date());
		
		// 들여쓰기 중요하다.
		// -> java 문법적으로 들여쓰기가 필요없다. 다만 가독성을 위해 반드시 지켜야하는 암묵적 룰!
		// 들여쓰기는 이크립스 기준으로 탭(\t)을 활용

		// Intent : 라인 들여쓰기. 저는 가장 중요하게 여긴다. tab 사용
		// Format : 띄여쓰기 ' '
		// ctrl + A : 모든 라인 선택
		// ctrl + i : 자동 들여쓰기
		// ctrl + shift + f : format 정렬
		// ctrl + z : 되돌리기
		// ctrl + y : 다시 실행하기
		// ctrl + d : 선택된 라인지우기
		// alt + ↑ : 선택된 라인 위로 옮기기
		// alt + ↓ : 선택된 라인 아래로로 옮기기
		// ctrl + alt + ↑ : 선택된 라인 위로 복사하기
		// ctrl + alt + ↓ : 선택된 라인 아래로 복사하기
		
	}
}
