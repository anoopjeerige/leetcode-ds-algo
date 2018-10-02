from traversal import stringToTreeNode
from collections import deque
from tree_node import TreeNode


class codec:

    def serialize(self, root):

        queue = [root]
        result = ""
        current = 0

        while current != len(queue):

            node = queue[current]
            current += 1

            if not node:
                result += "null, "
                continue

            result += str(node.val) + ", "
            queue.append(node.left)
            queue.append(node.right)

        return "[" + result[:-2] + "]"

    def deserialize(self, data):

        data = data[1:-1]
        data = data.strip()
        parts = data.split(',')

        queue = deque()

        root = parts[0]
        root = root.strip()
        root = TreeNode(int(root))

        queue.append(root)
        index = 1

        while index != len(parts):

            node = queue.popleft()

            if index == len(parts):
                break

            leftchild = parts[index]
            leftchild = leftchild.strip()
            index += 1

            if leftchild != "null":
                leftchild = TreeNode(int(leftchild))
                node.left = leftchild
                queue.append(leftchild)

            if index == len(parts):
                break

            rightchild = parts[index]
            rightchild = rightchild.strip()
            index += 1

            if rightchild != "null":
                rightchild = TreeNode(int(rightchild))
                node.right = rightchild
                queue.append(rightchild)

        return root

if __name__ == '__main__':

    # root = stringToTreeNode("[1, 2, 3, 4, 5, 6, 7]")
    # print(type(root))
    # print(codec().serialize(root))

    root = codec().deserialize("[1, 2, 3, 4, 5, 6, 7]")
    print(type(root))
    print(codec().serialize(root))
