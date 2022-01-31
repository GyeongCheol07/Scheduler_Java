package eita.scheduler;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Scheduler {
	
	//일정,내용을 저장하는 HashMap 선언
	private HashMap <Date, String>planMap = new HashMap<Date,String>();
	
	//일정 입력
	public void cmdRegister(Scanner scan, Scheduler s) throws ParseException {
		System.out.println("[일정 등록]날짜를 입력하세요.(yyyy-mm-dd)");
		System.out.print(">");
		String date = scan.next();
		String plan="";
		scan.nextLine();
		System.out.println("일정을 입력하세요.");
		System.out.print(">");
		plan = scan.nextLine();
		
		s.registerPlan(date, plan);
	}
	
	//일정 검색
	public void cmdSearch(Scanner scan,Scheduler s) throws ParseException {
		System.out.println("[일정 검색]날짜를 입력하세요.(yyyy-mm-dd)");
		System.out.print(">");
		String date = scan.next();
		String plan ="";
		plan = s.searchPlan(date);
		System.out.println(plan);
	}
	
	//도움말
	public void printMenu() {
		//메뉴
		System.out.println("+================+");
		System.out.println("| 1. 일정 등록      ");
		System.out.println("| 2. 일정 검색      ");
		System.out.println("| h. 도움말 q.종료   ");
		System.out.println("+================+");		
	}
	
	//일정 등록 저장
	private void registerPlan(String strdate, String plan) throws ParseException {
		
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
		planMap.put(date, plan);
		
		System.out.println("일정 입력이 완료 되었습니다.");
	}
	
	//저장된 일정 불러오기
	private String searchPlan(String strdate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
		String plan = planMap.get(date);
		return plan;		
	}

}

