import java.io.*;

/**
* Technique used to - 
* iterate array from two ends to middle
* Often used in a sorted array
*/
public class Exercises {
	
	/**
	* Two Pointer Technique - Reverse String
	*/
	public static String reverseString(String s) {
		
		char[] word = s.toCharArray();
		int i = 0;
		int j = word.length - 1;

		while (i < j) {
			swap(word, i ,j);
			i++;
			j--;
		}
		return new String(word);
		
	}

	/**
	* Function to swap elements of given array and indices
	*/
	public static void swap(char[] letters, int i, int j) {
		char temp = letters[i];
		letters[i] = letters[j];
		letters[j] = temp;
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

	public static int[] insertionSort(int[] nums) {
		int i = 1;
		while (i < nums.length) {
			int x = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > x) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = x;
			i++;
		}
		return nums;
	}
	/*
	* Two Sum II - Input array is sorted
	*/
	public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if ((numbers[left] + numbers[right]) == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if ((numbers[left] + numbers[right]) > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    /**
    * Helper Function to convert string input into integer array
    */
    public static int[] stringToIntegerArray(String input) {

    	// Remove leading and trailing whitespaces
    	input = input.trim();
    	// Reading the array elements ignoring the square brackets, example input - [1, 2, 3]
    	input = input.substring(1, input.length() - 1);
    	// Check if empty string
    	if (input.length() == 0) {
    		return new int[0];
    	}

    	// Split the string aroung commas
    	String[] parts = input.split(",");
    	// Initialize the new integer array
    	int[] output = new int[parts.length];
    	// Iterate the string parts, parse to int, add to new array
    	for (int index = 0; index < parts.length; index++) {
    		// Check whitespaces
    		output[index] = Integer.parseInt(parts[index].trim());
    	}
    	return output;
    }

    /*
    * Helper function to convert integer array to string
    */
    public static String integerArrayToString(int[] nums, int length) {
    	// Check empty array
    	if (length == 0) {
    		return "[]";
    	}

    	String result = "";
    	for (int index = 0; index < length; index++) {
    		int number = nums[index];
    		result += Integer.toString(number) + ", ";
    	}

    	return "[" + result.substring(0, result.length() -2) + "]";
    }

    /*
    * Helper function to convert integer array to string
    */
    public static String integerArrayToString(int[] nums) {
    	return integerArrayToString(nums, nums.length);
    }

	public static void main(String[] args) throws IOException {

		// // Test - Two Pointer Technique - Reverse String
		// String test = "hello";
		// System.out.println(reverseString(test));

		// int[] test = {9, 8, 5, 4, 3, 1, 7, 6, 2};
		// displayArray(insertionSort(test));

		// // Test - Two Sum II - Input array is sorted
		// int[] test = {7, 9, 11, 15};
		// int target = 16;
		// displayArray(twoSum(test, target));

		// Test helper - string to integer array
		String test = "[1, 2, 3]";
		displayArray(stringToIntegerArray(test));

		// Test helper - integer array to string
		int[] test1 = {1, 2, 3};
		System.out.println(integerArrayToString(test1));

		// Reading from standard in
		// Create buffered reader
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = in.readLine()) != null) {
			// First line has integer array
			int[] numbers = stringToIntegerArray(line);
			// Second line has integer target
			line = in.readLine();
			int target = Integer.parseInt(line);

			// Call required function
			int[] result = twoSum(numbers, target);

			// Print result
			String out = integerArrayToString(result);
			System.out.println(out);
		}


	}
}