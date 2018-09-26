hashset = set()

hashset.add(4)
hashset.add(2)
hashset.add(3)

hashset.remove(2)

print("2 not in hashset: {} ".format(2 not in hashset))

print("len: {}".format(len(hashset)))

for x in hashset:
    print(x)
