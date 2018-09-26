import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int item: nums) {
            if (hashSet.contains(item))
                return true;
            hashSet.add(item);
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> hashSet = new HashSet<>();
        for (int item: nums) {
            if (hashSet.contains(item))
                hashSet.remove(item);
            else
                hashSet.add(item);
        }
        return (int)hashSet.toArray()[0];
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num: nums1)
            set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums2)
            set2.add(num);
        set1.retainAll(set2);
        //List<Integer> temp = set1.toArray(new Integer[0]);
        return set1.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static String readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        return line;
    }

    public static int[] stringToList(String input) {
        if (input.length() == 0) {
            return null;
        }
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        //System.out.println(input);

        String[] items = input.split(",");
        int[] result = new int[items.length];

        for (int i = 0; i < result.length; i++) {
            String item = items[i];
            item = item.trim();
            result[i] = Integer.valueOf(item);
        }
        return result;
    }

    public static void displayList(int[] nums) {
        for(int num: nums)
            System.out.println(num);
    }

    public static void main(String[] args) throws IOException {

        // String line = readInput();
        // int[] input = stringToList(line);
        // //displayList(input);
        // //System.out.println(new Solution().containsDuplicate(input));
        // System.out.println(new Solution().singleNumber(input));

        String line = readInput();
        int[] nums1 = stringToList(line);
        line = readInput();
        int[] nums2 = stringToList(line);
        displayList(new Solution().intersection(nums1, nums2));
    }
}