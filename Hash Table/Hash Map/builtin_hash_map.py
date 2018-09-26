hashmap = {1: "pudge", 2: "nevermore", 3: "invoker"}
print(hashmap[2])
hashmap[3] = "huskar"
for key in hashmap:
    print("{} : {} ".format(key, hashmap[key]))

print("Size: {}".format(len(hashmap)))
print("Keys: {}, Values: {}, pairs: {}".format(
    hashmap.keys(), hashmap.values(), hashmap.items()))
