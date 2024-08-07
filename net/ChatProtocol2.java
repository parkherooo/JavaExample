package net;

public class ChatProtocol2 {
	
	//(클라이언트->서버) ID : aaa
	public static final String ID ="ID";
	
	//(C->S) CHAT : 받는 아이디;메세지 ex) CHAT :bbb;밥먹자
	//(S->C) CHAT : 받는 아이디;메세지 ex) CHAT :aaa;밥먹자
	public static final String CHAT ="CHAT";
	
	//(C->S) CHATALL : 메세지
	//(S->C) CHATALL : [보내는아이디] 메세지
	public static final String CHATALL ="CHATALL";
	
	//(S->C) CHATLIST : aaa;bbb;ccc;홍길동;
	public static final String CHATLIST ="CHATLIST";
	
	//(C->S)MESSAGE:받는아이디;메시지 ex) MESSAGE:bbb
	//(S->C)MESSAGE:받는아이디;메시지 ex) MESSAGE:aaa
	public static final String MESSAGE ="MESSAGE";
	
	public static final String MODE1 =":";
	public static final String MODE2 =";";
	
	public static void main(String[] args) {

	}

}
