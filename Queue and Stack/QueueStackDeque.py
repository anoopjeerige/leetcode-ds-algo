from collections import deque

"""
Deque - pronounced as "Deck", is a generalization of stacks and queues and stacks
Allows for thread safe, memory efficient appends and pops from both sides in O(1) time
"""

# Queue - FIFO
queue = deque()
print(len(queue))
queue.append("a")
print(queue[0])
queue.append("b")
print(len(queue))
print(queue[0])
print(queue.popleft())
print(queue.popleft())


# Stack - LIFO
stack = deque()
stack.appendleft("a")
stack.appendleft("b")
stack.appendleft("c")
print(stack)
print(stack.popleft())
print(stack.popleft())
print(stack.popleft())
