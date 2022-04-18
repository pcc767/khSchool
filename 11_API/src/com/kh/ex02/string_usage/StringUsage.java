package com.kh.ex02.string_usage;

import java.util.StringTokenizer;

//���ڿ� API ����
public class StringUsage {
	
	public static void main(String[] args) {
		//1. equals : ���ڿ��� ���ϴ� �Լ�
		String a = "aaa";
		String b = "aaabbb";
		
		System.out.println(a.equals("aaa"));
		System.out.println(a.equals(b));
		System.out.println(a == new String("aaa"));		// ��������
		System.out.println("------------------------------------------");
		
		
		//2. contains : ���ڿ� ���Կ��θ� �˷��ִ� �Լ�
		System.out.println(a.contains("a"));
		System.out.println(a.contains("c"));
		System.out.println(a.contains(b));
		System.out.println(a.contains(a));		
		System.out.println("------------------------------------------");

		
		
		//3. compareTo : ���ڿ��� ���絵�� Ȯ���ϴ� ���
		// - ���ڰ� ũ�� Ŭ���� ���缺�� ���� ���ڿ�, 10�̸��� ��� ���絵�� ����.
		a = "Hello Java";	//2
//		b = "Hello Java!!";	//2
		b = "Hello Java World!!";	//8
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(a));		
		System.out.println("------------------------------------------");
		
		//4. concat : ���ڿ��� �����ϴ� �Լ�
		String str = "ȫ�浿";
		String str2 = "�� �ּ����� �����Դϴ�.";
		str.concat(str2);
		String str3 = str.concat(str2);
		
		System.out.println(str);		// ����
		System.out.println(str3);
		System.out.println(str+str2);	// ���� ���
		System.out.println("------------------------------------------");

		
		// String API ���� ������
		// - this(����)�� �Һ��ϴ� ��Ģ(immutable = �Һ���)
		// - �ٸ� ��ü�� ���� �޾�����Ѵ�.

		//5. charAt() : ���ڿ����� �ϳ��� ���ڸ� ��ȯ�ϴ� ���
		String temp = "abcdef";
		for (int i = 0; i < temp.length(); i++) {
			System.out.print(temp.charAt(i)+" ");
		}
		System.out.println();
		System.out.println("------------------------------------------");
		
		
		//6. indexOf : ���ڿ� ������ �Ű������� ��ġ�ϴ� ������ index�� ��ȯ�ϴ� �Լ�.
		String str4 = "�ȳ��ϼ���";
		System.out.println(str4.indexOf("��"));	//2
		System.out.println("------------------------------------------");

		str4 = "abcabcabc";
		System.out.println(str.indexOf("a"));	//0
		System.out.println(str.indexOf("bc"));	//1,  �������� ��ȯ
		System.out.println(str.indexOf("a",1));	//3,  index 1������ �˻� ����
		System.out.println(str.indexOf("a",4));	//6,  index 4������ �˻� ����
		System.out.println(str.indexOf("f"));	//-1  �����Ͱ� ������.
//		int result = str4.indexOf("f");	//���� �������� ���
		System.out.println("------------------------------------------");

		// ������
		// '�ȳ�'�̶�� ģ ���ڿ� ������ ã�� �ε����� ����ϼ���!
		String str5 = "�ȳ��ϼ���? ���� ȫ�浿�̰�, �ٽ� �ȳ��ϼ��� �ϴ� "
						+ "����� ���� �ƴϰ� �ȳ��ϼ��� ���ϰ� ���� �ʽ��ϴ�.";
		
		String tokon = "�ȳ�";		
		int count = 0;
		int startIndex = 0;
		
		while(true) {
			int result = str5.indexOf(tokon,startIndex);
			if(result < 0) {
				break;
			}
			count++;
			System.out.println("ã�� �ε��� : "+result);
			startIndex = result+ tokon.length();			
		}
		System.out.println("ã�� ���� : "+ count);
		
		
		System.out.println("------------------------------------------");
		
		// 7. lastIndexOf : ���ڿ� ã�µ�, �ڿ������� ã�´�.
		System.out.println(str5.lastIndexOf("�ȳ�"));	//40 �ڿ������� ã�´�.
		System.out.println(str5.lastIndexOf("�ȳ�",40-2));	//������ ã�� ��ġ - ���ڱ���
		System.out.println(str5.lastIndexOf("�ȳ�",40-2));
		System.out.println("------------------------------------------");

		// 8.trim ��: white space�� �����ϴ� �Լ�
		//white space?
		//��� ���� ������ �ʴ� ���ڿ� Ȥ�� ����, newline, tab, ��Ÿ ���
		final String origin 
		= " \r    �̸� : #*ȫ�浿, ���� : #*23, �ּ� : #*����� ������   \u2003\n\t";
		System.out.println(origin);
		System.out.println("------------------------------------------");
		
		//���� �����Ⱚ�� ������ white space����
		System.out.println(origin.trim());	
		// ��� white space����+�ſ� ���� �ڡڡڡڡڡڡڡ�
		System.out.println(origin.strip()); 	
		// ���ʸ� �����Ѵ�.
		System.out.println(origin.stripLeading()); 	
		// ���ʸ� �����Ѵ�.
		System.out.println(origin.stripTrailing()); 	
		// white space �߿� \t newline ���� ����Ʈ�� �츱��
		System.out.println(origin.stripIndent()); 	
		System.out.println("------------------------------------------");
		String text = origin.strip();	//strip ��õ
		System.out.println(text);
		//WEB���� ��� �Է��� ������ �ʼ������� Ȱ���. Ư�� �Խ��Ǳۿ��� ���� ��� ���.
		
		
		// 9 .subString : ���ڿ��� ���� ��ġ���� �ڸ� ��
		// ������ : ���ڿ� ���̸� �� �� �����ϸ� �״´�.
		System.out.println("------------------------------------------");
		System.out.println(text.substring(10));	//�տ��� 10���� �����
		System.out.println(text.substring(4,10));	//�տ��� 4~10����
		System.out.println(text.substring(text.length() -10, text.length()));	//�տ��� 4~10���� �����
		
		System.out.println("------------------------------------------");
		
		
		// 10. replace : ���ڿ��� ��ü(��ü)�Ҷ� ���
//		System.out.println(text.replace("#*", "")); // �ߺ��� ��� ���� �����
		System.out.println(text.replace("ȫ�浿", "���浿")); // �ߺ��� ��� ���� �����
		System.out.println("------------------------------------------");

		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; // Ư�����ڸ� �����ϴ� ���Խ� ǥ��
		System.out.println(origin.replaceAll(match, "")); // ID, PW���� Ư������ �����Ҷ� -> ���Ȼ� ó�� �ʼ�!
		System.out.println("----------------------------");
		text = text.replace("#*", "");
		
		// 11. split : ���ڿ��� Ư�� ����(Delimiter)�� �߶� ToKen���� ��ȯ�ϴ� ���.
		System.out.println("����) "+text);
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

		// 12. join() : �迭�� Ư�� ���ڿ��� �����ִ� ���
		String[] strArray2 = text.split(","); //  Delimiter = ,
		System.out.println(strArray2[0]);
		System.out.println(strArray2[1]);
		
		String temp2 = String.join("_", strArray2);
		System.out.println(temp2);
		System.out.println("-----------------------------------");
		
		
		
		// 13. StringTokenizer : Split�� ��ü����
		System.out.println(text);
		
		StringTokenizer tokens = new StringTokenizer(text,",");
		while(tokens.hasMoreElements()) { // ������ ������Ʈ�� ���� �ִ�?
			System.out.println(tokens.nextElement()); // ���� ������Ʈ��.
		}
		System.out.println("-----------------------------------");
		
		// 14. �빮�� �����ϱ� - toXXXXXCase
		System.out.println("-------------------------------------");
		String temp5 = "ABC abc AAA bbb";
		System.out.println(temp5.toUpperCase()); // �빮�� ����
		System.out.println(temp5.toLowerCase()); // �ҹ��� ����
		System.out.println("-------------------------------------");
		
		// 15. valueOf : �ٸ� �ڷ������� ��ȯ�ϱ�
		int age = 23;
		String strAge1 = "" + age; // �̰� ��õ!
		String strAge2 = String.valueOf(age);
		System.out.println(strAge1);
		System.out.println(strAge2);
		System.out.println("------------------------------------");
	
		// 16. repeat : �ݺ��ϱ�
		String repeatText = "ABC".repeat(10);
		System.out.println(repeatText);

		
		


		
		

		


		
		
		

		
		
		



		
		
		
		
		
		
		

		
		
	}
	
		
		
	

}
