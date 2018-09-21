class Solution:

    def strStr(self, haystack, needle):

        """
        String - Implement strStr()
        :type haystack: str
        :type needle: str
        :rtype: int
        """

        # if needle empty return 0
        if not needle:
            return 0
        # if haystack empty return -1
        if not haystack:
            return -1
        # if needle len > haystack len return -1
        if len(needle) > len(haystack):
            return -1

        found = -1
        first = needle[0]

        for i in range(len(haystack)):
            if haystack[i] == first:
                k = i
                match_len = 0
                for j in range(len(needle)):
                    if needle[j] != haystack[k]:
                        break
                    else:
                        match_len += 1
                    k += 1

                if match_len == len(needle):
                    found = i
                    break

        return found

    def addBinary(self, a, b):
        """
        String - Add Binary
        :type a: str
        :type b: str
        :rtype: str
        """
        i = len(a) - 1
        j = len(b) - 1
        result = []
        carry = 0
        a_lsb = a[i]
        b_lsb = b[j]
        while i >= 0 or j >= 0:
            if a_lsb == '1' and b_lsb == '1':
                if carry == 1:
                    result.append('1')
                else:
                    result.append('0')
                carry = 1
            elif a_lsb == '0' and b_lsb == '0':
                if carry == 1:
                    result.append('1')
                else:
                    result.append('0')
                carry = 0
            else:
                if carry == 1:
                    result.append('0')
                    carry = 1
                else:
                    result.append('1')
                    carry = 0
            i -= 1
            j -= 1
            a_lsb = a[i] if i >= 0 else '0'
            b_lsb = b[j] if j >= 0 else '0'
        if carry == 1:
            result.append('1')
        result.reverse()
        return ''.join(result)

    def longestCommonPrefix(self, strs):
        """
        String - Longest Common Prefix
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ""

        pattern = strs[0]

        for i in range(1, len(strs)):
            while strs[i].find(pattern) != 0:
                pattern = pattern[:-1]
        return pattern

if __name__ == '__main__':
    
    # # Test String - Implement strStr()
    # print(Solution().strStr("hello", 'll'))

    # # Test String - Add Binary
    # print(Solution().addBinary("111", "1"))

    # Test String - Longest Common Prefix
    print(Solution().longestCommonPrefix(["flower", "flight", "flame"]))
    print(Solution().longestCommonPrefix(["flower", "plane", "car"]))
    print(Solution().longestCommonPrefix(["c", "acc", "ccc"]))

