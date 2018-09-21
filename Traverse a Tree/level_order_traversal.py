from collections import deque
from tree_node import TreeNode
from traversal import stringToTreeNode

import sys
import json


class LevelOrderTraversal:

    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        result = []

        if not root:
            return result

        queue = deque()
        queue.append(root)

        while len(queue) != 0:

            level = []
            nodeCount = len(queue)

            for _ in range(nodeCount):
                if len(queue) != 0 and queue[0].left:
                    queue.append(queue[0].left)
                if len(queue) != 0 and queue[0].right:
                    queue.append(queue[0].right)
                level.append(queue.popleft().val)

            result.append(level)

        return result


def readlines():
    for line in sys.stdin:
        yield line.strip('\n')


def stringToList(input):
    return json.loads(input)


if __name__ == '__main__':

    lines = readlines()
    line = next(lines)

    root = stringToTreeNode(line)

    print(LevelOrderTraversal().levelOrder(root))
