class MyCircularQueue {

	int[] data;
	int currLen;
	int start;
	int end;

	/** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        
        data = new int[k];
        currLen = 0;
        // Note - Start and end are outside the array when empty
        start = end = -1;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        
        // Check if circular queue is full
        if (isFull() == true) {
        	return false;
        }

        // Insert at end
        end = ++end % data.length;
        data[end] = value;
        currLen++;
        // If first element, set start
        if (currLen == 1) {
        	start = end;
        }
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        
        // Check if circular queue is empty
        if (isEmpty() == true) {
        	return false;
        }

        // Delete at start
        data[start] = -1;
        start = ++start % data.length;
        currLen--;
        // If last element, set start and end
        if (currLen == 0) {
        	start = end = -1;
        }
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        
        // Check if circular queue is empty
        if (isEmpty() == true) {
        	return -1;
        }

        return data[start];

    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        
        // Check if circular queue is empty
        if (isEmpty() == true) {
        	return -1;
        }

        return data[end];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        
        if (currLen == 0) {
        	return true;
        } else {
        	return false;
        }

    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        
        if (currLen == data.length) {
        	return true;
        } else {
        	return false;
        }
    }
}