package leetcodeDaily;

public class LCABinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public static class Res {
        TreeNode node;
        int height;

        public Res (TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        Res res = dfs(root);
        return res.node;
    }

    public static Res dfs(TreeNode root) {
        if (root == null) return new Res(null, 0);

        Res left = dfs(root.left);
        Res right = dfs(root.right);

        if (left.height > right.height) {
            left.height += 1;
            return left;
        } else if (left.height < right.height) {
            right.height += 1;
            return right;
        } else {
            return new Res(root, left.height + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode lca = lcaDeepestLeaves(root);
        System.out.println("LCA of deepest leaves: " + lca.val);
    }
}
