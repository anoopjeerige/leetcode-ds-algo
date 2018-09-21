class MyDoubleLinkedList {
	
	ListNode head;
	ListNode tail;
	int len;

	/** Initialize your data structure here. */
    public MyLinkedList() {
        	head = tail = null;
        	len = 0;
    }

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	// Invalid index check
    	if (index < 0 || index >= len) { return -1; }

    	ListNode curr = head;
    	while (index > 0) {
    		curr = curr.next;
    		index--;
    	}
    	return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	// Check if head is null
    	ListNode node = new ListNode(val);
    	if (head == null) {
    		head = tail = node;
    		len++;
    	} else {
    		node.next = head;
    		head.prev = node;
    		head = node;
    		len++;
    	}

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	ListNode node = new ListNode(val);
    	// Check if head is null
    	if (head == null) {
    		head = tail = node;
    		len++;
    	} else {
    		tail.next = node;
    		node.prev = tail;
    		tail = node;
    		len++;
    	}
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

    	// Invalid index
    	if (index < 0 || index > len) {
    		return;
    	}

    	// Tail addition
    	if (index == len) {
    		addAtTail(val);
    		return;
    	}

    	// Head addition
    	if (index == 0) {
    		addAtHead(val);
    		return;
    	}

    	ListNode node = new ListNode(val);
    	ListNode curr = head;
    	while (index > 1) {
    		curr = curr.next;
    		index--;
    	}
    	ListNode next = curr.next;
    	node.next = next;
    	node.prev = curr;
    	curr.next = node;
    	next.prev = node;
    	len++;
    	return;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    	// Invalid index
    	if (index < 0 || index >= len) {
    		return;
    	}

    	// Single node
    	if (len == 1) {
    		head = tail = null;
    		len--;
    		return;
    	}

    	// Last Node
    	if (index == (len - 1)) {
    		tail = tail.prev;
    		tail.next = null;
    		len--;
    		return;
    	}

    	// First Node
    	if (index == 0) {
    		head = head.next;
    		head.prev = null;
    		len--;
    		return;
    	}

    	ListNode curr = head;
    	while (index > 1) {
    		curr = curr.next;
    		index--;
    	}
    	ListNode next = curr.next.next;
    	curr.next = next;
    	next.prev = curr;
    	len--;
    }


}