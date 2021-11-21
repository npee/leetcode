package io.npee._00404_sumofleftleaves;


import javafx.util.Pair;

import java.util.*;

public class SumOfLeftLeaves {

    /**
     * DFS Recursive
     *
     * Time Complexity: O(N). All nodes will be visited.
     *
     * Space Complexity: O(H). Stack space.
     * In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N)
     *
     * N = Number of nodes. H = Height of the tree.
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // left leaf 일 조건(root 입장)
        // 1. left 일 것(root.left != null)
        // 2. left 가 leaf 일 것(root.left.left == null && root.left.right == null)
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * DFS Iterative (Pre-Order Traversal)
     *
     * Time Complexity: O(N). All nodes will be visited.
     *
     * Space Complexity: O(H). Stack space.
     * In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N)
     *
     * N = Number of nodes. H = Height of the tree.
     */
    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;

        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        stack.push(new Pair<>(root, false));

        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> current = stack.pop();
            TreeNode node = current.getKey();
            boolean isLeft = current.getValue();

            if (isLeft && node.left == null && node.right == null) {
                res += node.val;
                continue;
            }

            if (node.right != null) {
                stack.push(new Pair<>(node.right, false));
            }

            if (node.left != null) {
                stack.push(new Pair<>(node.left, true));
            }
        }

        return res;
    }

    /**
     * BFS Iterative
     *
     * Time Complexity: O(N). All nodes will be visited.
     *
     * Space Complexity: O(Width of the tree)
     * In case of a complete tree the width can be N/2. Thus worst case complexity = O(N)
     *
     * N = Number of nodes.
     */
    public static int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Boolean>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, false));

        int res = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Boolean> current = queue.poll();
            TreeNode node = current.getKey();
            boolean isLeft = current.getValue();

            if (isLeft && node.left == null && node.right == null) {
                res += node.val;
            }

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, true));
            }

            if (node.right != null) {
                queue.offer(new Pair<>(node.right, false));
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int result = sumOfLeftLeaves3(rootNode());
        System.out.println("result = " + result);
    }

    private static TreeNode rootNode() {
        // root = [3,9,20,null,null,15,7]
        return new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    }


    static class TreeNode {
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

}


