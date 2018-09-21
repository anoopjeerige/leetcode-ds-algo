public class TestLinkList {

	/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
	public static void main(String[] args) {
		
		// // Test case 1
		// MyLinkedList ll = new MyLinkedList();
		
		// ll.addAtHead(1);
		// ll.displayList();
		// System.out.println(ll.getSize());
		
		// ll.addAtTail(3);
		// ll.displayList();
		// System.out.println(ll.getSize());

		// ll.addAtIndex(1, 2);
		// ll.displayList();
		// System.out.println(ll.getSize());

		// ll.get(1);
		// ll.displayList();
		
		// ll.deleteAtIndex(1);
		// ll.displayList();
		// System.out.println(ll.getSize());

		// ll.get(1);

		// Test case 2
		// ["MyLinkedList","get","addAtIndex","get","get","addAtIndex","get","get"]
		// [[],[0],[1,2],[0],[1],[0,1],[0],[1]]

		MyLinkedList l1 = new MyLinkedList();

		System.out.println(l1.get(0));

		l1.addAtIndex(1, 2);

		System.out.println(l1.get(0));

		System.out.println(l1.get(1));

		l1.addAtIndex(0, 1);

		System.out.println(l1.get(0));

		System.out.println(l1.get(1));

	}
}