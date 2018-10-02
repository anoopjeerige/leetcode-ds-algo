from tree_node import TreeNode
import json
from collections import deque
from traversal import stringToTreeNode


class Exercises:

    def buildTreeR(self, inorder, postorder):
        """ Recursive"""
        if not inorder or not postorder:
            return None
        root = TreeNode(postorder.pop())
        index = inorder.index(root.val)
        # Its right first, as the pop order is postorder - root, right, left
        root.right = self.buildTree(inorder[index + 1:], postorder)
        root.left = self.buildTree(inorder[:index], postorder)
        return root

    def buildTreeI(self, inorder, postorder):
        """ Iterative """
        stack = deque()
        root = TreeNode(postorder[-1])
        stack.append(root)
        p_index, i_index = len(postorder) - 2, len(inorder) - 1

        while p_index >= 0:
            node = TreeNode(postorder[p_index])
            temp = None

            while stack and stack[-1].val == inorder[i_index]:
                temp = stack.pop()
                i_index -= 1

            if temp:
                temp.left = node
            else:
                stack[-1].right = node

            stack.append(node)
            p_index -= 1

        return root

    def buildTree(self, preorder, inorder):
        return self.buildHelper(deque(preorder), inorder)

    def buildHelper(self, preorder, inorder):
        if not preorder or not inorder:
            return None

        root = TreeNode(preorder.popleft())
        index = inorder.index(root.val)

        root.left = self.buildHelper(preorder, inorder[:index])
        root.right = self.buildHelper(preorder, inorder[index + 1:])
        return root

    def connect(self, root):
        """For perfect binary tree"""
        if root is None:
            return root

        root.next = None
        if root.left is None:
            return root

        queue = deque()
        queue.append(root.left)
        queue.append(root.right)

        while len(queue) != 0:
            node_count = len(queue)
            for _ in range(node_count - 1):

                current = queue.popleft()
                current.next = queue[0]
                if current.left:
                    queue.append(current.left)
                    queue.append(current.right)
            queue[0].next = None
            queue.popleft()

        return root

    def connect_1(self, root):
        """Better solution for connect for perfect binary tree"""
        if not root:
            return
        #level_node = root

        # if a level exisis below the current level
        while root.left:
            curr = root
            # keep moving right at current level while connecting at below
            # level
            while curr:
                # left to right connection
                curr.left.next = curr.right
                # connection between left and right subtree
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            root = root.left

    def connect_2(self, root):
        """Binary tree"""
        if not root:
            return

        head = None  # head node of the next level
        prev = None  # leading node of the next level
        curr = root  # current node of the current level

        while curr:
            # main loop to iterate levels
            while curr:
                # loop to move across in current level
                # left child
                if curr.left:
                    if prev:
                        prev.next = curr.left
                    else:
                        head = curr.left
                    prev = curr.left

                # right child
                if curr.right:
                    if prev:
                        prev.next = curr.right
                    else:
                        head = curr.right
                    prev = curr.right

                curr = curr.next  # move across nodes in same level

            # move to next level
            curr = head
            prev = None
            head = None

    def lowestCommonAncestor(self, root, p, q):
        stack = [root]
        parent = {root: None}
        while p not in parent or q not in parent:
            node = stack.pop()
            if node.left:
                parent[node.left] = node
                stack.append(node.left)
            if node.right:
                parent[node.right] = node
                stack.append(node.right)

        ancestor = set()
        while p:
            ancestor.add(p)
            p = parent[p]
        while q not in ancestor:
            q = parent[q]

        return q


def treeNodeToString(root):
    result = ""
    queue = [root]
    current = 0
    while current != len(queue):
        node = queue[current]
        current += 1

        if not node:
            result += 'null, '
            continue

        result += str(node.val) + ', '
        queue.append(node.left)
        queue.append(node.right)
    return "[" + result[:-2] + "]"


if __name__ == '__main__':
    # root = Exercises().buildTreeI([4, 2, 5, 1, 6, 3, 7], [4, 5, 2, 6, 7, 3, 1])
    # print(treeNodeToString(root))

    # root = Exercises().buildTree([1, 2, 4, 5, 3, 6, 7], [4, 2, 5, 1, 6, 3, 7])
    # print(treeNodeToString(root))

    root = stringToTreeNode("[1, 2, 3, 4, 5, 6, 7]")
    result = Exercises().traverse(root, 6)
    print(result)
