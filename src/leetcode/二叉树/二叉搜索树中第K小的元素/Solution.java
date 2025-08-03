package leetcode.二叉树.二叉搜索树中第K小的元素;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        int[] count = new int[1];
        count[0] = k;
        inorder(root, res, count);
        return res[0];
    }

    private void inorder(TreeNode root, int[] res, int[] count) {
        if (root == null || count[0] == 0) {
            return;
        }
        inorder(root.left, res, count);
        if (--count[0] == 0) {
            res[0] = root.val;
        }
        inorder(root.right, res, count);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        Solution solution = new Solution();
        int result = solution.kthSmallest(root, k);
        System.out.println(result);

    }
}
