class ClassicProblems {
	
	/** Reverse Linked List */
	public ListNode reverseList(ListNode head) {
     	
     	ListNode newHead = null;

     	while (head != null) {
     		ListNode next = head.next;
     		head.next = newHead;
     		newHead = head;
     		head = next;
     	}
     	return newHead;	
    }

    /** Reverse Linked List Recursive */
    public ListNode reverseListRecursive(ListNode head) {
    	return reverseHelper(head, null);
    }

    private ListNode reverseHelper(ListNode head, ListNode newHead) {
    	if (head == null) {
    		return newHead;
    	}
    	ListNode next = head.next;
    	head.next = newHead;
    	return reverseHelper(next, head);
    }

    public ListNode removeElements(ListNode head, int val) {
     	
     	if (head == null) {
     		return head;
     	}
     	ListNode temp = head;

     	while (head != null && head.val == val) {
     		head = head.next;
            temp = head;
     	}

     	while (temp != null && temp.next != null) {
     		if (temp.next.val == val) {
     			temp.next = temp.next.next;
     		} else {
     			temp = temp.next;
     		}
     		
     	}
     	return head;  
    }

    /**  Odd Even Linked List */
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null) {
        	return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (odd != null && odd.next != null && even != null && even.next != null) {
        	odd.next = even.next;
        	odd = odd.next;
        	even.next = odd.next;
        	even = even.next;
        }

        odd.next = evenHead;
        return head;

    }

    /** Palindrome Linked List */
    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) {
            return true;
        }

        ListNode walker = head;
        ListNode runner = head;
        ListNode stack = head;
        ListNode stackHead = null;

        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;

            if (runner != null && runner.next == null) {
                walker = walker.next;
            }

            stack.next = stackHead;
            stackHead = stack;
            stack = walker;
        }

        while (stackHead != null && walker != null) {
            if (stackHead.val == walker.val) {
                stackHead = stackHead.next;
                walker = walker.next;
            } else {
                return false;
            }
        }

        if (stackHead == walker) {
            return true;
        }
        return false;
    }

    public static void displayList(ListNode head) {

    	ListNode temp = head;

    	while (temp != null) {
    		System.out.print(temp.val + " ");
    		temp = temp.next;
    	}
    	System.out.println();
    }

    public static void main(String[] args) {

    	// /** Test - Reverse Linked List */
    	// ListNode test = new ListNode(1);
    	// ListNode test1 = new ListNode(2);
    	// ListNode test2 = new ListNode(3);
    	// test.next = test1;
    	// test1.next = test2;

    	// displayList(test);
    	// //displayList(new ClassicProblems().reverseList(test));
    	// displayList(new ClassicProblems().reverseListRecursive(test));

    	// /** Remove Linked List Elements */
    	// ListNode test = new ListNode(1);
    	// ListNode test1 = new ListNode(2);
    	// ListNode test2 = new ListNode(3);
    	// ListNode test3 = new ListNode(4);

    	// test.next = test1;
    	// test1.next = test2;
    	// test2.next = test3;

    	// displayList(test);
    	// displayList(new ClassicProblems().removeElements(test, 4));

    	// // Test - Odd Even Linked List
    	// ListNode test = new ListNode(1);
    	// // ListNode test1 = new ListNode(2);
    	// // ListNode test2 = new ListNode(3);
    	// // ListNode test3 = new ListNode(4);

    	// // test.next = test1;
    	// // test1.next = test2;
    	// // test2.next = test3;

    	// displayList(test);
    	// displayList(new ClassicProblems().oddEvenList(null));

    	/** Test Palindrome Linked List */
    	ListNode test = new ListNode(1);
    	ListNode test1 = new ListNode(2);
    	ListNode test2 = new ListNode(2);
    	ListNode test3 = new ListNode(1);

    	test.next = test1;
    	test1.next = test2;
    	test2.next = test3;

    	displayList(test);
    	System.out.println(new ClassicProblems().isPalindrome(test));

    }
}