/** 
Implementing a queue using SingleLinked List
Queue - A collection designed for holding elements prior to processing.
Interface - Queue
Implemented class - LinkedList

	 			Throws exception 	Returns special value
	Insert 		add(e) 				offer(e)
	Remove 		remove() 			poll()
	Examine 	element() 			peek()

	offer method inserts an element if possible
	poll method removes and retruns head of the queue
	peek method returns but does not remove the head of the queue
 */

import java.util.*;

class QueueBuiltIn {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();

		System.out.println(q.peek());

		q.offer(1);
		q.offer(2);

		System.out.println(q.peek());

		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());

	}
}