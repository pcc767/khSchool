package home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap.KeySetView;



// �ڡڡڡڹݵ�� @author���� ���� ���� �ڵ� �ĺ��ϰԲ� �ۼ� �ٶ��ϴ�.
/**
 * @author ª���ٸ�.
 *
 */
public class codeChallenge_2_OOP {

	// �ڡڡڡڹݵ�� @author���� ���� ���� �ڵ� �ĺ��ϰԲ� �ۼ� �ٶ��ϴ�.
	    /**
	     * @author ª���ٸ�
	     *
	     */

	    public static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        // 1. non public class - User �����ϱ�
	        // User��� ��ü �����ϼ���. id, pw, name, age�� �����ϴ� ��ü �����ϱ�
	        //  -> ��ü ����� �ش� �ڵ� ���� �Ʒ��� �����ϼ���. // �̸� Ʋ ��������ϴ�.

	        // ���� 1.private�� ������� �����ϰ�, getter, setter �����ϱ�.
	        // ���� 2.�����ڴ� �⺻���� 4���� ���� ��� �ʱ�ȭ�ϴ� ��ü �����ϱ�
	        // ���� 3.toString ����ϱ�

	        // 2. ��ü �����ϰ� ����ϱ�
	        // ���� �ٸ� 2���� instance(��ü)�� �����غ�����.
	        // �⺻ ������ ���� 4���� ���� �ʱ�ȭ �ϴ� �����ڷ� �����ϼ���.
	        // ������ ���� sysout���� ������ּ���.

	        // 3. ��ü �迭 ����ϱ�
	        // ID, �̸� ��� �ٸ� ����ڸ� 10���� �����Ͽ� �迭�� �������ּ���.
	        // ���̴� 2�� �ٸ��� �������ּ���. (ȫ�浿1 - 20, ȫ�浿2 - 20  ȫ�浿3 - 25 ... )
	        // �׸��� �迭�� ��ȸ�Ͽ� 10�� ��� ����ϼ���.

	        class User implements Serializable {

	            @Serial
	            private static final long serialVersionUID = 1L;
	            private String id;
	            private String pw;
	            private String name;
	            private int age;

	            public User(){}

	            public User(String id, String pw, String name, int age){
	                this.id = id;
	                this.pw = pw;
	                this.name = name;
	                this.age = age;
	            }

	            public String getId(){
	                return id;
	            }

	            public void setId(String id){
	                this.id = id;
	            }

	            public String getPw() {
	                return pw;
	            }

	            public void setPw(String pw) {
	                this.pw = pw;
	            }

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

	            @Override
	            public String toString() {
	                return "User{" +
	                        "id='" + id + '\'' +
	                        ", pw='" + pw + '\'' +
	                        ", name='" + name + '\'' +
	                        ", age=" + age +
	                        '}';
	            }

	           
	        }

	        User[] userArray = new User[]{
	                new User("test1","1234","ȫ�浿",20),
	                new User("test2","1244","�ڱ浿",30),
	                new User("test3","1333","��浿",33),
	                new User("test4","1678","���浿",22),
	                new User("test5","1232","�ֱ浿",24),
	                new User("test6","1124","��浿",27),
	                new User("test7","1754","���浿",35),
	                new User("test8","1093","���浿",36),
	                new User("test9","1200","�α浿",29),
	                new User("test10","1229","���浿",31),
	        };

	        // 4. ��ü �迭 ��ȸ�ϱ�
	        // ID/PW�� �Է¹ް�, 10���� ������ �� �����ϴ��� ID�� Ȯ���ϰ�, �α��� �������� Ȯ�����ּ���.
//	        System.out.print("������ ID : ");
//	        String id = sc.nextLine();
//	        System.out.print("������ PW : ");
//	        String pw = sc.nextLine();
	//
//	        for(int i=0; i<userArray.length; i++){
//	            if(userArray[i].getId().equals(id)){
//	                System.out.println("�����ϴ� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
//	                return;
//	            }
//	            System.out.println("������ ���̵��Դϴ�.");
//	        }

	        // 5. ��ü �迭 �����ϱ�
	        // ID�� �̸��� �Է¹ް� ID�� �����ϸ� �̸��� ������ �ݴϴ�.
//	        System.out.print("������ ID : ");
//	        String id = sc.nextLine();
//	        System.out.print("������ �̸� : ");
//	        String name = sc.nextLine();
	//
//	        for(int i=0; i<userArray.length; i++){
//	            if(userArray[i].getId().equals(id)){
//	                System.out.print("������ �̸� : ");
//	                String newName = sc.nextLine();
//	                return;
//	            }
//	        }

//	        6.

	        // 7. List �迭�� �����ϰ� �ռ� ���� �迭�� �ʱ�ȭ ���ּ���.
//	        ArrayList<User> list = new ArrayList<>(Arrays.asList(userArray));
	        ArrayList<User> list = new ArrayList<>();
	        for(User user : userArray){
	            list.add(user);
	        }
	        System.out.println(list);

//	         8. List�� ���ο� ���̵� 10���� �� �߰��ϼ���. �� ID�� �ߺ����� �ʽ��ϴ�.
	        for(int i=0; i<10; i++){
	            list.add(new User("test"+(11+i),"495"+(7+i),"ȫ�浿"+(1+i),28+i));
	        }
	        System.out.println(list);

	        // 9. ������ ID �ϳ��� Ž���ϼ���.
	        // 10. Ž���� ID�� ���켼��.

	        Random random = new Random();
	        random.setSeed(System.currentTimeMillis());

	        User ranNum = list.get(random.nextInt(10));
	        System.out.println(ranNum);     //�������
	        list.remove(ranNum);
	        System.out.println(ranNum);     //������


	        // 11. �� �տ� ���ο� ID�� �����ؼ� ��������.
	        list.add(0,new User("test0","test00", "�ű浿", 39));

	        // 12. List�� ������ �������� ��������. Hint : Collections Ȱ��
	        Collections.shuffle(list);

	        // 13. ��ü�� Comparable�� �����Ͽ� ID �������� �����ϼ���.
	        list.sort(new Comparator<User>() {
	            @Override
	            public int compare(User o1, User o2) {
	                return o1.getId().compareTo(o2.getId());
	            }
	        });

	        // 14. ��ü�� Comparator�� �͸� Ŭ���� �����Ͽ� ����-�̸� �� �����ϼ���.
	        list.sort(new Comparator<User>() {
	            @Override
	            public int compare(User o1, User o2) {
	                int result = Integer.compare(o1.getAge(), o2.getAge());
	                if(result == 0){
	                    result = o1.getName().compareTo(o2.getName());
	                }
	                return result;
	            }
	        });

	        // 15. List ���� �ٽ� �����ϰ�, ���� ����Ʈ �����͸� 2�� �ݺ��ؼ� �Է��ϼ���.
	        //     (2���� �Է��Ͽ� �ߺ��� ������ּ���!)

	        ArrayList<User> newList = new ArrayList<>();

	        for(int i=0; i<2; i++){
	            newList.addAll(list);
	        }
	        System.out.println(newList);

	        // 16. ID�� �ߺ��� �����ϴ� List�� Set�� ���� �����ϰ�, �ٽ� ID ������ �����ϼ���.
//	        Set<User> treeSet = new TreeSet<>();
//	
//	        treeSet.addAll(newList);
//	
//	        List<User> list_1 = new ArrayList<>(treeSet);
//	        Collections.shuffle(list_1);
//	
//	        System.out.println("Ȯ��");
//	        System.out.println(list_1);

	        // 17. List�� ���� Ž���� ���� Map�� �����ϼ���. Map�� Key��ID , Value�� User�� �����ϼ���.
	        // 18. Map�� List�� �־��ּ���. �� 15���� ������ �ߺ��� List�� Ȱ���ϼ���.

	        Map<String, User> hashMap = new HashMap<>();
	        for(User user : newList){
	            hashMap.put(user.getId(), user);
	        }

	        // 19. ���� ID�� Map���� Ž���ϼ���. �� �������� �ʴ� ��� '�������� �ʴ´�'�� ����Ʈ���ּ���.

	        System.out.println(hashMap.get("test2"));

	        // 20. Map�� Key�� ��� ����ϼ���.
	        Set<String> keySet = hashMap.keySet();
	        Iterator<String> iterator = keySet.iterator();
	        while (iterator.hasNext()){
	            String key = iterator.next();
	            System.out.println(key);
	        }

	        // 21. ���ο� ��ü�� 2�� �����Ͽ� Map�� �־��ִµ�, ID�� �ߺ��� ��ü, �ߺ����� �ʴ� ��ü�� �����ϼ���.
	        hashMap.put("test7",new User("test21","3454","���浿",33));
	        hashMap.put("test23",new User("test22","3454","�ű浿",29));

	        // 22. Map�� ���� ������ ��ü�� �����ϼ���.
	        hashMap.remove("test7");
	        hashMap.remove("test23");

	        // 23. List�� ����� ��ü�� �ٽ� �迭�� ��ȯ�ϰ�, Objectä �����ϼ���.
	        //     �� ����) ��ü�� Serializable�� �����Ͽ� ����ϼ���.
	        // 24. ����� ��ü�� �ٽ� �о�ͼ� ����Ʈ���ּ���.
	        Object[] arr = list.toArray();

	        File file = new File("./arrObj");
	        boolean result = codeChallenge_2_OOP.saveObject(file, arr);
	        System.out.println("result : "+result);

	        Object[] arr1 = (Object[]) codeChallenge_2_OOP.loadObject(file);
	        System.out.println(arr1.toString());

	        // 25. ����� File�� �������ּ���.
	        boolean fileDelete = file.delete();
	        System.out.println(fileDelete);

	        // 26. �ռ� ����� ���ڿ��� 'ȫ�浿'�� ã���ּ���.
	        String str = "���̵� : test, �̸� : ȫ�浿, ���� : 23, ��й�ȣ : 1234 / ���̵� : test2, �̸� : ��浿, ���� : 32, ��й�ȣ : 1234";
	        String token = "ȫ�浿";
	        int count = 0;
	        int startIndex = 0;
	        while (true){
	            int result1 = str.indexOf(token,startIndex);
	            if(result1 < 0){
	                break;
	            }
	            count++;
	            System.out.println("�O�� �ε��� : "+result1);
	            startIndex = result1+token.length();
	        }
	        System.out.println("ã�� ���� : "+ count);
	        System.out.println("----------------------------------\n");


	        // 27. �ռ� ����� ���ڿ��� '�̸�'�� �ε����� ��� ����ϼ���.
	        String tokenName = "�̸�";
	        int count_ = 0;
	        int startIndex_ = 0;
	        while (true){
	            int result2 = str.indexOf(tokenName,startIndex_);
	            if(result2 < 0){
	                break;
	            }
	            count++;
	            System.out.println("�O�� �ε��� : "+result2);
	            startIndex_ = result2+token.length();
	        }
	        System.out.println("ã�� ���� : "+ count_);
	        System.out.println("----------------------------------\n");

	        // 28. �ռ� ����� ���ڿ��� 'ȫ�浿'�� '�ֱ浿'���� �ٲ��ּ���.
	        System.out.println(str.replace("ȫ�浿","�ֱ浿"));
	        System.out.println("----------------------------------\n");

	        // 29. �ռ� ����� ���ڿ��� '/' �������� �߶��ּ���.
	        System.out.println("���� : "+ str);
	        String[] strArray = str.split("/");
	        for(int i=0; i< strArray.length; i++){
	            System.out.println(strArray[i]);
	        }
	        System.out.println("----------------------------------\n");

	        // 30. �ռ� ����� ���ڿ��� �Ľ��Ͽ� ��ü�� �����ϼ���.
	        //     ex) User Ȱ���Ͽ� ��ü 2���� ����.


	        // 31. ���� ��¥�� ����ϼ���.
	        Date date = new Date();
	        System.out.println(date);
	        date = new Date(System.currentTimeMillis());
	        SimpleDateFormat today = new SimpleDateFormat("YYYY/MM/dd");
	        System.out.println(today.format(date));

	        System.out.println("----------------------------------\n");

	        // 32. ���� ��¥�� '2021�� 9�� 18��, ���� 5�� 10��'���� ����ϼ���.
	        SimpleDateFormat today_ = new SimpleDateFormat("YYYY�� MM�� dd��, a hh�� mm��");
	        GregorianCalendar gc = new GregorianCalendar(2021,9-1,18,17,10);
	        System.out.println(today_.format(gc.getTime()));


	    }

	    public static boolean saveObject(File file, Object obj){

	        try (FileOutputStream fos = new FileOutputStream(file);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            ){
	            oos.writeObject(obj);

	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }

	    public static Object loadObject(File file){

	        try (
	                FileInputStream fis = new FileInputStream(file);
	                ObjectInputStream ois = new ObjectInputStream(fis);
	                ){
	            return ois.readObject();

	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
 }

// class User{}


