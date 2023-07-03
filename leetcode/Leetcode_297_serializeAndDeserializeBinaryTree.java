import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">二叉树的序列化与反序列化</a>
 */
public class Leetcode_297_serializeAndDeserializeBinaryTree {

    /**
     * 序列化的格式自己制定，保证可以反序列化即可
     */
    private final static String NULL = "null";
    private final static String SPLITTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLITTER);
            return;
        }

        sb.append(root.val).append(SPLITTER);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(SPLITTER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.poll();
        if (NULL.equals(val)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }
}
