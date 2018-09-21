from Empty import Empty


class MyStack:

    """
    Implement a stack using python's list class
    This uses the adapter pattern where the list class is adapted to implement a custom stack class
    """

    def __init__(self):
        """ Create a empty stack """
        self._data = []

    def __len__(self):
        """ Return the number of elements in the stack"""
        return len(self._data)

    def is_empty(self):
        """Return True if stack is empty"""
        return len(self._data) == 0

    def push(self, e):
        """ Add element e to the top of the stack"""
        self._data.append(e)

    def top(self):
        """Return element at the top of the stack"""
        if self.is_empty():
            raise Empty("Stack is empty")
        return self._data[-1]

    def pop(self):
        """Remove and return the last element from the top of the stack"""
        if self.is_empty():
            raise Empty("Stack is empty")
        return self._data.pop()


if __name__ == '__main__':
    my_stack = MyStack()
    my_stack.push(1)
    print(my_stack.top())
    print(my_stack.pop())
    print(my_stack.pop())
