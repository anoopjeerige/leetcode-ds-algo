public class Exercises {
	
	/**
	* String - Implement strStr()
	*/
	public static int strStr(String haystack, String needle) {
        if (needle.isEmpty() && haystack.isEmpty()) {
            return 0;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
			return -1;
		}

		int found = -1;
		char[] input = haystack.toCharArray();
		char[] seq = needle.toCharArray();
		char first = seq[0];

		for (int i = 0; i < input.length; i++) {
			if (first == input[i]) {
				int l = 0;
				for (int j = 0, k = i; j < seq.length && k < input.length; j++, k++) {
					if (seq[j] != input[k]) {
						break;
					} else {
						l++;
					}
				}
				if (l == seq.length) {
					found = i;
					break;
				}
			}
		}
		return found;
    }

    /**
    * String - Add Binary
    */
    public static String addBinary(String a, String b) {
        int carry = 0;
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        int n = first.length;
        int m = second.length;
        int i = n - 1;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();
        int x = Character.digit(first[i--], 2);
        int y = Character.digit(second[j--], 2);

        int sum = x + y + carry; 
        carry = sum / 2;
        int result = sum % 2;
        
        sb.append(result);
        
        while(i >= 0 || j >= 0) {
        	if (i >= 0) {
        		x = Character.digit(first[i--], 2);
        	} else {
        		x = 0;
        	}

        	if (j >= 0) {
        		y = Character.digit(second[j--], 2);
        	} else {
        		y = 0;
        	}
            sum = x + y + carry;
            carry = sum / 2;
            result = sum % 2;
            sb.append(result);
        }

        if (carry == 1) {
        	sb.append(1);
        }

        return sb.reverse().toString();
        }

	/**
	*String - Longest Common Prefix
	*/
	public static String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) return "";
        
        String prefix = strs[0];
        
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
	public static void main(String[] args) {

		// // Test String - Implement strStr()
		// String haystack = "Hello";
		// String needle = "ll";
		// System.out.println(strStr(haystack, needle));

		// // Test String - Implement Add Binary
		// String a = "111";
		// String b = "1";
		// System.out.println(addBinary(a, b));

		// Test String - Longest Common Prefix
		String[] test = {"c", "acc", "ccc"};
		String[] test1 = {"flag", "flirt", "flip"};
		System.out.println(longestCommonPrefix(test));
		System.out.println(longestCommonPrefix(test1));


	}
}