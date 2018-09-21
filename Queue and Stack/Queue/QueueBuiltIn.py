from collections import deque

"""
Using deque ("deck", shorthand for double ended queues) - generalizations of stacks and queues
Deques support thread safe, memory efficient appends and pops from either side of the deque with approx the same O(1) in both directions

collections.deque Description
len(D) number of elements
D.appendleft( ) add to beginning
D.append() add to end
D.popleft( ) remove from beginning
D.pop() remove from end
D[0] access first element
D[−1] access last element
D[j] access arbitrary entry by index
D[j] = val modify arbitrary entry by index
D.clear( ) clear all contents
D.rotate(k) circularly shift rightward k steps
D.remove(e) remove first matching element
D.count(e) count number of matches for e

"""

d = deque([], maxlen=2)

print(d)
d.append(1)
d.append(2)
print(d)
d.append(3)
print(d)

print(d.popleft())
print(d[0])
print(d[-1])
