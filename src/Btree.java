public class Btree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left != null && right != null) {
            if(left.val == right.val) {
                return true;
            } else {
                return false;
            }
        }
        boolean val01 = dfs(left.left, right.right);
        boolean val02 = dfs(left.right, right.left);
        System.out.println(val01 + "," + val02);
        return val01 && val02;
    }

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int current = 0;
        return dfs(root, targetSum, current);
    }
    public boolean dfs(TreeNode root, int targetSum, int current) {
        if(root == null) return false;
        if(current + root.val > targetSum) return false;

        current += root.val;

        if(root.left == null && root.right == null) {
            return current == targetSum;
        }
        return dfs(root.left, targetSum, current) || dfs(root.right, targetSum, current);
    }

}
