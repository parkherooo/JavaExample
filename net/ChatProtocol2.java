package net;

public class ChatProtocol2 {
	
	//(Ŭ���̾�Ʈ->����) ID : aaa
	public static final String ID ="ID";
	
	//(C->S) CHAT : �޴� ���̵�;�޼��� ex) CHAT :bbb;�����
	//(S->C) CHAT : �޴� ���̵�;�޼��� ex) CHAT :aaa;�����
	public static final String CHAT ="CHAT";
	
	//(C->S) CHATALL : �޼���
	//(S->C) CHATALL : [�����¾��̵�] �޼���
	public static final String CHATALL ="CHATALL";
	
	//(S->C) CHATLIST : aaa;bbb;ccc;ȫ�浿;
	public static final String CHATLIST ="CHATLIST";
	
	//(C->S)MESSAGE:�޴¾��̵�;�޽��� ex) MESSAGE:bbb
	//(S->C)MESSAGE:�޴¾��̵�;�޽��� ex) MESSAGE:aaa
	public static final String MESSAGE ="MESSAGE";
	
	public static final String MODE1 =":";
	public static final String MODE2 =";";
	
	public static void main(String[] args) {

	}

}
