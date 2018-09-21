import java.util.*;
import java.io.*;
import java.lang.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);

        while (!queue.isEmpty()) {

            int levelNum = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0 ; i < levelNum; i++) {
                if (queue.peekFirst().left != null) {
                    queue.addLast(queue.peekFirst().left);
                }

                if (queue.peekFirst().right != null) {
                    queue.addLast(queue.peekFirst().right);
                }
                level.add(queue.pollFirst().val);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        //new LevelOrderTraversal().levelOrder(null);

        Traversal t = new Traversal();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        System.out.println(new LevelOrderTraversal().levelOrder(t.stringToTreeNode(line)));

    }
}