package com.Legacy.controller;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.Legacy.model.service.BoxOfficeService;
import com.boxoffice.api.OpenApiManager;
import com.boxoffice.model.vo.Boxoffice;


public class BoxofficeController {
	private BoxOfficeService boxOfficeService = new BoxOfficeService();
	
	public void initBoxOffice() {
		Calendar cal = new GregorianCalendar(2022, 0, 3);
		Calendar today = Calendar.getInstance();
		
		while(true) {
			System.out.println(cal.getTime());
			if(cal.after(today) == true) {
				break;
			}
			List<Boxoffice> list = OpenApiManager.callWeeklyBoxOfficeListByXML(cal.getTime());
			cal.add(Calendar.DATE, 7);
			
			if(list == null || list.isEmpty()) {
				continue;
			}
			
			for(Boxoffice box : list) {
				System.out.println(box);
				boxOfficeService.insert(box);
			}
		}
	}
	
	public List<Boxoffice> getAllMvList(){
		return boxOfficeService.selectAll();
	}
	
	
	public List<Boxoffice> getMvListByYearweekTime(String yearweekTime){
		return boxOfficeService.selectByYearweekTime(yearweekTime);
	}
	
	public Boxoffice searchByBoxofficeNo(int boxofficeNo){
		return boxOfficeService.selectOne(boxofficeNo);
	}
	
	
	public List<Boxoffice> searchMovieName(String movieName){
		return boxOfficeService.selectByMvName(movieName);
	}
	
	
	public static void main(String[] args) {
		BoxofficeController controller = new BoxofficeController();
		controller.initBoxOffice();
	}
}
