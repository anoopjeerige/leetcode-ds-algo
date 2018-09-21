class Solution:

    def pivotIndex(self, nums):
        """
        Array Intro - Find Pivot Index
        """
        # Compute the prefix sums for each index
        right = sum(nums)
        left = 0
        for index, num in enumerate(nums):
            right -= num
            if left == right:
                return index
            left += num
        return -1

    def dominantIndex(self, nums):
        """
        Array Intro - Largest Number At Least Twice of Others
        :type nums: List[int]
        :rtype: int
        """
        biggest = max(nums)
        for index, num in enumerate(nums):
            if num == biggest:
                result = index
            elif num * 2 > biggest:
                return -1
        return result

    def plusOne(self, digits):
        """
        Array Intro - Plus One
        :type digits: List[int]
        :rtype: List[int]
        """
        result = []
        index = len(digits) - 1
        total = digits[index] + 1
        carry = total // 10
        result.insert(0, total % 10)
        while index > 0:
            index -= 1
            total = digits[index] + carry
            carry = total // 10
            result.insert(0, total % 10)
        if carry == 1:
            result.insert(0, 1)
        return result

    

if __name__ == '__main__':

    # # Test Array Intro - Find Pivot Index
    # print(Solution().pivotIndex([1, 3, 7, 6, 5, 6]))

    # # Test Array Intro - Largest Number At Least Twice of Others
    # print(Solution().dominantIndex([3, 6, 1, 0]))

    # Test Array Intro - Plus One
    # print(Solution().plusOne([9, 9, 9]))
    # print(Solution().plusOne([9, 9, 8]))

