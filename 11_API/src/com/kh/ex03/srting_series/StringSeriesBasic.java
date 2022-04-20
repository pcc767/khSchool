package com.kh.ex03.srting_series;

public class StringSeriesBasic {
	
	// String �ø�� ����� ��.
	
		// 1. String : ���� �⺻���� ���ڿ� Class, ���� ���� API ����, immutable(�Һ���) -> �ѹ� �������� �ٲ��� ����
		//     - ���� : ���� API �����ϰ� ���� �����ڵ� ����, Ȱ���ϱ� ����
		//     - ���� : �Һ����� ��Ģ���� ���� �޸� ������ �ʿ��ϰ�, ���ڿ� ��ĥ�� ����ӵ��� ��û ������.
		//				-> �޸� ���� �԰�, ������.
	
		// 2. StringBuffer : ���ڿ��� ���ϱ� ����� �ؽ�Ʈ ��ü, ������ ���� ���ߵ� API
		//    - Ư¡ : ������ �迭���� ���ڿ��� ����,������ ��������, Thread safe��
		//	  - ���� : ������, �޸� ���� ����. 
		//    - ���� : API ������ ����. -> String ����ؾ��� , Thread safe�Ͽ� StringBulider���� �������� ����
		
		// 3. StringBuilder : StringBuffer�� ��� ����,  Thread safe���� ���� -> �� �� ������.
	
	// String�� ���� ������ ���� -> ������ �޸� ���� ����
		// "a" + "b" + "c" + "d"    // �޸� ũ�� : 4
	 	//	1) "a" + "b" = "ab"     // �޸� ũ�� : 6
		//	2) "ab" + "c" = "abc"   // �޸� ũ�� : 9
		//	3) "abc" + "d" = "abcd" // �޸� ũ�� : 14
		
		//  String Buffer�� ���� ������ ���� -> ������ �޸� ���� ����
		// append("a") append("b")  append("c") append("d")
		//	1) "ab"     // �޸� ũ�� : 2
		//	2) "abc"    // �޸� ũ�� : 3
		//	3) "abcd"   // �޸� ũ�� : 4

	public static void main(String[] args) {
		// 0.���� �� ����ϱ�
		StringBuffer sb = new StringBuffer("�ȳ��ϼ���?"); // Buffer = �絿��/����, ���۸�, �������
		System.out.println(sb);	// toString �����ϴ� ����.
		System.out.println(sb.toString());
		
		// 1. append(�߰��ϴ�) �ڡڡڡڡڡڡڡ�
		// String str3 = str.concat(str2); String�� ����ϴ� ����� �ٸ���.
		sb.append(" ���� ȫ�浿�Դϴ�.");
		sb.append(" ������ �ݰ����ϴ�.");
		System.out.println(sb);
		
		// 2. �߰� ���Ե� �����ϴ�(��ġ ����)
//		offset = ������ �Ÿ�, ��ġ
		sb.insert(0, "����!!!");
		sb.insert(10,"@@@@@@");
		System.out.println(sb);
		
		// 3. indexof = Ž��
		int index = sb.indexOf("ȫ�浿");
		System.out.println(index);	// 0�̻��� ����.
		
		int index2 = sb.indexOf("��浿");
		System.out.println(index2);  // -1 = ã�� ����.
		
		// 4. �����ϱ�
		int index3 = sb.indexOf("ȫ�浿");
//		sb.delete(index3, index3+3);	// start, end = hard cording ����..
		sb.delete(index3, index3+ "ȫ�浿".length());	// start, end
		System.out.println("�����ϱ� : "+sb);
		
		// 4-1 ������ ���� �߰��ϱ�
		sb.insert(index3, "��浿");
		System.out.println(sb);
		
		// 4-2 ��ü(replace) �Լ� �����ϳ� �����ϱ� + �����ϱ� ������� ���
		sb.replace(index3, index3+3, "�ֱ浿");
		System.out.println(sb);
		
		// 5. �񱳿�����, ����!) �����ϸ� String���� ���� ��.
		StringBuffer sb2 = new StringBuffer("abc");
//		System.out.println(sb2.equals("abc"));	// false, �ȵǴ� ����
//		System.out.println(new StringBuffer("abc"));	// false, �ȵǴ� ����
		System.out.println(sb2.compareTo(new StringBuffer("abd")));	//�Ǵ� ����
		// compareTo : 0�̸� ����. -1 ���� ũ��, +1 �ڰ� ����.
		System.out.println(sb2.toString().equals("abc"));
		
		// 6. reverse : ������Ű��
		StringBuilder sb3 = new StringBuilder("�����ٶ󸶹ٻ�");
		System.out.println(sb3.reverse());
		
		// 7. setCharAt -> �� ���ڸ� �ٲٱ�
		sb.setCharAt(0, 'A');
		System.out.println(sb);
		
		// 8. 
		CharSequence sb5 = sb.subSequence(10, 20);
		System.out.println(sb5);
		
		
		
		
		
		
		
		
	}
	

}
