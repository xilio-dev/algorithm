package leetcode.二叉树.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = new Solution().inorderTraversal(root);
        System.out.println(result);

    }
}
