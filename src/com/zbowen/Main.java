package com.zbowen;

import com.zbowen.circle.SingleCircleLinkedList;
import com.zbowen.single.ArrayList;
import com.zbowen.single.SingleLinkedList;

public class Main {

	public static void main(String[] args) {
		//testArrayList();
		//singleLinkedList();
		//testLinkedList();
		testSingleCircleLinkedList();
		
	}
	
	public static void testSingleCircleLinkedList() {
		List<Integer> list = new SingleCircleLinkedList<Integer>();
		list.add(12);
		list.add(25);
		list.add(16);
		list.add(0,5); //[5,12,25,16]
		list.set(2, 68);//[5,12,68,16]
		System.out.println(list.remove(0)); //[12,68,16]
		System.out.println(list);
		
	}
	
	public static void testLinkedList() {
		List<Person> list = new LinkedList<Person>();
		Person person = new Person(15, "xiaohong");
		list.add(person);
		list.add(new Person(12, "jack"));
		list.add(new Person(18, "Tom"));
		list.add(new Person(16, "lucy"));
		list.set(2, new Person(20, "小米"));
		list.add(3, new Person(24, "华为"));
		System.out.println(list.remove(0));
		list.add(0, new Person(28, "腾讯"));
		System.out.println(list.contains(person));
		System.out.println(list);
		list.clear();
		System.gc();
	}
	
	
	public static void singleLinkedList() {
		List<Person> list = new SingleLinkedList<Person>();
		Person person = new Person(15, "xiaohong");
		list.add(person);
		list.add(new Person(12, "jack"));
		list.add(new Person(18, "Tom"));
		list.add(new Person(16, "lucy"));
		list.set(2, new Person(20, "小米"));
		list.add(3, new Person(24, "华为"));
		System.out.println(list.remove(0));
		System.out.println(list.contains(person));
		System.out.println(list);
		list.clear();
		System.gc();
	}
	
	public static void testArrayList() {
		ArrayList<Person> list = new ArrayList<>();
		Person person = new Person(15, "xiaohong");
		list.add(person);
		list.add(new Person(12, "jack"));
		list.add(new Person(18, "Tom"));
		list.add(new Person(16, "lucy"));
		list.set(2, new Person(20, "小米"));
		list.add(3, new Person(24, "华为"));
		System.out.println(list.remove(0));
		System.out.println(list.contains(person));
		System.out.println(list);
		list.clear();
		System.gc();
	}
}
