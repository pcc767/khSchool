
public class UserVO {
	// �̸�, ����, ��ȭ��ȣ 3���� ����� ������ ��� ��ü�� ���� = VO, ���� ó���ϴ� �뵵
	// �⺻ ������, 3���� ���ڸ� ��� ������, getter/setter, toString.
	
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
