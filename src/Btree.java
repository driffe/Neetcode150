public class Btree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null) {
            invertTree(root.left);
        }
        if(root.right != null) {
            invertTree(root.right);
        }

        return root;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countDepth(root, 0);
    }
    public int countDepth(TreeNode node, int depth) {
        if (node == null) return 0;

        int leftDepth = countDepth(node.left, depth + 1);
        int rightDepth = countDepth(node.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

}
