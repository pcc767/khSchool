
public class UserVO {
	// 이름, 나이, 전화번호 3개의 사용자 정보를 담는 객체를 생성 = VO, 값을 처리하는 용도
	// 기본 생성자, 3개의 인자를 담는 생성자, getter/setter, toString.
	
	private String name;
	private int age;
	private String phoneNum;
	
	
	// alt+shift+s
		// Generate xx
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String name, int age, String phoneNum) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return "UserVO [name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

	
	
	
	
	
	
	

}
