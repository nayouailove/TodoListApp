package com.todo.dao;

import java.util.*;
import com.todo.service.TodoSortByDate;
import com.todo.service.TodoSortByName;

public class TodoList {
	
	private List<TodoItem> list; //TodoItem객체들을 list로 관리한다. 
	
	public TodoList() {
		this.list=new ArrayList<TodoItem>();
		}
	
	public void addItem(TodoItem t) {
		list.add(t);	
	}

	public void deleteItem(TodoItem t) {
		list.remove(t);
	}
	void editItem(TodoItem t, TodoItem updated) {
		int index = list.indexOf(t);
		list.remove(index);
		list.add(updated);
	}
	
	public ArrayList<TodoItem> getList(){
		return new ArrayList<TodoItem>(list);
	}
	public void sortByName() {
		Collections.sort(list, new TodoSortByName());
	}
	public void reverseList() {
		Collections.reverse(list);
	}
	public void sortByDate() {
		Collections.sort(list, new TodoSortByDate());
	}
	
	public int indexOf(TodoItem t) {
		return list.indexOf(t);//인덱스는 0부터 시작한다. 그리고 없으면 -1
	}
	public Boolean isDuplicate(String title) {
		for (TodoItem item : list) { //입력받은 title-todoItem과 비교
			if (title.equals(item.getTitle())) return true;
			//중복된게 있다는 뜻임.. 함수는 여기서 멈추고 더이상 확인할게 없음
		}
		return false;
	}//중복된 내용이 들어기지 않기위한 함수 
	 
}
