package Generics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Reverse<T> implements Reversable<T>{
	
	protected T obj;
	
	public Reverse(T obj) {
		this.obj = obj;
	}
	
	public List<T> reverse(List<T> source){
		
		List<T> reversedList = new LinkedList<T>();
		
		Stack<T> tempStack = new Stack<T>();
		
		for (T element : source) {
			tempStack.push(element);
		}
		
		while (!tempStack.isEmpty()) {
			reversedList.add(tempStack.pop());
		}
		
		return reversedList;
	}
}
