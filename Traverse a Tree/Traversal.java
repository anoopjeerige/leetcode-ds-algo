import java.util.*;
import java.lang.*;
import java.io.*;

public class Traversal {

    // Recursive pre order
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> order = new ArrayList<>();
        traversePreorder(order, root);
        return order;

    }
    // Recursive pre order helper
    private static void traversePreorder(List<Integer> order, TreeNode node) {
        // root, left, right
        if (node == null) { return; }
        order.add(node.val);
        traversePreorder(order, node.left);
        traversePreorder(order, node.right);
    }

    // Iterative pre order
    public List<Integer> preorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        if (root == null) {
            return result;
        }

        stack.addFirst(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pollFirst();
            result.add(temp.val);
            if (temp.right != null) {
                stack.addFirst(temp.right);
            }
            if (temp.left != null) {
                stack.addFirst(temp.left);
            }
        }
        return result;
    }

    // Recursive in order
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> order = new ArrayList<>();
        traverseInorder(order, root);
        return order;
    }

    // Recursive in order helper
    private void traverseInorder(List<Integer> order, TreeNode node) {

        // left, root, right
        if (node == null) {
            return;
        }
        traverseInorder(order, node.left);
        order.add(node.val);
        traverseInorder(order, node.right);
    }

    // Iterative In order
    public List<Integer> inorderTraversalIterative(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();

        stack.addFirst(root);
        TreeNode node = root.left;

        while (!stack.isEmpty()) {

            if (node == null) {
                node = stack.removeFirst();
                result.add(node.val);
                node = node.right;
            }

            while(node != null) {
                stack.addFirst(node);
                node = node.left;
            }
        }
        return result;
    }

    // Recursive post order
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> order = new ArrayList<>();
        traversePostorder(order, root);
        return order;
    }

    // Recursive post order helper
    private void traversePostorder(List<Integer> order, TreeNode node) {
        if (node == null) {
            return;
        }
        traversePostorder(order, node.left);
        traversePostorder(order, node.right);
        order.add(node.val);
    }

    public static TreeNode stringToTreeNode(String input) {
        // Give - [1, 2, 3]
        Deque<TreeNode> queue = new LinkedList<>();

        // Trim whitespaces
        input = input.trim();
        // Remove brackets;
        input = input.substring(1, input.length() - 1);
        // Split on ','
        String[] parts = input.split(",");

        // Add first node
        String item = parts[0];
        item = item.trim();
        int index = 1;
        TreeNode root = new TreeNode(Integer.valueOf(item));
        queue.addLast(root);

        while(!queue.isEmpty()) {

            // Get first item on queue
            TreeNode node = queue.removeFirst();

            // Check index
            if (index == parts.length) {
                break;
            }

            // Add left child
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(item));
                node.left = left;
                queue.addLast(node.left);
            }

            // Check index
            if (index == parts.length) {
                break;
            }

            // Add right child
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(item));
                node.right = right;
                queue.addLast(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {

        // Get input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = br.readLine();

        // Test Pre order
        System.out.println("Pre Order");
        displayList(new Traversal().preorderTraversal(stringToTreeNode(line)));
        //displayList(new Traversal().preorderTraversalIterative(stringToTreeNode(line)));

        // Test In order
        System.out.println("In Order");
        displayList(new Traversal().inorderTraversal(stringToTreeNode(line)));
        //displayList(new Traversal().inorderTraversalIterative(stringToTreeNode(line)));

        // Test Post order
        System.out.println("Post Order");
        displayList(new Traversal().postorderTraversal(stringToTreeNode(line)));
    }

    public static void displayList(List<Integer> items) {
        for (int item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}