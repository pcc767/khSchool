package miniPrj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class movie {
    public static void main(String[] args) {
	
    	// ����Ű (������ �޾ƿ;���)
    	String key = "";

    	// �Ľ��� �����͸� ������ ����
    	String result = "";

    	try {

    		URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key="
    				+ key + "&movieCd=20124039");

    		BufferedReader bf;

    		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

    		result = bf.readLine();

        	JSONParser jsonParser = new JSONParser();
        	JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
        	JSONObject movieInfoResult = (JSONObject)jsonObject.get("movieInfoResult");
        	JSONObject movieInfo = (JSONObject)movieInfoResult.get("movieInfo");

        	JSONArray nations = (JSONArray)movieInfo.get("nations");
        	JSONObject nations_nationNm = (JSONObject)nations.get(0);

        	JSONArray directors = (JSONArray)movieInfo.get("directors");
        	JSONObject directors_peopleNm = (JSONObject)directors.get(0);

        	JSONArray genres = (JSONArray)movieInfo.get("genres");

        	JSONArray actors = (JSONArray)movieInfo.get("actors");

        	System.out.println("��ȭ�ڵ� : " + movieInfo.get("movieCd"));
        	System.out.println("��ȭ��(�ѱ�) : " + movieInfo.get("movieNm"));
        	System.out.println("��ȭ��(����) : " + movieInfo.get("movieNmEn"));
        	System.out.println("����ð� : " + movieInfo.get("showTm"));
        	System.out.println("������ : " + movieInfo.get("openDt"));
        	System.out.println("��ȭ���� : " + movieInfo.get("typeNm"));
        	System.out.println("���۱����� : " + nations_nationNm.get("nationNm"));
       	
        	String genreNm = "";
       	
        	for(int i = 0; i < genres.size(); i++) {
            	JSONObject genres_genreNm = (JSONObject)genres.get(i);
            	genreNm += genres_genreNm.get("genreNm") + " ";
        	}

        	System.out.println("�帣 : " + genreNm);
       	
        	System.out.println("������ : " + directors_peopleNm.get("peopleNm"));
       	
        	String peopleNm = "";
       	
        	for(int i = 0; i < actors.size(); i++) {
        		JSONObject actors_peopleNm = (JSONObject)actors.get(i);
        		peopleNm += actors_peopleNm.get("peopleNm") + " ";
        		peopleNm = peopleNm + actors_peopleNm.get("peopleNm") + " ";
        	}
       	
        	System.out.println("�⿬��� : " + peopleNm);

    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}