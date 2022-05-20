package com.kh.ex01.basic;

//Java�� �߸�� ����

//1. C��� �迭�� ������(��)�� �ع�.
//- ���α׷��� �����Ű�� ���ؼ� ���������� �ʿ��ѵ�, �̸� ����� �۾��� �ſ� �������.
//- �ҽ��ڵ� -> ������ -> exe(������ ���� ����), 'test'(������ �迭 �������� = Ȯ���� ����)
//- ���� �迭 CPU / AMD �迭 CPU / CPU ���� �� -> ���α׷��� ���鶧�� ���� �������� �ʿ�.
// �ҽ� �ڵ带 �ּ� 5�� �̻� �������� �ؼ� ���������� ���� �ʿ��ϴ�.
// ���� ���α׷��� ��� -> ���� ������ �� ȣȯ�� �׽�Ʈ ���� �ʿ��ߴ�.
//- ���� ������ ����ȭ�� ������ ���ߴ�.

//- JVM = ������� ������ �۾��� ������.
//-> ����Ŭ���� JVM�� OS �Ǵ� CPU �迭���� �������Ͽ� �������ϸ�, �����(������)�� ���̻� ������ ���� �ʾƵ� ��.
//   �ڡڡڡڡ� �������ѵ��� �ζ� 1�� �°� ���� ���� �ͺ��� ������ ���ϴ°� ���Ҵ�...(?)
//.class��� ������ ����� -> JVM���� ������ ���ӽ���. -> ���α׷��� �����.
//-> ũ�ν� �÷��� �ô밡 �������.

//Java ����? (���� ����)
//- �ڵ带 ��� ó�� ���� �����ϴ� ���.

//2. ���� ���ó�� �ڵ带 �����ϴ� ����(�з�����)������ ��ȯ�� ��������!
//- ���� ���(C��� �迭)�� �Ұ�����. 
//-> ���� : ��� ���α׷��� main���κ��� �����Ǿ���ߴ�. -> exe

//- �ڹٿ��� Class��? main�� ���ԵǾ� ���� �ʰ�, �ٸ� ���α׷�(JVM)���� ��� ȣ���Ҽ� �ִ�
//���̹�=(class �̸�)�� ���ٹ��(����������, ������)�� ǥ��ȭ�� ����.

//- �ٸ� ���α׷��� JVM�� �پ��� �����ӿ�ũ �Ǵ� ������ �ȴ�.
//- ������ ���α׷����� �� main�� ���� ���� -> �ٸ� �����ӿ�ũ���� ��� �����ؼ� �츮�� Ŭ������ ȣ��
//
//3. ��ũ��Ʈ��� + ���������� ����� ������ �ʿ�
//- �������� ���� �ʰ� ���� �� �о� ��� �����ϴ� ����
//-> �ҽ� �ڵ� ������ �ǽð����� ���� ������ �ݿ���ų�� ����.

//class ���� : �ܺο��� ȣ��� �츮 Ŭ������ �̸�
//���� ������ : �ܺη� ���� �츮�� ���α׷��� ��ȣ�ų� ���ٰ��ɰԲ� ������ִ� Ű����
//       ex) public=���������� private=��������
//�޼ҵ� : �ܺο��� �츮�� ������ ȣ���ϴ� ��ɾ�.
//    www.naver.com/test.do -> ȣ��Ǹ� ������ ������ ȸ���ؼ� ��������

//�� ���� ���� �߿��� ����
//1. ��ӿ� ���õ� ���� -> �Ϻ��� ������ �ʿ� -> Servlet ��� Ŭ�������� ��ӹ���
//2. �÷��� 
//3. IO Stream
//4. ����ó�� ����

// Class�� �̸���? - �ܺο��� �ҷ����� ������� Class�� �̸�
public class JavaSumary {
	// �ܺ� ����
	// �����δ� �츮�� main ������ ���� ��
	// �ܺ� �����ӿ�ũ(����, ������)���� �츮�� ������ Ư�� Class�� ȣ���Ѵٴ� ������ ���α׷� ����
	//  -> �츮�� �������ϴ� Class�� �̸�, ���̸� �����ϰ� ����Ҽ� �ִ� Class�� ���� ����
	public static void main(String[] args) {
		UserInputInterface userClass = new UserClass();
		// �̹� �����ӿ�ũ���� ���ǵ� �ڵ�
		userClass.setName("ȫ�浿");
		userClass.setAge(31);
		System.out.println(userClass.print());
		
		UserInputAbstractClass userClass2 = new UserClassV2();
		// �̹� �����ӿ�ũ���� ���ǵ� �ڵ�
		userClass2.setName("�ֱ浿");
		userClass2.setAge(23);
		System.out.println(userClass2.print());
	}
}

// ����ڿ��� �����ӿ�ũ�� �����Ҷ� ���ѵ� ���踦 �����Ͽ� ǥ������ �������̽��� ����� �����ִ� ����
interface UserInputInterface {
	void setName(String name);
	void setAge(int age);
	String print();
}


//����ڿ��� ǥ������ ���� �Ӹ� �ƴϰ� �Ϻ� �ڵ带 ��� �ۼ��Ͽ� ����/���뼺�� �����ٶ� ���
abstract class UserInputAbstractClass implements UserInputInterface{
	protected String name;
	protected String age;
	
	public void setAge(int age) {
		this.age = ""+age;
	}
	public void setName(String name) {
		this.name = name;
	}
	abstract public String print();
}


// ����� = �츮�� ���� Ŭ����
class UserClass implements UserInputInterface{
	String name;
	String age;
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setAge(int age) {
		this.age = ""+age;
	}
	
	@Override
	public String print() {
		return "�̸� : " + name +", ���� : " + age;
	}
}


class UserClassV2 extends UserInputAbstractClass{

	@Override
	public String print() {
		return "�̸��� " + name +" ���̴�" + age+"�δ�.";
	}
}


