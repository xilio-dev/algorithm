package leetcode.二叉树.翻转二叉树;


class Solution {
    public TreeNode invertTree(TreeNode root) {
        //递归终止条件 没有子节点了
        if (root == null) {
            return null;
        }
        //交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        //递归交换左右子树
        invertTree(root.left);
        //递归交换左右子树
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode result = new Solution().invertTree(root);
        preorderTraversal(result);
    }

    private static void preorderTraversal(TreeNode result) {
        if (result == null) {
            return;
        }
        System.out.println(result.val);
        preorderTraversal(result.left);
        preorderTraversal(result.right);
    }

}
