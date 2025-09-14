package com.todo.service;

import java.util.Comparator;
import com.todo.dao.TodoItem;

public class TodoSortByName implements Comparator<TodoItem> {
	@Override //재정의
	public int compare(TodoItem o1, TodoItem o2) {
		return o1.getTitle().compareTo(o2.getTitle());
	}
//comparator 인터페이스를 활용하여 compare클래스를 오버라이드한다. 
}
