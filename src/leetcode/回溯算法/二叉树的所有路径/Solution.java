package leetcode.回溯算法.二叉树的所有路径;



import java.util.ArrayList;
import java.util.List;

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
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder path, List<String> res) {
        if (root == null) {
            return;
        }
        int len = path.length();
        path.append(root.val);
        //当前节点是叶子节点，将路径添加到结果中
        if (root.left == null && root.right == null) {
            res.add(path.toString());
        } else {
            path.append("->");
            dfs(root.left, path, res);
            dfs(root.right, path, res);
        }
        path.setLength(len);
    }

    public static void main(String[] args) {
        //输入：root = [1,2,3,null,5]
        //输出：["1->2->5","1->3"]
        Solution solution = new Solution();
        TreeNode left = new TreeNode(2, null, new TreeNode(5, null, null));
        TreeNode root = new TreeNode(1, left, new TreeNode(3, null, null));
        List<String> strings = solution.binaryTreePaths(root);
        System.out.println(strings);
    }

}
