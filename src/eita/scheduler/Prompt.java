package eita.scheduler;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void runPrompt() throws ParseException {
		
		Scheduler s = new Scheduler();
		Scanner scanner = new Scanner(System.in);		
		s.printMenu();
		
		boolean isLoop = true;
		while(isLoop) {
			System.out.println("명령어 입력(1,2,h,q)");
			System.out.print(">");
			String cmd = scanner.next();
			
			switch(cmd) {
			case "1" :
				s.cmdRegister(scanner,s);
				break;
			case "2" :
				s.cmdSearch(scanner, s);
				break;
			case "h" :
				s.printMenu();
				break;
			case "q" :
				System.out.println("프로그램을 종료합니다.");
				isLoop = false;
				break;
			}
		}
	}
	public static void main(String[] args) throws ParseException {
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
