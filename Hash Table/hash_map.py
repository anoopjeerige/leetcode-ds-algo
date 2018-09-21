from random import randrange
from collections import MutableMapping


class MyHashMap(MutableMapping):

    _AVAIL = object()

    class _Item:
        __slots__ = '_key', '_value'

        def __init__(self, k, v):
            self._key = k
            self._value = v

        def __eq__(self, other):
            return self._key == other.key

        def __ne__(self, other):
            return not(self == other)

        def __lt__(self, other):
            return self._key < other._key

    def __init__(self, cap=11, p=109345121):
        self._table = cap * [None]
        self._n = 0
        self._prime = p
        self._scale = 1 + randrange(p - 1)
        self._shift = randrange(p - 1)

    def _hash_function(self, k):
        return (hash(k) * self._scale + self._shift) % self._prime % len(self._table)

    def _isAvailable(self, h):
        return self._table[h] is None or self._table[h] is MyHashMap._AVAIL

    def _find_slot(self, h, k):
        avail = None

        while True:
            if self._isAvailable(h):
                if avail is None:
                    avail = h
                if self._table[h] is None:
                    return (False, avail)
            elif self._table[h]._key == k:
                return (True, h)
            h = (h + 1) % len(self._table)

    def __iter__(self):
        for h in range(len(self._table)):
            if not self._isAvailable(h):
                yield self._table[h]._key

    def _resize(self, c):
        old = list(self.items())
        self._table = c * [None]
        self._n = 0
        for (k, v) in old:
            self[k] = v

    def __len__(self):
        return self._n

    def __getitem__(self, k):
        h = self._hash_function(k)
        found, s = self._find_slot(h, k)
        if not found:
            return -1
        return self._table[s]._value

    def __setitem__(self, k, v):
        h = self._hash_function(k)
        found, s = self._find_slot(h, k)
        if not found:
            self._table[s] = self._Item(k, v)
            self._n += 1
        else:
            self._table[s]._value = v

        if self._n > len(self._table) // 2:
            self._resize(2 * len(self._table) - 1)

    def __delitem__(self, k):
        h = self._hash_function(k)
        found, s = self._find_slot(h, k)
        if not found:
            return -1
        self._table[s] = MyHashMap._AVAIL
        self._n -= 1

    def put(self, key, value):
        self[key] = value

    def remove(self, key):
        del self[key]

    def get(self, key):
        return self[key]


if __name__ == '__main__':

    m = MyHashMap()
    m.put(1, "hello")
    m.put(2, "world")
    print(m[1])
    print(m[2])
    print(m[3])
    del m[2]
    print(m[2])
