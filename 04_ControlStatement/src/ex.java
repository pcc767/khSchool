import java.util.Scanner;

public class ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��й�ȣ �Է�(1000~9999) : ");
//		int iNum = Integer.parseInt(sc.nextLine());
		String iNum = sc.nextLine();
		
		if(iNum.length() > 4) {
			System.out.println("�ڸ��� �ȸ���.");
		} else if(iNum.contains(iNum)==true) {
			System.out.println("�ߺ��� ����.");
		} else  {
			System.out.println("����");
		}
	}

}
