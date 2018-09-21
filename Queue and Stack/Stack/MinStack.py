class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self._data = []
        self.min = None

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        if len(self._data) == 0:
            self._data.append(x)
            self.min = x
        else:
            if x < self.min:
                self.min = x
            self._data.append(x)

    def pop(self):
        """
        :rtype: void
        """
        if not len(self._data) == 0:
            self._data.pop()

    def top(self):
        """
        :rtype: int
        """
        if not len(self._data) == 0:
            return self._data[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if not len(self._data) == 0:
            return self._data[self.min]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

if __name__ == '__main__':
    min_stack = MinStack()

    min_stack.push(-2)
    min_stack.push(0)
    min_stack.push(-3)

    print(min_stack.getMin())
    min_stack.pop()
    print(min_stack.top())
    print(min_stack.getMin())
