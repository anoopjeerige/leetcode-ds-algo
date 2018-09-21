/**
* Stack - A last-in-first-out date structure
* A dynamic array can be used to implement a stack
*/

import java.util.*;

public class MyStack {
	
	/**
	* Implementing a stack astract data type using a dynamic array
	* This is using a adapter pattern, where a instance of class List is adapted to define a custom stack class
	*/

	private List<Integer> data;

	public MyStack() {
		data = new ArrayList<Integer>();
	}

	/** Insert element into stack */
	public void push(int x) {
		data.add(x);
	}

	/** Check if stack is empty or not */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/** Get top element if stack */
	public int top() {
		if(!isEmpty()){
			return data.get(data.size() - 1);
		}
		return 0;
	}

	/** Delete element from stack, return true if operation is successful */
	public boolean pop() {
		if (isEmpty()) {
			return false;
		}
		data.remove(data.size() - 1);
		return true;
	}

	public static void main(String[] args) {

		MyStack stack = new MyStack();

		stack.push(1);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());

	}
}