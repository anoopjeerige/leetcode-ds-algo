class CircularQueueTester {

	public static void main(String[] args) {

 
	 	/** ["MyCircularQueue","enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
[[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]] */
	 	MyCircularQueue obj = new MyCircularQueue(2);
	 	obj.enQueue(4);
	 	System.out.println(obj.Rear());
	 	obj.enQueue(9);
	 	displayQ(obj);
	 	obj.deQueue();
	 	displayQ(obj);
	 	System.out.println(obj.Front());
	 	
	 	// obj.deQueue();
	 	// displayQ(obj);
	 	// System.out.println(obj.Front());
	 	// obj.deQueue();
	 	// displayQ(obj);
	 	// System.out.println(obj.Front());
	 	// obj.enQueue(4);
	 	// displayQ(obj);
	 	// obj.enQueue(2);
	 	// displayQ(obj);
	 	// obj.enQueue(2);
	 	// displayQ(obj);
	 	// obj.enQueue(3);
	 	

	 	//System.out.println(param_1 + " " + param_2 + " " + param_3 + " " + param_4 + " " + param_5 + " " + param_6);
 
	}

	public static void displayQ(MyCircularQueue q) {

		for (int item: q.data) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
}