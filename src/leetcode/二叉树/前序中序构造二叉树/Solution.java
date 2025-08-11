package leetcode.二叉树.前序中序构造二叉树;


import java.util.HashMap;
import java.util.Map;

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
    private final Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        //构建中序遍历的索引，方便快速查找
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preLength - 1, 0, inLength - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        //从缓存获取根节点处索引
        Integer inRootIdx = indexMap.get(preorder[preLeft]);
        //创建根节点
        TreeNode head = new TreeNode(inorder[inRootIdx]);
        //计算左子树节点个数
        int leftSize = inRootIdx - inLeft;
        //递归构建左子树
        head.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRootIdx - 1);
        //递归构建右子树
        head.right = buildTree(preorder, inorder, preLeft + leftSize + 1, preRight, inRootIdx + 1, inRight);
        return head;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preorder, inorder);
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
