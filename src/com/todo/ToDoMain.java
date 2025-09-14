package com.todo;

import java.util.Scanner;
import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class ToDoMain {
	public static void start() {// 클래스 메소드, static를 쓴것이 클래스 메소드로 구현을 했다는 뜻
		//static vs 인스턴스 메소드
		Scanner sc= new Scanner(System.in); //스캐너 객체 하나 만듦
		TodoList l = new TodoList(); //
		boolean isList = false;
		boolean quit = false; //flag변수 두개
		TodoUtil.loadList(l, "todolist.txt");
		
		Menu.displaymenu();//명령어 사용법을 한번 보여줌.. 
		do {
			Menu.prompt();
			isList = false;//위에서 초기화할때 false로 했지만 무한루프 도중에 true로 세팅 될 일이 있다는 뜻
			String choice = sc.next();
			switch (choice) {
			case "add":
				TodoUtil.createItem(l); //todoUtil클래스에서 저 메소드 실행
				break;
				
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;
				
			case "ls_name_asc":
				l.sortByName();
				System.out.println("제목순으로 정렬하였습니다.");
				isList=true;//플래그변수 true로 세팅
				break;
				
			case "ls_name_desc":
				l.sortByName();
				l.reverseList();
				System.out.println("제목 역순으로 정렬하였습니다.");
				isList=true;
				break;
				
			case "ls_date":
				l.sortByDate();
				System.out.println("날짜순으로 정렬하였습니다.");
				isList=true;
				break;
			
			case "find":
				l.
				
			case "ls_cate":
				l.
				
			case "help":
				Menu.displaymenu();
				break;
				
			case "exit":
				quit=true;
				break;
				//while(!quit)나가게됨. 
				
			default:
				System.out.println("정확한 명령어를 입력하세요. (도움말 :  help");
				break;
			}
			if(isList) TodoUtil.listAll(l); //isList가 true가 되면 한번 다 보여줘라 
			//boolean변수니까 
			
		}while (!quit); //quit이라는 플래그 변수값
		//quit가 false가 되기 전까지 무한 반봅 
		TodoUtil.saveList(l, "todolist.txt");
	}
}
