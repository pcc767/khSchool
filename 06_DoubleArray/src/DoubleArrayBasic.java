import java.util.Arrays;

public class DoubleArrayBasic {
	public static void main(String[] args) {
		// 1. 가장 기본적인 2차원 배열 활용법
		int[][] array1 = new int[10][10];		// 10x10 = 100개의 int 공간 생성
		
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[i].length;j++) {
				array1[i][j] = i*10+j;		// 0~99까지 선언
				System.out.print(array1[i][j]+" ");		
			}
			System.out.println();
		}
		
		for(int i=0; i<array1.length; i++) {
			for(int j=0; j<array1[i].length;j++) {
				array1[i][j] = i*10+j;		// 0~99까지 선언
				System.out.print(array1[j][i]+" ");		//행렬을 ji로 출력
			}
			System.out.println();
		}
		
		
		//2. 2차원 가변형 배열 활용법  -> 현업에서 사용
		int[][] array2 = new int[10][]; 	//2차원 배열에서 크기가 선언되지 않은 상태!!
		System.out.println(Arrays.toString(array2));
		
		for(int i=0; i< array2.length; i++) {
			array2[i] = new int[i+1];	// [i+1]을 하는 이유 : for문의 1-10까지의 반복
			for(int j=0; j<array2[i].length; j++) {
				array2[i][j] = i*10+j;
				System.out.print(array2[i][j]+" ");
			}
			System.out.println();
		}
		
		// java.lang.NullPointerException : 객체가 생성되지 않은 null 상태에서 객체로 접근했을때 나오는 에러
		
		
		//3. 2차원 배열 초기화 + 생성
		int[][] array3 = {{1,2,3,4},{2,4},{4,3,2,1}};
		int[][] array4 = new int[][]{{1,2,3,4},{2,4},{4,3,2,1}};
		int[][] array5 = new int[][]{new int[]{1,2,3,4},new int[]{2,4},new int[]{4,3,2,1}};
		
		
		for(int i=0; i<array3.length; i++) {
			for(int j=0; j<array3[i].length; j++) {
				System.out.print(array3[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
