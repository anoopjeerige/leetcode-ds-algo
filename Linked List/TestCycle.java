/** 
Question : Given a Linked List determine if it has a cycle in it.
1) Use two pointers moving at different speeds in the linked list
	- If there is no cycle, the fast pointer will stop at the end of the list.
	- If there is a cycle, the fast pointer will eventually meet with the slow pointer
2) Speed of the two pointers
	- Slow pointer moves one step at a time, while fast pointer moves two steps at a time
	- If length of cycle is M, after M iterations the fast pointer will move one more cycle and catch up with slow pointer
 */

import java.util.*;

class TestCycle {
	
	
	/** Linked List Cycle */
	public boolean hasCycle_bad(ListNode head) {
    	
    	ListNode slow = head, fast = head;
    	while (fast != null) {
    		if (slow != null) {
    			slow = slow.next;
    		}
    		if (fast.next != null) {
    			fast = fast.next.next;
    		} else {
    			break;
    		}
    		if (slow == fast) {
    			System.out.println("Slow: " + slow.val + " Fast: " + fast.val);
    			return true;
    		}
    	}
    	return false;    
    }

    /** Linked List Cycle */
    public boolean hasCycle(ListNode head) {
    	if (head == null) {
    		return false;
    	}

    	ListNode walker = head;
    	ListNode runner = head;

    	while (walker.next != null && runner.next.next != null) {
    		walker = walker.next;
    		runner = runner.next.next;
    		if (walker == runner) {
    			return true;
    		}
    	}
    	return false;
    }

    /** Linked List Cycle II */
    public ListNode detectCycle(ListNode head) {

    	if (head == null) {
    		return null;
    	}
    	ListNode walker = head;
    	ListNode runner = head;

    	while (walker.next != null && runner.next != null) {
    		walker = walker.next;
    		if (runner.next.next != null) {
    			runner = runner.next.next;
    		} else {
    			break;
    		}
    		if (walker == runner) {
    			walker = head;
    			while (walker != runner) {
    				walker = walker.next;
    				runner = runner.next;
    			}
    			return walker;
    		}
    	}
    	return null;
    }


    /** Intersection of Two Linked Lists */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
        	pointerA = pointerA == null ? headB : pointerA.next;
        	pointerB = pointerB == null ? headA : pointerB.next;
        }	
        return pointerA;
    }

    /** Remove Nth Node From End of List */
    public ListNode removeNthFromEnd_bad(ListNode head, int n) {
        if (n <= 0) {
			return head;
		}
		ListNode a = head;
		ListNode b = head;
		int i = 0, j = 0, k = -1;

		while (b != null) {

			if (b.next == null) {
				k = j - n;
				break;
			} else if (b.next.next == null) {
				k = j + 1 - n;
				break;
			} else {
				a = a.next;
				i++;
				b = b.next.next;
				j += 2;
			}
		}

		if (i == j) {
			if (k == -2) {
				head.next = null;
				return head;
			} else if (k == -3) {
				head = head.next;
				return head;
			} else {
				//return null;
			}
		}

		if (k  == -1) {
			head = head.next;
			return head;
		} else if (k < -1) {
			return head;
		} else if (i > k) {
			a = head;
			i = 0;
		}
		while (i != k) {
			a = a.next;
			i++;
		}
		a.next = a.next.next;
		return head;
    }

     /** Remove Nth Node From End of List */
    public ListNode removeNthFromEnd(ListNode head, int n) {

    	ListNode fast = head, slow = head;

    	for (int i = 0; i < n; i++) {
    		fast = fast.next;
    	}

    	if (fast == null) {
    		return head.next;
    	}

    	while (fast.next != null) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	slow.next = slow.next.next;
    	return head;
    }
	
	/** Display list */
    public static void displayList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayCycle(ListNode head) {
        ListNode temp = head;
        System.out.print(temp.val + " ");
        temp = temp.next;
        while (temp != null && temp != head) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayCycle2(ListNode head) {
    	ListNode temp = head;
    	Map<ListNode, Integer> nodes = new HashMap<ListNode, Integer>();
    	while (temp != null && !nodes.containsKey(temp)) {
    		System.out.println(temp.val + " ");
    		nodes.put(temp, temp.val);
    		temp = temp.next;
    	}
    }

	public static void main(String[] args) {
		// /** Test Linked List Cycle */
		// ListNode head = new ListNode(1);
		// ListNode temp = new ListNode(2);
		// ListNode temp1 = new ListNode(3);
		// ListNode temp2 = new ListNode(4);
		// ListNode temp3 = new ListNode(5);
		// head.next = temp;
		// temp.next = temp1;
		// temp1.next = temp2;
		// temp2.next = temp3;
		// //temp3.next = temp;
		// //ListNode temp1 = new ListNode(3);
		// //temp.next = temp1;
		// //temp.next = head;
		// //temp1.next = head;
		// // displayList(head);
		// displayCycle2(head);
		// // System.out.println(new TestCycle().hasCycle(head));
		// ListNode result = new TestCycle().detectCycle(head);
		// System.out.println(result.val);

		/** Test Intersection of Two Linked Lists */
		ListNode head = new ListNode(1);
		ListNode temp = new ListNode(2);
		ListNode temp1 = new ListNode(3);
		ListNode temp2 = new ListNode(4);
		ListNode temp3 = new ListNode(5);
		ListNode temp4 = new ListNode(6);
		ListNode temp5 = new ListNode(9);
		ListNode temp6 = new ListNode(12);
		head.next = temp;
		temp.next = temp1;
		temp1.next = temp2;
		temp2.next = temp3;

		
		// temp4.next = temp5;
		// temp5.next = temp6;
		// temp6.next = temp1;

		displayList(head);
		displayList(temp4);

		// ListNode result = new TestCycle().getIntersectionNode(head, temp4);
		// System.out.println(result.val);

		displayList(new TestCycle().removeNthFromEnd(head, 5));
	}
}