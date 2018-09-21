class MyLinkedList {

    private SingleListNode head = null;
    private SingleListNode tail = null;
    private int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        System.out.println("Size:" + size);
        if (index < 0 || index > (size - 1)) { return -1; }
        int count = 0;
        SingleListNode temp = head;
        while (count < index) {
            temp = temp.getNext();
            count++;
        }
        return temp.getVal();
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SingleListNode curr = new SingleListNode(val);
        SingleListNode temp = null;
        if (head == null) {
            head = curr;
        } else {
            curr.setNext(head);
            head = curr;
        }
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        SingleListNode curr = new SingleListNode(val);
        SingleListNode temp = null;
        if (tail == null) {
            tail = curr;
        } else {
            tail.setNext(curr);
            tail = curr;
        }
        if (size == 0) {
            head = tail;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= size) {
            System.out.println("Inside add");
            SingleListNode curr = new SingleListNode(val);
            SingleListNode temp = head;
            int count = 0;
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                while (count < (index - 1)) {
                    temp = temp.getNext();
                    count++;
                }
                curr.setNext(temp.getNext());
                temp.setNext(curr);
                size++;
            }
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >=0 && index < size) {
            SingleListNode temp = head;
            int count = 0;
            if (index == (size - 1)) {
                while (count < (index - 1)) {
                    temp = temp.getNext();
                    count++;
                }
                temp.setNext(null);
                tail = temp;
            } else if (index == 0) {
                temp = temp.getNext();
                head = temp;
            } else {
                while (count < (index - 1)) {
                    temp = temp.getNext();
                    count++;
                }
                temp.setNext(temp.getNext().getNext());
            }
            size--;
        }
    }

    /** Display list */
    public void displayList() {
        SingleListNode temp = head;
        while (temp != null) {
            System.out.print(temp.getVal());
            temp = temp.getNext();
        }
        System.out.println();
    }

    /** Get size of list */
    public int getSize() {
        return size;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */