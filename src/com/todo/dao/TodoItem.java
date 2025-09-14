package com.todo.dao;
import java.text.SimpleDateFormat;
//dao는 DataAccessObject라는 뜻..
import java.util.Date;
import java.text.SimpleDateFormat;

public class TodoItem {
	private String title;
	private String desc;
	private String current_date; //세개의 멤버변수
	//이거 다른데 어떻게 바꿔줘야하는지 생각.
	//원래는 private Date current_date였음. 이러면 각 컴퓨터에서 쓴느 date객체 읽는방법에 따라 달라짐
	
	public TodoItem(String title, String desc) {
		//세개의 멤버변수를 이용해 생성자, constructor
		//title과 discription 두개를 입력받아서 객체가 만들어진다. 
		this.title=title;
		this.desc=desc;
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
		this.current_date=f.format(new Date()); 
		//f는 simpledateformat의 인스턴스이다. 이 객체는 저 특정날짜 포맷 규칙을 같는다.
		//객체는 현실세계의 사물처럼 고유한 속성(데이터)와 행동(메서드)를 갖는다.
		//format()은 저 클래스의 정의된 날짜를 특정형식의 문자열로 변환하는 메소드이다. 
		//메소드는 객체가 할 수 있는 행동을 정의한다. 
		//보통은 파라미터로 세개 다 받아서 객체 생성하는데 얜 날짜라
		
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc=desc;
	}
	public Date getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(Date current_date) {
		this.current_date=current_date;
	}
	@Override
	public String toString() {
		return "["+title+"]"+desc+"-"+current_date;
	}//화면상에 이 객체를 뿌려주기 위해서 
	public String toSaveString() {
		return title + "##"+desc+"##"+current_date+"\n";
	}//해당하는 item과만 상관이 있기 때문에 item에 있는것임.. 그와 반대로 savelist는 list자체를 다루어야하기때문에 util에 있음. 
}
