package com.todo.service;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil { //todolist건드리는 역할
	public static void createItem(TodoList list){
		//클래스 매서드	
		//todolist객체 하나를 가지고 거기에 todoitem하나를 집어넣음. 
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[항목추가]\n"+"제목 >");
		
		title = sc.next();//단어입력 뒤 엔터 들어옴
		if (list.isDuplicate(title)) {
			System.out.println("제목이 중복됩니다. ");
			return;
		}
		sc.nextLine(); //단어 입력 뒤 엔터 들어온거 제거
		System.out.print("내용 > ");
		desc = sc.nextLine().trim();//한문장 통채로 받기, 좌우여백 제거
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("추가되었습니다");
	}
	
	public static void getSize(TodoList l) {
		int sizeOfArrayList = l.size();
	}
	public static void saveList(TodoList l, String filename) {
		try {
			Writer w = new FileWriter(filename); 
			//String이 파라미터로 하나 들어올땐 어떻게 쓰이는가?
			for ( TodoItem item : l.getList()) {
				w.write(item.toSaveString());//여기서saveSTRING으로 나온애들을 파일에 한줄씩 저장해라 TOSAVE에 \N있음
			}
			w.close();
			System.out.println("모든 데이터가 저장되었습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteItem(TodoList l) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("항목 삭제\n"+"삭제할 항목의 번호를 입력하시오 > ");
		String title=sc.next();
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {//get은 들어있는것, title받은건 입력받은거 
				l.deleteItem(item);
				System.out.println("삭제되었습니다.");
				break;
			}
		}
	}
	public static void updateItem(TodoList l) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("항목수정\n"+"수정할 항목의 제목을 입력>");
		String title = sc.next().trim();
		if(!l.isDuplicate(title)) {
			System.out.println("없는 제목입니다.");
			return;
		}
		//아래로 내려왔다는것은 수정할 것이 있다는 뜻
		System.out.print("새 제목 >");
		String new_title=sc.next().trim();
		if(l.isDuplicate(new_title)) {
			System.out.println("제목이 중복됩니다. ");
			return;}
		sc.nextLine();//엔터키 제거:버퍼비우기
		System.out.print("새 내용 >");
		String new_description = sc.nextLine().trim();
		for(TodoItem item : l.getList()) {
			if(item.getTitle().equals(title)) {
			l.deleteItem(item);
			TodoItem t = new TodoItem(new_title, new_description);
			l.addItem(t);
			System.out.println("수정되었습니다");
		}}
}
	
	
	public static void listAll(TodoList l) {
		System.out.println("[전체목록}");
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
			//객체의 정보를 문자열로 변환
		}
	}
	
	public static void findList() {
		System.out.println("Command > ");
		//근데 사용은 main에서 해야함.. ㅜㅜ 어떻게 해
	}
	public static void loadList(TodoList l, String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line;
			int count=0;
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "##");
				String title = st.nextToken();
				String description = st.nextToken();
				String current_date = st.nextToken();
				TodoItem item = new TodoItem(title, description);
				item.setCurrent_date(current_date);
				l.addItem(item);
				count++;
			}
			br.close();
			System.out.println(count+"개의 항목을 읽었습니다. ");
		}catch (FileNotFoundException e) {
			System.out.println(filename+"파일이 없습니다.");
			//e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}}
	}
	

