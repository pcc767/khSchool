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



// ★★★★반드시 @author란에 별명 만들어서 코드 식별하게끔 작성 바랍니다.
/**
 * @author 짧은다리.
 *
 */
public class codeChallenge_2_OOP {

	// ★★★★반드시 @author란에 별명 만들어서 코드 식별하게끔 작성 바랍니다.
	    /**
	     * @author 짧은다리
	     *
	     */

	    public static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        // 1. non public class - User 선언하기
	        // User라는 객체 생성하세요. id, pw, name, age를 저장하는 객체 선언하기
	        //  -> 객체 선언시 해당 코드 가장 아래에 생성하세요. // 미리 틀 만들었습니다.

	        // 제약 1.private로 멤버변수 한정하고, getter, setter 생성하기.
	        // 제약 2.생성자는 기본형과 4가지 인자 모두 초기화하는 객체 선언하기
	        // 제약 3.toString 사용하기

	        // 2. 객체 생성하고 출력하기
	        // 각자 다른 2가지 instance(객체)를 생성해보세요.
	        // 기본 생성자 사용과 4가지 인자 초기화 하는 생성자로 생성하세요.
	        // 생성한 값을 sysout으로 출력해주세요.

	        // 3. 객체 배열 사용하기
	        // ID, 이름 모두 다른 사용자를 10명을 생성하여 배열로 저장해주세요.
	        // 나이는 2명씩 다르게 생성해주세요. (홍길동1 - 20, 홍길동2 - 20  홍길동3 - 25 ... )
	        // 그리고 배열을 순회하여 10명 모두 출력하세요.

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
	                new User("test1","1234","홍길동",20),
	                new User("test2","1244","박길동",30),
	                new User("test3","1333","김길동",33),
	                new User("test4","1678","조길동",22),
	                new User("test5","1232","최길동",24),
	                new User("test6","1124","고길동",27),
	                new User("test7","1754","유길동",35),
	                new User("test8","1093","오길동",36),
	                new User("test9","1200","부길동",29),
	                new User("test10","1229","강길동",31),
	        };

	        // 4. 객체 배열 순회하기
	        // ID/PW를 입력받고, 10개에 데이터 중 존재하는지 ID로 확인하고, 로그인 가능한지 확인해주세요.
//	        System.out.print("생성할 ID : ");
//	        String id = sc.nextLine();
//	        System.out.print("생성할 PW : ");
//	        String pw = sc.nextLine();
	//
//	        for(int i=0; i<userArray.length; i++){
//	            if(userArray[i].getId().equals(id)){
//	                System.out.println("존재하는 아이디입니다. 다시 입력해주세요.");
//	                return;
//	            }
//	            System.out.println("가능한 아이디입니다.");
//	        }

	        // 5. 객체 배열 변경하기
	        // ID와 이름을 입력받고 ID가 존재하면 이름을 변경해 줍니다.
//	        System.out.print("생성할 ID : ");
//	        String id = sc.nextLine();
//	        System.out.print("생성할 이름 : ");
//	        String name = sc.nextLine();
	//
//	        for(int i=0; i<userArray.length; i++){
//	            if(userArray[i].getId().equals(id)){
//	                System.out.print("변경할 이름 : ");
//	                String newName = sc.nextLine();
//	                return;
//	            }
//	        }

//	        6.

	        // 7. List 계열을 생성하고 앞서 만든 배열로 초기화 해주세요.
//	        ArrayList<User> list = new ArrayList<>(Arrays.asList(userArray));
	        ArrayList<User> list = new ArrayList<>();
	        for(User user : userArray){
	            list.add(user);
	        }
	        System.out.println(list);

//	         8. List에 새로운 아이디 10개를 더 추가하세요. 단 ID는 중복되지 않습니다.
	        for(int i=0; i<10; i++){
	            list.add(new User("test"+(11+i),"495"+(7+i),"홍길동"+(1+i),28+i));
	        }
	        System.out.println(list);

	        // 9. 임의의 ID 하나를 탐색하세요.
	        // 10. 탐색된 ID를 지우세요.

	        Random random = new Random();
	        random.setSeed(System.currentTimeMillis());

	        User ranNum = list.get(random.nextInt(10));
	        System.out.println(ranNum);     //지우기전
	        list.remove(ranNum);
	        System.out.println(ranNum);     //지운후


	        // 11. 맨 앞에 새로운 ID를 생성해서 넣으세요.
	        list.add(0,new User("test0","test00", "팍길동", 39));

	        // 12. List의 순서를 랜덤으로 섞으세요. Hint : Collections 활용
	        Collections.shuffle(list);

	        // 13. 객체에 Comparable를 구현하여 ID 기준으로 정렬하세요.
	        list.sort(new Comparator<User>() {
	            @Override
	            public int compare(User o1, User o2) {
	                return o1.getId().compareTo(o2.getId());
	            }
	        });

	        // 14. 객체에 Comparator를 익명 클래스 구현하여 나이-이름 순 정렬하세요.
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

	        // 15. List 새로 다시 생성하고, 기존 리스트 데이터를 2번 반복해서 입력하세요.
	        //     (2번씩 입력하여 중복을 만들어주세요!)

	        ArrayList<User> newList = new ArrayList<>();

	        for(int i=0; i<2; i++){
	            newList.addAll(list);
	        }
	        System.out.println(newList);

	        // 16. ID의 중복이 존재하는 List를 Set을 통해 제거하고, 다시 ID 순으로 정렬하세요.
//	        Set<User> treeSet = new TreeSet<>();
//	
//	        treeSet.addAll(newList);
//	
//	        List<User> list_1 = new ArrayList<>(treeSet);
//	        Collections.shuffle(list_1);
//	
//	        System.out.println("확인");
//	        System.out.println(list_1);

	        // 17. List의 빠른 탐색을 위해 Map을 생성하세요. Map에 Key는ID , Value는 User로 선언하세요.
	        // 18. Map에 List를 넣어주세요. 단 15번에 생성된 중복된 List를 활용하세요.

	        Map<String, User> hashMap = new HashMap<>();
	        for(User user : newList){
	            hashMap.put(user.getId(), user);
	        }

	        // 19. 임의 ID를 Map으로 탐색하세요. 단 존재하지 않는 경우 '존재하지 않는다'로 프린트해주세요.

	        System.out.println(hashMap.get("test2"));

	        // 20. Map의 Key를 모두 출력하세요.
	        Set<String> keySet = hashMap.keySet();
	        Iterator<String> iterator = keySet.iterator();
	        while (iterator.hasNext()){
	            String key = iterator.next();
	            System.out.println(key);
	        }

	        // 21. 새로운 객체를 2개 생성하여 Map에 넣어주는데, ID가 중복된 객체, 중복하지 않는 객체를 생성하세요.
	        hashMap.put("test7",new User("test21","3454","교길동",33));
	        hashMap.put("test23",new User("test22","3454","거길동",29));

	        // 22. Map에 새로 생성된 객체를 삭제하세요.
	        hashMap.remove("test7");
	        hashMap.remove("test23");

	        // 23. List로 저장된 객체를 다시 배열로 변환하고, Object채 저장하세요.
	        //     ※ 주의) 객체에 Serializable을 구현하여 사용하세요.
	        // 24. 저장된 객체를 다시 읽어와서 프린트해주세요.
	        Object[] arr = list.toArray();

	        File file = new File("./arrObj");
	        boolean result = codeChallenge_2_OOP.saveObject(file, arr);
	        System.out.println("result : "+result);

	        Object[] arr1 = (Object[]) codeChallenge_2_OOP.loadObject(file);
	        System.out.println(arr1.toString());

	        // 25. 저장된 File을 삭제해주세요.
	        boolean fileDelete = file.delete();
	        System.out.println(fileDelete);

	        // 26. 앞서 선언된 문자열에 '홍길동'을 찾아주세요.
	        String str = "아이디 : test, 이름 : 홍길동, 나이 : 23, 비밀번호 : 1234 / 아이디 : test2, 이름 : 김길동, 나이 : 32, 비밀번호 : 1234";
	        String token = "홍길동";
	        int count = 0;
	        int startIndex = 0;
	        while (true){
	            int result1 = str.indexOf(token,startIndex);
	            if(result1 < 0){
	                break;
	            }
	            count++;
	            System.out.println("찿은 인덱스 : "+result1);
	            startIndex = result1+token.length();
	        }
	        System.out.println("찾은 갯수 : "+ count);
	        System.out.println("----------------------------------\n");


	        // 27. 앞서 선언된 문자열에 '이름'의 인덱스를 모두 출력하세요.
	        String tokenName = "이름";
	        int count_ = 0;
	        int startIndex_ = 0;
	        while (true){
	            int result2 = str.indexOf(tokenName,startIndex_);
	            if(result2 < 0){
	                break;
	            }
	            count++;
	            System.out.println("찿은 인덱스 : "+result2);
	            startIndex_ = result2+token.length();
	        }
	        System.out.println("찾은 갯수 : "+ count_);
	        System.out.println("----------------------------------\n");

	        // 28. 앞서 선언된 문자열에 '홍길동'을 '최길동'으로 바꿔주세요.
	        System.out.println(str.replace("홍길동","최길동"));
	        System.out.println("----------------------------------\n");

	        // 29. 앞서 선언된 문자열을 '/' 기준으로 잘라주세요.
	        System.out.println("원문 : "+ str);
	        String[] strArray = str.split("/");
	        for(int i=0; i< strArray.length; i++){
	            System.out.println(strArray[i]);
	        }
	        System.out.println("----------------------------------\n");

	        // 30. 앞서 선언된 문자열을 파싱하여 객체로 저장하세요.
	        //     ex) User 활용하여 객체 2개로 생성.


	        // 31. 오늘 날짜를 출력하세요.
	        Date date = new Date();
	        System.out.println(date);
	        date = new Date(System.currentTimeMillis());
	        SimpleDateFormat today = new SimpleDateFormat("YYYY/MM/dd");
	        System.out.println(today.format(date));

	        System.out.println("----------------------------------\n");

	        // 32. 오늘 날짜를 '2021년 9월 18일, 오후 5시 10분'으로 출력하세요.
	        SimpleDateFormat today_ = new SimpleDateFormat("YYYY년 MM월 dd일, a hh시 mm분");
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


