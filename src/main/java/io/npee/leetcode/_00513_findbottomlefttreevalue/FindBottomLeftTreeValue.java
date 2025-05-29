package io.npee.leetcode._00513_findbottomlefttreevalue;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        int bottomLeftValue = findBottomLeftValue(root);
        System.out.println("bottomLeftValue = " + bottomLeftValue);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}