package leetcode.二叉树.将有序数组转换为二叉搜索树;

import java.util.Arrays;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        //递归终止条件 l > r 说明已经没有节点可以取了
        if (l > r) {
            return null;
        }
        //取中间节点作为根节点，如果是偶数个节点，取中间靠左的节点作为根节点
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //递归取左半部分的中间节点作为左子树，右半部分的中间节点作为右子树
        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        System.out.println(Arrays.toString(nums));
        TreeNode treeNode = new Solution().sortedArrayToBST(nums);

        printTree(treeNode);
    }

    private static void printTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        printTree(treeNode.left);
        printTree(treeNode.right);
    }
}
