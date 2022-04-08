package com.kh.ex03.branch;

public class BranchStatement1 {
	
	// 분기문 2가지
	// continue : 반복문에 흐름을 스킵하는 문장(단, 반복문은 끝나지 않고 다음 스텝으로 넘어감)
	// break    : 반복문을 벗어나는 문장(끝나는 문장)
	
	// 반복문 분기를 종료시키는 2가지 방법
	// break  : 반복문 종료. -> 반복문은 끝나지만 반복문 아래코드는 계속 실행
	// return : 반복문이 포함된 함수를 종료하는 문장.  -> 함수 자체가 종료.
	// System.exit(0) : 프로그램 종료
	
	public static void main(String[] args) {
		// 짝수가 아닌 31의 배수를 찾아본다. 1 ~ 1000
		// 갯수도 세본다. 10개만 찾고 끝낸다.
		
		// 프로그래머의 상식중 시작 숫자는? 답 = 0
		// 메모리나 자원에서 0번지를 사용해서 자원을 더 많이 사용하기 위해서!

		int count = 0;
		for(int i=1; i<=1000; i++ ) {
			// --------------- ★★ continue 활용 중요 ★★ ------------------
			if(i%2 == 0) {	//짝수이면
				continue;	// 아래의 문장을 실행하지 않고 'i++' 자리로 이동!!				
			}
			// --------------------------------------------------------
			if(i%31 == 0) {
				System.out.println(i);
				count++;
				if(count == 10) {
					break;		// 반복문을 종료하는 키워드
//					return;		// 그자리에서 함수를 끝내는 키워드  -> 아래 count가 보이지 않는다.!
				}
			}			
		}
		System.out.println("count : "+count);
	}

}
