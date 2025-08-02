package leetcode.二叉树.对称二叉树;

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
    public boolean isSymmetric(TreeNode root) {
        //如果一个节点都没有，那么是对称的
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        //左右两个节点都为空，那么是对称的
        if (p == null && q == null) {
            return true;
        }
        //如果一个节点为空，另一个节点不为空，那么不是对称的
        if (p == null || q == null) {
            return false;
        }
        //如果两个节点的值不相等，那么不是对称的
        if (p.val != q.val) {
            return false;
        }
        //递归判断左右子树是否对称：A的左边和B的右边，A的右边和B的左边是否对称
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));

    }
}
