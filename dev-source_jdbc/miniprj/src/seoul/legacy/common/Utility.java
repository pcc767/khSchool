package seoul.legacy.common;

import java.util.Scanner;

public class Utility {

	private static Scanner sc = new Scanner(System.in);
	private static String wrongInputMsg = "잘못 입력 하셨습니다. \n다시 입력해 주세요. : ";

	public static int scannerInt() {
		sc.reset();

		int result = 0;
		while (true) {

			String str = sc.nextLine();
			if (str == null || str.length() == 0) {
				System.out.print(wrongInputMsg);
				continue;
			}

			try {
				result = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.print(wrongInputMsg);
				continue;
			}
			break;
		}
		return result;
	}

	public static String scannerString() {
		sc.reset();

		String result = "";
		while (true) {

			result = sc.nextLine();
			if (result == null || result.length() < 1) {
				System.out.print(wrongInputMsg);
				continue;
			}
			break;
		}
		return result;

	}
}
