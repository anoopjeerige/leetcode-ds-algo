/**
* Queue and Stack using deque
* Queue     | Deque
* add(e)    | addLast(e)
* offer(e)  | offerLast(e)
* remove()  | removeFirst()
* poll()    | pollFirst()
* element() | getFirst()
* peek()    | peekFirst()
*
* Stack     | Deque
* push(e)   | addFirst(e)
* pop()     | removeFirst()
* peek()    | peekFirst()
*/

import java.util.*;

public class QueueStackDeque  {

    public static void main(String[] args) {
  
        QueueStackDeque qsd = new QueueStackDeque();
        qsd.qOper();
        qsd.sOper();

    }

    public void qOper() {
        Deque queue = new LinkedList<>();     
        queue.addLast(1);
        System.out.println(queue.peekFirst());
        queue.offerLast(2.56);
        System.out.println(queue.peekLast());
        System.out.println(queue.removeFirst());
        System.out.println(queue.pollFirst());
    }

    public void sOper() {
        Deque stack = new LinkedList<>();
        stack.addFirst(3);
        System.out.println(stack.peekFirst());
        stack.addFirst("Test");
        System.out.println(stack.peekFirst());
    }
}