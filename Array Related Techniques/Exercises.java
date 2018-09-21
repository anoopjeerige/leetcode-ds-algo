import java.io.*;

public class Exercises {

	/**
	* Array Techniques - Rotate Array
	*/
	public void rotate(int[] nums, int k) {

		// Check for rotations greater than length of array
		k %= nums.length;

		// Reverse the array
		reverse(nums, 0, nums.length - 1);

		// Reverse head element with k-1, head+1 element to k-2, ...
		reverse(nums, 0, k - 1);

		// Reverse the rest element from k till n-1 for original order
		reverse(nums, k, nums.length - 1);
	}

	/**
	* Array Techniques - Rotate Array
	*/
	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			nums[start] = nums[start] + nums[end];
			nums[end] = nums[start] - nums[end];
			nums[start] = nums[start] - nums[end];
			start++;
			end--;
		}
	}

	/**
	*
	*/
	public int[] stringToIntegerArray(String input) {

		input = input.substring(1, input.length() - 1);
		input = input.trim();

		String[] numbersStr = input.split(",");
		int[] result = new int[numbersStr.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt(numbersStr[i].trim());
		}
		return result;
	}

	/**
	* 
	*/
	public String integerArrayToString(int[] nums) {

		StringBuffer sb = new StringBuffer();
		for (int item: nums) {
			sb.append(item);
			sb.append(" ");
		}
		return sb.toString();
	}

	/**
	*
	*/
	public void displayArray(int[] nums) {

		for (int item: nums) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {

		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inputStreamReader);

		Exercises ex = new Exercises();

		System.out.print("Sample array format: [1, 2, 3]");
		String text = br.readLine();

		System.out.println();
		
		System.out.print("Number of rotations: ");
		int k = Integer.valueOf(br.readLine().trim());
		
		int[] test = ex.stringToIntegerArray(text);

		ex.displayArray(test);
		
		ex.rotate(test, k);
		//ex.reverse(test, 0, test.length - 1);
		System.out.println(ex.integerArrayToString(test));

	}
}