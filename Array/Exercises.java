import java.util.*;

public class Exercises {
	
	/**
	* Array Intro - Find Pivot Index
	*/
	public static int pivotIndex(int[] nums) {
        
        // Add all elements and assign as right
        int right = 0;
        for (int item: nums) {
        	right += item;
        }
        // Iterate elements add to left and subtract from right
        // until left equals right and return index
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
        	right -= nums[i];
        	if (left == right) {
        		return i;
        	}
        	left += nums[i];
        }
        return -1;

    }

    /**
    * Array Intro - Largest Number At Least Twice of Others
    */
    public static int dominantIndex(int[] nums) {

        // Find the biggest element
        int biggest = 0;
        for(int item: nums) {
            if (item > biggest) {
                biggest = item;
            }
        }
        int result = -1;
        // Iterate elements
        for (int i = 0; i < nums.length; i++) {
            // Return index of biggest element
            if (nums[i] == biggest) {
                result = i;
                continue;
            } 
             // Return -1 if twice of element is greater than biggest element
            if ((nums[i] * 2) > biggest) {
                result = -1;
                return result;
            }
        }
        return result;
    }

    /**
    * Array Intro - Plus One
    */
    public static int[] plusOne(int[] digits) {
        int[] results = new int[digits.length + 1];
        int dIndex = digits.length - 1;
        int rIndex = dIndex + 1;
        int sum = digits[dIndex] + 1;
        int carry = sum / 10;
        results[rIndex] = sum % 10;
        dIndex--;
        rIndex--;
        while (dIndex >=0) {
            sum = digits[dIndex] + carry;
            carry = sum / 10;
            results[rIndex] = sum % 10;
            dIndex--;
            rIndex--;
        }
        if (carry > 0) {
            results[rIndex] = 1;
            return results;
        }
        return Arrays.copyOfRange(results, rIndex + 1, results.length); 
    }

    public static void main(String[] args) {
    	// // Test LeetCode : Array Intro - Find Pivot Index
    	// int[] nums = {1, 7, 3, 6, 5, 6};
    	// System.out.println(pivotIndex(nums));

        // Test Array Intro - Largest Number At Least Twice of Others
        // int[] nums1 = {3, 6, 1, 0};
        // int[] nums2 = {1, 2, 4, 3};
        // System.out.println(dominantIndex(nums1));
        // System.out.println(dominantIndex(nums2));

        // Test Array Intro - Plus One
        int[] nums1 = {3, 6, 1, 0};
        int[] nums2 = {9, 9, 9, 9};
        System.out.println(plusOne(nums2));
    }
}