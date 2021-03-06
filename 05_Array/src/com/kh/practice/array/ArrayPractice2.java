package com.kh.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ArrayPractice2 {
	
	public static Scanner sc = new Scanner(System.in);
	public static Random random = new Random();
	
	public void practice1() {
		int[] arry = new int[10];
		for(int i=0; i<arry.length; i++) {
			arry[i] = i+1;
			System.out.print(arry[i]+" ");
		}
	}

	public void practice2() {
		int[] arry = new int[10];
		
		// 배열을 사용할때 i를 조작하면 안됨...
//		for(int i = arry.length; i>0; i--) {
//			System.out.print(i+" ");
//		}
		for(int i = 0; i<arry.length; i--) {
			arry[i] = 10-1;
			System.out.print(arry[i]+" ");
		}
	}
	
	public void practice3() {
		System.out.print("양의 정수 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		int[] array = new int[num]; 
		
		for(int i=0; i<array.length; i++) {
			array[i] = i+1;
			System.out.print(array[i]+" ");
		}	
		
	}
	
	public void practice4() {
		String[] strArray = new String[] {"사과","귤","포도","복숭아","참외"};
		for(int i=0; i<strArray.length; i++) {
			if(strArray[i]=="귤") {
				System.out.println("귤");
			}
		}
	}
	
	public void practice5() {
		System.out.println("문자열 : ");
		String str = sc.nextLine();
		System.out.println("문자 : ");
		char cha = sc.next().charAt(0);
		char[] array = new char[str.length()];
		int count = 0;
		
		for(int i=0; i< array.length; i++) {
			array[i] = str.charAt(i);
		}
		System.out.print(str + "에 " + cha + "가 존재하는 위치(인덱스) : ");
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == cha) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("\n"+cha+"의 개수 : "+count);

	}

	
	 public void practice6() {

	        System.out.print("0~6 사이의 숫자 입력 : ");
	        int iNum = Integer.parseInt(sc.nextLine());
	        String[] days = new String[] {"월","화","수","목","금","토","일"};

	        if(iNum > 6 || iNum < 0) {
	            System.out.println("잘 못 입력하셨습니다.");
	            return;
	        }

	        System.out.println(days[iNum]+"요일");

	    }


    public void practice7() {

        System.out.print("정수 : ");
        int iNum = Integer.parseInt(sc.nextLine());
        int[] arrayNum = new int[iNum];
        int total = 0;

        for(int i=0; i<iNum; i++) {
            System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
            arrayNum[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < iNum; i++) {
            System.out.print(arrayNum[i]+" ");
            total+=arrayNum[i];
        }
        System.out.println();
        System.out.println("총합 : "+ total);

    }

    public void practice8() {

    	//입력부
        int inputNum = 0;

        while (true) {
            System.out.print("정수 : ");
            inputNum = Integer.parseInt(sc.nextLine());

            if (inputNum % 2 == 0 || inputNum < 3) {
                System.out.println("다시 입력하세요");
                continue;
            }else {
            	break;
            }
        }
        
        //선언부
        int[] arrNum = new int[inputNum];
        int sum = 0;
        
        //계산부
        for (int i = 0; i < arrNum.length; i++) {
            if (i < inputNum / 2) {
            	arrNum[i] = i+1;
            } else {
            	arrNum[i] = inputNum - i;
            }
        }

        //출력부
        for (int i = 0; i < arrNum.length; i++) {		
    		System.out.print(arrNum[i]);
    		if(i < arrNum.length -1) {
    			System.out.print(", ");
    		}
		}
    }


    public void practice9() {

        System.out.print("치킨 이름을 입력하세요 : ");
        String str = sc.nextLine();
        String[] arrayStr = new String[] {"양념","불닭","간장"};

        int index = -1;        
        for(int i=0; i<arrayStr.length; i++) {
            if(arrayStr[i].equals(str)) {                
                index = i;
                break;
            }
        }
        
        if(index > -1) {
        	System.out.println(arrayStr[index]+"치킨 배달 가능");
        }else {
        	System.out.println(str+"치킨은 없는 메뉴입니다.");
        }
    }
    
    // 9번문제 번외.....중요
    public void practice9_2() {

        System.out.print("치킨 이름을 입력하세요 : ");
        String str = sc.nextLine();
        String[] arrayStr = new String[] {"양념","불닭","간장"};

        Arrays.sort(arrayStr);
        int index = Arrays.binarySearch(arrayStr, str);
        
        if(index > -1) {
        	System.out.println(arrayStr[index]+"치킨 배달 가능");
        }else {
        	System.out.println(str+"치킨은 없는 메뉴입니다.");
        }
    }


    public void practice10() {

        System.out.print("주민등록번호(-포함) :");
        String str = sc.nextLine();
        char[] arrayStr = new char[str.length()];
        
        for(int i = 0; i<arrayStr.length; i++) {
            arrayStr[i] = str.charAt(i);
        }

        for(int i = 0; i<arrayStr.length; i++) {
            if(i>7 ) {
                System.out.print("*");
            } else {
                System.out.print(arrayStr[i]);
            }
        }

    }


    public void practice11() {

        Random random = new Random();
        int[] arrayNum = new int[10];

        for(int i=0; i<arrayNum.length; i++) {
        	 arrayNum[i] = random.nextInt(10)+1;         
        }
        for(int i=0; i<arrayNum.length; i++)
        	System.out.print(arrayNum[i]+" ");

    }


    public void practice12() {

        int[] arrayNum = new int[10];

        for(int i=0; i<arrayNum.length; i++) {
        	 arrayNum[i] = random.nextInt(10)+1;         
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<arrayNum.length; i++) {
        	System.out.print(arrayNum[i]+" ");
        	if(min > arrayNum[i]) {
        		min = arrayNum[i];
        	}
        	if(min < arrayNum[i]) {
        		max = arrayNum[i];
        	}
        }
        System.out.println("\n"+"최대값 : "+max);
        System.out.println("최소값 : "+min);

    }

    public void practice12_2() {
    	
        int[] arrayNum = new int[10];

        for(int i=0; i<arrayNum.length; i++) {
        	 arrayNum[i] = random.nextInt(10)+1;         
        }
        int[] arrayNum2 = arrayNum.clone();
        Arrays.sort(arrayNum2);
        
        System.out.println(Arrays.toString(arrayNum));
        System.out.println("최대값 : "+arrayNum2[arrayNum2.length-1]);
        System.out.println("최소값 : "+arrayNum2[0]);

    }
    

    public void practice13() {

        Random random = new Random(System.currentTimeMillis());
        
        int[] array = new int[10];

        for(int i=0; i<array.length; i++) {
        	array[i] = random.nextInt(10)+1;
        	for (int j = 0; j < i; j++) {
				if(array[i] == array[j]) {
					i--;
					break;
				}
			}
        }
        for(int i=0; i<array.length; i++)
        	System.out.print(array[i]+" ");

    }
    
    public void practice13_2() {

        int[] array = new int[10];       
        
        for(int i=0; i<array.length; i++) {
        	array[i] = i+1;
        }

        //shuffle
        for(int i=0;i<30;i++) {
        	int random1 = random.nextInt(array.length);
        	int random2 = random.nextInt(array.length);
        	
        	int temp = array[random1];
        	array[random1] = array[random2];
        	array[random2] = temp;
        }
        
        for(int i=0; i<array.length; i++) {
        	System.out.print(array[i]+" ");
        }
       
    }
    
    public void practice13_3() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        	list.add(i+1);			
		}
        Collections.shuffle(list);
        System.out.println(list);
    }
    


    public void practice14() {

    	Random random = new Random();
        
        int[] array = new int[6];

        for(int i=0; i<array.length; i++) {
        	array[i] = random.nextInt(45)+1;
        	for (int j = 0; j < i; j++) {
				if(array[i] == array[j]) {
					i--;
					break;
				}
			}
        }
        
        Arrays.sort(array);
        
        for(int i=0; i<array.length; i++)
        	System.out.print(array[i]+" ");

    }
    
    public void practice14_2() {

    	List<Integer> list = new ArrayList<>();
    	for (int i = 0; i < 45; i++) {
			list.add(i+1);
		}
    	Collections.shuffle(list);
    	list = list.subList(0, 6);
    	Collections.sort(list);
    	System.out.println(list);

    }

    public void practice15(){

		System.out.println("문자열 : ");
		String inputStr = sc.nextLine();
		char[] strArray = new char[inputStr.length()];
		char[] pureArray = new char[inputStr.length()];
		
		for(int i = 0; i < strArray.length; i++) {
			strArray[i] = inputStr.charAt(i);
		}

		int len = 0;
		for(int i = 0; i < strArray.length; i++) {
			for(int j = 0; j < pureArray.length; j++) {
				if(pureArray[j] == strArray[i]) {
					break;
				}
				if(pureArray[j] == 0) {
					len++;
					pureArray[j] = strArray[i];
					break;
				}
			}
		}
		
		for(int i = 0; i< len; i++) {
			System.out.print(pureArray[i]);
			if(i < len -1 ) {
				System.out.print(", ");
			}
		}
	}
	
	public void practice15_2(){
		System.out.println("문자열 : ");
		String inputStr = sc.nextLine();

		Set<String> set = new TreeSet<>();
		for(int i = 0; i<inputStr.length(); i++) {
			set.add(inputStr.charAt(i) +"");
		}
		System.out.println(set);
	}
	
	
	public void practice16(){

		String[] array = null;
		int size = 0;
		int prevSize = 0;
		
		while(true) {
			if(size == 0) {
				System.out.print("배열의 크기를 입력하세요 : ");
				size = Integer.parseInt(sc.nextLine());
				array = new String[size];
			}else {
				System.out.print("더 입력하고 싶은 개수 : ");
				int inputNum = Integer.parseInt(sc.nextLine());
				String[] newArray = new String[size + inputNum];
				for(int i = 0; i<size; i++) {
					newArray[i] = array[i];
				}
				size = size + inputNum;
				array = newArray;
			}
			
			for(int i = prevSize; i<array.length; i++) {
				System.out.print((i+1) + " 번째 문자열 : ");
				String inputStr = sc.nextLine();
				array[i] = inputStr;
			}
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			String inputStr = sc.nextLine();
			if(inputStr.equals("N") || inputStr.equals("n")) {
				break;
			}
			prevSize = size;
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public void practice16_2(){
		List<String> list = new ArrayList<String>();
		int size = 0;
		int prevSize = 0;
		
		while(true) {
			if(size == 0) {
				System.out.print("배열의 크기를 입력하세요 : ");
				size = Integer.parseInt(sc.nextLine());
			}else {
				System.out.print("더 입력하고 싶은 개수 : ");
				int inputNum = Integer.parseInt(sc.nextLine());
				size = size + inputNum;
			}
			
			for(int i = prevSize; i<size; i++) {
				System.out.print((i+1) + " 번째 문자열 : ");
				String inputStr = sc.nextLine();
				list.add(inputStr);
			}
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			String inputStr = sc.nextLine();
			if(inputStr.equals("N") || inputStr.equals("n")) {
				break;
			}
			prevSize = size;
		}
		
		System.out.println(list);
	}

    
    
    



}

