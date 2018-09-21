class Exercises:

    def buildTree(self, inorder, preorder):
        left, root, right = 0, 0, 0
        parent = preorder[-1]
        for i in range(len(inorder)):
            if inorder[i] == parent:
                root, right = i, i + 1
                self.build(left, root, right)
