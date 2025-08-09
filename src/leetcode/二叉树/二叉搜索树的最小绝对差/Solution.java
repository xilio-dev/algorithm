package leetcode.二叉树.二叉搜索树的最小绝对差;

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
    private final Integer[] nodes = new Integer[2];
    private Integer count = 2;
    private Integer index = 0;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return Math.abs(nodes[0] - nodes[1]);
    }
    private void dfs(TreeNode root) {
        if (root == null || count == 0) {
            return;
        }
        dfs(root.left);
        nodes[index++] = root.val;
        count--;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new Solution().getMinimumDifference(root));
    }
}
