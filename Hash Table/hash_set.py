from random import randrange
from collections import MutableSet


class MyHashSet(MutableSet):

    _AVAIL = object()

    def __init__(self, cap=11, p=109345121):
        self._table = cap * [None]
        self._n = 0
        self._prime = p
        self._scale = 1 + randrange(p - 1)
        self._shift = randrange(p - 1)

    def _hash_function(self, k):
        return (hash(k) * self._scale + self._shift) % self._prime % len(self._table)

    def _isAvailable(self, h):
        return self._table[h] is None or self._table[h] is MyHashSet._AVAIL

    def _find_slot(self, h, k):
        avail = None

        while True:
            if self._isAvailable(h):
                if avail is None:
                    avail = h
                if self._table[h] is None:
                    return (False, avail)
            elif self._table[h] == k:
                return (True, h)
            h = (h + 1) % len(self._table)

    def __iter__(self):
        for h in range(len(self._table)):
            if not self._isAvailable(h):
                yield self._table[h]

    def _resize(self, c):
        old = list(self)
        self._table = c * [None]
        self._n = 0
        for k in old:
            self.add(k)

    def __len__(self):
        return self._n

    def __contains__(self, k):
        h = self._hash_function(k)
        found, s = self._find_slot(h, k)
        if not found:
            return False
        return True

    def add(self, k):
        h = self._hash_function(k)
        found, s = self._find_slot(h, k)
        if not found:
            self._table[s] = k
            self._n += 1
        else:
            self._table[s] = k

        if self._n > len(self._table) // 2:
            self._resize(2 * len(self._table) - 1)

    def discard(self, k):
        h = self._hash_function(k)
        found, s = self._find_slot(h, k)
        if not found:
            return
        self._table[s] = MyHashSet._AVAIL
        self._n -= 1

    def contains(self, key):
        return key in self

    def remove(self, key):
        self.discard(key)


if __name__ == '__main__':

    m = MyHashSet()
    m.add(1)
    m.remove(19)
