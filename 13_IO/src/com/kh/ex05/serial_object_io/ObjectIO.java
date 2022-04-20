package com.kh.ex05.serial_object_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class ObjectIO {
	
	// ��ü ������ IO �ϴ� ��
	
	public static boolean saveObject(File file, Object obj) {
		
		try (
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
			){
			
			oos.writeObject(obj);			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public static Object loadObject(File file) {
		
		try(
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);			
				
			){
			
			return ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		UserVO user = new UserVO("test", "ȫ�浿", 23, "010-3131-3333");
		File file = new File("./objInfo");
		
		boolean result = ObjectIO.saveObject(file, user); // ����ȭ
		System.out.println("result : " + result);
		// ���� �Ϸ�
		
		// �о� ����
		UserVO user2 = (UserVO) ObjectIO.loadObject(file); // ������ȭ
		System.out.println("user1 : " + user.toString());
		System.out.println("user2 : " + user2.toString());
		System.out.println(user.equals(user2));				// �׳� �ϸ� ���� �ʴٰ� ����.
		//equals�� �������̵�(������) �ʿ�  -> �ݵ�� ��Ŭ���� �ڵ��ϼ� ������� �ؾ���.!!!!!
		//�������̽� ������ ���Ѵٸ�(implements Serializable�� ���ٸ�) �����߻�.����ȭ ���� ���� ��ü ����
		
	}
	
	
	// ��ü �迭 ������ R/W �ϱ�
		public static void main222222(String[] args) {
			UserVO user1 = new UserVO("test1", "ȫ�浿3", 23, "010-3131-3333");
			UserVO user2 = new UserVO("test2", "ȫ�浿2", 33, "010-3131-3333");
			UserVO user3 = new UserVO("test3", "ȫ�浿3", 43, "010-3131-3333");
			UserVO user4 = new UserVO("test4", "ȫ�浿4", 53, "010-3131-3333");
			
			UserVO[] userArray = new UserVO[4];
			userArray[0] = user1; 
			userArray[1] = user2; 
			userArray[2] = user3; 
			userArray[3] = user4; 
			
			File file = new File("./objInfo");
			boolean result = ObjectIO.saveObject(file, userArray); // ����ȭ
			System.out.println("result : " + result);
			// ���� �Ϸ�
			
			// �о� ����
			UserVO[] userArray2 =(UserVO[]) ObjectIO.loadObject(file); // ������ȭ
			
			System.out.println("user1 : " + Arrays.toString(userArray));
			System.out.println("user2 : " + Arrays.toString(userArray2));
		}




}
