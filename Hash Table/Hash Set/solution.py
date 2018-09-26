import sys
import json


class Solution:

    def containsDuplicate(self, nums):
        hashSet = set()
        for item in nums:
            if item in hashSet:
                return True
            hashSet.add(item)
        return False

    def singleNumber(self, nums):
        result = 0
        for num in nums:
            result ^= num
        return result

    def intersection(self, nums1, nums2):
        hashSet = set(nums1)
        resultSet = set(nums2)

        return list(resultSet.intersection(hashSet))

    def isHappy(self, n):
        result = 0
        uniq = set()
        uniq.add(n)
        while True:
            while n > 0:
                x = n % 10
                result += x * x
                n = n // 10
            print(result)
            if result == 1:
                return True
            else:
                if result in uniq:
                    return False
                uniq.add(result)
                n = result
                result = 0


def readlines():
    for line in sys.stdin:
        yield line.strip("\n")


def stringToList(line):
    return json.loads(line)


def listToString(nums):
    return json.dumps(nums)


if __name__ == '__main__':
    # lines = readlines()
    # line = next(lines)

    # # print(Solution().containsDuplicate(stringToList(line)))
    # print(Solution().singleNumber(stringToList(line)))

    # lines = readlines()
    # line = next(lines)
    # nums1 = stringToList(line)
    # line = next(lines)
    # nums2 = stringToList(line)
    # print(Solution().intersection(nums1, nums2))

    lines = readlines()
    line = next(lines)
    print(Solution().isHappy(int(line)))
