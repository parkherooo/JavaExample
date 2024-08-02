package ch13;

import java.util.Vector;

class Box1{ //다양한 타입의 데이터를 저장
	private Object data;
	
	public void set(Object data) {
		this.data = data;
	}
	public Object get() {
		return data;
	}
}

class Box2<K>{ //지정한 타입만 데이터를 저장
	private K data;
	
	public void set(K data) {
		this.data = data;
	}
	public K get() {
		return data;
	}
}

class Box3<K,V>{
	private K key;
	private V Value;
}

public class GenericEx1 {
	public static void main(String[] args) {
		Box1 b1 = new Box1();
		b1.set(Integer.valueOf(22)); 
		Integer i1 = (Integer)b1.get();
		b1.set("하하");
		
		Box2<String> b2 = new Box2<String>();
		//b2.set(Integer.valueOf(22));
		b2.set("호호");
		String str = b2.get();
		
		Vector<String> v = new Vector<String>();
		String str1 ="하하";
		v.add(str1);
		v.add(str1);
		System.out.println(v.size());
	}
	
}
