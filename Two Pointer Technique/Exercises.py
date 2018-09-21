# Technique used to - 
# iterate array from two ends to middle
# Often used in a sorted array
class Solution:

    def reverseString(self, s):

        """
        Two Pointer Technique - Reverse String
        :type s: str
        :rtype: str
        """
        word = list(s)
        i = 0
        j = len(word) - 1

        while i < j:
            word[i], word[j] = word[j], word[i]
            i += 1
            j -= 1

        return "".join(word)



    def twoSum(self, numbers, target):
        """
        Two pointer technique - Two Sum II - Input array is sorted
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        #         # Loop each element
        #         unique_nums = sorted(set(numbers))
        #         for item in unique_nums:
        #             if (target - item) in numbers:
        #                 index1 = numbers.index(item) + 1
        #                 index2 = numbers.index((target - item), index1) + 1
        #                 return [index1, index2]

        #         return []

        left, right = 0, len(numbers) - 1
        while left < right:
            if numbers[left] + numbers[right] == target:
                return [left + 1, right + 1]
            elif numbers[left] + numbers[right] > target:
                right -= 1
            else:
                left += 1
        return []

    def readlines():
        """
        Generator to read lines from standard input
        """
        for line in sys.stdin:
            yield line.strip('\n')

    def stringToIntegerList(input):

        # Remove leading and trailing whitespaces
        input = input.strip()
        # Remove leading and trailing square brackets
        input = input[1:-1]
        # Split string on comma as sep
        parts = input.split(',')

        result = []
        if len(parts) == 0:
            return result

        for item in parts:
            result.append(int(item.strip()))

        return result






if __name__ == '__main__':
    # # Test - Two Pointer Technique - Reverse String
    # print(Solution().reverseString(""))

    # Test - Two Sum II - Input array is sorted
    print(Solution().twoSum([2, 7, 11, 15], 9))
