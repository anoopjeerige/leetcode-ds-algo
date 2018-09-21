// Two pointer technique - Scenario II
// - Using two pointer with different steps
// - One slow runner and one fast runner
// - Key strategy is to determine the key movement of both the pointers
// - Sort the array before planning the movement
// - Use greedy thought to determine the movement strategy

import java.util.*;
import java.io.*;

public class Exercises_2 {

	// Example - No space limitation
	// 	- Iterate the original array and add elements not equal to the target to the new array
	// 	- One pointer used for the iteration of the original array
	// 	- Second one always points to last position of the new array
	public static int[] removeElement(int[] nums, int val) {

		List<Integer> temp = new ArrayList<Integer>();
		int[] result = null;
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val){
				temp.add(k, nums[i]);
				k++;
			}
		}
		
		result = new int[temp.size()];
		for(int j = 0;j < result.length; j++) {
			result[j] = temp.get(j);
		}
		return result;
	}


	// Example - Space limitation
	// - One pointer to iterate the original array
	// - Second pointer points to position for next insertion
	public static int removeElement1(int[] nums, int val) {

		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[k++] = nums[i];
			}
		}
		return k;
	}

	/*
	* Two Pointer Technique - Max Consecutive Ones
	*/
	public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 0;
            }
        }
        return max;
    }

    /**
    * Two pointer technique 2 - Minimum Size Subarray Sum
    */
    public static int minSubArrayLen(int s, int[] nums) {
        
        if (nums == null || nums.length == 0) {
        	return 0;
        }

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
        	sum += nums[j++];

        	while (sum >= s) {
        		min = Math.min(min, j - i);
        		sum -= nums[i++];
        	}
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

	/**
    * Function to display array elements
    */
    public static void displayArray(int[] items) {
    	for (int item: items) {
    		System.out.print(item);
    		System.out.print(" ");
    	}
    	System.out.println();
    }

    /**
    * Function to trim an array for given length
    */
    public static int[] trimArray(int[] nums, int n) {
    	int[] result = new int[n];
    	for (int i = 0; i < n; i++) {
    		result[i] = nums[i];
    	}
    	return result;
    }

    /**
    * Test loading large data from properties file
    */
    public Properties loadProp() throws IOException {
    	Properties properties = new Properties();
		InputStream inputStream = getClass().getResourceAsStream("data.properties");
		properties.load(inputStream);
		return properties;
    }

    /**
    * Test reading a large input from a file
    */
    public int[] loadData() throws IOException, FileNotFoundException {
    	String filename = "input.txt";
    	FileReader fileReader = new FileReader(filename);
    	BufferedReader br = new BufferedReader(fileReader);

    	String[] numbersStr = br.readLine().split(",");
    	//System.out.println(numbersStr[0]);
    	//System.out.println(numbersStr[numbersStr.length - 1]);

    	int[] result = new int[numbersStr.length];
    	for (int i = 0; i < numbersStr.length; i++) {
    		result[i] = Integer.parseInt(numbersStr[i]);
    	}

    	return result;
    }

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// // Test - Example - No space limitation
		// int[] test = {1, 4, 4, 5, 6};
		// displayArray(removeElement(test, 4));

		// // Test - Example - Space limitation
		// int[] test1 = {1, 4, 4, 5, 6};
		// int n = removeElement1(test1, 4);
		// displayArray(test1);
		// displayArray(trimArray(test1, n));

		// Test - Two pointer technique 2 - Minimum Size Subarray Sum
		Exercises_2 ex = new Exercises_2();
		
		// Properties pr = ex.loadProp();
		// System.out.println(pr.getProperty("input"));

		int[] test2 = ex.loadData();
		
		System.out.println(minSubArrayLen(120331635, test2));
	}
}