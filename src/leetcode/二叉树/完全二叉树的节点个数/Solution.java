package leetcode.二叉树.完全二叉树的节点个数;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int total = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            total = total + size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        Solution solution = new Solution();
        System.out.println(solution.countNodes(root));


    }
}
