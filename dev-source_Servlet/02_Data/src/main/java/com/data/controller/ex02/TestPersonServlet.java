package com.data.controller.ex02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testperson.do")
public class TestPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String,String> foodImageMap = null;
	private static Map<String,String> animalImageMap = null;
	static {
		// 음식
		foodImageMap = new HashMap<String, String>();
		foodImageMap.put("카레", "http://health.chosun.com/site/data/img_dir/2020/03/27/2020032703807_0.jpg");
		foodImageMap.put("마라탕", "https://img.danawa.com/prod_img/500000/653/027/img/8027653_1.jpg");
		foodImageMap.put("초밥","https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/00/a0000370/img/basic/a0000370_main.jpg");
		foodImageMap.put("스테이크", "https://m.outback.co.kr/upload/product/20201018/20201018231434160101.jpg");
		foodImageMap.put("두부김치", "https://storage.googleapis.com/cbmpress/tfood/1676654995_PFW5kLVi_a8fc00e73dda2ba0ccc01e7d24076fe4730234c2.jpg");
	
		// 동물
		animalImageMap = new HashMap<String, String>();
		animalImageMap.put("컴퓨타", "https://www.apple.com/newsroom/images/product/mac/standard/Apple_MacBook-Pro_14-16-inch_10182021_big.jpg.large.jpg");
		animalImageMap.put("고양이", "http://dimg.donga.com/ugc/CDB/WEEKLY/Article/5b/b3/22/85/5bb32285000ed2738de6.jpg");
		animalImageMap.put("강아지", "http://image.dongascience.com/Photo/2020/03/5bddba7b6574b95d37b6079c199d7101.jpg");
		animalImageMap.put("올빼미", "http://c.files.bbci.co.uk/BAA2/production/_110687774_fatowl.jpg");
		animalImageMap.put("미어캣", "http://image.dongascience.com/Photo/2017/06/14972506438096.jpg");
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestPersonServlet - doGet 요청 들어옴!");

		// 요청 처리하는 패턴
		// 1. encoding 셋팅하기
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		// 2. Parameter 처리하기 - getParameter or getParameterValues
		Person person = makePerson(req);
		if(person == null) {
			System.out.println("Error!"); // 로그 띄우기!
			resp.getWriter().append("Error!!");
			return;
		}
		System.out.println(person.toString());
		
		// 번외. parameter를 모를때 처리하는 코드
//		Iterator<String> iter = req.getParameterNames().asIterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			System.out.println("key : " + key + " : " + req.getParameter(key));
//		}
		
		// 3. 응답페이지 type 셋팅하기
		resp.setContentType("text/html;charset=utf-8"); // 웹브라우저에 표시할 형식을 알려주는 파라메터

		// 4. 페이지 만들어서 전달하기
		String html = makePersonPage(req, person);
		resp.getWriter().append(html);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	private String makePersonPage(HttpServletRequest req, Person person) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		
		try {
			String msg = (String) req.getAttribute("MSG");
			Date date = (Date) req.getAttribute("MSG_DATE");
			if(msg != null) {
				sb.append("<h2>이전페이지 메세지 들어옴</h2>");
				sb.append("<h3>msg : " + msg +  "</h3>");
			}
			if(date != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String dateStr = sdf.format(date);
				sb.append("<h3>date : " + dateStr + "</h3>");
			}
			
			
			//여기서 발생 할 수 있는 에러 : null point, type cast
		} catch (Exception e) {
			
		}
		
		
		sb.append("<h1>취향테스트 결과</h1>");
		sb.append(String.format("<h3>이름 : %s </h3>", person.getName()));
		sb.append(String.format("<h3>나이 : %s </h3>", person.getAge()));
		sb.append(String.format("<h3>신장 : %s </h3>", person.getHeight()));
		sb.append(String.format("<h3>좋아하는 색 : %s </h3>", person.getColor()));
		sb.append(String.format("<h3><span style='color:%s'>■■■■■■</span></h3>", person.getColor()));
		sb.append(String.format("<h3>좋아하는 음식들 : %s </h3>", person.getFoods()));
		for(String foodName : person.getFoods()) {
			String url = foodImageMap.get(foodName);
			if(url != null) {
				sb.append(String.format("<img src='%s', width='200px', height='200px'>", url));
			}
		}
		
		sb.append(String.format("<h3>좋아하는 동물 : %s </h3>", person.getAnimal()));
		String url = animalImageMap.get(person.getAnimal());
		if(url != null) {
			sb.append(String.format("<img src='%s', width='200px', height='200px'>", url));
		}
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

	
	private Person makePerson(HttpServletRequest req) {
		// 파싱할때는 반드시 try-catch문으로 묶어서 하라.
		try {
			Person p = new Person();
			p.setName(req.getParameter("name"));
			p.setAge(req.getParameter("age"));
			p.setHeight(req.getParameter("height"));
			p.setColor(req.getParameter("color"));
			p.setFoods(req.getParameterValues("foods"));
			p.setAnimal(req.getParameter("animal"));
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

class Person {
	private String name;
	private int age;
	private double height;
	private String color;
	private List<String> foods;
	private String animal;

	public Person() {
		super();
	}

	public Person(String name, int age, double height, String color, List<String> foods, String animal) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.color = color;
		this.foods = foods;
		this.animal = animal;
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
	
	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setHeight(String height) {
		this.height = Double.parseDouble(height);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<String> getFoods() {
		return foods;
	}

	public void setFoods(List<String> foods) {
		this.foods = foods;
	}
	
	public void setFoods(String[] foods) {
		try {
			this.foods = Arrays.asList(foods);
		} catch (Exception e) {
			this.foods = new ArrayList<>();
		}
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", color=" + color + ", foods=" + foods
				+ ", animal=" + animal + "]";
	}
}
