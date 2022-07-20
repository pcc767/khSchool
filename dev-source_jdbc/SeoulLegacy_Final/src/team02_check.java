import java.util.Scanner;

public class team02_check {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		team02_check ch = new team02_check();
		ch.hosRegionMenu();
		
	}
	
	String Recode = "";
	private void hosRegionMenu() {
		Recode = regionSearch();
		System.out.println(Recode+" 된다.");
	}
	
	public String regionSearch() {
		String RegionCategory[] = {"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구"
				, "금천구", "노원구", "동봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구"
				, "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"
		};
		System.out.println("----------------------------------------------------------");
		for(int i = 0; i<RegionCategory.length; i++) {
			System.out.print((i+1)+". "+ RegionCategory[i]);
			if(i%2 == 0) {
				if(i>9) {
					System.out.print("\t\t");
					continue;
				}
				System.out.print("\t\t\t");
			}else {
				System.out.print("\n");
			}
		}
		
		System.out.println("\n검색할 위치 : ");
		int choNum = Integer.parseInt(sc.nextLine());
		
		return Recode = RegionCategory[choNum-1];
		
	}

}
