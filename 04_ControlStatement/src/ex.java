import java.util.Scanner;

public class ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("비밀번호 입력(1000~9999) : ");
//		int iNum = Integer.parseInt(sc.nextLine());
		String iNum = sc.nextLine();
		
		if(iNum.length() > 4) {
			System.out.println("자리수 안맞음.");
		} else if(iNum.contains(iNum)==true) {
			System.out.println("중복값 있음.");
		} else  {
			System.out.println("성공");
		}
	}

}
