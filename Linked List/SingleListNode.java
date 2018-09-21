/**
* Linked List is a linear data structure
* Each node in the list contains the value and reference field to link to next node
* Takes O(n) on average to visit a node by index
* Insertion and deletion of new node takes O(1)
* Use the head node to represent the whole list
*/

public class SingleListNode {
	
	private int val;
	private SingleListNode next;
	public SingleListNode(int x) { val = x; }

	public int getVal() { return val; }
	public SingleListNode getNext() { return next; }
	public void setNext (SingleListNode n) { next = n; }

}