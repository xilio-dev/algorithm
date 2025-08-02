package leetcode.二叉树.翻转二叉树;


import java.util.Stack;

class Solution {
    public TreeNode invertTree(TreeNode root) {
//        //递归终止条件 没有子节点了
//        if (root == null) {
//            return null;
//        }
//        //交换左右子树
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        //递归交换左右子树
//        invertTree(root.left);
//        //递归交换左右子树
//        invertTree(root.right);
//        return root;

        //方法二
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        //根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            //从栈弹出一个节点
            TreeNode node = stack.pop();
            //交换节点的左右节点引用
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            //如果左节点不为空，将其入栈便于下次操作，直到为空才退出循环
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
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
